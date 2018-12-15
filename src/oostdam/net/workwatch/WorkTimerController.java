package oostdam.net.workwatch;


import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class WorkTimerController {

    @FXML
    private TimeLabel time;
    @FXML
    private Button minus15;
    @FXML
    private Button plus15;

    @FXML
    private void initialize(){
        plus15.setText(" +15 min");
        plus15.setOnAction(event -> time.modify(Duration.of(15, ChronoUnit.MINUTES)));
        minus15.setText(" -15 min");
        minus15.setOnAction(event -> time.modify(Duration.of(-15, ChronoUnit.MINUTES)));


    }
}
