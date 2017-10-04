/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Model.PessoaOutro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author thassya
 */
public class PessoaOutroDAO implements PessoaDAO<PessoaOutro> {

    private static PessoaOutroDAO instance;

    private PessoaOutroDAO() {

    }

    public static PessoaOutroDAO getInstance() {
        if (instance == null) {
            instance = new PessoaOutroDAO();
        }
        return instance;
    }

    @Override
    public void salvar(PessoaOutro model) throws SQLException, ClassNotFoundException {
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
