package fr.puppetmaster.FilmLkS.repository;

import fr.puppetmaster.FilmLkS.entity.Movie;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    public Movie findByTitle(String title);
    
    //Je recherche une liste de Films ayant le  mot clé title : 
    //Ex :    /movies/search/byTitle?tm=Star
    @RestResource(path = "/byTitle")
    public List<Movie> findByTitleContains(@Param("tm") String title);
    
    //Tabulation 
    //Ex :   /movies/search/byTitlePage?tm=Star&page=0&size=2
    @RestResource(path = "/byTitlePage")
    public Page<Movie> findByTitleContains(@Param("tm") String title, Pageable pageable);
}
