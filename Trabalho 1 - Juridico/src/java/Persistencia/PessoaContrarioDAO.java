/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Model.PessoaContrario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author thassya
 */
public class PessoaContrarioDAO implements PessoaDAO<PessoaContrario>{

    private static PessoaContrarioDAO instance;

    private PessoaContrarioDAO() {

    }

    public static PessoaContrarioDAO getInstance() {
        if (instance == null) {
            instance = new PessoaContrarioDAO();
        }
        return instance;
    }
    
    @Override
    public void salvar(PessoaContrario model) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "INSERT INTO pessoa (nome, tipoDocumento, numeroDocumento, email, tipo) VALUES (?,?,?,?,?);";

            ps = conn.prepareStatement(sql);
            ps.setString(1, model.getNome());
            ps.setString(2, model.getTipoDocumento());
            ps.setString(3, model.getNumeroDocumento());
            ps.setString(4, model.getEmail());
            ps.setInt(5, model.getTipo());

            ps.execute();
           

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, ps);
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
