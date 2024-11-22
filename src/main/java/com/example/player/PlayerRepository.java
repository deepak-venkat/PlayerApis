package com.example.player;

import java.util.*;
import com.example.player.Player;
import org.springframework.stereotype.Repository;

@Repository
interface PlayerRepository {
    public List<Player> getPlayers();

    public Player addPlayer(Player player);

    public Player getPlayer(int playerId);

    public Player updatePlayer(Player player, int playerId);

    public void deletePlayer(int playerId);
}