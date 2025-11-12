package mk.finki.ukim.wp.lab.service.impl;


import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.repository.BookRepository;
import mk.finki.ukim.wp.lab.repository.impl.BookRepositoryImpl;
import mk.finki.ukim.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    public final BookRepository bookRepository;

    public BookServiceImpl(BookRepositoryImpl impl){
        this.bookRepository = impl;
    }


    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return bookRepository.searchBooks(text, rating);
    }

    @Override
    public Book deleteBook(Long id) {
        return bookRepository.deleteBook(id);
    }

    @Override
    public Book addBook(String title, String genre, double averageRating, Author author) {
        return bookRepository.addBook(title, genre, averageRating, author);
    }

    @Override
    public Book editBook(String title, String genre, double averageRating, Long author, Long id) {
        return bookRepository.editBook(title, genre, averageRating, author, id);
    }


}
