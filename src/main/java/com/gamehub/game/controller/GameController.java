package com.gamehub.game.controller;

import com.gamehub.game.exception.RAWGApiException;
import com.gamehub.game.model.RawgGame;
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
    public List<RawgGame> getGames() throws RAWGApiException {
        return gameService.getRawgData();
    }

    @GetMapping("/games/errorhandler")
    @CrossOrigin("http://localhost:5173/")
    public ResponseEntity<List<RawgGame>> getGamesErrorHandled() throws RAWGApiException {
        return ResponseEntity.ok().body(gameService.getRawgData());
    }
}
