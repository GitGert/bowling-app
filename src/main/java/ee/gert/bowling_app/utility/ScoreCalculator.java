package ee.gert.bowling_app.utility;

import ee.gert.bowling_app.model.Frame;
import ee.gert.bowling_app.model.Player;

import java.util.List;

public class ScoreCalculator {
    public void calculateTotalScore(Player player){
        List<Frame> frames = player.getFrames();
        Integer score = 0;
        for (int i = 0; i < frames.size(); i++) {
            Frame frame = frames.get(i);
            Integer currentFrameBonusPoints = 0;

            if (frame.isSpare() && i+1 <= frames.size() - 1){
                currentFrameBonusPoints += frames.get(i+1).getTurn1();
            }

            if (frame.isStrike() && i+1 <= frames.size() - 1){
                Frame nextFrame = frames.get(i+1);
                if (nextFrame.isStrike() && i+2 <= frames.size() - 1){
                    currentFrameBonusPoints += nextFrame.getTurn1();
                    currentFrameBonusPoints += frames.get(i+2).getTurn1();
                }else{
                    currentFrameBonusPoints += (nextFrame.getTurn1() + nextFrame.getTurn2());
                }
            }

            calculateScore(frame, currentFrameBonusPoints);
            score += frame.getScore();
        }
        player.setTotalScore(score);
    }

    public void calculateScore(Frame frame, Integer extraPoints) {
        if (frame.getTurn3() != null) {
            frame.setScore(frame.getTurn1() + frame.getTurn2() + frame.getTurn3());
        } else {
            frame.setScore(frame.getTurn1() + frame.getTurn2() + extraPoints);
        }
    }
}
