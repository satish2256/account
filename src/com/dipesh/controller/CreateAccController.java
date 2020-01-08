
package com.dipesh.controller;
import com.dipesh.common.DBConnection;
import com.dipesh.model.CreateAccount;
import com.dipesh.model.LoginUser;
import java.sql.*;
import javax.swing.JOptionPane;
public class CreateAccController 
{
    public void createAcc(CreateAccount ob)
    {
        //int a=4;
    Connection con=null;
    try
    {
      con=DBConnection.getConnection();
      String sql="insert into login(username,password) values(?,?)";
      PreparedStatement pst=con.prepareStatement(sql);
      pst.setString(1,ob.getUsername());
      pst.setString(2,ob.getPassword());
          pst.execute();   
          JOptionPane.showMessageDialog(null,"Account Created Successfully");
      
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
       // return 4;
  }
   public int usernameRepeat(CreateAccount ob)
    {
      Connection con=null;
      int res=0;
String username=ob.getUsername();
try
{
   
    con=DBConnection.getConnection();
    String sql="select username,password from login where username='"+ob.getUsername()+"'";
    PreparedStatement pst=con.prepareStatement(sql);
   ResultSet rs= pst.executeQuery();
  while(rs.next()) 
  {
   if(username.equals(rs.getString("username")))
   {
       res=1;
     return res;
   }
  }
}
catch(Exception ex)
{
    System.out.println(ex);
}
 finally
       {
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
