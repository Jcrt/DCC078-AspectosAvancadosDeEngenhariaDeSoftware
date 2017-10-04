/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Model.PessoaAdvogado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author thassya
 */
public class PessoaAdvogadoDAO implements PessoaDAO<PessoaAdvogado> {

    private static PessoaAdvogadoDAO instance;

    private PessoaAdvogadoDAO() {

    }

    public static PessoaAdvogadoDAO getInstance() {
        if (instance == null) {
            instance = new PessoaAdvogadoDAO();
        }
        return instance;
    }

    public void salvar(PessoaAdvogado model) throws SQLException, ClassNotFoundException {
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

    private void closeResources(Connection conn, Statement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {

        }
    }
}
