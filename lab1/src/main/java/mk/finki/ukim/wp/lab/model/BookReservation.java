package mk.finki.ukim.wp.lab.model;

import lombok.Data;

@Data
public class BookReservation {
    private String bookTitle;
    private String readerName;
    private String readerAddress;
    Long numberOfCopies;

    public BookReservation(String bookTitle, String readerName, String readerAddress, Long numberOfCopies){
        this.bookTitle = bookTitle;
        this.readerAddress = readerAddress;
        this.readerName = readerName;
        this.numberOfCopies = numberOfCopies;
    }

}
