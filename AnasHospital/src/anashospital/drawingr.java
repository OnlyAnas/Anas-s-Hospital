/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anashospital;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.security.SecureRandom;
import javax.swing.*;

/**
 *
 * @author anees
 */
public class drawingr extends JPanel {
    
    public void paintComponent ( Graphics g ) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.drawLine(300, 400, 1550, 400);        
    }
}
