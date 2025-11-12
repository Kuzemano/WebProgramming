package mk.finki.ukim.wp.lab.model;


import lombok.Data;

@Data
public class Book {
    private Long id;
    private String title;
    private String genre;
    double averageRating;
    private Author author;

    public Book(String title, String genre, double averageRating, Author author){
        this.id = (long)(Math.random()*1000);
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
    }

}
