package mk.finki.ukim.wp.lab.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    double averageRating;
    @ManyToOne
    private Author author;

    public Book(String title, String genre, double averageRating){
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
    }

    public Book(){

    }



}
