package mk.finki.ukim.wp.lab.web.controller;

import mk.finki.ukim.wp.lab.model.BookReservation;
import mk.finki.ukim.wp.lab.service.BookReservationService;
import mk.finki.ukim.wp.lab.service.impl.BookReservationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookReservationController {
    public final BookReservationService service;

    public BookReservationController(BookReservationServiceImpl impl){
        this.service =  impl;
    }

    @PostMapping("/bookReservation")
    public String idk(@RequestParam("numCopies") int numCopies, @RequestParam("readerAddress") String readerAddress, @RequestParam("readerName") String readerName, @RequestParam("book") String title, Model model){
        model.addAttribute("res", service.placeReservation(title, readerName, readerAddress, numCopies));
        return "reservationConfirmation";



    }






}
