package com.gamehub.game.repository;

import com.gamehub.game.model.RawgGame;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends MongoRepository<RawgGame, Integer> {
}
