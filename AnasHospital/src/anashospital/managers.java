/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anashospital;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author anees
 */
public class managers extends javax.swing.JFrame {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String url = "jdbc:derby://localhost:1527/AnasHospital";
    String DBName = "anas";
    String DBPassword = "anas";
    ResultSetMetaData md;
    /**
     * Creates new form managers
     */
    public managers() {
        dbconnect();
        initComponents();
        
        hand handler = new hand();
        disp.addActionListener(handler);
        //dispm.addActionListener(handler);
        dispe.addActionListener(handler);
    }
    
        private final void dbconnect() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        ta1 = new javax.swing.JTextArea();
        dispe = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tae = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        disp = new javax.swing.JButton();

        ta1.setColumns(20);
        ta1.setRows(5);
        jScrollPane2.setViewportView(ta1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dispe.setText("Display all employee information");

        tae.setColumns(20);
        tae.setRows(5);
        jScrollPane1.setViewportView(tae);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Manager Name :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Manager File Num :");

        l1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l1.setForeground(new java.awt.Color(255, 0, 0));
        l1.setText("jLabel7");

        l2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l2.setForeground(new java.awt.Color(255, 0, 0));
        l2.setText("jLabel8");

        ta.setColumns(20);
        ta.setRows(5);
        jScrollPane4.setViewportView(ta);

        disp.setText("Display all patient information");

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
                        .addGap(133, 133, 133)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(disp)
                        .addGap(402, 402, 402)
                        .addComponent(dispe)))
                .addContainerGap(1028, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(l1)
                    .addComponent(disp)
                    .addComponent(dispe))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(l2))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(309, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public class hand implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
           
                if ( ae.getSource() == disp ) {
                         try {
                             rs = st.executeQuery("select * from patient");
                             md = rs.getMetaData();
                             
                             int n = md.getColumnCount();
                    
                    for (int i = 1; i <= n; i++){
                        ta.append(md.getColumnName(i) + "    ");
                    }
                    while(rs.next()){
                        ta.append("\n" + rs.getString(1) + "    " + rs.getString(2) + "    " + rs.getString(3) + "    " + rs.getString(5)+ "\n");
                    }
                    rs.close();
                         } catch (SQLException ex) {
                             Logger.getLogger(managers.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     }
//                    if ( ae.getSource() == dispm ) {
//                try {
//                 rs = st.executeQuery("select * from managers");
//                 int n = md.getColumnCount();
//                    
//                    for (int i = 1; i <= n; i++){
//                        tam.append(md.getColumnName(i) + "    ");
//                    }
//                    while(rs.next()){
//                        tam.append("\n" + rs.getString(1) + "    " + rs.getString(2) + "    " + rs.getString(3) + "\n");
//                    }
//                   
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//            }
                     
                     if ( ae.getSource() == dispe ) {
                         try {
            rs = st.executeQuery("select * from employee");
            md = rs.getMetaData();
            
                 
                    int n = md.getColumnCount();
                    
                    for (int i = 1; i <= n; i++){
                        tae.append(md.getColumnName(i) + "    ");
                    }
                    while(rs.next()){
                        tae.append("\n" + rs.getString(1) + "         " + rs.getString(2) + "            " + rs.getString(3) + "                 " + rs.getString(4) + "                " + rs.getString(5)+ "\n");
                    }
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                     
                     
        }
                     
        
    
}
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
            java.util.logging.Logger.getLogger(managers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton disp;
    private javax.swing.JButton dispe;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    javax.swing.JLabel l1;
    javax.swing.JLabel l2;
    public javax.swing.JTextArea ta;
    public javax.swing.JTextArea ta1;
    public javax.swing.JTextArea tae;
    // End of variables declaration//GEN-END:variables
}
