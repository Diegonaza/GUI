/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiexperiments;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author diego
 */
public class Register extends MyFrame implements ActionListener{
    BorderLayout bLayout = new BorderLayout();
    GridLayout gLayout = new GridLayout(1,2);
    GridLayout gLayoutL = new GridLayout(2,1,10,10);
    FlowLayout fLayout = new FlowLayout();
    JPanel pLeft = new JPanel();
    JPanel pSouth = new JPanel();
    JPanel pCenter = new JPanel();
    JPanel pCenterLeft = new JPanel();
    JPanel pCenterRight = new JPanel();
    JPanel pTopLeft = new JPanel();
    JPanel pMidLeft = new JPanel();
    JPanel pbotLeft = new JPanel();
    JPanel pRegister = new JPanel();
    JPanel pRegSProvider = new JPanel();
    ImageIcon logo = new ImageIcon("C:\\Users\\diego\\Desktop\\GUI\\icon2.png");
    JCheckBox checkUser = new JCheckBox();
    JCheckBox checkSProvider = new JCheckBox();
    JLabel lCheckUser = new JLabel("I'm a Customer");
    JLabel lCheckSProvider = new JLabel("I'm a Service Provider");
    JLabel lUGName = new JLabel ("Given Name :");
    MyTextArea lNameInfo = new MyTextArea("* Name must be at least 2 characters long and can not contain special characters, numbers or space .");
    JLabel lUSName = new JLabel ("Surname :");
    MyTextArea lSurnameInfo = new MyTextArea("* Surname must be at least 2 characters long and can not contain special characters, numbers or space .");
    JLabel lUPNumber = new JLabel ("Phone number :");
    MyTextArea lPhoneInfo = new MyTextArea("* Phones must follow this pattern xxx-xxx-xxx-xxxx, only numbers accepted .");
    JLabel lUEmail = new JLabel ("Email :");
    MyTextArea lEmailInfo = new MyTextArea("* Please enter a valid email address .");
    JLabel lUPassword = new JLabel ("Password :");
     MyTextArea lPasswordInfo = new MyTextArea("* Password must be at least 8 characters long and must have at least one Capital letter and one number.");
    JLabel lUCPassword = new JLabel ("Confirm Password :");
    MyTextArea lConfirmPasswordInfo = new MyTextArea("* Passwords must match .");
    JLabel lULocation = new JLabel ("Location :");
     MyTextArea lLocationInfo = new MyTextArea("* Must not be empty .");
    JLabel lConfirmedReg = new JLabel ("Registration is now Completed"); 
    JPasswordField tUCPassword = new JPasswordField();
    JPasswordField tUPassword = new JPasswordField();
    JTextField tULocation = new JTextField();
    JTextField tUEmail = new JTextField ();
    JTextField tUPNumber = new JTextField ();
    JTextField tUGName = new JTextField();
    JTextField tUSName = new JTextField();
    JTextArea tUserCat = new JTextArea("Before we start your registration, please let us know which option describes you better :");
    JButton bProceed = new JButton("Proceed");
    JButton bCancel = new JButton ("Cancel");
    JButton bConfirm = new JButton ("Confirm");
    JButton bOk = new JButton ("Ok");
    sendSMS sms = new sendSMS();  
    FormReturnValues formValues = new FormReturnValues();
    DBConnection register = new DBConnection();
    
    
    public Register(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel.setLayout(bLayout);
        panel.add(pLeft,BorderLayout.WEST);
        pLeft.setPreferredSize(new Dimension(300,100));
        pLeft.setLayout(gLayoutL);
        pLeft.setBackground(Color.black);
        pLeft.add(pTopLeft);
        pTopLeft.setBackground(new Color(10,15,45));
        pTopLeft.setBorder(BorderFactory.createLineBorder(new Color(255,255,255), 5, false));
        pTopLeft.setLayout(null);
        pTopLeft.add(checkUser);
        pTopLeft.add(checkSProvider);
        pTopLeft.add(lCheckUser);
        pTopLeft.add(lCheckSProvider);
        pTopLeft.add(bProceed);        
        pTopLeft.add(tUserCat);
        this.validate();
        bProceed.setBounds(40, 230, pTopLeft.getWidth()-80,30);
        bProceed.addActionListener(this);
        
        tUserCat.setWrapStyleWord(true);
        tUserCat.setLineWrap(true);
        tUserCat.setOpaque(false);
        tUserCat.setEditable(false);
        tUserCat.setFocusable(false);
        this.validate();
        tUserCat.setBounds(20, 20, (pTopLeft.getWidth()-20), 100);
        tUserCat.setFont(new Font("Serif",Font.BOLD,16));
        tUserCat.setForeground(new Color(200,200,200));
        
        lCheckUser.setBounds(85, 150, 100, 30);
        checkUser.setBackground(new Color(10,15,45));
        checkUser.setBounds(50, 150, 30, 30);
        checkUser.addActionListener(this);
        lCheckSProvider.setBounds(85, 175, 150, 30);
        checkSProvider.setBackground(new Color(10,15,45));
        checkSProvider.setBounds(50, 175, 30, 30);
        checkSProvider.addActionListener(this);
               
               
        panel.add(pCenter, BorderLayout.CENTER);
        
        
        pCenter.setBackground(Color.red);
        pCenter.setLayout(gLayout);
        pCenter.add(pCenterLeft);
        pCenter.add(pCenterRight);
        
        pCenterLeft.setBackground(new Color(10,15,45));
        pCenterLeft.setLayout(null);
        pCenterLeft.setBorder(BorderFactory.createLineBorder(new Color(255,255,255), 5, false));
        lConfirmedReg.setVisible(false);
        pCenterLeft.add(lConfirmedReg);
        lConfirmedReg.setBounds(200, 100, 550, 50);
        lConfirmedReg.setFont(new Font("Serif",Font.BOLD,32));
        lConfirmedReg.setForeground(new Color(255,255,255));
        pCenterLeft.add(bOk);
        bOk.setBounds(275, 175, 250, 30);
        bOk.addActionListener(this);
        bOk.setVisible(false);
        
        
        pCenterRight.setBackground(new Color(255,255,255));
        pCenterRight.setLayout(null);
              try{BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\diego\\Desktop\\GUI\\logo9.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        pCenterRight.add(picLabel);
        this.validate();
        this.repaint();
        picLabel.setBounds(0,-10,pCenterRight.getWidth(),pCenterRight.getHeight());
                      
        }
        catch(Exception ex){
            System.out.println("FUUUCK");
        }
              
              
        
              
              
              
        pRegister.setBackground(new Color(10,15,45));
        pRegister.setBorder(BorderFactory.createLineBorder(new Color(255,255,255), 5, false));
        pCenterLeft.add(pRegister);
        
        pRegister.setLayout(null);
        pRegister.setSize(pCenterLeft.getSize());
        pRegister.add(lUGName);
        pRegister.add(tUGName);
        pRegister.add(lNameInfo);
            lUGName.setBounds(50, 100, 100, 30);
            tUGName.setBounds(50, 130, 220, 30);
            lNameInfo.setBounds(320, 130, 400, 60);
            tUGName.setText("");
        pRegister.add(lUSName);
        pRegister.add(tUSName);
        pRegister.add(lSurnameInfo);
            lUSName.setBounds(50, 160, 100, 30);
            tUSName.setBounds(50, 190, 220, 30);
            lSurnameInfo.setBounds(320, 190, 400, 60);
            tUSName.setText("");
        pRegister.add(lUPNumber);
        pRegister.add(tUPNumber);
        pRegister.add(lPhoneInfo);
            lUPNumber.setBounds(50, 220, 100, 30);
            tUPNumber.setBounds(50, 250, 220, 30);
            lPhoneInfo.setBounds(320, 250, 400, 60);
            tUPNumber.setText("");
        pRegister.add(lUEmail);
        pRegister.add(tUEmail);
        pRegister.add(lEmailInfo);
            lUEmail.setBounds(50, 280, 100, 30);
            tUEmail.setBounds(50, 310, 220, 30);
            lEmailInfo.setBounds(320, 310, 400, 60);
            tUEmail.setText("");
        pRegister.add(lUPassword);
        pRegister.add(tUPassword);
        pRegister.add(lPasswordInfo);
            lUPassword.setBounds(50, 340, 100, 30);
            tUPassword.setBounds(50, 370, 220, 30);
            lPasswordInfo.setBounds(320, 370, 400, 60);
            tUPassword.setText("");
        pRegister.add(lUCPassword);
        pRegister.add(tUCPassword);
        pRegister.add(lConfirmPasswordInfo);
            lUCPassword.setBounds(50, 400, 150, 30);
            tUCPassword.setBounds(50, 430, 220,30);
            lConfirmPasswordInfo.setBounds(320, 430, 220, 60);
            tUCPassword.setText("");
        pRegister.add(bCancel);
            bCancel.setBounds(50, 600, 100, 30);
            bCancel.addActionListener(this);
        pRegister.add(bConfirm);
            bConfirm.setBounds(170, 600, 100, 30);
            bConfirm.addActionListener(this);
            
            pRegister.add(lULocation);
            pRegister.add(tULocation);
            pRegister.add(lLocationInfo);
            lULocation.setBounds(50, 460, 100, 30);
            tULocation.setBounds(50, 490, 220, 30);
            lLocationInfo.setBounds(320, 490, 400, 60);
            tULocation.setText("");
            pRegister.setVisible(false);
                
            
            this.validate();
            this.repaint();
              
              
    

}
    
    public  FormReturnValues ValidateForm(FormReturnValues input){
        //ref https://www.youtube.com/watch?v=OOdO785p3Qo
        
        String emailRegex =  "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        String phoneRegex = "^[0-9]{3}+[0-9]{3}+[0-9]{3}+[0-9]{4}$";
        String nameRegex = "^[A-Z ']{2,40}$";
       
        
        
        Pattern phonePattern = Pattern.compile(phoneRegex, Pattern.CASE_INSENSITIVE);
        Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Pattern namePattern = Pattern.compile(nameRegex,Pattern.CASE_INSENSITIVE);
        
        
        Matcher matcher = emailPattern.matcher(input.email);
        input.isEmailValid = matcher.find();
        
        
        matcher = phonePattern.matcher(input.phone);
        input.isPhoneValid = matcher.find();
        
        matcher = namePattern.matcher(input.name);
        input.isNameValid = matcher.find();
        matcher = namePattern.matcher(input.surname);
        input.isSurnameValid = matcher.find();
        
        if(input.password.length()>=8){
        for(int i =0; i<input.password.length(); i++){
         if(Character.isUpperCase(input.password.charAt(i))== true){
             
           for(int y=0; y<input.password.length(); y++){
               if(Character.isDigit(input.password.charAt(y))==true){
                   input.isPasswordValid = true;
                   break;
               }
           } 
        }
        }
        }else{
            input.isPasswordValid = false;
        }
        if (input.confirmPassword.equals(input.password)){
            input.isConfirmValid = true;
        }else
            input.isConfirmValid = false;
        if(input.Location.isBlank()){
            input.isValidLocation = false;
        }else{
            input.isValidLocation = true;
        }
        
         return input;
    }
    
    public void SetFormValues(FormReturnValues in){
       
        
        if(in.isNameValid == false){
            lNameInfo.setVisible(true);                            
        }else{
            lNameInfo.setVisible(false);
        }
            if(in.isSurnameValid == false){
            lSurnameInfo.setVisible(true);
        }else{
            lSurnameInfo.setVisible(false);
            }
            
            if(in.isPhoneValid==false){
            lPhoneInfo.setVisible(true);
        }else{
            lPhoneInfo.setVisible(false);
            }
            if(in.isEmailValid==false){
            lEmailInfo.setVisible(true);
        }else{
            lEmailInfo.setVisible(false);
            }
            if(in.isPasswordValid==false){
            lPasswordInfo.setVisible(true);
        }else{
            lPasswordInfo.setVisible(false);
            }
            if(in.isConfirmValid==false){
            lConfirmPasswordInfo.setVisible(true);
            }else{
            lConfirmPasswordInfo.setVisible(false);
            }
            if(checkSProvider.isSelected()&&in.isValidLocation==false){
            lLocationInfo.setVisible(true);
            }else{
                lLocationInfo.setVisible(false);
            }
            if(checkSProvider.isSelected()){
            if(in.isConfirmValid&&in.isEmailValid&&in.isNameValid&&in.isPasswordValid&&in.isPhoneValid&&in.isSurnameValid&&in.isValidLocation){
            register.InsertRegister(in.name+" "+in.surname, in.phone, in.email, in.password, in.Location, 1);    
            System.out.println("Form is Valid");
            pRegister.setVisible(false);
            formValues.Reset();
            lConfirmedReg.setVisible(true);
            bOk.setVisible(true);
            }
            }
            if(checkUser.isSelected()){
                if(in.isConfirmValid&&in.isEmailValid&&in.isNameValid&&in.isPasswordValid&&in.isPhoneValid&&in.isSurnameValid){
            System.out.println("Form is Valid");
            register.InsertRegister(in.name+" "+in.surname, in.phone, in.email, in.password, in.Location, 0);
            pRegister.setVisible(false);
            formValues.Reset();
             lConfirmedReg.setVisible(true);
             bOk.setVisible(true);
            }
            }
        
        
        
    }
    
    
    public void SetTLPanel(int i){
        if(i == 1){
            pTopLeft.setVisible(false);
            checkUser.setEnabled(false);
            checkUser.setVisible(false);
            checkSProvider.setEnabled(false);
            checkSProvider.setVisible(false);
            bProceed.setEnabled(false);
            bProceed.setVisible(false);
        }
        else if (i == 2){
            pTopLeft.setVisible(true);
            checkUser.setEnabled(true);
            checkUser.setSelected(false);
            checkUser.setVisible(true);
            checkSProvider.setEnabled(true);
            checkSProvider.setSelected(false);
            checkSProvider.setVisible(true);
            bProceed.setEnabled(true);
            bProceed.setVisible(true);
        }
    }
    
    
    
    public void SetForm(boolean b){
       if(b==true){
          pRegister.setVisible(true);
          tULocation.setVisible(true);
          lULocation.setVisible(true);
       }else{
           pRegister.setVisible(true);
           tULocation.setVisible(false);
           lULocation.setVisible(false);
       }
        
    }
   
    public void ResetInfoPanel(){
        lNameInfo.setVisible(false);
        lSurnameInfo.setVisible(false);
        lPhoneInfo.setVisible(false);
        lEmailInfo.setVisible(false);
        lPasswordInfo.setVisible(false);
        lConfirmPasswordInfo.setVisible(false);
        lLocationInfo.setVisible(false);
        tUGName.setText("");
        tUSName.setText("");
        tUPNumber.setText("");
        tUEmail.setText("");
        tUPassword.setText("");
        tUCPassword.setText("");
        tULocation.setText("");
    }
    
        @Override
     public void actionPerformed(ActionEvent e) {
    if(e.getSource()== checkUser){
        if(checkUser.isSelected()){
            System.out.println("SELECTED");
            checkSProvider.setSelected(false);
            checkSProvider.setEnabled(false);
        }
        else if(checkUser.isSelected()==false){
            checkSProvider.setEnabled(true);
        }
    }
    else if(e.getSource()== checkSProvider){
         if(checkSProvider.isSelected()){
             checkUser.setSelected(false);
             checkUser.setEnabled(false);
         }
         else if(checkSProvider.isSelected()==false){
             checkUser.setEnabled(true);
         }
    }
    else if(e.getSource()== bProceed){
        if(checkUser.isSelected()){
            ResetInfoPanel();
            formValues.Reset();
            //pCenterLeft.remove(pRegister);
            SetForm(false);
            SetTLPanel(1);
        }
        else if(checkSProvider.isSelected()) {
            
            ResetInfoPanel();
            formValues.Reset();
            //pCenterLeft.remove(pRegister);
            
            
            SetForm(true);
            SetTLPanel(1);
        }
       
        else{
            System.out.println("Required fields");
        }
    }
    
     else if(e.getSource()== bCancel){
         
            //pCenterLeft.remove(pRegister);
            pRegister.setVisible(false);
            formValues.Reset();
            SetTLPanel(2);
            this.validate();
            this.repaint();
            
        }
     else if(e.getSource()==bConfirm){
        
        //sms.sendSms();
       // System.out.println("SMS sent");
     formValues.name     = tUGName.getText();
     formValues.surname  = tUSName.getText();
     formValues.phone    = tUPNumber.getText();
     formValues.email    = tUEmail.getText();
     formValues.password = tUPassword.getText();
     formValues.confirmPassword = tUCPassword.getText();
     formValues.Location = tULocation.getText();
       
     
      
       SetFormValues(ValidateForm(formValues));
       formValues.Reset();
       
     }
     else if(e.getSource()==bOk){
         this.dispose();
     }
    
}
     
     
}
