package com.example.demo.database;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GameMapper implements RowMapper<Game> {
    @Override
    public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setName(rs.getString("name"));
        game.setDescription(rs.getString("description"));
        game.setRecommend(Boolean.valueOf(rs.getString("recommend")));
        game.setTimePlayed(Float.parseFloat(rs.getString("time_played")));
        return game;
    }
}
