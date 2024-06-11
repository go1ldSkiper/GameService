package com.example.gameinfoservice.repository;

import com.example.gameinfoservice.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

<<<<<<< HEAD

=======
>>>>>>> f08aa90c8e02269b92c74c98a24117acd783481a
/** The interface Game repository. */
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

<<<<<<< HEAD
    /**
     * Find game by name game.
     *
     * @param name the name
     * @return the game
     */
    @Query("SELECT g FROM Game g LEFT JOIN FETCH g.genre WHERE g.name = :name")
    Game findGameByName(@Param("name") String name);
=======
  /**
   * Find game by name game.
   *
   * @param name the name
   * @return the game
   */
  @Query("SELECT g FROM Game g LEFT JOIN FETCH g.genre WHERE g.name = :name")
  Game findGameByName(@Param("name") String name);
>>>>>>> f08aa90c8e02269b92c74c98a24117acd783481a
}
