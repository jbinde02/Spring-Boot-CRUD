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

    public String getGame(String gameName){
        List<Game> result = jdbcTemplate.query(String.format("SELECT * FROM GAMES WHERE NAME = \'%s\'",gameName ), new GameMapper());
        if (result.isEmpty()){
            return String.format("No game found with the name %s", gameName);
        }else{
            return result.toString();
        }
    }

    public boolean insertGame(Game game){
        int result = jdbcTemplate.update("INSERT INTO GAMES VALUES(?,?,?,?)", game.getName(), game.getDescription(), game.getRecommend(), game.getTimePlayed());
        return result > 0;
    }

    public boolean updateGame(Game game){
        int result = jdbcTemplate.update("UPDATE GAMES SET DESCRIPTION = ?, RECOMMEND = ?, TIME_PLAYED = ? WHERE NAME = ?", game.getDescription(), game.getRecommend(), game.getTimePlayed(), game.getName());
        return result > 0;
    }

    public boolean deleteGame(String gameName){
        int result = jdbcTemplate.update("DELETE FROM GAMES WHERE NAME = ?", gameName);
        return result > 0;
    }
}
