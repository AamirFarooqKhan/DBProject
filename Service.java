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
public class Service {
    private static Connection con;
    private static ResultSet  rs;
    private static int    updateStatus;
    
    private static void Connect(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon","root","seecs@123");
        
        
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    
    }
    private static void executeQuery(String sql){
        Connect();
        try{
        PreparedStatement ps = con.prepareStatement(sql);
         rs = ps.executeQuery();}
        catch(SQLException e){
            System.out.println(e);
        }
        
    
    } 
    
    private static void executeUpdate(String sql){
        Connect();
        try{
        PreparedStatement ps = con.prepareStatement(sql);
        updateStatus = ps.executeUpdate();}
        catch(SQLException e){
            System.out.println(e);
        }
    
    }
    
    private static void closeConnection(){
        try{
         con.close();
        
        }
        catch(SQLException e){
        
            System.out.println(e);
        }
    }
    
    public static ResultSet getResult(String sql){
        executeQuery(sql);
       
        return rs;
    }
    
     public static int getUpdateResult(String sql){
        executeUpdate(sql);
        
        return updateStatus;
    }
}
