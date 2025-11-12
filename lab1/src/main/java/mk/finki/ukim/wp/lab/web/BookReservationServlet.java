package mk.finki.ukim.wp.lab.web;

/*
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.wp.lab.service.BookReservationService;
import mk.finki.ukim.wp.lab.service.impl.BookReservationServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "res", urlPatterns = {"/bookReservation"})
public class BookReservationServlet extends HttpServlet {
    public final SpringTemplateEngine eng;
    public final BookReservationService service;

    public BookReservationServlet(SpringTemplateEngine eng, BookReservationServiceImpl impl){
        this.eng = eng;
        this.service = impl;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        IWebExchange exchange = JakartaServletWebApplication.buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(exchange);


        String title = req.getParameter("book");
        String readerName = req.getParameter("readerName");
        String readerAddress = req.getParameter("readerAddress");
        int numCopies = Integer.parseInt(req.getParameter("numCopies"));

        context.setVariable("res", service.placeReservation(title, readerName, readerAddress, numCopies));

        eng.process("reservationConfirmation.html", context, resp.getWriter());



    }




}
*/