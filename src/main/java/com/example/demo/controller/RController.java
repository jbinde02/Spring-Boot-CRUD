package com.example.demo.controller;

import com.example.demo.database.DatabaseAccesser;
import com.example.demo.database.Game;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class RController {

    DatabaseAccesser da;
    public RController(DatabaseAccesser da){
        this.da = da;
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/games")
    public String listGames(){
        return da.getAllGames();
    }

    @GetMapping("/game")
    public String getGame(@RequestParam(name = "name") String gameName){
        return da.getGame(gameName);
    }

    @PostMapping(path = "/game", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addGame(@RequestBody Game gameBody){
        boolean result = da.insertGame(gameBody);
        return String.valueOf(result);
    }

    @PutMapping(path = "/game", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateGame(@RequestBody Game gameBody){
        boolean result = da.updateGame(gameBody);
        return String.valueOf(result);
    }

    @DeleteMapping("/game")
    public String deleteGame(@RequestParam(name = "name") String gameName){
        boolean result = da.deleteGame(gameName);
        return String.valueOf(result);
    }
}
