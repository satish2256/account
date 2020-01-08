
package com.dipesh.model;

import java.util.Date;
public class Payment {
    
private int id;
 private int Std_id;
 private double Amount;
 private Date dop;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStd_id() {
        return Std_id;
    }

    public void setStd_id(int Std_id) {
        this.Std_id = Std_id;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public Date getDop() {
        return dop;
    }

    public void setDop(Date dop) {
        this.dop = dop;
    }
 
}
