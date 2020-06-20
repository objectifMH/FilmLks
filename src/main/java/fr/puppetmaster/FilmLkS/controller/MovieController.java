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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gtu
 */
@CrossOrigin("*")
@Transactional
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ActorRepository actorRepository;
    
    @Autowired
    private DirectorRepository directorRepository;

    //***************  films  ***************
    
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
    
    @GetMapping("films/{mc}")
    public List<Movie> findAllMoviesTitleByMc(@PathVariable String mc) {
        return movieService.getMovieByMc(mc);
    }
    

    
    //@GetMapping("/findFilm/{field}")
    //public List<Movie> findMovieByField(@PathVariable String field) {
    //    return "a faire";
    //}
    
    

    //***************  acteurs  ***************
    
    @GetMapping("acteur/{id}")
    public Actor findActorById(@PathVariable int id) {
        Actor actor = actorRepository.findById(id).get();
        
        return actor;
    }
    
    @GetMapping("acteurs")
    public List<Actor> findAllActors() {
        return actorRepository.findAll();
    }
    
    
    //recherche les acteurs avec un nom contenant un mot clé (ignore la casse) : 
    @GetMapping("acteurs/{nomActeur}")
    public List<Actor> findAllActorsByName(@PathVariable String nomActeur) {
        return actorRepository.findAll().stream().filter(movie -> movie.getName().toLowerCase().contains(nomActeur.toLowerCase())).collect(Collectors.toList());
    }
    
    // a finir 
    //@GetMapping("/findActeurs/{field}")
    public List<Actor> findActorByField(@PathVariable String field) {
        return actorRepository.findAll();//new Sort(Sort.Direction.ASC, "field"));
    }
    
    
    //***************  directeur  ***************
    
    @GetMapping("directeur/{id}")
    public List<Movie> findDirecteurById(@PathVariable int id) {
        Director director = directorRepository.findById(id).get();
        List<Movie> movies = movieService.getMovieByDirector(director);
        
        return movies;
    }

    @GetMapping("directeurs")
    public List<Movie> findDirecteurs() {

        List<Movie> movies = new ArrayList();
        for (Director director : directorRepository.findAll()) {
            movies.addAll(movieService.getMovieByDirector(director));
        }

        return movies;
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
