package ee.gert.bowling_app.service;

import ee.gert.bowling_app.dto.FrameDTO;
import ee.gert.bowling_app.model.Frame;
import ee.gert.bowling_app.model.Game;
import ee.gert.bowling_app.model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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

    public Player addFrame(Integer index, FrameDTO frameDTO, String playerName) {
        Frame frame = new Frame();
        frame.convertDTOtoFrame(frameDTO);


        Player player = this.game.getPlayerByName(playerName);

        if (player == null){
            return null;
        }

        if(index == null || index < 0 || index >= player.getFrames().size()){
            player.getFrames().add(frame);
            return player;
        }

        player.getFrames().set(index, frame);
        return  player;
    }
}
