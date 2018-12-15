package oostdam.net.workwatch;

import javafx.scene.control.Label;

import java.time.Instant;

public class TimeLabel {

    private Label label;
    private final Instant start = Instant.now();
    private int additions;

    public TimeLabel(){

    }
}
