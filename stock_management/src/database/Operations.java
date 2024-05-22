/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author walter
 */
public class Operations {
    
    public static Connection Connect() {
        
        Connection conn = null;
        
        try {
            
            String url = "jdbc:mysql://localhost:3306/stock_management";
            String user = "root";
            String password = "root";
            
            conn = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException error) {
            System.out.println(error.getMessage());
        }
        
        return conn;
    }
    
    public static void insertProduct(Product produto, Connection conn) {
        
        String name = produto.getName();
        String description = produto.getDescription();
        int quantity = produto.getQuantity();
        double price = produto.getPrice();
        
        String query = "INSERT INTO products (Name, Description, Quantity, Price) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, quantity);
            statement.setDouble(4, price);
            statement.executeUpdate();
            System.out.println("Product added successfully.");
        } catch (SQLException erro) {
            System.out.println(erro.getMessage());
        }
        
    }
    
    public static void readProducts(Connection conn) {
        
        String query = "SELECT * FROM products";
        
        try {
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()){
                
                System.out.println("------------------------------------------");
                System.out.println("Product ID: " + result.getInt("ProductID"));
                System.out.println("Name: " + result.getString("Name"));
                System.out.println("Description: " + result.getString("Description"));
                System.out.println("Quantity: " + result.getInt("Quantity"));
                System.out.println("Price: " + result.getDouble("Price"));
                if (!result.next()){
                   System.out.println("------------------------------------------"); 
                }
            }
        } catch (SQLException erro){
            System.out.println(erro.getMessage());
        }
        
    }
    
    public static void updateProduct(Product produto, int productId, Connection conn){
        
        String query = "UPDATE products SET Name = ?, Description = ?, Quantity = ?, Price = ? WHERE ProductID = ?";
        String name = produto.getName();
        String description = produto.getDescription();
        int quantity = produto.getQuantity();
        double price = produto.getPrice();
        
        try {
            
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, quantity);
            statement.setDouble(4, price);
            statement.setInt(5, productId);
            statement.executeUpdate();
            System.out.println("Product updated successfully.");
        }
        catch (SQLException erro) {
            
            System.out.println(erro.getMessage());
        }
        
        
    }
    
    public static void deleteProduct(int productId, Connection conn) {
        
        String query = "DELETE FROM Products WHERE ProductID = ?";
        
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, productId);
            statement.executeUpdate();
            System.out.println("Product deleted successfully.");
        }
        catch (SQLException erro) {
            System.out.println(erro.getMessage());
        }
    }
}
