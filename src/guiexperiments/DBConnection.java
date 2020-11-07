/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiexperiments;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author diego
 */
public class DBConnection {
    Connection conn ;
    LoginReturnValues lRV = new LoginReturnValues();
    public DBConnection(){
        
  
    }
    
    public void InsertRegister(String name, String phone, String email,String password, String location, int issp){
        
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "user", "123");
            System.out.println("YAY");
            PreparedStatement reg = conn.prepareStatement("INSERT INTO users(name,phone,email,password,location,issp) values ('"+name+"','"+phone+"','"+email+"','"+password+"','"+location+"','"+issp+"')");
         
         
         reg.executeUpdate();
         conn.close();
         
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public LoginReturnValues Login(String userName,String password){
        String pass = "";
        int issp = 3;
        try{
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "user", "123");
        String sel = "SELECT password, issp FROM user.users where email = '"+userName+"' ";
       Statement signin = conn.createStatement();
        ResultSet rs = signin.executeQuery(sel);
        while(rs.next()){
            pass = rs.getString("password");
            issp = rs.getInt("issp");
        }
        
        if(pass.equals(password )&& pass.isBlank()==false){
            System.out.println("Ez Login");
            signin.close();
            conn.close();
            lRV.b = true;
            lRV.i = issp;
            return lRV;
            
        }else{
            lRV.b = false;
            lRV.i = 99;
            System.out.println("Username or password incorrect");
            System.out.println(pass);
            System.out.println(password);
           
            
        }
        
        signin.close();
        conn.close();
        
        }catch(Exception e){
            
        }
        return null;
        
    }
    
}
