package mk.finki.ukim.wp.lab.web;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.service.BookService;
import mk.finki.ukim.wp.lab.service.impl.BookServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "list", urlPatterns = {"", "/wow"})
public class BookListServlet extends HttpServlet {
    public final SpringTemplateEngine eng;
    public final BookService service;

    public BookListServlet(SpringTemplateEngine eng, BookServiceImpl imple){
        this.eng = eng;
        this.service = imple;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{

        IWebExchange exchange = JakartaServletWebApplication.buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(exchange);
        context.setVariable("books", service.listAll());

        eng.process("listBooks.html", context, resp.getWriter());




    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        IWebExchange exchange = JakartaServletWebApplication.buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(exchange);


        String text = req.getParameter("contains");
        double rating = Double.parseDouble(req.getParameter("rating"));

        context.setVariable("books", service.listAll().stream().filter(a->a.getTitle().toLowerCase().contains(text.toLowerCase()) && a.getAverageRating()>=rating));
        eng.process("listBooks.html", context, resp.getWriter());





    }

}
