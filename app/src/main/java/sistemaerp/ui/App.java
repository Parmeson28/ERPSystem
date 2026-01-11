package sistemaerp.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application{
    @Override
    public void start(Stage stage) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/main.fxml"));

            Scene scene = new Scene(root, 600, 600, Color.SKYBLUE);

            stage.setTitle("ERP System");



            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
