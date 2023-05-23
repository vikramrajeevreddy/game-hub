package com.gamehub.game.repository;

import com.gamehub.game.model.RawgIndividualGame;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualGameRepository extends MongoRepository<RawgIndividualGame, Integer> {
}
