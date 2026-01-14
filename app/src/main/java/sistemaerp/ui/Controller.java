package sistemaerp.ui;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {


   @FXML

   TextField descricao, codigo;

   private Stage stage;
   private Scene scene;
   private Parent root;

   public void takeText(ActionEvent e){
        
        System.out.println(descricao.getText());
        System.out.println(codigo.getText());

        descricao.setText("");
        codigo.setText("");
   }

   public void switchMain(ActionEvent event) throws IOException{
      root = FXMLLoader.load(getClass().getResource("/main.fxml"));
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
   }

   public void switchCadastro(ActionEvent event) throws IOException{
      root = FXMLLoader.load(getClass().getResource("/cadastrarProdutos.fxml"));
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene); 
      stage.show();
   }

}
