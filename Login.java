/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.amazon;
import java.util.Scanner;
import java.sql.*;
/**
 *
 * @author Aamir Khan
 */

public class Login {

    Customer cust_1 = new Customer();
    boolean status;
    public Login(String email,String password){
        /*
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Email ");
        String email = sc.nextLine();
        System.out.print("Enter Password ");
        String password = sc.nextLine();
        */
        status = verification(email, password);
    
    }
     //Verifies if the mail and pass are correct by consulting the Database.
     public final boolean verification(String mail, String pass){
         //Customer cus_1 = new Customer();   //New customer object is created
         boolean logged_in = false;
          try{
        String sql = String.format("Select * from customer where email_address = \"%s\" and passward = \"%s\" ", mail,pass);
        /*Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon","root","seecs@123");
        PreparedStatement ps = con.prepareStatement(sql);*/
        
        ResultSet rs = Service.getResult(sql); //ps.executeQuery();
   
        while(rs.next()){ 
            cust_1.setCustomer_id(rs.getInt(1));
            cust_1.setEmail(mail);
            cust_1.setPassword(pass);
            cust_1.setCustomer_name(rs.getString(4));
            cust_1.setCustomer_acc( rs.getInt(5));
            cust_1.setCustomerBank(cust_1.getCustomer_acc());
            logged_in = true;}
            
            
            
        
        
        }
        
        catch(SQLException e){
            System.out.println("Error "+ e);
          
        }
       
        
          return logged_in;
    }
    
    public void printCustomer(){
        if(status){ //If logged in then 
        System.out.println("The customer just logged in ");
        System.out.printf("Customer name: %s\tCustomer_id = %d\t",cust_1.getCustomer_name(),cust_1.getCustomer_id());
        System.out.printf("Customer_accno = %d\t Balance = %d\t",cust_1.getCustomer_acc(),(cust_1.getCustomerBank()).getBalance());
        }
        else{   //If login failed.
            System.out.println("Authentication failed!!");
        }
    
    }
    
     }

