package com.example.gameinfoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/** The type Game. */
@Setter
@Getter
@Entity
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
<<<<<<< HEAD
          name = "game_genre",
          joinColumns = @JoinColumn(name = "game_id"),
          inverseJoinColumns = @JoinColumn(name = "genre_id"))
=======
      name = "game_genre",
      joinColumns = @JoinColumn(name = "game_id"),
      inverseJoinColumns = @JoinColumn(name = "genre_id"))
>>>>>>> f08aa90c8e02269b92c74c98a24117acd783481a
  @JsonIgnoreProperties(value = "games")
  private List<Genre> genre;
}
