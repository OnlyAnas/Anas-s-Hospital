/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anashospital;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 *
 * @author anees
 */
public class fmenu extends javax.swing.JFrame {
String url = "jdbc:derby://localhost:1527/AnasHospital";
    String DBName = "anas";
    String DBPassword = "anas";
    JLabel id = new JLabel("Enter your national ID number : ");
    JTextField id_i = new JTextField(50);
    JLabel file_n = new JLabel("Enter your file number : ");
    JTextField file_i = new JTextField(50);
    JButton login = new JButton("Login");
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    /**
     * Creates new form fmenu
     */
    public fmenu() {
        dbconnect();
        initComponents();
    }
        public final void dbconnect() {
        try {
             con = DriverManager.getConnection(url,DBName,DBPassword);
             st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             rs = st.executeQuery("select * from managers");
             rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText(" Press File to go to Anas's Hospital");

        jMenu1.setText("File");

        jMenuItem1.setText("Patient and Employee Services");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Managment Services");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(264, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AnasHospitald h = new AnasHospitald();
        h.setSize(1920, 1080);
        h.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JFrame f = new JFrame();
        f.setSize(1920, 1080);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Managers Login");
        f.setLayout(null);
        f.getContentPane().setBackground(Color.DARK_GRAY);
        id.setFont(new Font("serif", Font.BOLD + Font.PLAIN, 30));
        id.setBounds(250, 100, 600, 300);
        id.setForeground(Color.RED);
        id_i.setBounds(800, 220, 400, 50);
        id_i.setFont(new Font("serif", Font.BOLD, 20));
        file_n.setFont(new Font("serif", Font.BOLD + Font.PLAIN, 30));
        file_n.setBounds(250, 440, 600, 300);
        file_n.setForeground(Color.RED);
        file_i.setBounds(800, 570, 400, 50);
        file_i.setFont(new Font("serif", Font.BOLD, 20));
        login.setBounds(800, 700, 400, 100);
        login.setFont(new Font("serif", Font.BOLD, 30));
        login.setForeground(Color.BLACK);
        login.setBackground(Color.WHITE);
        f.add(id);
        f.add(id_i);
        f.add(file_n);
        f.add(file_i);
        f.add(login);
        
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                        if ( ae.getSource() == login ) {  
                try {
                    rs = st.executeQuery("select * from managers where m_id ='"+ id_i.getText() + "' and m_file = '" + file_i.getText() + "'");
                    
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Welcome To Anas's Hospital Managment");
                        managers m = new managers();
                        m.setVisible(true);
                        m.setSize(1920,1080);
                        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        m.setTitle("Managers Control Panel");
                        m.l1.setText(rs.getString("m_name"));
                        m.l2.setText(file_i.getText());
                        
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Check your input");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(fmenu.class.getName()).log(Level.SEVERE, null, ex);
                }
}}
        });
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(fmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fmenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables

}
