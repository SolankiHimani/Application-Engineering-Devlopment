/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Electricity;

import Business.Customer.Customer;
import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Organisation.Organisation;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Himani Solanki
 */
public class ElectricityWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ElectricityWorkAreaJPanel
     */
    
    JPanel userProcessContainer;
    Enterprise enterprise;
    UserAccount userAccount;
    Organisation organisation;
    Ecosystem business;
    UserAccount account;
   
    public ElectricityWorkAreaJPanel(JPanel userProcessContainer, Enterprise enterprise, UserAccount account, Organisation organization, Ecosystem business) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.enterprise=enterprise;
        this.userAccount=userAccount;
        this.organisation=organization;
        this.business=business;
        this.account=account;
        
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        requestButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Electricity Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 11, -1, -1));

        requestButton.setText("Manage Requests");
        requestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestButtonActionPerformed(evt);
            }
        });
        add(requestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 75, 155, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/electricity-760x506.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 810, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void requestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestButtonActionPerformed
        // TODO add your handling code here:
        Interface.Electricity.ManageElectricityRequestJPanel imcmojp = new Interface.Electricity.ManageElectricityRequestJPanel(userProcessContainer,enterprise,business,account);
        userProcessContainer.add("ManageElectricityRequestJPanel",imcmojp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_requestButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton requestButton;
    // End of variables declaration//GEN-END:variables
}