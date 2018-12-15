module oostdam.net.workwatch {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    /**
     * The main class (that extends Application) must be accessible by javafx.graphics to work.
     * As explained in {@link javafx.application.Application}
     **/
    exports oostdam.net.workwatch to javafx.graphics;

    /**
     * The package with classes that have bindings with @FXML must open up to {@link javafx.fxml}
     * So the private fields can be set using reflection. See {@link javafx.fxml.FXML}
     */
    opens oostdam.net.workwatch to javafx.fxml;
}