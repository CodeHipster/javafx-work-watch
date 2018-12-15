package oostdam.net.workwatch;


import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * Controller class for the WorkWatch.
 * It binds with the WorkWatch.fxml.
 */
public class WorkWatchController {

    /**
     * The javafx framework injects the nodes defined into these properties.
     */
    @FXML
    private Watch watch;
    @FXML
    private Button minus15;
    @FXML
    private Button plus15;

    /**
     * The initialize method is called after the controller is constructed and the properties have been injected.
     * This gives the ability to add some functionality to the nodes.
     */
    @FXML
    private void initialize(){
        // Define the actions the buttons should do. Which is modify the time on the watch.
        plus15.setOnAction(event -> watch.modify(Duration.of(15, ChronoUnit.MINUTES)));
        minus15.setOnAction(event -> watch.modify(Duration.of(-15, ChronoUnit.MINUTES)));
    }
}
