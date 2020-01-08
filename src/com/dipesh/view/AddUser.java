/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dipesh.view;

import com.dipesh.controller.CreateAccController;
import com.dipesh.model.CreateAccount;
import javax.swing.JOptionPane;

/**
 *
 * @author satis
 */
public class AddUser extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddUser
     */
    public AddUser() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_createaccount = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_createuser = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton_create = new javax.swing.JButton();
        jPasswordField_createpass = new javax.swing.JPasswordField();

        setClosable(true);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Fill the form please");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Username");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Password");

        jButton_create.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_create.setText("Create");
        jButton_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_createActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_createaccountLayout = new javax.swing.GroupLayout(jPanel_createaccount);
        jPanel_createaccount.setLayout(jPanel_createaccountLayout);
        jPanel_createaccountLayout.setHorizontalGroup(
            jPanel_createaccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_createaccountLayout.createSequentialGroup()
                .addGroup(jPanel_createaccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_createaccountLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel6))
                    .addGroup(jPanel_createaccountLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel_createaccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel_createaccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_createuser)
                            .addComponent(jPasswordField_createpass, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))
                    .addGroup(jPanel_createaccountLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jButton_create)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_createaccountLayout.setVerticalGroup(
            jPanel_createaccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_createaccountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_createaccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_createuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel_createaccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jPasswordField_createpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton_create)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jPanel_createaccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel_createaccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_createActionPerformed
        String Username=jTextField_createuser.getText();
        String Password=jPasswordField_createpass.getText();

        if((Username.trim().length() == 0)||(Password.trim().length() == 0)||(Username.trim().length() == 0))
        {
            JOptionPane.showMessageDialog(null,"Please fill all the form");
        }
        else
        {
            CreateAccount ob=new CreateAccount();
            ob.setUsername(Username);
            ob.setPassword(Password);
            CreateAccController cac=new CreateAccController();
            int res=cac.usernameRepeat(ob);
            if(res==1)
            {
                JOptionPane.showMessageDialog(null, "Username already taken");
            }
            else
            {
                cac.createAcc(ob);
//                jPanel_existUser.setVisible(true);
                jPanel_createaccount.setVisible(false);
                clearFields();
            }
        }
    }//GEN-LAST:event_jButton_createActionPerformed

    private void clearFields()
    {
        jTextField_createuser.setText("");
        jPasswordField_createpass.setText("");
    
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_create;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JPanel jPanel_createaccount;
    private javax.swing.JPasswordField jPasswordField_createpass;
    private javax.swing.JTextField jTextField_createuser;
    // End of variables declaration//GEN-END:variables
}
