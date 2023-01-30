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
    public String getGame(){
        return "Darktide";
    }

    @PostMapping(path = "games", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addGames(){
        return "Darktide";
    }

    @PostMapping(path = "game", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addGame(@RequestBody Game gameBody){
        return gameBody.toString();
    }
}
