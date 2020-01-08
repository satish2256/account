
package com.dipesh.controller;
import com.dipesh.common.DBConnection;
import com.dipesh.model.Courses;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class CourseController 
{
    public void addCourses(Courses ob)
    {
        Connection con=null;
        try
        {
          con=DBConnection.getConnection();
          String sql="insert into course(name,duration)values(?,?)";
          PreparedStatement pst=con.prepareStatement(sql);
          pst.setString(1,ob.getName());
          pst.setString(2,ob.getDuration());
         
          pst.execute();
          JOptionPane.showMessageDialog(null,"Course Record saved");
          
        }catch(Exception ex){
            System.out.println(ex);
        }finally{
            try
            {
                con.close();
            } catch(Exception ex)  {
                System.out.println(ex);
            }
        }
    }
     public ArrayList<Courses> fetchData(){
     ArrayList<Courses> list=new ArrayList();
    Connection con=null;
    try
    {
        con=DBConnection.getConnection();
        String sql="select * from course";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(sql);
        while(rs.next())
        {
            Courses ob=new Courses();
            ob.setId(rs.getInt("id"));
            ob.setName(rs.getString("name"));
            ob.setDuration(rs.getString("duration"));
            
            list.add(ob);
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
    return list;
 }
     public void updateCourse(Courses ob)
     {
         Connection con=null;
         try{
         con=DBConnection.getConnection();
         String sql="update course set name=?,duration=? where id=?";
         PreparedStatement pst=con.prepareStatement(sql);
         pst.setString(1,ob.getName());
         pst.setString(2,ob.getDuration());
         pst.setInt(6,ob.getId());
         pst.execute();
         JOptionPane.showMessageDialog(null,"Record Updated");
         }
         catch(Exception ex)
         {
             System.out.println("dipesh"+ex);
         }
         finally
         {
             try
             {
                 con.close();
             }
             catch(Exception ex)
             {
                 System.out.println("dipesh :)");
             }
         }
     }
     public void deleteCourse(int id)
     {
          Connection con=null;
        try
        {
            con=DBConnection.getConnection();
            String sql="delete from course where id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,id);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Record Deleted");
        }   catch(Exception ex)         {
                 System.out.println(ex);
            }   finally{
                try
                {
                    con.close();
                } catch(Exception ex){
                    System.out.println(ex);
                }
        }
     }
     
    
}