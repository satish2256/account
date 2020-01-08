
package com.dipesh.model;
//import com.toedter.calendar.JDateChooser;
import java.util.Date;
public class Students {
    private int id;
    private String name;
    private String address;
    private long phone ;
    private String course;
    private double total_fee;
    private double due_fee;

    public double getDue_fee() {
        return due_fee;
    }

    public void setDue_fee(double due_fee) {
        this.due_fee = due_fee;
    }
    private Date duedate;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    

    public double getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(double total_fee) {
        this.total_fee = total_fee;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }
    
    
    
}
