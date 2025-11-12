package mk.finki.ukim.wp.lab.repository;


import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    List<Book> searchBooks(String text, Double rating);
    Book deleteBook(Long id);
    Book addBook(String title, String genre, double averageRating, Author author);
    Book editBook(String title, String genre, double averageRating, Long author, Long id);
}
