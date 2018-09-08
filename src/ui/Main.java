package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class Main extends Application {

    Button buttonGivingWeather;
    TextField fieldGivingWeather;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("The Magical Weather in Houston Button");

        buttonGivingWeather = new Button();
        buttonGivingWeather.setText("Click for Weather in Houston!");

        fieldGivingWeather = new TextField();

        buttonGivingWeather.setOnAction(e -> getWeather(fieldGivingWeather));

        VBox layout = new VBox(20);
        layout.getChildren().add(buttonGivingWeather);
        layout.getChildren().add(fieldGivingWeather);

        Scene scene = new Scene(layout, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void getWeather(TextField fieldGivingWeather) {
        String API_KEY = "f3bdf5c92d8699bf8ccc49766c219752";
        String LOCATION = "Houston";
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY;

        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            String weather = result.toString();
            int indexstart = weather.indexOf("temp") + 6;
            int indexend = weather.indexOf(',', indexstart);
            String returnString = weather.substring(indexstart, indexend);
            rd.close();
            fieldGivingWeather.setText(returnString);
        } catch (IOException e) {
            System.out.println("failed!");
        }

    }
}
