package mk.finki.ukim.wp.lab.service.impl;


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
}
