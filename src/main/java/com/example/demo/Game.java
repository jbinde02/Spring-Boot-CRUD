package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    private Boolean recommend;

    public float getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(float timePlayed) {
        this.timePlayed = timePlayed;
    }
    @JsonProperty("time_played")
    private float timePlayed;

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", recommend=" + recommend +
                ", timePlayed=" + timePlayed +
                '}';
    }
}
