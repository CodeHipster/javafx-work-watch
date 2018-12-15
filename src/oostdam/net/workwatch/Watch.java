package oostdam.net.workwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.time.Duration;
import java.time.Instant;

/**
 * Custom javafx node.
 * It keeps track of time and exposes the ability to modify the time.
 */
public class Watch extends VBox {

    // Set start to now() as we want the watch to start when the application starts.
    private final Instant start = Instant.now();
    // The breaks for the time on the watch.
    private Duration breaks = Duration.ZERO;

    // Label for the unmodified time.
    private Label elapsedTime = new Label();
    // Label for the breaks applied to the time.
    private Label breakTime = new Label();
    // Label for the resulting time.
    private Label workedTime = new Label();

    public Watch(){
        getChildren().addAll(elapsedTime, breakTime, workedTime);

        // Creating a Timeline with 2 KeyFrames(think frames of an animation)
        // first frame takes zero time and updates the time on the watch
        // second frame takes 1 second and does nothing
        // these frames are repeated indefinitely.
        Timeline clock = new Timeline(
                new KeyFrame(javafx.util.Duration.ZERO, e -> { updateTime(); })
                , new KeyFrame(javafx.util.Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        // Updating the time in the constructor, so the content of the labels is set before the javafx framework resolves its layout.
        // If not the labels would get their content on the first frame of the clock.
        updateTime();
    }

    /**
     * Modify the time.
     * @param duration
     */
    public void modify(Duration duration){
        breaks = breaks.plus(duration);
        updateTime();
    }

    /**
     * Update the time shown on the watch.
     */
    private void updateTime(){
        Duration elapsed = Duration.between(start, Instant.now());
        Duration worked = elapsed.minus(breaks);
        this.elapsedTime.setText("Time elapsed: " + format(elapsed));
        this.breakTime.setText("Break: " + format(breaks));
        this.workedTime.setText("Worked: " + format(worked));
    }

    /**
     * Format a duration to hh:MM:SS
     */
    public String format(Duration duration){
        long seconds = duration.getSeconds();
        long absSeconds = Math.abs(seconds);
        String positive = String.format(
                "%02d:%02d:%02d",
                absSeconds / 3600,
                (absSeconds % 3600) / 60,
                absSeconds % 60);
        return seconds < 0 ? "-" + positive : positive;
    }
}
