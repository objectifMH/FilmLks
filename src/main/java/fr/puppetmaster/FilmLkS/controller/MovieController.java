/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.puppetmaster.FilmLkS.controller;

import fr.puppetmaster.FilmLkS.entity.Actor;
import fr.puppetmaster.FilmLkS.entity.Director;
import fr.puppetmaster.FilmLkS.entity.Movie;
import fr.puppetmaster.FilmLkS.repository.ActorRepository;
import fr.puppetmaster.FilmLkS.repository.DirectorRepository;
import fr.puppetmaster.FilmLkS.service.MovieService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gtu
 */
@Transactional
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ActorRepository actorRepository;
    
    @Autowired
    private DirectorRepository directorRepository;

    @GetMapping("films")
    public List<Movie> findAllMovies() {
        System.out.println("Dans controller films");
        return movieService.getMovies();
    }

    @GetMapping("film/{id}")
    public Movie findMovieById(@PathVariable int id) {
        Movie movie = movieService.getMovieById(id);
        System.out.println(movie);
        System.out.println(movie.getActors());

        return movie;
    }

    @GetMapping("/findFilm/{title}")
    public Movie findMovieByName(@PathVariable String title) {
        return movieService.getMovieByTitle(title);
    }

    @GetMapping("actor/{id}")
    public Actor findActorById(@PathVariable int id) {
        Actor actor = actorRepository.findById(id).get();
        
        return actor;
    }
    
    @GetMapping("director/{id}")
    public Director findDirectorById(@PathVariable int id) {
        Director director = directorRepository.findById(id).get();
        return director;
    }

    /*
    @PostMapping("film")
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }

    @DeleteMapping("film/{id}")
    public void deleteMovie(@PathVariable int id){
        movieService.deleteMovieById(id);
    }

    @PutMapping("movie")
    public Movie updateMovie(@RequestBody Movie newMovie){
        return movieService.updateMovie(newMovie);
    }
     */
}
