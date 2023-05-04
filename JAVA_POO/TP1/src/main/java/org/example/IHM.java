package org.example;

import jdk.jshell.spi.ExecutionControl;
import org.example.dao.ProductDAO;
import org.example.model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class IHM {
    Scanner scanner;
    String choix;

    private ProductDAO productDAO;
    private Connection connection;
    public IHM() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    createProductAction();
                    break;
                case "2":
                    displayProductAction();
                    break;
                case "3":
                    updateProductAction();
                    break;
                case "4":
                    deleteProductAction();
                    break;
            }
        }while (!choix.equals("0"));
    }
    private void menu() {
        System.out.println("1 - Création de produit ");
        System.out.println("2 - Affichage d'un produit ");
        System.out.println("3 - Modification d'un produit ");
        System.out.println("4 - Suppresion d'un produit ");
    }

    private Product createProductAction() {
        Product product = null;
        System.out.print("Merci de saisir le nom du produit : ");
        String name = scanner.nextLine();
        System.out.print("Merci de saisir le prix : ");
        float price = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Merci de saisir la quantité : ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Merci de saisir la description : ");
        String description = scanner.nextLine();
        product = new Product(name, price, quantity,description);
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            productDAO = new ProductDAO(connection);
            if(productDAO.save(product)) {
                System.out.println("Produit "+ product.getId());
                connection.commit();
            }else {
                product = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            product = null;
        }
        return product;
    }

    private Product displayProductAction(){
        Product product = null;
        System.out.print("Merci de saisir l'id du produit: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            productDAO = new ProductDAO(connection);
            product = productDAO.getById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(product != null) {
            System.out.println(product);
        }
        return product;
    }

    private Product updateProductAction(){
        Product product = null;
        System.out.print("Merci de saisir l'id du produit: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            productDAO = new ProductDAO(connection);
            product = productDAO.getById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(product != null) {
            System.out.print("Merci de saisir le nouveau prix du produit: ");
            float price = scanner.nextFloat();
            scanner.nextLine();
            product.setPrice(price);
            try {
                connection = new DataBaseManager().getConnection();
                connection.setAutoCommit(false);
                productDAO = new ProductDAO(connection);
                if(productDAO.update(product)) {
                    System.out.println("Produit "+ product.getId());
                    connection.commit();
                }else {
                    product = null;
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
            System.out.println(product);
        }
        return product;
    }

    private Product deleteProductAction(){
        Product product = null;
        System.out.print("Merci de saisir l'id du produit: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            productDAO = new ProductDAO(connection);
            product = productDAO.getById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(product != null) {
            try {
                connection = new DataBaseManager().getConnection();
                connection.setAutoCommit(false);
                productDAO = new ProductDAO(connection);
                if(productDAO.delete(product)) {
                    System.out.println("Produit "+ product.getId());
                    connection.commit();
                }else {
                    product = null;
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
            System.out.println(product);
        }
        return product;
    }

}
