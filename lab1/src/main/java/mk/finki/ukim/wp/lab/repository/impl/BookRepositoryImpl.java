package mk.finki.ukim.wp.lab.repository.impl;


import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.repository.BookRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Book deleteBook(Long id) {
        Optional<Book> booki = DataHolder.books.stream().filter(a->a.getId().equals(id)).findFirst();
        Book book = null;
        if(booki.isPresent())
            book = booki.get();


        DataHolder.books.remove(book);

        return null;

    }

    @Override
    public Book addBook(String title, String genre, double averageRating, Author author) {
        Book book = null;
        DataHolder.books.add(book = new Book(title, genre, averageRating, author));
        return book;
    }

    @Override
    public Book editBook(String title, String genre, double averageRating, Long author, Long id) {
        Optional<Book> booki =  DataHolder.books.stream().filter(a->a.getId().equals(id)).findFirst();
        Book book = null;
        if(booki.isPresent()){
            book = booki.get();
        }

        book.setAuthor(DataHolder.authors.stream().filter(a->a.getId().equals(author)).findFirst().get());
        book.setGenre(genre);
        book.setTitle(title);
        book.setAverageRating(averageRating);
        return book;
    }


}
