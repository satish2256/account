package com.dipesh.common;
import java.sql.*;
public class DBConnection 
{
    public static Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/accountmgmt","root","");
            return con;
        }
        catch(ClassNotFoundException | SQLException ex)
            
        {
            System.out.println(ex.toString());
        }
              return null;
    }
}

