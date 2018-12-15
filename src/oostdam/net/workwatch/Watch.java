package oostdam.net.workwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;

import java.time.Duration;
import java.time.Instant;

/**
 * Custom javafx node.
 * It keeps track of time and exposes the ability to modify the time.
 */
public class Watch extends Label{

    // Set start to now() as we want the watch to start when the application starts.
    private final Instant start = Instant.now();
    // The modification for the time on the watch.
    private Duration modification = Duration.ZERO;

    public Watch(){
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
    }

    /**
     * Modify the time.
     * @param duration
     */
    public void modify(Duration duration){
        modification = modification.plus(duration);
        updateTime();
    }

    /**
     * Recalculate the time of the watch.
     */
    private void updateTime(){
        Duration duration = Duration.between(start, Instant.now()).plus(modification);
        this.setText("Time: " + format(duration));
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
