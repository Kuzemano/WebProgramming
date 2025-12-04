package mk.finki.ukim.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = null;

    public static List<Author> authors = null;

    public static List<BookReservation> reservations = null;


    @PostConstruct
    public void init(){

        authors = new ArrayList<>(List.of(
                new Author("Aldous", "Hucksley", "England","Nope1"),
                new Author("John", "Smith", "America","Nope2"),
                new Author("Honore", "de Balzac", "France","Nope3")
        ));
/*
        books = new ArrayList<>(List.of(
                new Book("The brothers karamazov", "Novel", 9.9, authors.getFirst()),
                new Book("The portrait of Dorian Grey", "Novel", 9.7, authors.get(1)),
                new Book("I dont know", "Novel", 9.2, authors.get(2))
        ));*/
        reservations = new ArrayList<>();

    }



}
