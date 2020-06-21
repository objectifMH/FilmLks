package fr.puppetmaster.FilmLkS.repository;

import fr.puppetmaster.FilmLkS.entity.Movie;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    public Movie findByTitle(String title);

    //Je recherche une liste de Films dont le titre a pour mot clé "tm" (sensible à la casse) : 
    //Ex :    /movies/search/byTitle?tm=Star
    @RestResource(path = "/byTitle")
    public List<Movie> findByTitleContains(@Param("tm") String title);
   
    //Je recherche une liste de Films dont le titre a pour mot clé "tm" (pas sensible à la casse) :
    @RestResource(path = "/byTitleIc")
    public List<Movie> findByTitleContainingIgnoreCase(@Param("tm") String title);

    //Tabulation 
    //Ex :   /movies/search/byTitlePage?tm=Star&page=0&size=2
    @RestResource(path = "/byTitlePage")
    public Page<Movie> findByTitleContains(@Param("tm") String title, Pageable pageable);


    //liste les films  pour un directeur donné : 
    @Query(value = "SELECT * FROM MOVIE m WHERE m.director_id = ?1", nativeQuery = true)
    public List<Movie> findByDirector(int id);
    
    //liste les films  pour un acteur donné : 
    @Query(value = "SELECT m.id, m.title, m.date, m.prix, m.director_id  FROM ACTOR a, actor_movie am, movie m where  am.movie_id = m.id and a.id = am.actor_id and a.id = ?1", nativeQuery = true)
    public List<Movie> findByActor(int id);
    
    
    //@Query(value = "SELECT * FROM MOVIE m WHERE upper(m.title) like upper((concat('%', ?1,'%')) ", nativeQuery = true)
    //public List<Movie> findByDirectorNoCase(String nameD);
    
    //Ex 
    // Creation d'un film : 
    // POST http://localhost:8088/movies/
    //{
    //	"title" : "Parasite",
    //  "prix" : 1.99,
    //  "date" : "1999-01-01",
    //  "director" : "/directors/5"
    //  }   
    //
}
