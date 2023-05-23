package com.gamehub.game.service;

import com.gamehub.game.exception.RAWGApiException;
import com.gamehub.game.model.RawgIndividualGame;
import com.gamehub.game.model.RawgListGame;
import com.gamehub.game.proxy.RawgGameProxy;
import com.gamehub.game.repository.IndividualGameRepository;
import com.gamehub.game.repository.ListGameRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final ListGameRepository listGameRepository;

    private final RawgGameProxy rawgGameProxy;

    private final IndividualGameRepository individualGameRepository;

    @Value("${rawg.game.api.key}")
    private String apiKey;

    public GameService(ListGameRepository listGameRepository, RawgGameProxy rawgGameProxy, IndividualGameRepository individualGameRepository) {
        this.listGameRepository = listGameRepository;
        this.rawgGameProxy=rawgGameProxy;
        this.individualGameRepository = individualGameRepository;
    }

    public List<RawgListGame> getRawgData() {
        List<RawgListGame> results= rawgGameProxy.getListOfGames(apiKey).getResults();
        if(results.isEmpty()) throw new RAWGApiException("Error Fetching Data from Rawg API");
        listGameRepository.saveAll(results);
        return results;
    }

    public RawgIndividualGame getRawgGameData(int id) {
        RawgIndividualGame result= rawgGameProxy.getRawgGameDetails(id,apiKey);
        if(result.getName().isEmpty()) throw new RAWGApiException("Error Fetching Data from Rawg API");
        individualGameRepository.save(result);
        return result;
    }
}
