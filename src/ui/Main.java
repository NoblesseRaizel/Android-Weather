package ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {

    Button buttonGivingWeather;
    TextField fieldGivingWeather;
    VBox layout = new VBox(20);
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("The Magical Weather in Houston Button");

        buttonGivingWeather = new Button();
        buttonGivingWeather.setText("Click for Weather in Houston!");

        fieldGivingWeather = new TextField();

        layout.getChildren().add(buttonGivingWeather);
        layout.getChildren().add(fieldGivingWeather);

        Scene scene = new Scene(layout, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == buttonGivingWeather) {

        }
    }
}
