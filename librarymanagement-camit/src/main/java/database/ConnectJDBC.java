/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;

/**
 *
 * @author Administrator
 */
public class ConnectJDBC {
    
    private static Connection connect;
    
    public ConnectJDBC() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12346922", "sql12346922" , "E3T8PQ26Yn");
    }
    
    public Connection getConnection()
    {
       return connect;
    }
    
}


