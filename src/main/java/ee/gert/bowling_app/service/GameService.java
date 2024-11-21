package ee.gert.bowling_app.service;

import ee.gert.bowling_app.context.GameContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private GameContext gameContext;

    GameService(){
//        this.startGame();
    }

    public void startGame() {
        gameContext.resetGame();
    }
}
