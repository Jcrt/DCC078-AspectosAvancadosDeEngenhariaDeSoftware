/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 07228620674
 */
public class DatabaseLocator {
    public static DatabaseLocator instance = null;
    
    private DatabaseLocator(){
        
    }
    
    public static DatabaseLocator getInstance() throws ClassNotFoundException, SQLException{
        if(instance == null)
            instance = new DatabaseLocator();
        return instance;
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn =
            //(Connection) DriverManager.getConnection("jdbc:mysql://172.18.10.31/07228620674", "07228620674", "23654789Siga");
            (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/DCC078", "root", "rootpass#1");
         
        return conn;
    }
}


