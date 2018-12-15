package oostdam.net.workwatch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Load the fxml that defines the gui.
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/WorkWatch.fxml"));
        // Get the root node from the loader.
        HBox root = loader.load();
        // Create a scene given the root node.
        Scene scene = new Scene(root);

        stage.setTitle("WorkWatch");
        // Attach the scene to the stage given by the framework to this start method.
        stage.setScene(scene);
        // Show the stage/window.
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}