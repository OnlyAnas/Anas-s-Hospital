/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anashospital;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author anees
 */
public class AnasHospitald extends JFrame {
        // DB Connection
    String url = "jdbc:derby://localhost:1527/AnasHospital";
    String DBName = "anas";
    String DBPassword = "anas";
    //------
    JLabel anas = new JLabel("Anas's Hospital");
    JLabel who = new JLabel("Patient and Employee Services");
    JButton patient = new JButton("Patient Services");
    JButton Workers = new JButton("Employee Services");
    Icon img = new ImageIcon(getClass().getResource("health11.png"));
    JLabel image = new JLabel(img);
    //------ user GUI 
    JLabel id = new JLabel("Enter your national ID number : ");
    JTextField id_i  = new JTextField(50);
    JLabel file_n = new JLabel("Enter your file number : ");
    JTextField file_i = new JTextField(50);
    JButton login = new JButton("Login");
    //------- SQL    
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    public AnasHospitald(){
        setLayout(null);
        getContentPane().setBackground(Color.DARK_GRAY);
        image.setBounds(1650, 0, 240, 240);
        anas.setFont(new Font("serif", Font.BOLD+Font.ITALIC,120));
        anas.setForeground(Color.GRAY);
        anas.setBounds(550, 50, 1920, 100);
        who.setFont(new Font("serif", Font.BOLD + Font.ITALIC, 90));
        who.setForeground(Color.WHITE);
        who.setBounds(370, 200, 1920, 100);
        patient.setBounds(50, 550 , 650, 150);
        patient.setFont(new Font("serif", Font.BOLD + Font.PLAIN , 60));
        patient.setForeground(Color.BLACK);
        patient.setBackground(Color.WHITE);
        Workers.setBounds(1200, 550 , 650 , 150);
        Workers.setForeground(Color.BLACK);
        Workers.setBackground(Color.WHITE);
        Workers.setFont(new Font("serif", Font.BOLD + Font.PLAIN , 60));
        add(who);add(patient);add(Workers);add(anas);add(image);
        //---------------------------- First frame is done
        
        hand handler = new hand();
        patient.addActionListener(handler); // to create frame for patient
        Workers.addActionListener(handler); // ------------ For Employee
    }
    
    public class hand implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
                        if ( ae.getSource() == patient ) {
                            JFrame pf = new JFrame();
                            pf.setSize(1920, 1080);
                            pf.setVisible(true);
                            pf.setTitle("Patient Services");
                            pf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            pf.setLayout(null);
                            pf.getContentPane().setBackground(Color.DARK_GRAY);
                            id.setFont(new Font("serif", Font.BOLD+Font.PLAIN, 30));
                            id.setBounds(250, 100, 600, 300);
                            id.setForeground(Color.RED);
                            id_i.setBounds(800, 220, 400, 50);
                            id_i.setFont(new Font("serif", Font.BOLD,20));                            
                            file_n.setFont(new Font("serif", Font.BOLD+Font.PLAIN, 30));
                            file_n.setBounds(250, 440, 600, 300);
                            file_n.setForeground(Color.RED);
                            file_i.setBounds(800, 570, 400, 50);
                            file_i.setFont(new Font("serif", Font.BOLD,20));
                            login.setBounds(800, 700, 400, 100);
                            login.setFont(new Font("serif",Font.BOLD,30));
                            login.setForeground(Color.BLACK);
                            login.setBackground(Color.WHITE);
                            pf.add(id);pf.add(id_i);pf.add(file_n);pf.add(file_i);pf.add(login);pf.add(login);
                            
                            login.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {
                                    try {
                                         con = DriverManager.getConnection(url,DBName,DBPassword);
                                         st = con.createStatement();
                                         rs = st.executeQuery("select * from patient where p_national_id = '" + id_i.getText() +"' and p_file_number = '" + file_i.getText() + "'");
                                        
                                        if ( rs.next() ){
                                            JOptionPane.showMessageDialog(null, "Welcome to Anas's Hospital");
                                            JFrame pf1 = new JFrame();
                                            pf1.setSize(1920,1080);
                                            pf1.setVisible(true);
                                            pf1.setTitle("personal information");
                                            pf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                            pf1.setLayout(null);
                                            pf1.getContentPane().setBackground(Color.lightGray);
                                            JMenuBar mb = new JMenuBar();
                                            JMenu m1 = new JMenu("File");
                                            JMenuItem i1 = new JMenuItem("Print Page");
                                            mb.add(m1);m1.add(i1);
                                            mb.setBounds(0, 0, 60, 40);
                                            //----------
                                            JLabel urname = new JLabel();
                                            JLabel satu = new JLabel();
                                            JLabel blood = new JLabel();
                                            rs = st.executeQuery("select * from patient where p_national_id = '"+id_i.getText()+"'");
                                            rs.next();
                                            //---------------- get patient name and display it
                                            JLabel itname = new JLabel("Patient name :");
                                            itname.setForeground(Color.BLACK);
                                            itname.setFont(new Font("serif",Font.BOLD, 25));
                                            itname.setBounds(15, 60, 260, 90);
                                            // 2
                                            urname.setText(rs.getString("p_name"));
                                            urname.setForeground(Color.RED);
                                            urname.setFont(new Font("serif",Font.BOLD, 25));
                                            urname.setBounds(270, 60, 300, 90);
                                            //---------------- get patient file number and display it
                                            JLabel itfn = new JLabel("Patient File Number :");
                                            itfn.setForeground(Color.BLACK);
                                            itfn.setFont(new Font("serif",Font.BOLD, 25));
                                            itfn.setBounds(15, 90, 260, 120);
                                            // 2                                            
                                            JLabel urfn = new JLabel(file_i.getText());
                                            urfn.setForeground(Color.red);
                                            urfn.setFont(new Font("serif",Font.BOLD, 25));
                                            urfn.setBounds(270 ,90 , 300, 120);
                                            //---------------- get patient blood type and display it
                                            JLabel pblood = new JLabel();
                                            pblood.setText("Blood Type :");
                                            pblood.setForeground(Color.BLACK);
                                            pblood.setFont(new Font("serif",Font.BOLD, 25));
                                            pblood.setBounds(15, 120, 260, 150);
                                            //----------------
                                            blood.setText(rs.getString("p_blood"));
                                            blood.setForeground(Color.red);
                                            blood.setFont(new Font("serif",Font.BOLD, 25));
                                            blood.setBounds(270, 120, 300, 150);                                            
                                            //---------------- get patient satuation and display it
                                            JTextArea ta = new JTextArea();
                                            ta.setBounds(600, 200, 1000,400);
                                            ta.setText(rs.getString("report"));
                                            ta.setFont(new Font("serif", Font.BOLD, 20));
                                            ta.setForeground(Color.BLACK);
                                            ta.setEnabled(false);
                                            //----------------
                                            JLabel wsatu = new JLabel("PATIENT REPORT");
                                            wsatu.setForeground(Color.YELLOW);
                                            wsatu.setFont(new Font("serif",Font.BOLD, 50));
                                            wsatu.setBounds(900, 60, 1000, 100);
                                            //----------------
                                            pf1.add(itfn);pf1.add(urfn);pf1.add(itname);pf1.add((urname));pf1.add(ta);pf1.add(mb);pf1.add(pblood);pf1.add(blood);pf1.add(satu);pf1.add(wsatu);
                                        } else{
                                            JOptionPane.showMessageDialog(null, "Check your input again");}
                                        
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(null, ex);
                                        Logger.getLogger(AnasHospital.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            });
            }
                        
                        if( ae.getSource() == Workers ) {
                            JFrame wf = new JFrame();
                            wf.setSize(1920, 1080);
                            wf.setVisible(true);
                            wf.setTitle("Employee Services");
                            wf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            wf.setLayout(null);
                            wf.getContentPane().setBackground(Color.DARK_GRAY);
                            id.setFont(new Font("serif", Font.BOLD+Font.PLAIN, 30));
                            id.setBounds(250, 100, 600, 300);
                            id.setForeground(Color.RED);
                            id_i.setBounds(800, 220, 400, 50);
                            id_i.setFont(new Font("serif", Font.BOLD,20));                            
                            file_n.setFont(new Font("serif", Font.BOLD+Font.PLAIN, 30));
                            file_n.setBounds(250, 440, 600, 300);
                            file_n.setForeground(Color.RED);
                            file_i.setBounds(800, 570, 400, 50);
                            file_i.setFont(new Font("serif", Font.BOLD,20));
                            login.setBounds(800, 700, 400, 100);
                            login.setFont(new Font("serif",Font.BOLD,30));
                            login.setForeground(Color.BLACK);
                            login.setBackground(Color.WHITE);
                            wf.add(id);wf.add(id_i);wf.add(file_n);wf.add(file_i);wf.add(login);wf.add(login);
                            
                            login.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {
                                    try {
                                        con = DriverManager.getConnection(url,DBName,DBPassword);
                                        st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                        rs = st.executeQuery("select * from employee where e_national_id ='"+ id_i.getText() + "' and e_file_number = '" + file_i.getText() + "'");
                                          if(rs.next()){
                                             JOptionPane.showMessageDialog(null, "Welcome To Anas's Hospital");
                                             employee e1 = new employee();
                                             e1.setVisible(true);
                                             e1.setSize(1920,1080);
                                             e1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                             e1.setTitle("Employee Control Panel");
                                             e1.l1.setText(rs.getString("e_name"));
                                             e1.l2.setText(file_i.getText());
                                             
                                             
//                                             JLabel urname = new JLabel(rs.getString("e_name"));
//                                             JLabel urfile = new JLabel(id_i.getText());
//                                             //-----------
//                                            JLabel itname = new JLabel("Employee name :");
//                                            itname.setForeground(Color.BLACK);
//                                            itname.setFont(new Font("serif",Font.BOLD, 25));
//                                            itname.setBounds(15, 60, 260, 90);
//                                            //-------------
//                                            urname.setForeground(Color.RED);
//                                            urname.setFont(new Font("serif",Font.BOLD, 25));
//                                            urname.setBounds(270, 60, 300, 90); 
//                                            //-------------
//                                            //---------------- get Employee file number and display it
//                                            JLabel itfn = new JLabel("Employee File Number :");
//                                            itfn.setForeground(Color.BLACK);
//                                            itfn.setFont(new Font("serif",Font.BOLD, 25));
//                                            itfn.setBounds(15, 90, 260, 120);
//                                            // 2                                            
//                                            JLabel urfn = new JLabel(file_i.getText());
//                                            urfn.setForeground(Color.red);
//                                            urfn.setFont(new Font("serif",Font.BOLD, 25));
//                                            urfn.setBounds(270 ,90 , 300, 120);            
//                                           //--------------
//                                            //---------------- get patient blood type and display it
//                                            JLabel sdate = new JLabel("Begin of service date : ");
//                                            sdate.setForeground(Color.BLACK);
//                                            sdate.setFont(new Font("serif",Font.BOLD, 25));
//                                            sdate.setBounds(15, 120, 260, 150);
//                                            //----------------
//                                            sdate.setText(rs.getString("p_blood"));
//                                            sdate.setForeground(Color.red);
//                                            sdate.setFont(new Font("serif",Font.BOLD, 25));
//                                            sdate.setBounds(270, 120, 300, 150);                                             
                                          } else {
                                              JOptionPane.showMessageDialog(null, "Check your input");
                                          }
                                             
                                             
                                         
                                    } catch (SQLException ex) {
                                        Logger.getLogger(AnasHospital.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            });
                        }
            }
                
        }
}
