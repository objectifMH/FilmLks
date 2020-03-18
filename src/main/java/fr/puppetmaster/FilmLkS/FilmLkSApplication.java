package fr.puppetmaster.FilmLkS;


import fr.puppetmaster.FilmLkS.entity.Actor;
import fr.puppetmaster.FilmLkS.entity.Director;
import fr.puppetmaster.FilmLkS.entity.Movie;
import fr.puppetmaster.FilmLkS.repository.ActorRepository;
import fr.puppetmaster.FilmLkS.repository.DirectorRepository;
import fr.puppetmaster.FilmLkS.repository.MovieRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.transaction.annotation.Transactional;


@SpringBootApplication
public class FilmLkSApplication implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private ActorRepository actorRepository;
    
    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private RepositoryRestConfiguration restConfiguration;
    
    

    public static void main(String[] args) {
        SpringApplication.run(FilmLkSApplication.class, args);
    }

    @Override @Transactional
    public void run(String... args) throws Exception {
        //Affiche l'id 
        restConfiguration.exposeIdsFor(Actor.class, Director.class, Movie.class);
        
        
        System.out.println("Le serveur est lancé ! ");
        movieRepository.findAll().forEach(movie -> {
            //System.out.println(movie.toString());
            System.out.println(movie.getTitle());
            System.out.println(movie.getDirector());
            //System.out.println(movie.getActors());
            
            
        });

        Movie filmGattaca = movieRepository.findByTitle("Gattaca");
        //System.out.println(filmGattaca);
        
        Actor actorBrad = actorRepository.findByName("Harrison Ford");
        //System.out.println(actorBrad);
        
        //on ajoute un film : 
        Director dir = directorRepository.findById(1).get();
        List<Actor> actorsMov = new ArrayList();
        
        Movie mov = new Movie(null, "Le tombeaux des lucioles", new Date() , dir, actorsMov);
        movieRepository.save(mov);
    }
}
