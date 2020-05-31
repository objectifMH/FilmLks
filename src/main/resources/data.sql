DROP TABLE IF EXISTS actor_movie;
DROP TABLE IF EXISTS actor;
DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS director;

CREATE TABLE director (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

CREATE TABLE actor (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

CREATE TABLE movie (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    date TIMESTAMP NOT NULL,
    prix double,
    director_id INT NOT NULL,
    CONSTRAINT director_fk FOREIGN KEY (director_id)  REFERENCES director (id)
);

CREATE TABLE actor_movie(
    movie_id INT NOT NULL,
    actor_id INT NOT NULL,
    CONSTRAINT actor_movie_pk PRIMARY KEY (actor_id, movie_id),
    CONSTRAINT movie_fk FOREIGN KEY (movie_id) REFERENCES movie (id),
    CONSTRAINT actor_fk FOREIGN KEY (actor_id) REFERENCES actor (id)
);

INSERT INTO director (id, name) VALUES (1, 'George Lucas');
INSERT INTO director (id, name) VALUES (2, 'Steven Spielberg');
INSERT INTO director (id, name) VALUES (3, 'Andrew Niccol');
INSERT INTO director (id, name) VALUES (4, 'Nolan');



INSERT INTO actor (id, name) VALUES (1, 'Harrison Ford');
INSERT INTO actor (id, name) VALUES (2, 'Mark Hamil');
INSERT INTO actor (id, name) VALUES (3, 'Carrie Fisher');
INSERT INTO actor (id, name) VALUES (4, 'Sean Connery');
INSERT INTO actor (id, name) VALUES (5, 'Ethan Hawke');
INSERT INTO actor (id, name) VALUES (6, 'Uma Thurman');
INSERT INTO actor (id, name) VALUES (7, 'Jude Law');
INSERT INTO actor (id, name) VALUES (8, 'Michael Law');
INSERT INTO actor (id, name) VALUES (9, 'Michael Jackson');
INSERT INTO actor (id, name) VALUES (10, 'Michael Jordan');
INSERT INTO actor (id, name) VALUES (11, 'Michael B. Jordan');
INSERT INTO actor (id, name) VALUES (12, 'Jordan Lewis');



INSERT INTO movie (id, title, date, prix, director_id) VALUES (10,'Star Wars episode 1 - La menace fantome', '1999-01-01',1.99, 1);
INSERT INTO movie (id, title, date, prix, director_id) VALUES (11,'Star Wars : 2 - La revanche des Sith', '2002-01-01',1.99, 1);
INSERT INTO movie (id, title, date, prix, director_id) VALUES (12,'Star Wars 3 - L''attaque des clones', '2005-01-01',2.99, 1);
INSERT INTO movie (id, title, date, prix, director_id) VALUES (13,'Star Wars, episode IV : Un nouvel espoir', '1977-01-01',0.99, 1);
INSERT INTO movie (id, title, date, prix, director_id) VALUES (20,'Indiana Jones - Les aventuriers de l''arche perdue', '1977-01-01',1.99, 2);
INSERT INTO movie (id, title, date, prix, director_id) VALUES (21,'Indiana Jones - Le temple maudit', '1984-05-23',1.99, 2);
INSERT INTO movie (id, title, date, prix, director_id) VALUES (22,'Indiana Jones - La derniere croisade', '1989-05-24',1.99, 2);
INSERT INTO movie (id, title, date, prix, director_id) VALUES (23,'Indiana Jones - Le royaume du crane de cristal', '2008-05-21',0.99, 2);
INSERT INTO movie (id, title, date, prix, director_id) VALUES (24,'Gattaca', '1999-01-01',1.99, 3);
INSERT INTO movie (id, title, date, prix, director_id) VALUES (25,'Interstellar', '1999-01-01',1.99, 4);

INSERT INTO actor_movie (actor_id, movie_id) VALUES (1,13);
INSERT INTO actor_movie (actor_id, movie_id) VALUES (1,20);
INSERT INTO actor_movie (actor_id, movie_id) VALUES (1,21);
INSERT INTO actor_movie (actor_id, movie_id) VALUES (1,22);
INSERT INTO actor_movie (actor_id, movie_id) VALUES (1,23);
INSERT INTO actor_movie (actor_id, movie_id) VALUES (2,13);
INSERT INTO actor_movie (actor_id, movie_id) VALUES (3,13);
INSERT INTO actor_movie (actor_id, movie_id) VALUES (4,22);
INSERT INTO actor_movie (actor_id, movie_id) VALUES (5,24);
INSERT INTO actor_movie (actor_id, movie_id) VALUES (6,24);
INSERT INTO actor_movie (actor_id, movie_id) VALUES (7,24);

INSERT INTO actor_movie (actor_id, movie_id) VALUES (1,10);
INSERT INTO actor_movie (actor_id, movie_id) VALUES (5,10);
