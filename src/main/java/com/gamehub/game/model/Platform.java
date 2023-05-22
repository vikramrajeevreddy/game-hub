package com.gamehub.game.model;

import lombok.Data;

@Data
public class Platform {
    private String name;

    private int id;
    private String slug;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
