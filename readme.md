# Work watch

simple app to keep track of time. 

It has 1 label and 2 buttons.
- label shows the time since the application started
- button 1 increases the time with 15 minutes
- button 2 reduces the time with 15 minutes


## requirements
The project is build with [java 11](https://www.oracle.com/technetwork/java/javase/downloads/index.html) 
and [javafx 11](https://openjfx.io/)


### intellij

You will need to configure the dependencies on javafx.

    Open module settings (or Project structure...) -> modules -> dependencies(tab)
    add dependencies to the module (JARs or directories)
    browse to the directory where you installed javafx -> lib folder and select
    - javafx.base.jar
    - javafx.controls.jar
    - javafx.fxml.jar
    - javafx.graphics.jar
    

### jar

TODO: make executable jar

    jar --create --file WorkWatch.jar --main-class oostdam.net.workwatch.Main -C out/production/java-workwatch .
    copy lib folder of javafx 11 to pkg
    java --module-path pkg --module oostdam.net.workwatch
