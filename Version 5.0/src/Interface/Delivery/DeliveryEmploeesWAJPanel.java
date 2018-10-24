/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Delivery;

import Business.Customer.Customer;
import Business.Customer.Product;
import Business.Ecosystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organisation.DeliveryOrganisation;
import Business.Organisation.Grocery.GroceryOrganisation;
import Business.Organisation.Organisation;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ajaygoel
 */
public class DeliveryEmploeesWAJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DeliveryEmploeesWAJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    Enterprise enterprise;
    Ecosystem business;
    Organisation organisation;
    DeliveryOrganisation d;
    GroceryOrganisation goo;
    Customer c1;

    public DeliveryEmploeesWAJPanel(JPanel userProcessContainer, UserAccount account, Organisation organization, Enterprise enterprise, Ecosystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.business = business;
        this.enterprise = enterprise;
        this.organisation = organization;

        for (Organisation organization3 : enterprise.getOrganisationDirectory().getOrganizationlist()) {
            if (organization3 instanceof DeliveryOrganisation) {
                d = (DeliveryOrganisation) organization3;
            }
            if (organization3 instanceof GroceryOrganisation) {
                goo = (GroceryOrganisation) organization3;
            }

        }
        nameTxtField.setText(account.getEmployee().getName());

        populate_table();
        populate_assigned_table();

    }

    public void populate_table() {
        DefaultTableModel model = (DefaultTableModel) orderListJTbl.getModel();
        model.setRowCount(0);
        for (WorkRequest wr : d.getWorkQueue().getReqList()) {
            Object[] row = new Object[6];
            row[0] = wr.getCust();
            row[1] = wr.getStatus();
            row[2] = wr.getProduct();
            row[3] = wr;
            row[4] = wr.getReceiver();
            row[5] = wr.getResolveDate();
            model.addRow(row);

        }
    }

    public void populate_assigned_table() {
        DefaultTableModel model = (DefaultTableModel) Assigned_order_table.getModel();
        model.setRowCount(0);

        for (WorkRequest wr : account.getWorkQueue().getReqList()) {

            Object Row[] = new Object[6];
            Row[0] = wr.getCust();
            Row[1] = wr.getResolveDate();
            Row[2] = wr.getMessage();
            Row[3] = wr;
            Row[4] = wr.getReceiver();
            Row[5]= wr.getStatus();

            model.addRow(Row);
        }

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
        jLabel2 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        AssignBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Assigned_order_table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        DeliverAssignedBtn = new javax.swing.JButton();
        CancelAssignedBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderListJTbl = new javax.swing.JTable();
        nameTxtField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Delivery Employee work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 11, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Order Details");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 60, -1, -1));

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 239, -1, -1));

        AssignBtn.setText("Assign to me");
        AssignBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssignBtnActionPerformed(evt);
            }
        });
        add(AssignBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 239, 504, -1));

        Assigned_order_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Detail", "Resolve Date", "Message", "request Date", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(Assigned_order_table);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 389, 752, 126));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Assigned by Admin:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 342, -1, -1));

        DeliverAssignedBtn.setText("Deliver Order");
        DeliverAssignedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeliverAssignedBtnActionPerformed(evt);
            }
        });
        add(DeliverAssignedBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 533, -1, -1));

        CancelAssignedBtn.setText("Cancel Order");
        CancelAssignedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelAssignedBtnActionPerformed(evt);
            }
        });
        add(CancelAssignedBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 533, 143, -1));

        orderListJTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Detail", "Status", "Product", "Request Date", "Receiver", "Resolve Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(orderListJTbl);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 91, 812, 122));
        add(nameTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 15, 106, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Welcome !");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 11, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/todo-list-1024x916.jpg"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void AssignBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssignBtnActionPerformed
        // TODO add your handling code here:

        int row = orderListJTbl.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkRequest wr = (WorkRequest) orderListJTbl.getValueAt(row, 3);

        if (wr.getStatus().equals("Delivered")) {
            JOptionPane.showMessageDialog(null, "The product is already delivered", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (wr.getReceiver()!=null) {
        if(wr.getReceiver().equals(account))
        {
            {
            JOptionPane.showMessageDialog(null, "The request is already assigned to you", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        }
        }
        
        
        wr.setReceiver(account);
        account.getWorkQueue().getReqList().add(wr);
        wr.getCust().getNotification().addNotification(wr);
        JOptionPane.showMessageDialog(null, "The request has been successfully assigned to you", "Information", JOptionPane.INFORMATION_MESSAGE);

        populate_assigned_table();
        populate_table();

    }//GEN-LAST:event_AssignBtnActionPerformed

    private void DeliverAssignedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeliverAssignedBtnActionPerformed
        // TODO add your handling code here:

        int row = Assigned_order_table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkRequest wr = (WorkRequest) Assigned_order_table.getValueAt(row, 3);
        if (wr.getStatus().equals("Delivered")) {
            JOptionPane.showMessageDialog(null, "This request has already been closed", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        
        
        wr.setStatus("Delivered");
        wr.setMessage("Delivered");
        wr.getCust().getNotification().addNotification(wr);
        Date resolveDate = new Date();
        wr.setResolveDate(resolveDate);

        JOptionPane.showMessageDialog(null, "The request has been completed", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);

        double amountTOAdd = 0;
        amountTOAdd = Double.valueOf(wr.getProduct().getPrice());
        d.addMoney(amountTOAdd * 0.1);

        populate_assigned_table();
        populate_table();

        Customer c1 = (Customer) orderListJTbl.getValueAt(row, 0);
        for (Product p1 : c1.getProdList()) {
            if (p1 != null) {
                //if (p1.getName().equals(prod.getName())) {
                if (p1 == wr.getProduct()) {
                    if (p1.getOrder_status().equals("Pending to be delivered") || p1.getOrder_status().equals("Automatic sent to Delivery")) {
                        p1.setOrder_status("Delivered");
                        p1.setQuantity_left(p1.getQuantity_left() + p1.getProductQuant());

                        JOptionPane.showMessageDialog(null, "Product Delivered", "Information", JOptionPane.INFORMATION_MESSAGE);
                        populate_table();

                        Properties props = new Properties();
                        props.put("mail.smtp.host", "smtp.gmail.com");
                        props.put("mail.smtp.socketFactory.port", "465");
                        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                        props.put("mail.smtp.auth", "true");
                        props.put("mail.smtp.port", "465");
                        Session session = Session.getDefaultInstance(props,
                                new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication("aedproject2018@gmail.com", "aedProject2");
                            }
                        }
                        );

                        try {
                            Message message = new MimeMessage(session);
                            message.setFrom(new InternetAddress("aedproject2018@gmail.com"));//ajaygoel1993@gmail.com,yadav.ank@husky.neu.edu,solanki.h@husky.neu.edu"
                            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(c1.getE_mail()));
                            message.setSubject("IOT SMART HOME");
                            Date date1 = new Date();
                            message.setText("Your product " + p1.getProdName() + " has been delivered on " + date1);
                            Transport.send(message);

                            JOptionPane.showMessageDialog(null, "message sent");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }

                        JOptionPane.showMessageDialog(null, "Product delivered", "Information", JOptionPane.INFORMATION_MESSAGE);
                        populate_table();
                    } else if (p1.getOrder_status().equals("Delivered")) {
                        JOptionPane.showMessageDialog(null, "This product is already delivered", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else if (p1.getOrder_status().equals("Cancelled")) {
                        JOptionPane.showMessageDialog(null, "This product is cancelled.", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                }
            }

        }


    }//GEN-LAST:event_DeliverAssignedBtnActionPerformed

    private void CancelAssignedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelAssignedBtnActionPerformed
        // TODO add your handling code here:

        // TODO add your handling code here:
        int row = Assigned_order_table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkRequest wr = (WorkRequest) Assigned_order_table.getValueAt(row, 3);
        if (wr.getStatus().equals("Cancelled")) {
            JOptionPane.showMessageDialog(null, "This request has already been closed", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        wr.setStatus("Cancelled");
        wr.setMessage("Cancelled");
        wr.getCust().getNotification().addNotification(wr);
        Date resolveDate = new Date();
        wr.setResolveDate(resolveDate);

        JOptionPane.showMessageDialog(null, "The request has been Cancelled", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        populate_assigned_table();
        populate_table();
        
        for(WorkRequest wr4:goo.getWorkQueue().getReqList())
        {
            if(wr4.equals(wr))
            {
                double amountTOdel=0;
                        amountTOdel = Double.valueOf(wr.getProduct().getPrice());
                        goo.addMoney(amountTOdel*0.1);
                        goo.debitMoney(wr,amountTOdel);
                        d.debitMoney(wr, amountTOdel*0.1);
            }
        }
        
        

        Customer c1 = (Customer) Assigned_order_table.getValueAt(row, 0);

        for (Product p2 : c1.getProdList()) {

            if (p2 == wr.getProduct()) {
                System.out.println(p2.getOrder_status());
                if (p2.getOrder_status().equalsIgnoreCase("Pending at delivery employee") || p2.getOrder_status().equals("Automatically generated at delivery ")
                        || p2.getOrder_status().equalsIgnoreCase("Pending to be delivered")||p2.getOrder_status().equals("Automatically generated at grocery")) {
                    p2.setOrder_status("Cancelled");

                    double amountTOdel = 0;
                    amountTOdel = Double.valueOf(wr.getProduct().getPrice());
                    wr.getCust().addMoney(amountTOdel);

                    JOptionPane.showMessageDialog(null, "Product Cancelled", "Information", JOptionPane.INFORMATION_MESSAGE);
                    populate_table();

                    Properties props = new Properties();
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.socketFactory.port", "465");
                    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.port", "465");
                    Session session = Session.getDefaultInstance(props,
                            new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("aedproject2018@gmail.com", "aedProject2");
                        }
                    }
                    );

                    try {
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress("aedproject2018@gmail.com"));//ajaygoel1993@gmail.com,yadav.ank@husky.neu.edu,solanki.h@husky.neu.edu"
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(c1.getE_mail()));
                        message.setSubject("IOT SMART HOME");
                        Date date1 = new Date();
                        message.setText("Your product " + p2.getProdName() + " has been cancelled on " + date1);
                        Transport.send(message);

                        JOptionPane.showMessageDialog(null, "message sent");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }

                }
            }
        }
        populate_assigned_table();
        populate_table();
    }//GEN-LAST:event_CancelAssignedBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AssignBtn;
    private javax.swing.JTable Assigned_order_table;
    private javax.swing.JButton CancelAssignedBtn;
    private javax.swing.JButton DeliverAssignedBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nameTxtField;
    private javax.swing.JTable orderListJTbl;
    // End of variables declaration//GEN-END:variables
}
