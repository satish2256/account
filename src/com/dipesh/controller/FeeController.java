
package com.dipesh.controller;

import com.dipesh.common.DBConnection;
import com.dipesh.model.Payment;
import com.dipesh.model.Students;
import com.dipesh.view.PayFee;
import java.sql.*;
import java.util.ArrayList;

public class FeeController {
    
  public Students fetchData(String id)
 {
     
    Connection con=null;
    try
    {
        //PayFee pf=new PayFee();
        con=DBConnection.getConnection();
        String sql="select * from student where id=? or names =?";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1, id);
        pst.setString(2,id);

        ResultSet rs=pst.executeQuery();
         
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
            return ob;
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
    catch(SQLException ex)
    {
        System.out.println(ex);
    }
}
    return null;
 }
  public void saveData(ArrayList<Payment> List,double paidAmt) {
        Connection con=null;
        try {
            
            con=DBConnection.getConnection();
            con.setAutoCommit(false);
            for(int i=0; i<List.size(); i++) {
                String sql="insert into payment(std_id,DateOfPayment,amount)values(?,?,?)";
                PreparedStatement pst=con.prepareStatement(sql);
                pst.setInt(1,List.get(i).getStd_id());
                pst.setDate(2,new java.sql.Date(List.get(i).getDop().getTime()));
                pst.setDouble(3,List.get(i).getAmount());
                
                pst.execute();
                
                //get fee
                StudentController sc=new StudentController();
                double tot_amt=sc.getAmount(List.get(i).getStd_id(),con);
                
                //update fee
                double newAmt=tot_amt-paidAmt;
                sc.updateQty(List.get(i).getStd_id(), newAmt, con);
                con.commit();
            }
        } catch(Exception ex) {
            System.out.println(ex);
            try {
                con.rollback();
            } catch(Exception e) {
                System.out.println(e);
            }
        }
        finally {
            try {
                
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}
