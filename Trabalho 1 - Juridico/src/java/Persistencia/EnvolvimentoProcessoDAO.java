/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Model.EnvolvimentoProcesso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author thassya
 */
public class EnvolvimentoProcessoDAO {

    private static EnvolvimentoProcessoDAO instance;

    private EnvolvimentoProcessoDAO() {
    }

    public static EnvolvimentoProcessoDAO getInstance() {
        if (instance == null) {
            instance = new EnvolvimentoProcessoDAO();
        }
        return instance;
    }
    public void salvar(EnvolvimentoProcesso model, String msg) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
             String sql = "INSERT INTO envolvidoNotificacaoProcesso (processo_id, pessoa_id, mensagem, data) "
                       + " VALUES (?,?,?,?);";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, model.getIdProcesso());
            ps.setInt(2, model.getIdPessoaEnvolvimento());
            ps.setString(3, msg);
            ps.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
            
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
