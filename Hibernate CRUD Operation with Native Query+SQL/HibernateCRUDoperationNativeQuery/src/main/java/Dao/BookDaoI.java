package Dao;

import Model.Book;

public interface BookDaoI {

    void addBook(Book b);

    void updatePriceById(int bookId, double newPrice);

    void removeBookById(int bookId);

    void generateBill(int bookId, int quantity);

    void searchBookByTitle(String title);

    void searchBookById(int bookId);

	void ShowData();
}
