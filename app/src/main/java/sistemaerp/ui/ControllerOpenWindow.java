package sistemaerp.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sistemaerp.util.AppState;

public class ControllerOpenWindow{
 
    Scene scene;
    private Stage stage;

    public Stage openSearchWindow(AppState state){

        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/searchWindow.fxml"));

            scene = new Scene(fxmlLoader.load(), 400, 400);

            ControllerSearchWindow controller = fxmlLoader.getController();
            controller.setAppState(state);

            stage = new Stage();
            stage.setTitle("Busca de itens");


            stage.setScene(scene);
            
            stage.show();

            return stage;

        }catch(IOException e){
            System.out.println(e);
            System.out.println("Could not create new window!");
        }

        
        return null;
        
    }


    public void closeWindow(Stage stage){

        stage.close();

    }
}
