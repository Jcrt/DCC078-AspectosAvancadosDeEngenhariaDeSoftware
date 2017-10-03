/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Model.PessoaAdvogado;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author thassya
 */
public class AdvogadoDAO {

    private static AdvogadoDAO instance;

    private AdvogadoDAO() {

    }

    public static AdvogadoDAO getInstance() {
        if (instance == null) {
            instance = new AdvogadoDAO();
        }
        return instance;
    }

    public void salvar(PessoaAdvogado model) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        
        try {
                conn = DatabaseLocator.getInstance().getConnection();
                st = conn.createStatement();
                
                st.execute("insert into pessoa (nome, tipoDocumento, numeroDocumento, email, tipo)" +
                        " values ('" + model.getNome() + "', '" + model.getTipoDocumento()+ "', '" + model.getNumeroDocumento() + 
                        "', '" + model.getEmail() + "', " + model.getTipo()+ ")");
            } catch(SQLException e) {
                throw e;
            } finally {
                closeResources(conn, st);
            }
    }
    
    private void closeResources(Connection conn, Statement st) {
        try {
            if(st!=null) st.close();
            if(conn!=null) conn.close();

        } catch(SQLException e) {

        }
    }
}
