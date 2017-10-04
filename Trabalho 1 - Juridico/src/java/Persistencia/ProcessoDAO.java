/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Model.Processo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

            sql = "INSERT INTO envolvimentoProcesso (idProcesso, idPessoa, tipoEnvolvimento) VALUES (?,?,?);";

            ps = conn.prepareStatement(sql);
            ps.setString(1, model.getNumeroProcesso());
            ps.setInt(2, model.getStatus());
            ps.setDate(3, model.getDataCadastro());
            ps.setDate(4, model.getDataBaixa());
            ps.setDate(5, model.getDataEncerramento());

            ps.execute();

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
