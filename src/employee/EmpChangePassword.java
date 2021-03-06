/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import dbcon.DbOperations;
import gettersetter.Register;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import validations.RegValidations;



/**
 *
 * @author suraj
 */
public class EmpChangePassword extends javax.swing.JFrame {

    /**
     * Creates new form ChangePassword
     */
//    Register rs;
//    public EmpChangePassword(Register rs) {
//        initComponents();
//        //this.rs=rs;
//        
//       // jLabel1.setText("Welcome : "+rs.getName());
//    }
    Register rs;
    public EmpChangePassword(Register rs)
    {
         try
            {
                 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
       catch(Exception e)
            {
                System.out.println(e);
            }
        initComponents();
        this.rs=rs;
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 204, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Back");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 27, 76, 31));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 190, 53));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Change");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 158, 53));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password-removebg-preview.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 180, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 784));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 176, 332, 57));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 330, 332, 59));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 480, 332, 58));

        jLabel1.setText("Old Password:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 153, -1, -1));

        jLabel2.setText("New Password:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 301, -1, -1));

        jLabel3.setText("Confirm Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 451, -1, -1));

        jButton1.setText("Update Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 588, 160, 46));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/white.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 920, 790));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String old_pass=jTextField1.getText();
        String new_pass=jTextField2.getText();
        String confirm_pass=jTextField3.getText();
        
        boolean status=DbOperations.checkPassword(old_pass, rs.getEmail());
        if(status)
        {
            RegValidations regval= new RegValidations();
            if(!regval.passValidation(new_pass))
            {
               JOptionPane.showMessageDialog(rootPane, "Invalid Password", "Password Errror", JOptionPane.ERROR_MESSAGE); 
            }
            else
            {
                if(new_pass.equals(confirm_pass))
            {
                if(DbOperations.updatePassword(new_pass, rs.getEmail()))
                {
                    JOptionPane.showMessageDialog(rootPane, "Password updated successfully");
                        jTextField1.setText("");
                        jTextField2.setText("");
                        jTextField3.setText("");
                }
                else
                {
                   JOptionPane.showMessageDialog(rootPane, "Password didn't updated", "Password Error", JOptionPane.ERROR_MESSAGE);

                }
            }
            else
            {
               JOptionPane.showMessageDialog(rootPane, "New password and confirm password didn't matched", "Password Error", JOptionPane.ERROR_MESSAGE);

            }
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Old password didn't matched", "Password Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        
        new EmployeePanel(rs).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        // TODO add your handling code here:
        
        jLabel5.setForeground(Color.red);
        
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        // TODO add your handling code here:
        
        jLabel5.setForeground(Color.white);
    }//GEN-LAST:event_jLabel5MouseExited

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
