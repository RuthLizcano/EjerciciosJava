/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author RUYIS
 */
public class ConnectionBD {
    public static Connection getConnection() throws SQLException {
       
        String dbURL = "jdbc:mysql://localhost:3306/reto4";
        String username = "root";
        String password = "Pradaruth94.";
        try{ 
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                System.out.println("Conectado");}
            //if( conn != null ) 
            //    System.out.println ( "Conectado" );
            return conn;
        } catch (SQLException ex) {
           
            ex.printStackTrace();
            return null;   
        }
        
    }  
}
