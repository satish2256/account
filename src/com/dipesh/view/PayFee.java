
package com.dipesh.view;

import com.dipesh.controller.FeeController;
import com.dipesh.model.Payment;
import com.dipesh.model.Students;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pramo
 */
public class PayFee extends javax.swing.JInternalFrame {
DefaultTableModel model;
    /**
     * Creates new form PayFee
     */
    public PayFee() {
        initComponents();
        java.util.Date d=new java.util.Date();
        jLabel_Date.setText(d.toString());
         model=new DefaultTableModel(null,new String[]{"ID","Name","address","Contact","Course","Total fee","Due fee","Due date"});
        jTable_payfee.setModel(model);
    }
    public void clearTable()
    {
         int count=jTable_payfee.getRowCount();
    for(int i=0;i<count;i++)
    {
        model.removeRow(0);
    }
    }
    public void loadTable()
    {
        String  name=jTextField_searchName.getText();
        FeeController fc=new FeeController();
        Students ob=fc.fetchData(name);
        if(ob!=null)
        {
            model.addRow(new Object[]{ob.getId(),ob.getName(),
                ob.getAddress(),ob.getPhone(),ob.getCourse(),ob.getTotal_fee(),ob.getDue_fee(),ob.getDuedate()});
       
       // jTextField_searchName.setText("");
        feeDues();
        }
    }
    private void feeDues()
    {
        int count=jTable_payfee.getRowCount();
    double total=0.0;
    for(int i=0;i<count;i++)
    {
     double amt=   Double.parseDouble(jTable_payfee.getValueAt(i,6).toString());
     total+=amt;
    }
      jLabel_FeeDues.setText(total+"");
    }
    private void printBill()
    {
        double remaining=0.0;
        double total=0;
        double paid=0;
        java.util.Date d=new java.util.Date();
        int count=jTable_payfee.getRowCount();
        String str="College Of IT\n Bijaychowk,Gausala\n";
        str+="                                                       Paid Date:"+d+"\n\n\n";
        for(int i=0;i<count;i++)
        {
            try{
           total=Double.parseDouble(jTable_payfee.getValueAt(i,5).toString());
            paid=Double.parseDouble(jTextField_payAmt.getText());
            remaining=total-paid;
            str+="ID:";
            str+=jTable_payfee.getValueAt(i,0).toString()+"\n";
            str+="Name:";
            str+=jTable_payfee.getValueAt(i,1).toString()+"\n";
            str+="Address:";
            str+=jTable_payfee.getValueAt(i,2).toString()+"\n";
            str+="Phone no:";
            str+=jTable_payfee.getValueAt(i,3).toString()+"\n";
            str+="Course:";
            str+=jTable_payfee.getValueAt(i,4).toString()+"\n";
            str+="Remaining Fee:";
            str+=remaining+"\n";
            str+="Due Date:";
            str+=jTable_payfee.getValueAt(i,6).toString()+"\n";
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
        Bill ob=new Bill();
        ob.jTextArea_bill.setLineWrap(true);
        ob.jTextArea_bill.setText(str);
        try
        {
            ob.jTextArea_bill.print();
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
                
    }
    public boolean checkFee()
    {
        double remaining=0.0;
        int count=jTable_payfee.getRowCount();
        for(int i=0;i<count;i++)
        {
        remaining=Double.parseDouble(jTable_payfee.getValueAt(i,5).toString());
        }
       double paying=Double.parseDouble(jTextField_payAmt.getText()); 
     if(paying>remaining)
     {
         return true;
     }
     return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Date = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_searchName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_payfee = new javax.swing.JTable();
        jLabel_feeDues = new javax.swing.JLabel();
        jLabel_FeeDues = new javax.swing.JLabel();
        jTextField_payAmt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton_pay = new javax.swing.JButton();

        setClosable(true);
        setTitle("Pay Fee");

        jLabel_Date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Date.setText("Date");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Search by id");

        jTextField_searchName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_searchNameActionPerformed(evt);
            }
        });
        jTextField_searchName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_searchNameKeyReleased(evt);
            }
        });

        jTable_payfee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_payfee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_payfeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_payfee);

        jLabel_feeDues.setText("Fee Dues");

        jLabel_FeeDues.setText(".");

        jTextField_payAmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_payAmtActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Pay Rs.");

        jButton_pay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_pay.setText("Pay & Print Bill");
        jButton_pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_payActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_searchName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_pay)
                            .addComponent(jTextField_payAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 516, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_feeDues, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addComponent(jLabel_FeeDues, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(301, 301, 301))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Date)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_searchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_feeDues)
                    .addComponent(jLabel_FeeDues))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_payAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jButton_pay)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_searchNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_searchNameKeyReleased
            clearTable();
        loadTable();
    }//GEN-LAST:event_jTextField_searchNameKeyReleased

    private void jTextField_searchNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_searchNameActionPerformed
        // TODO add your handling code here:
        clearTable();
        loadTable();
       /* int id=Integer.parseInt(jTextField_searchName.getText());
        FeeController fc=new FeeController();
        Students ob=fc.fetchData(id);
        if(ob!=null)
        {
            model.addRow(new Object[]{ob.getId(),ob.getName(),
                ob.getAddress(),ob.getPhone(),ob.getCourse(),ob.getTotal_fee(),ob.getDuedate()});
       
        jTextField_searchName.setText("");
        feeDues();
        }
               */
               
    }//GEN-LAST:event_jTextField_searchNameActionPerformed

    private void jTextField_payAmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_payAmtActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField_payAmtActionPerformed

    private void jButton_payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_payActionPerformed
      boolean checkfee;
      if(checkfee=checkFee())
      {
      JOptionPane.showMessageDialog(null,"Please enter amount less than or equal to remaining");
      }
      else
      {
        ArrayList<Payment> list=new ArrayList();
    int count=jTable_payfee.getRowCount();
    double paidAmt=Double.parseDouble(jTextField_payAmt.getText());
    for(int i=0;i<count;i++)
    {
        Payment ob=new Payment();
        int std_id=Integer.parseInt(jTable_payfee.getValueAt(i,0).toString());
        double total_fee=Double.parseDouble(jTable_payfee.getValueAt(i,5).toString());
        java.util.Date d=new java.util.Date();
        ob.setStd_id(std_id);
        ob.setDop(d);
        ob.setAmount(total_fee);
        list.add(ob);
    }
        FeeController fc=new FeeController();
        fc.saveData(list,paidAmt);
        JOptionPane.showMessageDialog(null,"Amount paid succesfully");
        printBill();
        clearTable();
        loadTable();
      }
    }//GEN-LAST:event_jButton_payActionPerformed

    private void jTable_payfeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_payfeeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_payfeeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_pay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Date;
    private javax.swing.JLabel jLabel_FeeDues;
    private javax.swing.JLabel jLabel_feeDues;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_payfee;
    public static javax.swing.JTextField jTextField_payAmt;
    public static javax.swing.JTextField jTextField_searchName;
    // End of variables declaration//GEN-END:variables
}
