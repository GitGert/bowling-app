package ee.gert.bowling_app.service;

import ee.gert.bowling_app.context.GameContext;
import ee.gert.bowling_app.model.Frame;
import ee.gert.bowling_app.model.Game;
import ee.gert.bowling_app.model.Player;

import ee.gert.bowling_app.utility.ScoreCalculator;
import ee.gert.bowling_app.validator.FrameValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameContext gameContext;

    GameService(){
        this.startGame();
    }

    public void startGame() {
        gameContext.resetGame();
    }
}
