CREATE TABLE IF NOT EXISTS public.authors
(
    id integer generated by default as identity primary key,
    first_name character varying(128) COLLATE pg_catalog."default",
    last_name character varying(128) COLLATE pg_catalog."default"
);

CREATE TABLE IF NOT EXISTS public.books
(
    id integer generated by default as identity primary key ,
    isbn character varying(16) COLLATE pg_catalog."default",
    title character varying(128) COLLATE pg_catalog."default",
    author_id integer,
    price numeric(6,2)
);

ALTER TABLE public.books
    ADD CONSTRAINT pk_author_id
        FOREIGN KEY (author_id)
            REFERENCES public.authors(id);

CREATE SEQUENCE hibernate_sequence START 1 INCREMENT 1;