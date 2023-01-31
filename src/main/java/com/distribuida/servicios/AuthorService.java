package com.distribuida.servicios;

import com.distribuida.db.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author findById(Long id);

    void save(Author author);

    void deleteById(Long id);

    void update(Author author);
}
