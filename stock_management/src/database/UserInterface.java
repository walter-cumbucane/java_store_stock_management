/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.util.Scanner;
import java.sql.Connection;

/**
 *
 * @author walter
 */
public class UserInterface {
    
    public static void adicionarProduto(Connection conn){
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Qual e o nome do produto que deseja inserir: ");
        String name = scanner.nextLine();
        System.out.println("Insira uma descricao para o produto que deseja armazenar: ");
        String description = scanner.nextLine();
        System.out.println("Qual e a quantidade unitaria de produtos disponvel: ");
        int quantity = scanner.nextInt();
        System.out.println("Qual e o preco unitario de cada produto: ");
        double price = scanner.nextDouble();
        
        Product produto = new Product(name, description, quantity, price);
        Operations.insertProduct(produto, conn);
    }
    
    public static void listarProdutos(Connection conn) {
        
        Operations.readProducts(conn);
    }
    
    public static void actualizarProdutos(Connection conn) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Qual e o id do produto que deseja actualizar: ");
        int productId = Integer.parseInt(scanner.nextLine());
        System.out.println("Insira um novo nome para o produto: ");
        String name = scanner.nextLine();
        System.out.println("Insira uma nova descricao para o produto: ");
        String description = scanner.nextLine();
        System.out.println("Insira uma nova quantidade unitaria para o produto: ");
        int quantity = scanner.nextInt();
        System.out.println("Insira um novo preco unitario para o produto: ");
        double price = scanner.nextDouble();
        
        Product produto = new Product(name, description, quantity, price);
        Operations.updateProduct(produto, productId, conn);
    }
    
    public static void eliminarProduto(Connection conn) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Qual e o id do produto que deseja eliminar: ");
        int productId = scanner.nextInt();
        Operations.deleteProduct(productId, conn);
    }
    
}
