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
public class Inventory {
    private int inventory_id;
    private String item_name;
    private int    item_price;
    private String delivery_date;
    private String image_url;
    private String item_description;
    private Connection con;
    
    //====================Getters & Setters ==============================//
    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_price() {
        return item_price;
    }

    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }

    

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }
    //===================================================================//
    
    //Check if item is in stock.
    public boolean isInStock(){
        boolean exists = false ;
        try{
        /*    
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon","root","seecs@123");
        PreparedStatement ps = con.prepareStatement("Select instock from inventory where inventory_id = "+this.getInventory_id());*/
        String sql = "Select instock from inventory where inventory_id = "+this.getInventory_id();
        ResultSet         rs = Service.getResult(sql);
        while(rs.next()){
            if(rs.getInt(1) > 0){ //If in stock > 0
                exists = true;
                System.out.println("There are " + rs.getInt(1) + " items in stock");
            }
        }
        }
        
        catch(SQLException e){
            System.out.println("Error "+ e);
            return false;
        }
        
        return exists;
    }
    
    
    //Updates in stock. This method will be called after successful purhcase.
    public void updateInStock(){
        int item_no = this.getInventory_id();
      
        /*    
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon","root","seecs@123");
        PreparedStatement ps = con.prepareStatement("Update inventory set instock = instock-1");*/
        if(isInStock()){
        int response = Service.getUpdateResult("Update inventory set instock = instock-1");
            if(response > 0){
            System.out.println("Update Successful");
         }
            else{
            System.out.println("Update Failed");
        }
        }
        else{
            System.out.println("Stock is empty for current item");
        }
        
        }
       
       
    
    }
    
    

