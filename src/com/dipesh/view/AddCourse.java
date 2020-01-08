
package com.dipesh.view;

import com.dipesh.controller.CourseController;
import com.dipesh.model.Courses;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AddCourse extends javax.swing.JInternalFrame {
    DefaultTableModel model;

    public AddCourse() {
        initComponents();
        model=new DefaultTableModel(null,new String[]{"ID","Name","duration"});
        jTable_student.setModel(model);
    }
    private void clearTable()
{
    int count=jTable_student.getRowCount();
    for(int i=0;i<count;i++)
    {
        model.removeRow(0);
    }
}
    private void clearFields()
    {
        jTextField_name.setText("");
        jTextField_duration.setText("");
 
    }
 private void loadData()
{
   clearTable();
   CourseController sdc=new CourseController();
        ArrayList<Courses> list=sdc.fetchData();
        for(int i=0;i<list.size();i++)
        {
            model.addRow(new Object[]{list.get(i).getId(),
                list.get(i).getName(),list.get(i).getDuration()
            });
        } 
}  
 private boolean validateData()
 {
           String name=jTextField_name.getText();
            String duration=jTextField_duration.getText();
      if(name.isEmpty()||duration.isEmpty())
      {
         return true;
      }
      return false;
 }
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField_name = new javax.swing.JTextField();
        jButton_add = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_student = new javax.swing.JTable();
        jButton_loadstudents = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField_duration = new javax.swing.JTextField();
        jLabel_ID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Add Students");

        jLabel1.setText("Name");

        jTextField_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nameActionPerformed(evt);
            }
        });

        jButton_add.setText("Add");
        jButton_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addActionPerformed(evt);
            }
        });

        jButton_update.setText("Update");
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });

        jButton_delete.setText("Delete");
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
            }
        });

        jTable_student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_studentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_student);

        jButton_loadstudents.setText("Load Course");
        jButton_loadstudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_loadstudentsActionPerformed(evt);
            }
        });

        jLabel5.setText("Duration");

        jTextField_duration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_durationActionPerformed(evt);
            }
        });

        jLabel_ID.setText(". ");

        jLabel2.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel_ID))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_add, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_update)
                        .addGap(29, 29, 29)
                        .addComponent(jButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_loadstudents, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_duration, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_ID)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_add)
                            .addComponent(jButton_update)
                            .addComponent(jButton_delete))
                        .addGap(18, 18, 18)
                        .addComponent(jButton_loadstudents)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nameActionPerformed
   
    private void jButton_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addActionPerformed
   boolean validate;
      if(validate=validateData()){
        JOptionPane.showMessageDialog(null,"Please enter all the information!");
     }
     else
     {
      String name=jTextField_name.getText();
      String duration=jTextField_duration.getText();
      
      Courses ob=new Courses();
      ob.setName(name);
      ob.setDuration(duration);
      CourseController cc=new CourseController();
      cc.addCourses(ob);
      clearFields();     
     }
    
    
    }//GEN-LAST:event_jButton_addActionPerformed
    
    private void jButton_loadstudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_loadstudentsActionPerformed
              loadData();
    }//GEN-LAST:event_jButton_loadstudentsActionPerformed

    private void jTable_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_studentMouseClicked
        int row=jTable_student.getSelectedRow();
        jLabel_ID.setText(jTable_student.getValueAt(row,0).toString());
        jTextField_name.setText(jTable_student.getValueAt(row,1).toString());
        jTextField_duration.setText(jTable_student.getValueAt(row,2).toString());
    }//GEN-LAST:event_jTable_studentMouseClicked

    private void jTextField_durationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_durationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_durationActionPerformed

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
       boolean validate;
        if(validate=validateData()){
        JOptionPane.showMessageDialog(null,"Please enter all the information!");
                            }
        else
        {
        Courses ob=new Courses();
        ob.setId(Integer.parseInt(jLabel_ID.getText()));
        ob.setName(jTextField_name.getText());
        ob.setDuration(jTextField_duration.getText());
       
        CourseController cc=new CourseController();
        cc.updateCourse(ob);
        loadData();
        clearFields();
         
       }
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
       if(jLabel_ID.getText().equals("ID"))
       {
       JOptionPane.showMessageDialog(null,"Pleasse select a student from load students");
       }
       else{
         int id=Integer.parseInt(jLabel_ID.getText());
        CourseController sdc=new CourseController();
        sdc.deleteCourse(id);
        loadData();
        clearFields();
        jLabel_ID.setText("ID");
       }
    }//GEN-LAST:event_jButton_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_add;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_loadstudents;
    private javax.swing.JButton jButton_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_ID;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_student;
    private javax.swing.JTextField jTextField_duration;
    private javax.swing.JTextField jTextField_name;
    // End of variables declaration//GEN-END:variables
}
