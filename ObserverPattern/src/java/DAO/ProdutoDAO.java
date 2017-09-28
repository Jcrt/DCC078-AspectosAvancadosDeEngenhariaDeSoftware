/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Produto;
import Persistencia.DatabaseLocator;
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
public class ProdutoDAO {
    
    private static ProdutoDAO instance;
    
    private ProdutoDAO(){
        
    }
    
    public static ProdutoDAO getInstance(){
        if(instance == null)
            instance = new ProdutoDAO();
        return instance;
    }
    
    public void alterarEstoque(Produto prod) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("UPDATE produto SET estoque = ? WHERE id = ?");
            st.setInt(1, prod.getEstoque());
            st.setInt(2, prod.getId());
            st.executeUpdate();
        } catch(SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public Produto ler(int codigo) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;
        Produto p = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM produto WHERE id = ?");
            st.setInt(1, codigo);
            rs = st.executeQuery();
            
            if(rs.next()){
                p = new Produto(
                            rs.getInt("id"), 
                            rs.getString("nome"), 
                            rs.getInt("estoque")
                       );
            }
        } catch(SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return p;
    }
    
    public List<Produto> listar() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;
        List<Produto> productList = new ArrayList<>();
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM produto ORDER BY nome");
            rs = st.executeQuery();
            
            while(rs.next()){
                productList.add(
                    new Produto(
                        rs.getInt("id"), 
                        rs.getString("nome"), 
                        rs.getInt("estoque")
                    )
                );
            }
        } catch(SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return productList;
    }

    private void closeResources(Connection conn, Statement st) {
        try {
            if(st!=null) st.close();
            if(conn!=null) conn.close();

        } catch(SQLException e) {

        }
    }
}
