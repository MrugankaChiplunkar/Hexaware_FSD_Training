package Service;

import java.util.Scanner;
import Dao.BookDao;
import Dao.BookDaoI;
import Model.Book;

public class BookService {

    Scanner sc = new Scanner(System.in);
    BookDaoI dao = new BookDao();

    public void addBook() {
        System.out.print("enter book ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        System.out.print("enter book title: ");
        String title = sc.nextLine();
        System.out.print("enter author name: ");
        String author = sc.nextLine();
        System.out.print("enter price: ");
        double price = sc.nextDouble();
        System.out.print("enter quantity: ");
        int quantity = sc.nextInt();

        Book b = new Book(id, title, author, price, quantity);
        dao.addBook(b);
    }

    public void updatePriceById() {
        System.out.print("enter book ID: ");
        int id = sc.nextInt();
        System.out.print("enter new price: ");
        double price = sc.nextDouble();
        dao.updatePriceById(id, price);
    }

    public void removeBookById() {
        System.out.print("enter book ID to remove: ");
        int id = sc.nextInt();
        dao.removeBookById(id);
    }

    public void generateBill() {
        System.out.print("enter book ID: ");
        int id = sc.nextInt();
        System.out.print("enter quantity: ");
        int qty = sc.nextInt();
        dao.generateBill(id, qty);
    }

    public void searchBookById() {
        System.out.print("enter book ID to search: ");
        int id = sc.nextInt();
        dao.searchBookById(id);
    }

    public void searchBookByTitle() {
        sc.nextLine(); 
        System.out.print("enter book title to search: ");
        String title = sc.nextLine();
        dao.searchBookByTitle(title);
    }
}
