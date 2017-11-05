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
import Model.ProcessoArquivado;
import Model.ProcessoAtivo;
import Model.ProcessoBaixaProvisória;
import Model.ProcessoEncerrado;
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
        int idInserido = 0;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "INSERT INTO processo (numeroProcesso, status, dataCadastro, dataBaixa, dataEncerramento, fase_id) VALUES (?,?,?,?,?,?);";

            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, model.getNumeroProcesso());
            ps.setInt(2, model.getStatus());
            ps.setDate(3, model.getDataCadastro());
            ps.setDate(4, model.getDataBaixa());
            ps.setDate(5, model.getDataEncerramento());
            ps.setInt(6, model.getFase().getId());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idInserido = rs.getInt(1);
                
                for(Observer env : model.getEnvolvidos()){
                    EnvolvimentoProcesso e = (EnvolvimentoProcesso) env;
                    sql = "INSERT INTO envolvimentoprocesso(processo_id, pessoa_id, EnvolvimentoProcessoEnum)"
                            + "VALUES(?,?,?)";
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, idInserido);
                    ps.setInt(2, e.getIdPessoaEnvolvimento());
                    ps.setInt(3, e.getTipoEnvolvimento());  
                    
                    ps.executeUpdate();
                }
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
        AndamentoDAO aDAO = AndamentoDAO.getInstance();
        String sql = "SELECT id, numeroProcesso, status, dataCadastro, dataBaixa, dataEncerramento, fase_id "
                    + "FROM Processo "
                    + "WHERE isApagado = 0";
        
        List<Processo> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = DatabaseLocator.getInstance().getConnection();
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Processo model = null;
                switch(rs.getInt("status")){
                    case 1: 
                        model = new ProcessoAtivo(rs.getString("numeroProcesso"));
                    break;
                    case 2: 
                        model = new ProcessoArquivado(rs.getString("numeroProcesso"));
                    break;
                    case 3: 
                        model = new ProcessoBaixaProvisória(rs.getString("numeroProcesso"));
                    break;
                    case 4:
                        model = new ProcessoEncerrado(rs.getString("numeroProcesso"));
                    break;
                }
                
                model.setId(rs.getInt("id"));
                model.setDataCadastro(rs.getDate("dataCadastro"));
                model.setDataBaixa(rs.getDate("dataBaixa"));
                model.setDataEncerramento(rs.getDate("dataEncerramento"));
                model.setEnvolvidos(this.getEnvolvidosPorProcesso(model.getId()));
                model.setAndamentos(aDAO.getAndamentosPorPorcesso(rs.getInt("id")));
                model.setFase(FaseDAO.getInstance().getById(rs.getInt("fase_id")));
                lista.add(model);
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, ps);
        }
        return lista;
    }
    
    public Processo getProcesso(int idProcesso) throws ClassNotFoundException, SQLException{
        AndamentoDAO aDAO = AndamentoDAO.getInstance();
        String sql = "SELECT id, numeroProcesso, status, dataCadastro, dataBaixa, dataEncerramento, fase_id "
                    + "FROM Processo "
                    + "WHERE id = ? "
                    + " AND isApagado = 0";
        Connection conn = null;
        PreparedStatement ps = null;
        Processo model = null;
        
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idProcesso);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                switch(rs.getInt("status")){
                    case 1: 
                        model = new ProcessoAtivo(rs.getString("numeroProcesso"));
                    break;
                    case 2: 
                        model = new ProcessoArquivado(rs.getString("numeroProcesso"));
                    break;
                    case 3: 
                        model = new ProcessoBaixaProvisória(rs.getString("numeroProcesso"));
                    break;
                    case 4:
                        model = new ProcessoEncerrado(rs.getString("numeroProcesso"));
                    break;
                }
                
                model.setId(idProcesso);
                model.setDataCadastro(rs.getDate("dataCadastro"));
                model.setDataBaixa(rs.getDate("dataBaixa"));
                model.setDataEncerramento(rs.getDate("dataEncerramento"));
                model.setEnvolvidos(this.getEnvolvidosPorProcesso(model.getId()));
                model.setAndamentos(aDAO.getAndamentosPorPorcesso(idProcesso));
                model.setFase(FaseDAO.getInstance().getById(rs.getInt("fase_id")));
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, ps);
        }
        return model;
    }
    
    private List<Observer> getEnvolvidosPorProcesso(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT processo_id, pessoa_id, EnvolvimentoProcessoEnum "
                + " FROM envolvimentoprocesso"
                + " WHERE processo_id = ?";
        
        List<Observer> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = DatabaseLocator.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EnvolvimentoProcesso model = new EnvolvimentoProcesso();
                model.setIdProcesso(id);
                model.setTipoEnvolvimento(TipoEnvolvimentoEnum.values()[rs.getInt("EnvolvimentoProcessoEnum") - 1]);
                model.setPessoaEnvolvimento(PessoaDAO.getInstance().getPessoaById(rs.getInt("pessoa_id")));
                lista.add(model);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResources(conn, ps);
        }
        return lista;
    }
    
    public void updateStatusProcesso(Processo p) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "UPDATE processo SET status = ? WHERE id = ?";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, p.getStatus());
            ps.setInt(2, p.getId());
           
            ps.executeUpdate();
           
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, ps);
        }
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

    
}
