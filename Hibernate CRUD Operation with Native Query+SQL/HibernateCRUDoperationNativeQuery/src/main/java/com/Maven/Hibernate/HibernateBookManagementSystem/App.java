package com.Maven.Hibernate.HibernateBookManagementSystem;

import java.util.Scanner;

import Service.BookService;

public class App {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	BookService service = new BookService();

        while (true) {
            System.out.println("Book Management System");
            System.out.println("1. add new book");
            System.out.println("2. update book price");
            System.out.println("3. remove book");
            System.out.println("4. generate bill");
            System.out.println("5. search book by ID");
            System.out.println("6. search book by title");
            System.out.println("7. exit");
            System.out.print("enter your choice: ");
            
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    service.addBook();
                    break;
                case 2:
                    service.updatePriceById();
                    break;
                case 3:
                    service.removeBookById();
                    break;
                case 4:
                    service.generateBill();
                    break;
                case 5:
                    service.searchBookById();
                    break;
                case 6:
                    service.searchBookByTitle();
                    break;
                case 7:
                    System.out.println("exited");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("invalid choice");
            }
        }
    }
    	
    	service.ShowData();
    }
}