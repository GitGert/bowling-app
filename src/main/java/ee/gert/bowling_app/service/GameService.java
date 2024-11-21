package ee.gert.bowling_app.service;

import ee.gert.bowling_app.model.Frame;
import ee.gert.bowling_app.model.Game;
import ee.gert.bowling_app.model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private Game game;

    GameService(){
        this.startGame();
    }

    public void startGame(){
        this.game = new Game();
    }

    public Player addPlayer(Player player){
        game.addPlayer(player);
        return player;
    }

    public List<Player> getPlayers(){
        return new ArrayList<>(game.getPlayers().values());
    }

    //TODO : throw errors instead to show when something goes wrong
    public Player addFrame(Integer index, Frame frame, String playerName) {
        Player player = this.game.getPlayerByName(playerName);
        if (player == null){
            return null;
        }

        if (!player.isNewFrameValid(frame, index )){
            return null;
        }
        
        List<Frame> playerFrames = player.getFrames();

        if(index != null && index > 0 && index < playerFrames.size()){
            playerFrames.set(index, frame);
            player.calculateTotalScore();
            return  player;
        }else if (playerFrames.size() >10){ // if there is no index check if there is room for more.
            return  player;
        }

        playerFrames.add(frame);
        player.calculateTotalScore();
        return player;
    }
}
