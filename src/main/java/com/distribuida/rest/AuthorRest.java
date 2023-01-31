package com.distribuida.rest;

import com.distribuida.db.Author;
import com.distribuida.servicios.AuthorService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/authors")
public class AuthorRest {

    @Inject
    AuthorService authorService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Author findById(@PathParam("id") Long id) {
        return authorService.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(Author author) {
        authorService.save(author);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        authorService.deleteById(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void update(@PathParam("id") Long id, Author author) {
        if (authorService.findById(id) != null) {
            authorService.update(author);
        }

    }
}
