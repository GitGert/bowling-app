package ee.gert.bowling_app.model;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Data
public class Player {
    private String name;
    private List<Frame> frames;
    private Integer totalScore;
}
