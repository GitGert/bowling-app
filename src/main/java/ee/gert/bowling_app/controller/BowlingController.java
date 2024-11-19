package ee.gert.bowling_app.controller;

import ee.gert.bowling_app.model.FrameRequest;
import ee.gert.bowling_app.model.Game;
import ee.gert.bowling_app.model.Player;
import ee.gert.bowling_app.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BowlingController {
    @Autowired
    GameService gameService;


    @GetMapping("start-game")
    public String startGame(){
        gameService.startGame();
        return "game started";
    }

    @GetMapping("players")
    public List<Player> getAllPlayers(){
        return gameService.getPlayers();
    }

    @PostMapping("player")
    public Player addPlayer(@RequestBody Player player){
        return gameService.addPlayer(player);
    }

    @PostMapping("add-frame")
    public Player addFrame(@RequestBody FrameRequest frameRequest){
        return gameService.addFrame(frameRequest.getFrameIndex(), frameRequest.getFrame(), frameRequest.getPlayerName());
    }


}
