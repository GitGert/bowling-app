package ee.gert.bowling_app.context;


import ee.gert.bowling_app.model.Game;
import org.springframework.stereotype.Component;

@Component
public class GameContext {
    private Game game = new Game();

    public Game getGame() {
        return game;
    }

    public void resetGame() {
        this.game = new Game();
    }
}
