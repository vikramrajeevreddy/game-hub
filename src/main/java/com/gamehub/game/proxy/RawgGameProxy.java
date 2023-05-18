package com.gamehub.game.proxy;

import com.gamehub.game.model.RawgGameDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "rawg-game-service", url = "${rawg-base-api}")
public interface RawgGameProxy {

//    @GetMapping("/games/{id}")
//    RawgGameDto getGameDetails(@PathVariable("id") String gameId, @RequestParam("key") String apiKey);

    @GetMapping("/games")
    public RawgGameDto getListOfGames(@RequestParam("key") String apiKey);
}