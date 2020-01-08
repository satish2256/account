
package com.dipesh.view;

import com.dipesh.controller.CourseController;
import com.dipesh.controller.StudentController;
import com.dipesh.model.Courses;
import com.dipesh.model.Students;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AddStudents extends javax.swing.JInternalFrame {
    DefaultTableModel model;

    public AddStudents() {
        initComponents();
        model=new DefaultTableModel(null,new String[]{"ID","Name","address","Contact","Course","Total fee","Due date"});
        jTable_student.setModel(model);
        
        CourseController sdc=new CourseController();
        ArrayList<Courses> list=sdc.fetchData();
        for(int i=0;i<list.size();i++)
        {
            jComboBox_Course.addItem(list.get(i).getName());
           
        } 
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
        jTextField_address.setText("");
        jTextField_contact.setText("");
        jTextField_totalfee.setText("");
        jDateChooser_date.setDate(null);
 
    }
 private void loadData()
{
   clearTable();
   StudentController sdc=new StudentController();
        ArrayList<Students> list=sdc.fetchData();
        for(int i=0;i<list.size();i++)
        {
            model.addRow(new Object[]{list.get(i).getId(),
                list.get(i).getName(),list.get(i).getAddress(),list.get(i).getPhone(),
                list.get(i).getCourse(),list.get(i).getTotal_fee(),list.get(i).getDuedate()
            });
        } 
}  
 private boolean validateData()
 {
      String name=jTextField_name.getText();
      String address=jTextField_address.getText();
      Long phone=Long.parseLong(jTextField_contact.getText());
      Double totalfee=Double.parseDouble(jTextField_totalfee.getText());
      java.sql.Date duedate = new java.sql.Date(jDateChooser_date.getDate().getTime());
      String  faculty=jComboBox_Course.getSelectedItem().toString();
      if(name.isEmpty()||address.isEmpty()||
      jTextField_contact.getText().isEmpty()||jTextField_totalfee.getText().isEmpty()
      ||duedate.equals(""))
      {
         return true;
      }
      return false;
 }
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_name = new javax.swing.JTextField();
        jTextField_address = new javax.swing.JTextField();
        jTextField_contact = new javax.swing.JTextField();
        jButton_add = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_student = new javax.swing.JTable();
        jButton_loadstudents = new javax.swing.JButton();
        jComboBox_Course = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jTextField_totalfee = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel_ID = new javax.swing.JLabel();
        jDateChooser_date = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Add Students");

        jLabel1.setText("Name");

        jLabel2.setText("Address");

        jLabel3.setText("Contact");

        jLabel4.setText("Course");

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

        jButton_loadstudents.setText("Load Students");
        jButton_loadstudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_loadstudentsActionPerformed(evt);
            }
        });

        jComboBox_Course.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "select" }));
        jComboBox_Course.setSelectedIndex(0);
        jComboBox_Course.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_CourseItemStateChanged(evt);
            }
        });
        jComboBox_Course.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox_CourseMouseClicked(evt);
            }
        });
        jComboBox_Course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_CourseActionPerformed(evt);
            }
        });

        jLabel5.setText("Total Fee");

        jTextField_totalfee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_totalfeeActionPerformed(evt);
            }
        });

        jLabel6.setText("Due Date");

        jLabel_ID.setText(".");

        jLabel7.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addGap(54, 54, 54))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(33, 33, 33)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField_contact)
                                .addComponent(jComboBox_Course, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 2, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField_totalfee, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                        .addComponent(jDateChooser_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addComponent(jLabel6)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel7))
                            .addGap(53, 53, 53)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel_ID)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_address)
                                    .addComponent(jTextField_name)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_add, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_loadstudents, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_update)
                                .addGap(33, 33, 33)
                                .addComponent(jButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(67, 67, 67)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_ID)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox_Course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_totalfee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jLabel6))
                    .addComponent(jDateChooser_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_add)
                    .addComponent(jButton_update)
                    .addComponent(jButton_delete))
                .addGap(31, 31, 31)
                .addComponent(jButton_loadstudents)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
      String address=jTextField_address.getText();
      Long phone=Long.parseLong(jTextField_contact.getText());
      Double totalfee=Double.parseDouble(jTextField_totalfee.getText());
      java.sql.Date duedate = new java.sql.Date(jDateChooser_date.getDate().getTime());
      String  faculty=jComboBox_Course.getSelectedItem().toString();
      Students ob=new Students();
      ob.setName(name);
      ob.setAddress(address);
      ob.setPhone(phone);
      ob.setCourse(faculty);
      ob.setTotal_fee(totalfee);
      ob.setDuedate(duedate);
      StudentController sc=new StudentController();
      sc.addStudents(ob);
      clearFields();     
     }
    
    
    }//GEN-LAST:event_jButton_addActionPerformed
    
    private void jComboBox_CourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_CourseActionPerformed
   
    }//GEN-LAST:event_jComboBox_CourseActionPerformed

    private void jComboBox_CourseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_CourseItemStateChanged
         
    }//GEN-LAST:event_jComboBox_CourseItemStateChanged

    private void jButton_loadstudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_loadstudentsActionPerformed
              loadData();
    }//GEN-LAST:event_jButton_loadstudentsActionPerformed

    private void jTable_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_studentMouseClicked
        try {
            int row=jTable_student.getSelectedRow();
            jLabel_ID.setText(jTable_student.getValueAt(row,0).toString());
            jTextField_name.setText(jTable_student.getValueAt(row,1).toString());
            jTextField_address.setText(jTable_student.getValueAt(row,2).toString());
            jTextField_contact.setText(jTable_student.getValueAt(row,3).toString());
            jTextField_totalfee.setText(jTable_student.getValueAt(row,5).toString());
            java.util.Date d= new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(row,6).toString());
            jDateChooser_date.setDate(d);
        } catch (ParseException ex) {
            Logger.getLogger(AddStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable_studentMouseClicked

    private void jTextField_totalfeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_totalfeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_totalfeeActionPerformed

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
       boolean validate;
        if(validate=validateData()){
        JOptionPane.showMessageDialog(null,"Please enter all the information!");
                            }
        else
        {
        Students ob=new Students();
        ob.setId(Integer.parseInt(jLabel_ID.getText()));
        ob.setName(jTextField_name.getText());
        ob.setAddress(jTextField_address.getText());
        ob.setPhone(Long.parseLong(jTextField_contact.getText()));
        ob.setTotal_fee(Double.parseDouble(jTextField_totalfee.getText()));
        java.sql.Date duedate = new java.sql.Date(jDateChooser_date.getDate().getTime());
        ob.setDuedate(duedate);
        StudentController pdc=new StudentController();
        pdc.updateStudent(ob);
        loadData();
        clearFields();
        /*
      String name=jTextField_name.getText();
      String address=jTextField_address.getText();
      Long phone=Long.parseLong(jTextField_contact.getText());
      Double totalfee=Double.parseDouble(jTextField_totalfee.getText());
      java.sql.Date duedate = new java.sql.Date(jDateChooser_date.getDate().getTime());
      String  faculty=jComboBox_faculty.getSelectedItem().toString();
      Students ob=new Students();
      ob.setName(name);
      ob.setAddress(address);
      ob.setPhone(phone);
      ob.setCourse(faculty);
      ob.setTotal_fee(totalfee);
      ob.setDuedate(duedate);
      StudentController sc=new StudentController();
      sc.updateStudent(ob);
      clearFields();    */  
       }
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
       if(jLabel_ID.getText().equals("ID"))
       {
       JOptionPane.showMessageDialog(null,"Pleasse select a student from load students");
       }
       else{
         int id=Integer.parseInt(jLabel_ID.getText());
        StudentController sdc=new StudentController();
        sdc.deleteStudent(id);
        loadData();
        clearFields();
        jLabel_ID.setText("ID");
       }
    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void jComboBox_CourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_CourseMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jComboBox_CourseMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_add;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_loadstudents;
    private javax.swing.JButton jButton_update;
    private javax.swing.JComboBox jComboBox_Course;
    private com.toedter.calendar.JDateChooser jDateChooser_date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_ID;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_student;
    private javax.swing.JTextField jTextField_address;
    private javax.swing.JTextField jTextField_contact;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JTextField jTextField_totalfee;
    // End of variables declaration//GEN-END:variables
}
