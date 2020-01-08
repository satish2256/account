package com.dipesh.controller;
import com.dipesh.common.DBConnection;
import com.dipesh.model.LoginUser;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
public class LoginUserController 
{
    public int loginUser(LoginUser ob)
    {
Connection con=null;
int check=0;
String pass=ob.getPassword();
String user=ob.getUsername();
try
{
    con=DBConnection.getConnection();
    String sql="select username,password from login where username='"+user+"'";
    Statement pst=con.createStatement();
   ResultSet rs= pst.executeQuery(sql);
   if(rs.next()){
   if(pass.equals(rs.getString("password")))
   {
       check=1;
       return check;
   } 
 }
}
catch(Exception ex)
{
  System.out.println(ex);
    
}
 finally{
       try
       {
        con.close();   
       
       }
       catch(Exception ex)
       {
           System.out.println(ex);
       }
}
       return 0;
}
    
}