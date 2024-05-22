/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;

/**
 *
 * @author walter
 */
public class Main {
    
    public static void main(String[] args){
        
        Connection conn = Operations.Connect();
        Product produto = new Product("novo", "Java Handled", 5, 15);
        //Operations.insertProduct(produto1, conn);
        Operations.readProducts(conn);
        Operations.deleteProduct(2, conn);
        Operations.deleteProduct(1, conn);
        System.out.println("After product deletion");
        Operations.readProducts(conn);
    }
}
