package mk.finki.ukim.wp.lab.model;


import lombok.Data;

@Data
public class Book {
    private String title;
    private String genre;
    double averageRating;

    public Book(String title, String genre, double averageRating){
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
    }

}
