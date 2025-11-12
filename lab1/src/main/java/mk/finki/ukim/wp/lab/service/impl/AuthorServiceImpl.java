package mk.finki.ukim.wp.lab.service.impl;


import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.repository.AuthorRepository;
import mk.finki.ukim.wp.lab.repository.impl.AuthorRepositoryImpl;
import mk.finki.ukim.wp.lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repo;

    public AuthorServiceImpl(AuthorRepositoryImpl impl){
        this.repo = impl;
    }


    @Override
    public List<Author> findAll() {
        return repo.findAll();
    }
}
