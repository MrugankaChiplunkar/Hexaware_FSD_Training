package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Model.Book;
import Util.HibernateUtil;

public class BookDao implements BookDaoI {

    @Override
    public void addBook(Book b) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction txTransaction = session.beginTransaction();
        session.save(b);
        txTransaction.commit();
        session.close();
        System.out.println("book added");
    }

    @Override
    public void updatePriceById(int bookId, double newPrice) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction txTransaction = session.beginTransaction();
        Query<Book> Q = session.createQuery("update Book set price = :price where bookId = :id");
        Q.setParameter("price", newPrice);
        Q.setParameter("id", bookId);
        int r = Q.executeUpdate();
        if (r > 0) {
            System.out.println("updated");
        } else {
            System.out.println("not found");
        }
        txTransaction.commit();
        session.close();
    }

    @Override
    public void removeBookById(int bookId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction txTransaction = session.beginTransaction();
        Query<Book> Q = session.createQuery("delete from Book where bookId = :id");
        Q.setParameter("id", bookId);
        int r = Q.executeUpdate();
        if (r > 0) {
            System.out.println("removed");
        } else {
            System.out.println("not found");
        }
        txTransaction.commit();
        session.close();
    }

    @Override
    public void generateBill(int bookId, int quantityRequested) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction txTransaction = session.beginTransaction();
        Book book = session.get(Book.class, bookId);
        if (book != null) {
            if (book.getQuantity() >= quantityRequested) {
                double total = book.getPrice() * quantityRequested;
                System.out.println("title: " + book.getTitle());
                System.out.println("unit price: " + book.getPrice());
                System.out.println("total: " + total);
            } else {
                System.out.println("insufficient stock");
            }
        } else {
            System.out.println("book not found");
        }
        txTransaction.commit();
        session.close();
    }

    @Override
    public void searchBookById(int bookId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Book book = session.get(Book.class, bookId);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("book not found.");
        }
        session.close();
    }

    @Override
    public void searchBookByTitle(String title) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction txTransaction = session.beginTransaction();
        Query<Book> Q = session.createQuery("from Book where title = :title", Book.class);
        Q.setParameter("title", title);
        List<Book> list = Q.list();
        if (!list.isEmpty()) {
            list.forEach(System.out::println);
        } else {
            System.out.println("book not found");
        }
        txTransaction.commit();
        session.close();
    }
}
