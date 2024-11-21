package ee.gert.bowling_app.model;

import lombok.*;

@Data
public class Frame {
//    private static final String[] turnValues= {"1","2", "3", "4", "5", "6", "7", "8", "9", "10", "X", "/", "-", "F"};

    private Integer turn1;
    private Integer turn2;
    private Integer turn3;
    private Integer score;

    public Frame(){
        this.turn1 = 0;
        this.turn2 = 0;
//        this.turn3 = 0;
        this.score = 0;
    }
    public Frame(Boolean isLast){
        this.turn1 = 0;
        this.turn2 = 0;
        if (isLast){
            this.turn3 = 0;
        }
        this.score = 0;
    }

    public void calculateScore(Integer extraPoints){
        if (turn3 != null){
            setScore(turn1 + turn2 + turn3);
        }else {
            setScore(turn1 + turn2 + extraPoints);
        }
    }

    //FIXME: this does not take the last frame with 3 slots into account
    public boolean isStrike(){
        return (this.turn1 == 10);
    }

    //FIXME: this does not take the last frame with 3 slots into account
    public boolean isSpare(){
        return (this.turn1 != 10 && this.turn1 + this.turn2== 10);
    }




//    public void convertDTOtoFrame(FrameDTO frameDTO){
////        int frameScore = frameDTO.getTurn1()+ frameDTO.getTurn2() + frameDTO.getTurn3();
////        this.setScore(frameScore);
//
//        if (frameDTO.getTurn1() == 10){
//            this.setScore(10);
//            this.setTurn1("X");
//            return;
//        }
//
//        if (frameDTO.getTurn1()+ frameDTO.getTurn2() == 10){
//            this.setTurn1(frameDTO.getTurn1().toString()); //FIXME: validate the request string values before blindly adding them.
//            this.setScore(10);
//            this.setTurn2("/");
//            return;
//        }
//
//        if (frameDTO.getTurn1() != null){
//            this.setTurn1(frameDTO.getTurn1().toString());
//            this.setScore(this.getScore()+frameDTO.getTurn1());
//        }
//        if (frameDTO.getTurn2() != null){
//            this.setTurn2(frameDTO.getTurn2().toString());
//            this.setScore(this.getScore()+frameDTO.getTurn2());
//        }
//        if (frameDTO.getTurn3() != null){
//            this.setTurn3(frameDTO.getTurn3().toString());
//            this.setScore(this.getScore()+frameDTO.getTurn3());
//        }
//    }
}
