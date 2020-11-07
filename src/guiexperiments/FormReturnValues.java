/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiexperiments;

/**
 *
 * @author diego
 */
public class FormReturnValues {
    
    String name;
    String surname;
    String phone;
    String email;
    String password;
    String confirmPassword;
    String Location;
    boolean isNameValid = false;
    boolean isSurnameValid = false;
    boolean isPhoneValid = false;
    boolean isEmailValid = false;
    boolean isPasswordValid = false;
    boolean isConfirmValid = false;
    boolean isValidLocation = false;
    
    public FormReturnValues(){
        
    }
    
    public void Reset(){
        name = "";
        surname = "";
        phone = "";
        email = "";
        password = "";
        confirmPassword="";
        Location="";
    isNameValid = false;
    isSurnameValid = false;
    isPhoneValid = false;
    isEmailValid = false;
    isPasswordValid = false;
    isConfirmValid = false;
    isValidLocation = false;
    }
}
