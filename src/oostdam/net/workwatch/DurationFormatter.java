package oostdam.net.workwatch;

import java.time.Duration;

public class DurationFormatter {

    /**
     * Format a duration to hh:MM:SS
     * @param duration
     * @return
     */
    public static String format(Duration duration){
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
