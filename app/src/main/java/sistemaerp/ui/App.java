package sistemaerp.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sistemaerp.inventory.InventoryManagement;
import sistemaerp.util.AppState;

public class App extends Application{

    ControllerMain main;
    
    AppState state = new AppState();

    @Override
    public void start(Stage stage) {

        InventoryManagement management = new InventoryManagement();
        management.verifyFile();
        management.showItem();

        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
            root = loader.load();
            Scene scene = new Scene(root, 600, 600, Color.SKYBLUE);


            ControllerMain controller = loader.getController();
            controller.setAppState(state);

            stage.setTitle("ERP System");

            scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
