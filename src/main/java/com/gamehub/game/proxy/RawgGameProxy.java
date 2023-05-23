package com.gamehub.game.proxy;

import com.gamehub.game.model.RawgGamesDto;
import com.gamehub.game.model.RawgIndividualGame;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "rawg-game-service", url = "${rawg-base-api}")
public interface RawgGameProxy {

    @GetMapping("/games/{id}")
    public RawgIndividualGame getRawgGameDetails(@PathVariable("id") int gameId, @RequestParam("key") String apiKey);

    @GetMapping("/games")
    public RawgGamesDto getListOfGames(@RequestParam("key") String apiKey);
}