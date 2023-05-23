package com.gamehub.game.service;

import com.gamehub.game.exception.RAWGApiException;
import com.gamehub.game.model.RawgIndividualGame;
import com.gamehub.game.model.RawgListGame;
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

    public List<RawgListGame> getRawgData() {
        List<RawgListGame> results= rawgGameProxy.getListOfGames(apiKey).getResults();
        if(results.isEmpty()) throw new RAWGApiException("Error Fetching Data from Rawg API");
        gameRepository.saveAll(results);
        return results;
    }

    public RawgIndividualGame getRawgGameData(int id) {
        RawgIndividualGame result= rawgGameProxy.getRawgGameDetails(id,apiKey);
        if(result.getName().isEmpty()) throw new RAWGApiException("Error Fetching Data from Rawg API");
        //gameRepository.saveAll(result);
        return result;
    }
}
