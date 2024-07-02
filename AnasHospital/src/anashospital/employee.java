/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anashospital;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author anees
 */
public class employee extends javax.swing.JFrame {
    /**
     * Creates new form employee
     */
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String url = "jdbc:derby://localhost:1527/AnasHospital";
    String DBName = "anas";
    String DBPassword = "anas";
    ResultSetMetaData md;
    public employee() {
        dbconnect();
        initComponents();
        
        
        hand handler = new hand();
        next.addActionListener(handler);
        prev.addActionListener(handler);
        update.addActionListener(handler);
        insert.addActionListener(handler);
        delete.addActionListener(handler);
        disp.addActionListener(handler);
    }
    
        public final void dbconnect() {
        try {
             con = DriverManager.getConnection(url,DBName,DBPassword);
             st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             rs = st.executeQuery("select * from patient");
             md = rs.getMetaData();
             rs.next();
             
        } catch (SQLException ex) {
            Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
        public class hand implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if ( ae.getSource() == next ) {
                try {
                    if (rs.next()){
                         t1.setText(rs.getString(1));
                        t2.setText(rs.getString(2));
                        t3.setText(rs.getString(3));
                        t4.setText(rs.getString(5));
                        report.setText(rs.getString("report"));     
                    }
                    else {
                        rs.previous();
                        JOptionPane.showMessageDialog(null, "End of file");
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ae.getSource() == prev) {
                try {
                    if (rs.previous()){
                         t1.setText(rs.getString(1));
                        t2.setText(rs.getString(2));
                        t3.setText(rs.getString(3));
                        t4.setText(rs.getString(5));
                        report.setText(rs.getString("report"));
                    }
                    else {
                        rs.next();
                        JOptionPane.showMessageDialog(null, "Begin of file");
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
            if ( ae.getSource() == insert ) {
                try {
                    rs.moveToInsertRow();
                    rs.updateString(1, t1.getText());
                    rs.updateString(2, t2.getText());
                    rs.updateString(3, t3.getText());
                    rs.updateString(4, report.getText());
                    rs.updateString(5, t4.getText());
                    rs.insertRow();
                    rs.close();
                    rs = st.executeQuery("select * from patient");
                    JOptionPane.showMessageDialog(null,"Patient added");
                        } catch (SQLException ex) {
                    Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ae.getSource() == update ) {
                try {
                    rs.moveToCurrentRow();
                    rs.updateString(1, t1.getText());
                    rs.updateString(2, t2.getText());
                    rs.updateString(3, t3.getText());
                    rs.updateString(4, report.getText());
                    rs.updateString(5, t4.getText());
                    rs.updateRow();
                    JOptionPane.showMessageDialog(null, "Patient information updated");
                } catch (SQLException ex) {
                    Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            if(ae.getSource() == delete) {
                try {
                    rs.moveToCurrentRow();
                    rs.deleteRow();
                    JOptionPane.showMessageDialog(null, "Patient Deleted");
                } catch (SQLException ex) {
                    Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if ( ae.getSource() == disp ) {
                try {
                 
                    int n = md.getColumnCount();
                    
                    for (int i = 1; i <= n; i++){
                        ta.append(md.getColumnName(i) + "    ");
                    }
                    while(rs.next()){
                        ta.append("\n" + rs.getString(1) + "    " + rs.getString(2) + "    " + rs.getString(3) + "    " + rs.getString(5)+ "\n");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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

        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        t3 = new javax.swing.JTextField();
        t4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        next = new javax.swing.JButton();
        prev = new javax.swing.JButton();
        insert = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        disp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        report = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Patient Name");

        jLabel2.setText("Patient ID");

        jLabel3.setText("Patient File num");

        jLabel4.setText("Patient B_Type");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Employee Name :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Employee File Num :");

        l1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l1.setForeground(new java.awt.Color(255, 0, 0));
        l1.setText("jLabel7");

        l2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l2.setForeground(new java.awt.Color(255, 0, 0));
        l2.setText("jLabel8");

        next.setText("Next Patient");

        prev.setText("Previous Patient");

        insert.setText("Insert Patient");

        update.setText("Update Patient");

        delete.setText("Delete Patient");

        disp.setText("Display all patient information");

        ta.setColumns(20);
        ta.setRows(5);
        jScrollPane1.setViewportView(ta);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Patient Report");

        report.setColumns(20);
        report.setRows(5);
        jScrollPane2.setViewportView(report);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(26, 26, 26)
                        .addComponent(l1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(disp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(next)
                                .addGap(18, 18, 18)
                                .addComponent(prev)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(insert)
                                .addGap(18, 18, 18)
                                .addComponent(update)
                                .addGap(18, 18, 18)
                                .addComponent(delete))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(310, 310, 310)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(next)
                                    .addComponent(prev)
                                    .addComponent(update)
                                    .addComponent(delete)
                                    .addComponent(insert)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)))
                        .addGap(49, 49, 49)
                        .addComponent(jLabel9)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(l1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(l2)
                            .addComponent(disp))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

                  

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JButton disp;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    javax.swing.JLabel l1;
    javax.swing.JLabel l2;
    private javax.swing.JButton next;
    private javax.swing.JButton prev;
    private javax.swing.JTextArea report;
    public javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    public javax.swing.JTextArea ta;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
