/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author walter
 */
public class Main {
    
    public static void main(String[] args){
        
        Connection conn = Operations.Connect();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bem-vindo ao sistema de Gerenciamento de stocks.");
        System.out.println("Que operacoes deseja efectuar: ");
        System.out.println("1- Listar Produtos disponiveis no stock");
        System.out.println("2- Adicionar um novo produto ao stock");
        System.out.println("3- Actualizar um produto existente no stock");
        System.out.println("4- Eliminar um produto existente no stock");
        System.out.println("5- Sair do sistema");
        System.out.print("Escolha: ");
        int opcao = scanner.nextInt();
        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        
        while (opcao != 5) {
            
            if (opcao == 1){ 
                UserInterface.listarProdutos(conn);
            } 
            else if (opcao == 2) {
                UserInterface.adicionarProduto(conn);
            }
            else if (opcao == 3) {
                UserInterface.actualizarProdutos(conn);
            }
            else if (opcao == 4) {
                UserInterface.eliminarProduto(conn);
            }
            else {
                System.out.println("Por favor, introduza uma opcao valida!");
            }
            
            System.out.println("--------------------------------------");
            System.out.println("--------------------------------------");
            System.out.println("Que operacoes deseja efectuar: ");
            System.out.println("1- Listar Produtos disponiveis no stock");
            System.out.println("2- Adicionar um novo produto ao stock");
            System.out.println("3- Actualizar um produto existente no stock");
            System.out.println("4- Eliminar um produto existente no stock");
            System.out.println("5- Sair do sistema");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            System.out.println("--------------------------------------");
            System.out.println("--------------------------------------");
            
         
        }
       
        
    }
}
