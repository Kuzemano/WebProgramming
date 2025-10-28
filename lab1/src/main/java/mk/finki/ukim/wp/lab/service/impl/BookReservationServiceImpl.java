package mk.finki.ukim.wp.lab.service.impl;


import mk.finki.ukim.wp.lab.model.BookReservation;
import mk.finki.ukim.wp.lab.repository.BookReservationRepository;
import mk.finki.ukim.wp.lab.repository.impl.BookReservationRepositoryImpl;
import mk.finki.ukim.wp.lab.service.BookReservationService;
import org.springframework.stereotype.Service;

@Service
public class BookReservationServiceImpl implements BookReservationService {
    public final BookReservationRepository repo;

    public BookReservationServiceImpl(BookReservationRepositoryImpl impl){
        this.repo = impl;
    }


    @Override
    public BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, int numberOfCopies) {
        return repo.save(new BookReservation(bookTitle, readerName, readerAddress, Long.valueOf(numberOfCopies)));
    }
}
