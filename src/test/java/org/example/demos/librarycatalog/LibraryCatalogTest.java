package org.example.demos.librarycatalog;

import org.example.book.Book;
import org.example.book.LibraryCatalog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryCatalogTest {

    private LibraryCatalog library;

    @BeforeEach
    void setUp() {
        library = new LibraryCatalog();
        // Adding some initial books for testing
        library.addBook(new Book("Book1", "Author1"));
        library.addBook(new Book("Book2", "Author2"));
    }

    @Test
    void testAddBook() {
        // Test case 1: Adding a new book
        Book newBook = new Book("NewBook", "NewAuthor");
        library.addBook(newBook);

        // Use assertTrue to check if the book is added
        assertTrue(library.getBooks().contains(newBook));
    }

    @Test
    void testBorrowBook() {
        // Test case 1: Borrow an available book
        library.borrowBook("Book1");

        // Use assertFalse to check if the book is no longer available
        assertFalse(library.getBooks().stream().filter(book -> book.getTitle().equals("Book1")).findFirst().get().isAvailable());

        // Test case 2: Borrow a non-existent book
        library.borrowBook("NonExistentBook");

        // Use assertFalse to check that nothing changes (no book borrowed)
        assertFalse(library.getBooks().stream().anyMatch(book -> book.getTitle().equals("NonExistentBook")));
    }

    @Test
    void testReturnBook() {
        // Test case 1: Return a borrowed book
        library.borrowBook("Book2");
        library.returnBook("Book2");

        // Use assertTrue to check if the book is now available
        assertTrue(library.getBooks().stream().filter(book -> book.getTitle().equals("Book2")).findFirst().get().isAvailable());

        // Test case 2: Return a non-borrowed book
        library.returnBook("NonBorrowedBook");

        // Use assertTrue to check that nothing changes (no book returned)
        assertTrue(library.getBooks().stream().noneMatch(book -> book.getTitle().equals("NonBorrowedBook")));
    }
}

