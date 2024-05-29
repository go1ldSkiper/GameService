package com.example.gameinfoservice.repository;

import com.example.gameinfoservice.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * The interface Game repository.
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    /**
     * Find game by id game.
     *
     * @param id the id
     * @return the game
     */
    Game findGameById(Long id);

    /**
     * Find game by name or null game.
     *
     * @param name the name
     * @return the game
     */
    @Query("SELECT g FROM Game g left JOIN FETCH g.genre WHERE g.name = :name")
    Game findGameByNameOrNull(@Param("name") String name);
}
