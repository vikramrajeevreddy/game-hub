package com.gamehub.game.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class RawgIndividualGame {

    private int id;

    private String name;

    private String released;

    private int rating;

    private String background_image;

    private int metacritic;

    private String description;

    private List<ParentPlatform> parent_platforms;

}
