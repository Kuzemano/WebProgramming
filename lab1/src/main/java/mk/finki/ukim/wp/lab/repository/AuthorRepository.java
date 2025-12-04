package mk.finki.ukim.wp.lab.repository;


import mk.finki.ukim.wp.lab.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {



}
