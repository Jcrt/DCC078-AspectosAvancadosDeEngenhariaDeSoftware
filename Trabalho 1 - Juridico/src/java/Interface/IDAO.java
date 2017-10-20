/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thassya
 */
public interface IDAO<T> {

    public abstract void salvar(T objeto) throws SQLException, ClassNotFoundException;

    public abstract void atualizar(T objeto) throws SQLException, ClassNotFoundException;

    public List<T> listar() throws ClassNotFoundException, SQLException;
    
    public T getById(int id) throws ClassNotFoundException, SQLException;
    
}
