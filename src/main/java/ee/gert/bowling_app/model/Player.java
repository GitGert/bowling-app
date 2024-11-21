package ee.gert.bowling_app.model;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Player {
    
    private String name;
    private List<Frame> frames;
    private Integer totalScore;

//     FIXME: last frame should have 3 turns depending on the throws.

    public Player(String name){
        this.name = name;
        this.frames = new ArrayList<>(10);
        this.totalScore = 0;
    }

    public boolean isNewFrameValid(Frame newFrame){
        //if is last then has to have option for X X X

        System.out.println(newFrame);
        if (this.frames.size() < 9){
            if (newFrame.getTurn1() != null && newFrame.getTurn2() != null && newFrame.getTurn3() == null){
                return (newFrame.getTurn1() + newFrame.getTurn2() <= 10);
            }
        }else if (this.frames.size() == 9){
            if  (newFrame.getTurn1() != null && newFrame.getTurn2() != null && newFrame.getTurn3() != null){
                return  (newFrame.getTurn1() <=10 && newFrame.getTurn2() <=10 && newFrame.getTurn3() <=10);
            }
        }
        // if not last then must not have 3rd thingy and must have atleast 2.
        return false;
    }


    //FIXME : currently I don't even need the variable TotalScore, might be a problem later.
    public void calculateTotalScore(){
        Integer score = 0;
        for (int i = 0; i < frames.size(); i++) {
            Frame frame = frames.get(i);
            Integer currentFrameBonusPoints = 0;
            if (frame.isSpare() && i+1 <= frames.size() - 1){
                currentFrameBonusPoints += frames.get(i+1).getTurn1();
                //FIXME: what happens when this goes out of bounds?
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


            frame.calculateScore(currentFrameBonusPoints);
            score += frame.getScore();
        }
        setTotalScore(score);
    }

}
