/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.sql.SQLException;

/**
 *
 * @author thassya
 */
public interface IPessoaDAO<T> {
    public abstract void salvar(T objeto) throws SQLException, ClassNotFoundException;    
}


