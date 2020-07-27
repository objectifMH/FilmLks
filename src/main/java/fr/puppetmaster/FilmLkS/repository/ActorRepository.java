package fr.puppetmaster.FilmLkS.repository;

import fr.puppetmaster.FilmLkS.entity.Actor;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    
    public Actor findByName(String name);
     
    @RestResource(path = "/byNameIc")
    public List<Actor> findByNameContainsIgnoreCase(@Param("na") String name);
    
    //Recherche une liste d'acteurs ayant le mot clé name : 
    //Ex :    /actors/search/byName?na=Jordan
    @RestResource(path = "/byName")
    public List<Actor> findByNameContains(@Param("na") String name);
    
    //Tabulation 
    //Ex :   /actors/search/byNamePage?na=Jordan&page=0&size=2
    @RestResource(path = "/byNamePage")
    public Page<Actor> findByNameContains(@Param("na") String name, Pageable pageable);
    
    

}
