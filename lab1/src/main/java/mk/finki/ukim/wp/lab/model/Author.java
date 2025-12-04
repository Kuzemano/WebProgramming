package mk.finki.ukim.wp.lab.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@Entity
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String surname;
    private String country;
    private String biography;
    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();



    public Author(){

    }

    public Author(String name, String surname, String country, String biography){

        this.name = name;
        this.surname = surname;
        this.country = country;
        this.biography = biography;
    }



}
