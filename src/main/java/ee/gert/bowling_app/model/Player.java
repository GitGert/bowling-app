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

    public boolean isNewFrameValid(Frame newFrame, Integer editingIndex){
        System.out.println(newFrame);

        boolean isEditingAnExistingFrame = editingIndex != null;

        if (isEditingAnExistingFrame){
            if ( editingIndex > this.frames.size()-1){
                return false;
            }
        }

        if (this.frames.size() <= 8 || isEditingAnExistingFrame && editingIndex <= 8){
            return isNormalFrameValid(newFrame);
        }else if (this.frames.size() == 9 || isEditingAnExistingFrame && editingIndex == 9){
            return isLastFrameValid(newFrame);
        }
        return false;
    }

    public boolean isNormalFrameValid(Frame frame){
        if (frame.getTurn1() != null && frame.getTurn2() != null && frame.getTurn3() == null){
            return (frame.getTurn1() + frame.getTurn2() <= 10);
        }
        return false;
    }

    public boolean isLastFrameValid(Frame frame){
        if  (frame.getTurn1() != null && frame.getTurn2() != null){
            //cannot have a third throw if did not get a strike or a spare:
            if (frame.isSpare() || frame.isStrike() && frame.getTurn3() == null){
                return false;
            }

            if (frame.getTurn3() == null){
                return frame.getTurn1() <=10 && frame.getTurn2() <=10;
            }else{
                return frame.getTurn1() <=10 && frame.getTurn2() <=10 && frame.getTurn3() <=10;
            }

        }
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
