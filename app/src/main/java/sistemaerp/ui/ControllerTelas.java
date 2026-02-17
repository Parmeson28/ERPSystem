package sistemaerp.ui;

import java.io.IOException;

import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerTelas {

    //This is a speciffic class for switching window

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchCadastro(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/cadastrarProdutos.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();


        scene = new Scene(root);


        stage.setScene(scene); 
        stage.show();
    }

    public void switchVistas(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/vistasExplodidas.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();


        scene = new Scene(root);


        stage.setScene(scene); 
        stage.show();
    }

    public void switchMain(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

  
        scene = new Scene(root);
  
        stage.setScene(scene);
        stage.show();
     }

     public void switchMovimentacao(ActionEvent event) throws IOException{

        root = FXMLLoader.load(getClass().getResource("/stockMovement.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  
  
        scene = new Scene(root);

  
        stage.setScene(scene);
        stage.show();
     }

     public void openSearchWindow(ActionEvent event){

        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/searchWindow.fxml"));

            scene = new Scene(fxmlLoader.load(), 400, 400);

            Stage stage = new Stage();
            stage.setTitle("Busca de itens");

            stage.setScene(scene);
            stage.show();

        }catch(IOException e){
            System.out.println("Could not create new window!");
        }
        
     }

}
