/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiexperiments;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author diego
 */
public class MyFrame extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    ImageIcon image = new ImageIcon("C:\\Users\\diego\\Desktop\\GUI\\icon2.png");
    
    
    
    public MyFrame(){
        this.setIconImage(image.getImage());
        this.add(panel);
        panel.setBackground(new Color(10,15,45));
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
            @Override
public void actionPerformed(ActionEvent arg0) {
    if(arg0.getActionCommand()== "Register"){
    System.out.println("Register");
    }
    else if(arg0.getActionCommand() == "SignIn"){
        System.out.println("Login");
    }
}

}
