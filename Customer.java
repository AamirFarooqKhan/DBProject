/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.amazon;
import java.sql.*;
/**
 *
 * @author Aamir Khan
 */
public class Customer {
    private int customer_id;
    private String email;
    private String password;
    private String Customer_name;
    private int  Customer_acc;
    private Bank   Cust_bank = new Bank();
    private Connection con;
   
    
    
    //====================Getters & Setters ===========================//
    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomer_name() {
        return Customer_name;
    }

    public void setCustomer_name(String Customer_name) {
        this.Customer_name = Customer_name;
    }
     public int getCustomer_acc() {
        return Customer_acc;
    }

    public void setCustomer_acc(int Customer_acc) {
        this.Customer_acc = Customer_acc;
    }
    
    
    
    //Set values for Bank account of the customer.
    public void setCustomerBank(int num){
        num = this.getCustomer_acc();
        String sql = String.format("Select * from bank where acc_no = %d",num);
         try{
        /*     
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon","root","seecs@123");
        PreparedStatement ps = con.prepareStatement(sql);*/
        ResultSet         rs = Service.getResult(sql);
        while(rs.next()){
            Cust_bank.setAcc_no(rs.getInt(1));          
            Cust_bank.setCustomer_name(rs.getString(2));
            Cust_bank.setBalance(rs.getInt(3));}
        
       
        }
        
        catch(SQLException e){
            System.out.println("Error "+ e);
          
        }
        
    
    }
    
    public Bank getCustomerBank(){
        return Cust_bank;
    
    }
    //===================================================//
    
    public void Purchase(Inventory buy_item){
        if(buy_item.isInStock() && (this.getCustomerBank()).getBalance()>= buy_item.getItem_price()){
            System.out.println("Purhcase Successful");
            buy_item.updateInStock();
        }
        else{
            System.out.println("Purhcase Unsuccessful");
        
        }
       
        }
        
        
    
}
