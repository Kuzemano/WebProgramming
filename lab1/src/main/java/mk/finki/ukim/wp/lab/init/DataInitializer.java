package mk.finki.ukim.wp.lab.init;

import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.repository.AuthorRepository;
import mk.finki.ukim.wp.lab.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataInitializer(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Only populate if the database is empty
        System.out.println("auth: "+authorRepository.count()+"  books: "+bookRepository.count());
        if (authorRepository.count() == 0 && bookRepository.count() == 0) {

            Author a1 = new Author("Jane", "Austen", "UK", "Famous novelist");
            Author a2 = new Author("Mark", "Twain", "USA", "Famous humorist");
            authorRepository.saveAll(List.of(a1, a2));

            Book b1 = new Book("Pride and Prejudice", "Romance", 4.8);
            b1.setAuthor(a1);

            Book b2 = new Book("Adventures of Huckleberry Finn", "Adventure", 4.5);
            b2.setAuthor(a2);

            bookRepository.saveAll(List.of(b1, b2));

            System.out.println("Database initialized with sample authors and books!");
        }
    }
}

