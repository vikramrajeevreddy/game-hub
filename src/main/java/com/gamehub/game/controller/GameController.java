package com.gamehub.game.controller;

import com.gamehub.game.model.RawgGame;
import com.gamehub.game.service.GameService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<RawgGame> getGames(){
        return gameService.getRawgData();
    }
}
