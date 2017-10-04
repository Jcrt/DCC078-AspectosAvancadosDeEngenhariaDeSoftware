/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Model.Andamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author thassya
 */
public class AndamentoDAO {
     private static AndamentoDAO instance;

    private AndamentoDAO() {
    }

    public static AndamentoDAO getInstance() {
        if (instance == null) {
            instance = new AndamentoDAO();
        }
        return instance;
    }
    
    public void salvar(Andamento model) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "INSERT INTO andamento (idProcesso, descricao, data) VALUES (?,?,?);";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, model.getIdProcesso());
            ps.setString(2, model.getDescricao());
            ps.setDate(3, model.getData());
            
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
