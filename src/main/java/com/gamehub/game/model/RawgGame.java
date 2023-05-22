package com.gamehub.game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RawgGame {
    private long id;

    private String name;

    private String released;

    private int rating;

    private String background_image;

    private int metacritic;

    private List<ParentPlatform> parent_platforms;

}
