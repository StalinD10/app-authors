package com.distribuida.servicios;

import com.distribuida.dao.AuthorRepository;
import com.distribuida.db.Author;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Inject
    AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll().list();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public void save(Author author) {
        authorRepository.persistAndFlush(author);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public void update(Author author) {
        authorRepository.persist(author);
    }
}
