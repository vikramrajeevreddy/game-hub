package com.gamehub.game.service;

import com.gamehub.game.model.RawgGame;
import com.gamehub.game.proxy.RawgGameProxy;
import com.gamehub.game.repository.GameRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    private final RawgGameProxy rawgGameProxy;

    @Value("${rawg.game.api.key}")
    private String apiKey;

    public GameService(GameRepository gameRepository, RawgGameProxy rawgGameProxy) {
        this.gameRepository = gameRepository;
        this.rawgGameProxy=rawgGameProxy;
    }

    public List<RawgGame> getRawgData(){
        List<RawgGame> results= rawgGameProxy.getListOfGames(apiKey).getResults();
        gameRepository.saveAll(results);
        return results;
    }
}