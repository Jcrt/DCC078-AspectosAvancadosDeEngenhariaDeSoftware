/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Model.PessoaContrario;
import java.sql.Connection;
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
    public void salvar(PessoaContrario objeto) throws SQLException, ClassNotFoundException {
    }
    
     private void closeResources(Connection conn, Statement st) {
        try {
            if(st!=null) st.close();
            if(conn!=null) conn.close();

        } catch(SQLException e) {

        }
    }
    
}
