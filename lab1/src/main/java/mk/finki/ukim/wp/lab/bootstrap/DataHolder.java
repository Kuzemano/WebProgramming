package mk.finki.ukim.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = null;

    public static List<BookReservation> reservations = null;


    @PostConstruct
    public void init(){
        books = new ArrayList<>(List.of(
                new Book("The brothers karamazov", "Novel", 9.9),
                new Book("The portrait of Dorian Grey", "Novel", 9.7),
                new Book("I dont know", "Novel", 9.2)
        ));
        reservations = new ArrayList<>();

    }



}
