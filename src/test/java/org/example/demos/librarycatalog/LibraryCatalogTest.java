package org.example.demos.librarycatalog;

import org.example.book.Book;
import org.example.book.LibraryCatalog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LibraryCatalogTest {

    private LibraryCatalog libraryCatalog;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        libraryCatalog = new LibraryCatalog();
        book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        libraryCatalog.addBook(book1);
        libraryCatalog.addBook(book2);
    }

    @Test
    public void testAddBook() {
        List<Book> books = libraryCatalog.getBooks();

        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }

    @Test
    public void testBorrowBook() {
        libraryCatalog.borrowBook("The Great Gatsby");

        assertFalse(book1.isAvailable());
        assertTrue(book2.isAvailable());
    }

    @Test
    public void testReturnBook() {
        book1.setAvailable(false);
        book2.setAvailable(false);

        libraryCatalog.returnBook("The Great Gatsby");

        assertTrue(book1.isAvailable());
        assertFalse(book2.isAvailable());
    }

    @Test
    public void testBorrowNonExistentBook() {
        // Attempt to borrow a book that doesn't exist in the catalog
        libraryCatalog.borrowBook("NonExistentTitle");

        // Ensure that the catalog state remains unchanged
        assertTrue(book1.isAvailable());
        assertTrue(book2.isAvailable());
    }
    @Test
    public void testReturnNonExistentBook() {
        // Attempt to return a book that doesn't exist in the catalog
        libraryCatalog.returnBook("NonExistentTitle");

        // Ensure that the catalog state remains unchanged
        assertTrue(book1.isAvailable());
        assertTrue(book2.isAvailable());
    }
}


