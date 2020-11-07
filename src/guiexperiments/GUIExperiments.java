/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiexperiments;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author diego
 */
public class GUIExperiments extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    
    JPanel panel = new JPanel();
    JTextField nameInput = new JTextField(20);
    JPasswordField passInput = new JPasswordField();
    BorderLayout manager = new BorderLayout();
    JLabel nLabel = new JLabel("UserName");
    JLabel pLabel = new JLabel ("Password");
    JLabel dLabel = new JLabel ("Don't have an account yet ?");
    JButton bSignIn = new JButton("Sign in");
    JButton bRegister = new JButton("Register");
    DBConnection conn = new DBConnection();
    MainWindowUser mWU ;
    MainWindowSProvider mWSP;
    
    
    
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        new GUIExperiments();
        
    }
    public GUIExperiments(){
        panel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.setVisible(true);
        this.setSize(450, 600);
        this.add(panel);
        panel.setBackground(new Color(10,15,45));
        this.setTitle("Welcome");
        //this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.black);
        
    
        ImageIcon image = new ImageIcon("C:\\Users\\diego\\Desktop\\GUI\\icon2.png");
        ImageIcon logo = new ImageIcon("C:\\Users\\diego\\Desktop\\GUI\\icon2.png");
        
      
        bSignIn.setBounds(175, 400, 80, 30);
        bRegister.setBounds(155, 470, 120, 30);
        dLabel.setBounds(135, 440, 300, 30);
        nLabel.setBounds(30, 290, 100, 30);
        pLabel.setBounds(30,340,100,30);
        nameInput.setBounds(110, 290, 210, 30);
        passInput.setBounds(110, 340, 210, 30);
        panel.add(bRegister);
        panel.add(bSignIn);
        panel.add(dLabel);
        panel.add(pLabel);
        panel.add(nLabel);
        panel.add(nameInput);
        panel.add(passInput);
        bRegister.addActionListener(this);
        bRegister.setActionCommand("Register");
        bSignIn.addActionListener(this);
        bSignIn.setActionCommand("SignIn");
        

           
        try{BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\diego\\Desktop\\GUI\\logo6.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panel.add(picLabel);
        picLabel.setBounds(110, 40, 200, 200);
        
        
        }
        catch(Exception ex){
            System.out.println("FUUUCK");
        }
        
        
        this.setIconImage(image.getImage());
        
        this.validate();
        this.repaint();
    }
        @Override
public void actionPerformed(ActionEvent arg0) {
    if(arg0.getActionCommand()== "Register"){
    System.out.println("Register");
    Register frame = new Register();
    //this.setVisible(false);
    }
    else if(arg0.getActionCommand() == "SignIn"){
        conn.Login(nameInput.getText(), passInput.getText());
      if(conn.lRV.b == true){
        System.out.println("Welcome");
       if(conn.lRV.i == 0){ 
        mWU = new MainWindowUser();
        this.dispose();
       }else if(conn.lRV.i == 1){
           mWSP = new MainWindowSProvider();
           this.dispose();
       }
    }else{
          
          System.out.println("failed to sign in...");
      }
    }
}
    
}
