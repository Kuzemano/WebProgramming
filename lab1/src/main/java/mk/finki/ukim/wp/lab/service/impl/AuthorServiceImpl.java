package mk.finki.ukim.wp.lab.service.impl;


import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.repository.AuthorRepository;
import mk.finki.ukim.wp.lab.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repo;

    public AuthorServiceImpl(AuthorRepository repo){
        this.repo = repo;
    }


    @Override
    public List<Author> findAll() {
        return repo.findAll();
    }

    @Override
    public Author findById(Long id) {
        if(repo.findById(id).isPresent())
            return repo.findById(id).get();
        else return null;
    }


}
