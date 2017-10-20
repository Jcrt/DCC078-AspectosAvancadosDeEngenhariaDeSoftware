/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Enum.TipoPessoaEnum;
import Model.PessoaOutro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Interface.IDAO;

/**
 *
 * @author thassya
 */
public class PessoaOutroDAO implements IDAO<PessoaOutro> {

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
            ps.setInt(5, model.getTipoEnum());

            ps.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, ps);
        }
    }

    @Override
    public void atualizar(PessoaOutro model) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "UPDATE pessoa SETnome = ?, tipoDocumento = ?, numeroDocumento =?, email = ?, tipo = ? WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, model.getNome());
            ps.setString(2, model.getTipoDocumento());
            ps.setString(3, model.getNumeroDocumento());
            ps.setString(4, model.getEmail());
            ps.setInt(5, model.getTipoEnum());
            ps.setInt(5, model.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, ps);
        }
    }

    @Override
    public List<PessoaOutro> listar() throws ClassNotFoundException, SQLException {
        List<PessoaOutro> lista = new ArrayList<PessoaOutro>();
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM pessoa WHERE tipo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, TipoPessoaEnum.OUTROS.getValor());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PessoaOutro model = new PessoaOutro(rs.getInt("id"), rs.getString("nome"), rs.getString("numerodocumento"), rs.getString("email"));
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

    @Override
    public PessoaOutro getById(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
