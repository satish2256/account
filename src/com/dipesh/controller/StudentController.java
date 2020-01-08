
package com.dipesh.controller;
import com.dipesh.common.DBConnection;
import com.dipesh.model.Students;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class StudentController 
{
    public void addStudents(Students ob)
    {
        Connection con=null;
        try
        {
          con=DBConnection.getConnection();
          String sql="insert into student(names,address,contactno,course,total_fee,due_fee,due_date)values(?,?,?,?,?,?,?)";
          PreparedStatement pst=con.prepareStatement(sql);
          pst.setString(1,ob.getName());
          pst.setString(2,ob.getAddress());
          pst.setLong(3,ob.getPhone());
          pst.setString(4,ob.getCourse());
          pst.setDouble(5,ob.getTotal_fee());
          pst.setDouble(6,ob.getDue_fee());

          pst.setDate(7,new java.sql.Date(ob.getDuedate().getTime()));
          pst.execute();
          JOptionPane.showMessageDialog(null,"Student Record saved");
          
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
    }
     public ArrayList<Students> fetchData()
 {
     ArrayList<Students> list=new ArrayList();
    Connection con=null;
    try
    {
        con=DBConnection.getConnection();
        String sql="select * from student";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(sql);
        while(rs.next())
        {
            Students ob=new Students();
            ob.setId(rs.getInt("id"));
            ob.setName(rs.getString("names"));
            ob.setAddress(rs.getString("address"));
            ob.setPhone(rs.getLong("contactno"));
            ob.setCourse(rs.getString("course"));
            ob.setTotal_fee(rs.getDouble("total_fee"));
            ob.setDue_fee(rs.getDouble("due_fee"));

            ob.setDuedate(rs.getDate("Due_Date"));
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
     public void updateStudent(Students ob)
     {
         Connection con=null;
         try{
         con=DBConnection.getConnection();
         String sql="update student set names=?,address=?,contactno=?,total_fee=?,due_fee=?,due_date=? where id=?";
         PreparedStatement pst=con.prepareStatement(sql);
         pst.setString(1,ob.getName());
         pst.setString(2,ob.getAddress());
         pst.setLong(3,ob.getPhone());
         pst.setDouble(4,ob.getTotal_fee());
         pst.setDate(5,new java.sql.Date(ob.getDuedate().getTime()));
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
                 System.out.println("Pramod :)");
             }
         }
     }
     public void deleteStudent(int id)
     {
          Connection con=null;
     try
     {
         con=DBConnection.getConnection();
         String sql="delete from student where id=?";
         PreparedStatement pst=con.prepareStatement(sql);
         pst.setInt(1,id);
         pst.execute();
         JOptionPane.showMessageDialog(null,"Record Deleted");
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
     }
     public double getAmount(int Std_id,Connection con) {
       double tot_amt=0;
       try {
           String sql="select due_fee from student where id=?";
           PreparedStatement pst=con.prepareStatement(sql);
           pst.setInt(1, Std_id);
           ResultSet rs=pst.executeQuery();
           while(rs.next()) {
               tot_amt=rs.getInt("due_fee");
           }
       } catch(Exception ex) {
           System.out.println(ex);
       }
       return tot_amt;
    }
     public void updateQty(int Std_id,double newAmt, Connection con) {
       try {
           String sql="update student set due_fee=? where id=?";
           PreparedStatement pst=con.prepareStatement(sql);
           pst.setDouble(1, newAmt);
           pst.setInt(2,Std_id);
           pst.execute();
       } catch(Exception ex) {
           System.out.println(ex);
       }
    }
}