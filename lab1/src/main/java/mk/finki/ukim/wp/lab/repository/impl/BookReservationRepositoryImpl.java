package mk.finki.ukim.wp.lab.repository.impl;


import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.BookReservation;
import mk.finki.ukim.wp.lab.repository.BookReservationRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;

@Repository
public class BookReservationRepositoryImpl implements BookReservationRepository {


    @Override
    public BookReservation save(BookReservation reservation) {
        DataHolder.reservations.add(reservation);
        return reservation;
    }
}
