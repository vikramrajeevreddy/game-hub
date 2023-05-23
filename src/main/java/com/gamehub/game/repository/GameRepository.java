package com.gamehub.game.repository;

import com.gamehub.game.model.RawgListGame;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends MongoRepository<RawgListGame, Integer> {
}
