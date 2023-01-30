package com.example.demo.database;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DatabaseAccesser {
    private final JdbcTemplate jdbcTemplate;

    public DatabaseAccesser(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getAllGames(){
        List<Game> allGames = jdbcTemplate.query("SELECT * FROM GAMES;", new GameMapper());
        return allGames.toString();
    }
}
