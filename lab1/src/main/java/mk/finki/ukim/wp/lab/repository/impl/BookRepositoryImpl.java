package mk.finki.ukim.wp.lab.repository.impl;


import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.repository.BookRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {


    @Override
    public List<Book> findAll() {
        return DataHolder.books;
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return DataHolder.books.stream().filter(a->a.getTitle().contains(text) && a.getAverageRating()>=rating).toList();

    }
}
