/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Model.PessoaOutro;
import java.sql.Connection;
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
    public void salvar(PessoaOutro objeto) throws SQLException, ClassNotFoundException {
    }
    
     private void closeResources(Connection conn, Statement st) {
        try {
            if(st!=null) st.close();
            if(conn!=null) conn.close();

        } catch(SQLException e) {

        }
    }

}
