package mk.finki.ukim.wp.lab.service.impl;


import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.repository.BookRepository;
import mk.finki.ukim.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    public final BookRepository bookRepository;

    public BookServiceImpl(BookRepository impl){
        this.bookRepository = impl;
    }


    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }


    @Override
    public Book deleteBook(Long id) {
        bookRepository.deleteById(id);
        return null;
    }

    @Override
    public Book addBook(String title, String genre, double averageRating, Author author) {
        Book book =  new Book(title, genre, averageRating);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Override
    public Book editBook(String title, String genre, double averageRating, Long author, Long id) {
        bookRepository.deleteById(id);
        return bookRepository.save(new Book(title, genre, averageRating));
    }

    @Override
    public List<Book> findByAuthor(Author author) {
        return bookRepository.findAllByAuthor(author);
    }


}
