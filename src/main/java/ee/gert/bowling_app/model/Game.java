package ee.gert.bowling_app.model;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class Game {
    private HashMap<String ,Player> players;

    public void addPlayer(Player player){
        //TODO: must add check for player name to be unique
        this.players.put(player.getName(), player);
    }

    public Game(){
        this.players = new HashMap<>();
    }

    public Player getPlayerByName(String name){
        if (players.containsKey(name)){
            return players.get(name);
        }
        return  null;
    }

    public Integer getTotalScore(){

//        for (Player player : this.players.values()){
//            this. player.getTotalScore();
//        }

    }

// I should Have a map of users tied to 10 array length frames
//    Map<Player[], Frame[]> userScores = new HashMap<>();



}
