
CREATE TABLE public.library
(
    library_id          character varying(64)    NOT NULL,
    library_name               character varying(128)   NOT NULL,
    date_created       timestamp with time zone,
    CONSTRAINT library_pk PRIMARY KEY (library_id)

);


--CREATE TABLE public.patron
--(
--    patron_id       character varying(64)    NOT NULL,
--    patron_name               character varying(128)   NOT NULL,
--    date_created       timestamp with time zone NOT NULL,
--    library_id          character varying(64)    NOT NULL,
--    CONSTRAINT patron_pk PRIMARY KEY (patron_id),
--    CONSTRAINT patron_library_fk FOREIGN KEY (library_id) REFERENCES library (library_id) MATCH simple ON UPDATE cascade ON DELETE NO action
--
--);


CREATE TABLE public.book
(
    book_id          character varying(64)    NOT NULL,
    book_name        character varying(128)   NOT NULL,
    date_created      timestamp with time zone NOT NULL,
    library_id          character varying(64)    NOT NULL,
    CONSTRAINT book_pk PRIMARY KEY (book_id),
    CONSTRAINT book_library_fk FOREIGN KEY (library_id) REFERENCES library (library_id) MATCH simple ON UPDATE cascade ON DELETE NO action

);



