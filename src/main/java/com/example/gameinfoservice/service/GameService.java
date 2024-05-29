package com.example.gameinfoservice.service;

import com.example.gameinfoservice.cache.CacheManager;
import com.example.gameinfoservice.model.Game;
import com.example.gameinfoservice.model.Genre;
import com.example.gameinfoservice.repository.GameRepository;
import com.example.gameinfoservice.repository.GenreRepository;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class GameService {

    private GameRepository gameRepository;
    private GenreRepository genreRepository;
    private CacheManager cacheManager;
    private static final String GAME = "gameName_";



    public List<Game> getAllGames() {
        List<Game> gameList = gameRepository.findAll();
        for (Game game: gameList) {
            cacheManager.put(GAME + game.getName(), game);
        }
        return gameList;
    }



    public boolean saveGame(final Game game) {
        cacheManager.put(GAME + game.getName(), game);
        gameRepository.save(game);
        return true;
    }



    public boolean changeName(final Long id, final String newName) {
        Game game = gameRepository.findGameById(id);
        game.setName(newName);
        cacheManager.clear();
        gameRepository.save(game);
        return true;
    }



    public Game putGameToGenre(final Long id, final String name) {
        Genre genre = genreRepository.findGenreByName(name);
        List<Game> games = genre.getGames();
        Game game = gameRepository.findGameById(id);
        games.add(game);
        genre.setGames(games);
        genreRepository.save(genre);
        List<Genre> genres = game.getGenre();
        genres.add(genre);
        game.setGenre(genres);
        gameRepository.save(game);
        cacheManager.clear();
        return game;
    }



    public void deleteGameById(final Long id) {
        Game game = gameRepository.findGameById(id);
        List<Genre> genres = game.getGenre();
        for (Genre genre : genres) {
            List<Game> games = genre.getGames();
            games.remove(game);
            genre.setGames(games);
            genreRepository.save(genre);
        }
        cacheManager.clear();
        gameRepository.deleteById(id);
    }



    public Game getByName(final String name) {
        Object gameObj = cacheManager.get(GAME + name);
        if (gameObj != null) {
            return (Game) gameObj;
        } else {
            Game game = gameRepository.findGameByNameOrNull(name);
            cacheManager.put(GAME + game.getName(), game);
            return game;
        }
    }
}
