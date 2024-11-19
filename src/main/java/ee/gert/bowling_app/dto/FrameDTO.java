package ee.gert.bowling_app.dto;

import ee.gert.bowling_app.model.Frame;
import lombok.Data;

@Data
public class FrameDTO {

    private Integer turn1;
    private Integer turn2;
    private Integer turn3;

    private Integer score;

//    private Integer throwCount;

//FIXME: take into account that - or 0 should be a missed shot, null is not shot, numbers or X or / it is a shot that hit.

    public void turnFrameToFrameDTO(Frame frame){

        if (frame.getTurn1().equals("X")){
            this.setScore(10);
            this.setTurn1(10);
            return;
        }

        if ((frame.getTurn1()+ frame.getTurn2()).equals("/")){
            this.setTurn1(Integer.parseInt(frame.getTurn1())); //FIXME: validate the request string values before blindly adding them.
            this.setScore(10);
            this.setTurn2(10-this.getTurn1());
            return;
        }


        if (!frame.getTurn1().equals(0)){

            this.setTurn1(frame.getTurn1().toString());
            this.setScore(this.getScore()+frame.getTurn1());
        }
        if (frame.getTurn2() != null){
            this.setTurn2(frame.getTurn2().toString());
            this.setScore(this.getScore()+frame.getTurn2());
        }
        if (frame.getTurn3() != null){
            this.setTurn3(frame.getTurn3().toString());
            this.setScore(this.getScore()+frame.getTurn3());
        }

    }
}
/