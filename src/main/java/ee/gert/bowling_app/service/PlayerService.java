package ee.gert.bowling_app.service;

import ee.gert.bowling_app.context.GameContext;
import ee.gert.bowling_app.model.Frame;
import ee.gert.bowling_app.model.Player;
import ee.gert.bowling_app.utility.ScoreCalculator;
import ee.gert.bowling_app.validator.FrameValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    @Autowired
    ScoreCalculator scoreCalculator;

    @Autowired
    FrameValidator frameValidator;

    @Autowired
    private GameContext gameContext;

    public Player addPlayer(Player player) {
        gameContext.getGame().addPlayer(player);
        return player;
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(gameContext.getGame().getPlayers().values());
    }

    //TODO : throw errors instead of return null to show when something goes wrong
    public Player addFrame(Integer index, Frame frame, String playerName) {
        Player player = this.gameContext.getGame().getPlayerByName(playerName);
        if (player == null){
            return null;
        }

        if (!frameValidator.isNewFrameValid(player, frame, index )){
            return null;
        }

        List<Frame> playerFrames = player.getFrames();

        if(index != null && index > 0 && index < playerFrames.size()){
            playerFrames.set(index, frame);
            scoreCalculator.calculateTotalScore(player);
            return  player;
        }else if (playerFrames.size() >10){ // if there is no index for an edit check if there is room for more.
            return  player;
        }

        playerFrames.add(frame);
        scoreCalculator.calculateTotalScore(player);
        return player;
    }
}
