package com.example.player;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import com.example.player.Player;
import com.example.player.PlayerService;
import com.example.player.PlayerRepository;

@RestController

class PlayerController {
    @Autowired
    private PlayerRepository service;

    @GetMapping("/players")

    public List<Player> getPlayers() {
        return service.getPlayers();
    }

    @PostMapping("/players")

    public Player addPlayer(@RequestBody Player player) {
        return service.addPlayer(player);
    }

    @GetMapping("/players/{playerId}")

    public Player getThatPlayer(@PathVariable int playerId) {
        return service.getPlayer(playerId);
    }

    @PutMapping("/players/{playerId}")

    public Player updateThatPlayer(@RequestBody Player player, @PathVariable int playerId) {
        return service.updatePlayer(player, playerId);
    }

    @DeleteMapping("/players/{playerId}")
    public void deleteThatPlayer(@PathVariable int playerId) {
        service.deletePlayer(playerId);
    }
}
