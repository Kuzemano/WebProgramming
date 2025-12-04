package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.model.BookReservation;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReservationRepository {

    BookReservation save(BookReservation reservation);


}
