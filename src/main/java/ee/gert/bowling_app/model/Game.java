package ee.gert.bowling_app.model;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class Game {
    private HashMap<String, Player> players;

    public void addPlayer(Player player) {
        this.players.put(player.getName(), player);
    }

    public Game() {
        this.players = new HashMap<>();
    }

    public Player getPlayerByName(String name) {
        if (players.containsKey(name)) {
            return players.get(name);
        }
        return null;
    }
}