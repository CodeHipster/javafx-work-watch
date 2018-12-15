package oostdam.net.workwatch;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class WorkTimerController {

    private final Instant start = Instant.now();
    private int additions;

    @FXML
    private Label time;
    @FXML
    private Button minus15;
    @FXML
    private Button plus15;

    @FXML
    private void initialize(){
        updateTime();
        plus15.setText(" +15");
        plus15.setOnAction(event -> this.add15Minutes());
        minus15.setText(" -15");
        minus15.setOnAction(event -> this.subtract15Minutes());

        Timeline clock = new Timeline(
                new KeyFrame(javafx.util.Duration.ZERO, e -> { updateTime(); })
                , new KeyFrame(javafx.util.Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    private void subtract15Minutes(){additions--; updateTime();}
    private void add15Minutes(){additions++; updateTime();}

    private void updateTime(){
        Duration duration = Duration.between(start, Instant.now()).plus(additions * 15, ChronoUnit.MINUTES);
        time.setText("Time: " + DurationFormatter.format(duration));
    }

}
