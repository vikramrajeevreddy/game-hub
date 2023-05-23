package com.gamehub.game.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RawgGamesDto {
        private long count;
        private List<RawgListGame> results = new ArrayList<>();
}
