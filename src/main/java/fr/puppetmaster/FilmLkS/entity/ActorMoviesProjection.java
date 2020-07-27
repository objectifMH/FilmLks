/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.puppetmaster.FilmLkS.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="actorsMov", types=Actor.class)
public interface ActorMoviesProjection {
    public String getName();
}

