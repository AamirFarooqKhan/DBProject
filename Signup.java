/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.amazon;

/**
 *
 * @author Aamir Khan
 */

public class Signup {
    private boolean status;
     String email;
     String password;
     String name;
     int acc_no;
    public Signup(String mail,String pass,String name,int account){
        
        
         email = mail;
         password = pass;
         this.name     = name;
         acc_no = account;
         status = Bank.verifyBankAccount(acc_no, name);
         registration();
    }
    
    private void registration(){
        if(status){
         String sql = String.format("Insert into Customer (email_address,passward,customer_name,acc_no) values (\"%s\",\"%s\",\"%s\",%d);",email,password,name,acc_no );
         int updateResult = Service.getUpdateResult(sql);
         if(updateResult >  0){
             System.out.println("Registration Successful!!");
         }
         else{
             System.out.println("Registration failed!!");
         }
        }
        
        else{
            System.out.println("Registration failed!! Account number incorrect!!");
        }
    }


    public boolean getStatus(){
        return status;
        
}
}
    