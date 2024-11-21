package ee.gert.bowling_app.model;

import lombok.Data;

@Data
public class FrameRequest {
    Frame frame;
    String playerName;
    Integer frameIndex;
}
