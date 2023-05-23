package com.gamehub.game.controller;

import com.gamehub.game.exception.RAWGApiException;
import com.gamehub.game.model.RawgIndividualGame;
import com.gamehub.game.model.RawgListGame;
import com.gamehub.game.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rawg")
public class GameController {
    public GameService gameService;

    public GameController(GameService gameService){
    this.gameService = gameService;
    }

    @GetMapping("/games")
    @CrossOrigin("http://localhost:5173/")
    public List<RawgListGame> getGames() throws RAWGApiException {
        return gameService.getRawgData();
    }

    @GetMapping("/games/errorhandler")
    @CrossOrigin("http://localhost:5173/")
    public ResponseEntity<List<RawgListGame>> getGamesErrorHandled() {
        return ResponseEntity.ok().body(gameService.getRawgData());
    }

    @GetMapping("/games/{id}")
    @CrossOrigin("http://localhost:5173/")
    public ResponseEntity<RawgIndividualGame> getGameDataErrorHandled(@PathVariable int id) {
        return ResponseEntity.ok().body(gameService.getRawgGameData(id));
    }
}
