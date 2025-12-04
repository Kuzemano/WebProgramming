package mk.finki.ukim.wp.lab.web.controller;



import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.service.AuthorService;
import mk.finki.ukim.wp.lab.service.BookService;
import mk.finki.ukim.wp.lab.service.impl.AuthorServiceImpl;
import mk.finki.ukim.wp.lab.service.impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = {"/books", "", "/"})
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;



    public BookController(BookServiceImpl bookService, AuthorServiceImpl impl){
        this.bookService = bookService;
        this.authorService = impl;
    }

    @GetMapping("/authorBooks/{id}")
    public String authorBooks(Model model, @PathVariable Long id) {
        Author author = authorService.findById(id);
        model.addAttribute("authorName", author.getName());
        model.addAttribute("books", bookService.findByAuthor(author));
        return "authorBook";


    }






    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error, Model model){

        model.addAttribute("books", bookService.listAll());
        model.addAttribute("authors", authorService.findAll());
        return  "listBooks";
    }
    @GetMapping("/add")
    public String addBook(Model model){
        model.addAttribute("authors", authorService.findAll());
        System.out.println(authorService.findAll());
        return "addBooks";
    }



    @PostMapping("/add")
    public String addBook(@RequestParam String title,
                          @RequestParam String genre,
                          @RequestParam Double averageRating,
                          @RequestParam Long authorId){
        System.out.println(authorId);
        System.out.println(authorService.findAll());
        Author auth = authorService.findAll().stream().filter(a->a.getId().equals(authorId) ).findFirst().get();
        bookService.addBook(title, genre, averageRating, auth);

        return "redirect:/books";
    }



    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model){
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("ide", id);
        return "editBook";
    }



    @PostMapping("/edit")
    public String editBookReal(
                               @RequestParam String title,
                               @RequestParam String genre,
                               @RequestParam Double averageRating,
                               @RequestParam Long authorId,
                               @RequestParam Long bookId){
        Author auth = authorService.findAll().stream().filter(a->a.getId().equals(authorId) ).findFirst().get();

        bookService.editBook(title, genre, averageRating, auth.getId(), bookId);
        return "redirect:/books";
    }

/*
    @GetMapping("/delete/{id}")
    public String accDelete(@PathVariable Long id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }
*/
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }


}
