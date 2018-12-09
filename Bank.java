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
import java.sql.*;
public class Bank {
    private int acc_no;
    private String customer_name;
    private int    balance;

    //==========================Getters & Setters ==========================//
    public int getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(int acc_no) {
        this.acc_no = acc_no;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
   //=============================================================//
    public static boolean verifyBankAccount(int acc_no,String name){
         boolean verified = false; 
        try{    
          
        String Myname = " ";    
        String sql = "Select * from bank where acc_no = "+acc_no;
            ResultSet rs = Service.getResult(sql);
            while(rs.next()){
                  Myname = rs.getString(2);
            }
            if(Myname.matches(name)){
                verified = true;
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return verified;    
    }
}
