package ee.gert.bowling_app.model;

import lombok.*;

@Data
public class Frame {
    private Integer turn1;
    private Integer turn2;
    private Integer turn3;
    private Integer score;

    public Frame() {
        this.turn1 = 0;
        this.turn2 = 0;
        this.score = 0;
    }

    public Frame(Boolean isLast) {
        this.turn1 = 0;
        this.turn2 = 0;
        if (isLast) {
            this.turn3 = 0;
        }
        this.score = 0;
    }

    //FIXME: this does not take the last frame with 3 slots into account
    public boolean isStrike() {
        return (this.turn1 == 10);
    }

    //FIXME: this does not take the last frame with 3 slots into account
    public boolean isSpare() {
        return (this.turn1 != 10 && this.turn1 + this.turn2 == 10);
    }
}