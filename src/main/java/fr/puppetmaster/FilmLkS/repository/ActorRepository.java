package fr.puppetmaster.FilmLkS.repository;

import fr.puppetmaster.FilmLkS.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    public Actor findByName(String name);
}
