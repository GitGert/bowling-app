package ee.gert.bowling_app.validator;

import ee.gert.bowling_app.model.Frame;
import ee.gert.bowling_app.model.Player;

import java.util.List;

public class FrameValidator {
    public boolean isNewFrameValid(Player player, Frame newFrame, Integer editingIndex){
        List<Frame> frames = player.getFrames();
        System.out.println(newFrame);

        boolean isEditingAnExistingFrame = editingIndex != null;

        if (isEditingAnExistingFrame){
            if ( editingIndex > frames.size()-1){
                return false;
            }
        }

        if (frames.size() <= 8 || isEditingAnExistingFrame && editingIndex <= 8){
            return isNormalFrameValid(newFrame);
        }else if (frames.size() == 9 || isEditingAnExistingFrame && editingIndex == 9){
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
        if  (frame.getTurn1() == null && frame.getTurn2() == null){
            return false;
        }

        if (frame.isSpare() || frame.isStrike() && frame.getTurn3() == null){
            return false;
        }

        if (frame.getTurn3() == null){
            return frame.getTurn1() <=10 && frame.getTurn2() <=10;
        }else{
            return frame.getTurn1() <=10 && frame.getTurn2() <=10 && frame.getTurn3() <=10;
        }
    }


}
