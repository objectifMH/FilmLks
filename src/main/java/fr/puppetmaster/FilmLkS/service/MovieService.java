/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.puppetmaster.FilmLkS.service;

import fr.puppetmaster.FilmLkS.entity.Director;
import fr.puppetmaster.FilmLkS.entity.Movie;
import fr.puppetmaster.FilmLkS.repository.MovieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

/**
 *
 * @author gtu
 */
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    //On sauve un Film :
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    //On sauve une liste de films :
    public List<Movie> addMovies(List<Movie> movies) {
        return movieRepository.saveAll(movies);
    }

    //On renvoie une liste de Films :
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    //On cherche un Film par son id :
    public Movie getMovieById(int id) {
        System.out.println(movieRepository.findById(id).orElse(null));
        return movieRepository.findById(id).orElse(null);
    }

    //On cherche un Film par son titre :
    public Movie getMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    //On supprime un Film :
    public void deleteMovieById(int id) {
        movieRepository.deleteById(id);

    }

    //On met à jour un Film :
    public Movie updateMovie(Movie movieMaj) {
        Movie movie = movieRepository.findById(movieMaj.getId()).orElse(null);
        return movieRepository.save(movieMaj);
    }

    //On trie en fonction des champs :  
    public List<Movie> getMovieSortByTitle(String field) {
        return movieRepository.findAll();
    }
    
    //On cherche par mot clé :
    public List<Movie> getMovieByMc(String mc) {
        return movieRepository.findByTitleContains(mc);
    }
    
    //On cherche par mot directeur :
    public List<Movie> getMovieByDirector(Director director) {
       return movieRepository.findByDirector(director.getId());
    }

}
