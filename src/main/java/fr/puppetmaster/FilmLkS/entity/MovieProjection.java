/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.puppetmaster.FilmLkS.entity;

import java.util.List;
import org.springframework.data.rest.core.config.Projection;

// Ex pour tous les films       : movies?projection=movieAct 
// Ex pour le film avec id = 24 : movies/24?projection=movieAct 

@Projection(name="movieAct", types= Movie.class)
public interface MovieProjection {
    public String getTitle();
    public Director getDirector();
    public List<Actor> getActors();
}
