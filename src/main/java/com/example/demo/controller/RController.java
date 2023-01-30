package com.example.demo.controller;

import com.example.demo.database.Game;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class RController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/games")
    public String listGames(){
        return "Darktide";
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
