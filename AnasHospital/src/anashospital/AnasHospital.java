package anashospital;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AnasHospital extends JFrame{
    public AnasHospital() {
       
    }
    
    

    public static void main(String[] args) {
        fmenu f = new fmenu();
        
        drawingr g = new drawingr();
        g.setBounds(0, 0, 1920, 1080);
        f.add(g);
        f.setSize(1920, 1080);
        f.setTitle("Anas's Hospital");
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

