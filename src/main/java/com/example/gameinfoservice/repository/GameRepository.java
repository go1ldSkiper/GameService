package com.example.gameinfoservice.repository;

import com.example.gameinfoservice.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface GameRepository extends JpaRepository<Game, Long> {


    Game findGameById(Long id);

    @Query("SELECT g FROM Game g left JOIN FETCH g.genre WHERE g.name = :name")
    Game findGameByNameOrNull(@Param("name") String name);
}
