package fr.puppetmaster.FilmLkS.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    // Avec cette solution pas besoin de projections ni de //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) dans la table Movie

    //@ManyToMany(mappedBy = "actors")
    //private Collection<Movie> movies = new ArrayList();
}
