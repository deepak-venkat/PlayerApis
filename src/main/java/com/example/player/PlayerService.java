package com.example.player;

import com.example.player.Player;
import com.example.player.PlayerRepository;
import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service

public class PlayerService implements PlayerRepository {

    private static HashMap<Integer, Player> team = new HashMap<>();
    private int playerId = 12;

    public PlayerService() {
        team.put(1, new Player(1, "Alexander", 5, "All-rounder"));
        team.put(2, new Player(2, "Benjamin", 3, "All-rounder"));
        team.put(3, new Player(3, "Michael", 18, "Batsman"));
        team.put(4, new Player(4, "William", 45, "Batsman"));
        team.put(5, new Player(5, "Joshua", 19, "Batsman"));
        team.put(6, new Player(6, "Daniel", 10, "Bowler"));
        team.put(7, new Player(7, "Matthew", 34, "Bowler"));
        team.put(8, new Player(8, "Samuel", 17, "Batsman"));
        team.put(9, new Player(9, "John", 1, "Bowler"));
        team.put(10, new Player(10, "Earnest", 2, "All-rounder"));
        team.put(11, new Player(11, "Bob", 25, "Batsman"));
    }

    // Don't modify the above code
    @Override
    public List<Player> getPlayers() {
        Collection<Player> players = team.values();
        List<Player> arrList = new ArrayList<>(players);
        return arrList;
    }

    @Override
    public Player addPlayer(Player player) {
        player.setPlayerId(playerId);
        team.put(playerId, player);
        playerId += 1;
        return player;
    }

    @Override
    public Player getPlayer(int playerId) {
        Player player = team.get(playerId);
        if (player == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return player;
    }

    @Override
    public Player updatePlayer(Player updatePlayer, int playerId) {
        Player player = team.get(playerId);
        if (player == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (updatePlayer.getPlayerName() != null)
            player.setPlayerName(updatePlayer.getPlayerName());
        Integer jerseyNo = updatePlayer.getJerseyNumber();
        if (jerseyNo != null) // int is primitive , cannot be compared with null(only reference types allowed)
            player.setJerseyNumber(updatePlayer.getJerseyNumber());
        if (updatePlayer.getRole() != null)
            player.setRole(updatePlayer.getRole());
        return player;
    }

    @Override
    public void deletePlayer(int playerId) {
        Player player = team.get(playerId);
        if (player == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else {
            team.remove(playerId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
