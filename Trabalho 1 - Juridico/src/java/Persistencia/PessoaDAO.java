/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Enum.TipoPessoaEnum;
import Interface.IPessoa;
import Interface.IPessoaDAO;
import Model.Notificacoes;
import Model.Pessoa;
import Model.PessoaAdvogado;
import Model.PessoaCliente;
import Model.PessoaContrario;
import Model.PessoaOutro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio R. Trindade
 */
public class PessoaDAO implements IPessoaDAO<IPessoa>{
    
    private static PessoaDAO instance;

    private PessoaDAO() {

    }

    public static PessoaDAO getInstance() {
        if (instance == null) {
            instance = new PessoaDAO();
        }
        return instance;
    }
    
    @Override
    public void salvar(IPessoa model) throws SQLException, ClassNotFoundException {
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
    public void atualizar(IPessoa model) throws SQLException, ClassNotFoundException {
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
    public List<IPessoa> listar() throws ClassNotFoundException, SQLException {
        List<IPessoa> lista = new ArrayList<>();
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
    
    public List<IPessoa> listar(TipoPessoaEnum tipoPessoa) throws ClassNotFoundException, SQLException {
        List<IPessoa> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM pessoa WHERE tipo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, tipoPessoa.getValor());

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
    
    public IPessoa validaLogin(String login, String senha) throws ClassNotFoundException, SQLException{
        
        Connection con = null;
        PreparedStatement ps = null;
        IPessoa pessoa = null;
        String sql = "SELECT * FROM pessoa WHERE login = ? AND senha = ?";
        
        con = DatabaseLocator.getInstance().getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, login);
        ps.setString(2, senha);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            switch(rs.getInt("tipo")){
                case 1:
                    pessoa = new PessoaAdvogado(rs.getInt("id"), rs.getString("nome"), rs.getString("numeroDocumento"), rs.getString("email"));
                break;
                case 2:
                    pessoa = new PessoaCliente(rs.getInt("id"), rs.getString("nome"), rs.getString("numeroDocumento"), rs.getString("email"));
                break;
                case 3:
                    pessoa = new PessoaContrario(rs.getInt("id"), rs.getString("nome"), rs.getString("numeroDocumento"), rs.getString("email"));
                break;
                case 4:
                    pessoa = new PessoaOutro(rs.getInt("id"), rs.getString("nome"), rs.getString("numeroDocumento"), rs.getString("email"));
                break;
            }
        }
        return pessoa;
    }
    
    public List<IPessoa> listarPessoas() throws ClassNotFoundException, SQLException{
        Connection con;
        PreparedStatement ps;
        List<IPessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";
        
        con = DatabaseLocator.getInstance().getConnection();
        ps = con.prepareStatement(sql);
       
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            switch(rs.getInt("tipo")){
                case 1:
                    pessoas.add(new PessoaAdvogado(rs.getInt("id"), rs.getString("nome"), rs.getString("numeroDocumento"), rs.getString("email")));
                break;
                case 2:
                    pessoas.add(new PessoaCliente(rs.getInt("id"), rs.getString("nome"), rs.getString("numeroDocumento"), rs.getString("email")));
                break;
                case 3:
                    pessoas.add(new PessoaContrario(rs.getInt("id"), rs.getString("nome"), rs.getString("numeroDocumento"), rs.getString("email")));
                break;
                case 4:
                    pessoas.add(new PessoaOutro(rs.getInt("id"), rs.getString("nome"), rs.getString("numeroDocumento"), rs.getString("email")));
                break;
            }
        }
        return pessoas;
    }
    
    public Pessoa getPessoaById(int id) throws ClassNotFoundException, SQLException{
        
        Connection con = null;
        PreparedStatement ps = null;
        Pessoa pessoa = null;
        String sql = "SELECT * FROM pessoa WHERE id = ?";
        
        con = DatabaseLocator.getInstance().getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            switch(rs.getInt("tipo")){
                case 1:
                    pessoa = new PessoaAdvogado(rs.getInt("id"), rs.getString("nome"), rs.getString("numeroDocumento"), rs.getString("email"));
                break;
                case 2:
                    pessoa = new PessoaCliente(rs.getInt("id"), rs.getString("nome"), rs.getString("numeroDocumento"), rs.getString("email"));
                break;
                case 3:
                    pessoa = new PessoaContrario(rs.getInt("id"), rs.getString("nome"), rs.getString("numeroDocumento"), rs.getString("email"));
                break;
                case 4:
                    pessoa = new PessoaOutro(rs.getInt("id"), rs.getString("nome"), rs.getString("numeroDocumento"), rs.getString("email"));
                break;
            }
        }
        return pessoa;
    }
    
    public List<Notificacoes> getNotificacoes(int idPessoa) throws ClassNotFoundException, SQLException {
        List<Notificacoes> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "SELECT p.numeroProcesso, e.mensagem, e.data " +
                        "FROM envolvidonotificacaoprocesso e" +
                        "	INNER JOIN processo p ON e.processo_id = p.id " +
                        "WHERE e.pessoa_id = ? "
                        + " ORDER BY data DESC";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idPessoa);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Notificacoes model = new Notificacoes(rs.getString("numeroProcesso"), rs.getString("mensagem"), null);
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
}