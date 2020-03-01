package fr.puppetmaster.FilmLkS.repository;

import fr.puppetmaster.FilmLkS.entity.Director;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
    //Je recherche une liste de directeur ayant le  mot clé name : 
    @RestResource(path = "/byName")
    public List<Director> findByNameContains(@Param("nd") String name);
    
    @RestResource(path = "/byNameIc")
    public List<Director> findByNameContainsIgnoreCase(@Param("nd") String name);

}
