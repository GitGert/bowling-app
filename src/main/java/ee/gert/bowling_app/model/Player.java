package ee.gert.bowling_app.model;


import lombok.*;
import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Player {
    
    private String name;
    //FIXME: can I modify the frames still like in javascript?
    private List<Frame> frames;
    private Integer TotalScore;
//     FIXME: last frame should have 3 turns depending on the throws.

    public Player(String name){
        this.name = name;
        this.frames = new ArrayList<>();
    }

    public Integer getTotalScore(){
        for (Frame frame : frames){

            //convert to FRameDTO;
        }
    }

}
