/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Enum.TipoPessoaEnum;
import Model.PessoaAdvogado;
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
public class PessoaAdvogadoDAO implements IDAO<PessoaAdvogado> {

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
            ps.setInt(5, model.getTipoEnum());

            ps.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, ps);
        }
    }

    @Override
    public void atualizar(PessoaAdvogado model) throws SQLException, ClassNotFoundException {
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
    public List<PessoaAdvogado> listar() throws ClassNotFoundException, SQLException {
        List<PessoaAdvogado> lista = new ArrayList<PessoaAdvogado>();
        Connection conn = null;
       PreparedStatement ps = null;
        
        try {
               
            conn = DatabaseLocator.getInstance().getConnection();            
            String sql = "SELECT * FROM pessoa WHERE tipo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, TipoPessoaEnum.ADVOGADO.getValor());           
         
            ResultSet rs = ps.executeQuery();           
            while(rs.next()){
                PessoaAdvogado model = new PessoaAdvogado(rs.getInt("id"),rs.getString("nome"), rs.getString("numerodocumento"), rs.getString("email"));
                lista.add(model);            
            }

        } catch(SQLException e) {
            throw e;
        } finally {
            closeResources(conn, ps);
        }
        return lista;
    }

    public PessoaAdvogado getPessoa(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM pessoa WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                return new PessoaAdvogado(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("numeroDocumento"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return null;
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

    @Override
    public PessoaAdvogado getById(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
