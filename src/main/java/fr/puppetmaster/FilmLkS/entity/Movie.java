package fr.puppetmaster.FilmLkS.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false ) 
    private String title;
    
    
    @Temporal(TemporalType.DATE) @Column(nullable = false ) 
    private Date date;
    
    @ManyToOne 
    //@Column(name = "id_director", nullable = false)
    private Director director;
    
    
    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="actor_movie", 
          joinColumns = @JoinColumn(name = "movie_id") ,
            inverseJoinColumns = @JoinColumn(name = "actor_id")) 
    private List<Actor> actors; 

}
