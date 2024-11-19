package ee.gert.bowling_app.model;

import ee.gert.bowling_app.dto.FrameDTO;
import lombok.Data;

import java.util.List;

@Data
public class FrameRequest {
    FrameDTO frame;
    String playerName;
    Integer frameIndex;
}
