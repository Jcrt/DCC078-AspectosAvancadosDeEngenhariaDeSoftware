/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Enum.StatusEnum;
import Enum.TipoEnvolvimentoEnum;
import Model.EnvolvimentoProcesso;
import Model.Processo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 *
 * @author thassya
 */
public class ProcessoDAO {

    private static ProcessoDAO instance;
    private static AndamentoDAO andamento = null;
    private static EnvolvimentoProcessoDAO envolvimento = null;

    private ProcessoDAO() {
        andamento = AndamentoDAO.getInstance();
        envolvimento = EnvolvimentoProcessoDAO.getInstance();
    }

    public static ProcessoDAO getInstance() {
        if (instance == null) {
            instance = new ProcessoDAO();
        }
        return instance;
    }

    public void salvar(Processo model) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "INSERT INTO processo (numeroProcesso, status, dataCadastro, dataBaixa, dataEncerramento) VALUES (?,?,?,?,?);";

            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, model.getNumeroProcesso());
            ps.setInt(2, model.getStatus());
            ps.setDate(3, model.getDataCadastro());
            ps.setDate(4, model.getDataBaixa());
            ps.setDate(5, model.getDataEncerramento());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                final int idInserido = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, ps);
        }
    }

    public void putNotificacoesEnvolvidos(Processo p) throws SQLException, ClassNotFoundException {
        try {
            for (Observer ev : p.getEnvolvidos()) {
                EnvolvimentoProcesso e = (EnvolvimentoProcesso) ev;
                for (String msg : e.getNotificacoes()) {

                    EnvolvimentoProcesso env = new EnvolvimentoProcesso();
                    env.setIdProcesso(p.getId());
                    env.setPessoaEnvolvimento(e.getPessoaEnvolvimento());

                    envolvimento.salvar(env, msg);
                }
            }
        } catch (SQLException e) {
            throw e;
        } finally {

        }
    }
    
    public List<Processo> listar() throws ClassNotFoundException, SQLException{
        String sql = "SELECT id, numeroProcesso, status, dataCadastro, dataBaixa, dataEncerramento "
                    + "FROM Processo";
        
        List<Processo> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = DatabaseLocator.getInstance().getConnection();
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Processo model = new Processo(rs.getString("numeroProcesso"));
                model.setId(rs.getInt("id"));
                model.setStatus(StatusEnum.values()[rs.getInt("status")]);
                model.setDataCadastro(rs.getDate("dataCadastro"));
                model.setDataBaixa(rs.getDate("dataBaixa"));
                model.setDataEncerramento(rs.getDate("dataEncerramento"));
                model.setEnvolvidos(this.getEnvolvidosPorProcesso(model.getId()));
                //model.setAndamentos(this.getAndamentosPorProcesso(model.getId()));
                lista.add(model);
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, ps);
        }
        return lista;
    }

    private void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {

        }
    }

    private List<Observer> getEnvolvidosPorProcesso(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT processo_id, pessoa_id, EnvolvimentoProcessoEnum FROM envolvimentoprocesso";
        
        List<Observer> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = DatabaseLocator.getInstance().getConnection();
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EnvolvimentoProcesso model = new EnvolvimentoProcesso();
                model.setIdProcesso(id);
                model.setTipoEnvolvimento(TipoEnvolvimentoEnum.values()[rs.getInt("EnvolvimentoProcessoEnum")]);
                model.setPessoaEnvolvimento(PessoaDAO.getInstance().getPessoaById(rs.getInt("pessoa_id")));
                lista.add(model);
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, ps);
        }
        return lista;
    }

    /*private List<Andamento> getAndamentosPorProcesso(int id) {
        
    }*/
}
