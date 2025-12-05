package mk.finki.ukim.wp.lab.service.impl;


import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.repository.AuthorRepository;
import mk.finki.ukim.wp.lab.repository.BookRepository;
import mk.finki.ukim.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    public final BookRepository bookRepository;
    public final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository impl, AuthorRepository authorRepository){
        this.bookRepository = impl;
        this.authorRepository = authorRepository;

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
        Book book = new Book(title, genre, averageRating);
        Author auth = authorRepository.findById(author).get();
        if(!authorRepository.findById(author).isPresent()) {
            return null;
        }
        book.setAuthor(auth);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findByAuthor(Author author) {
        return bookRepository.findAllByAuthor(author);
    }


}
