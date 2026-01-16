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
import sistemaerp.inventory.InventoryManagement;

public class ControllerCadastro {
    

   @FXML

   private TextField descricao, codigo;

   private Stage stage;
   private Scene scene;
   private Parent root;

   InventoryManagement management = new InventoryManagement();

   public void takeText(ActionEvent e){
         String description = descricao.getText(); 
         String itemId = codigo.getText();

         if(!description.strip().equals("") && !itemId.strip().equals("")){
            management.registerItems(description, itemId, 0);
         }
            
         
         descricao.setText("");
         codigo.setText("");
   }

   public void switchMain(ActionEvent event) throws IOException{
      root = FXMLLoader.load(getClass().getResource("/main.fxml"));
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();


      scene = new Scene(root);


      management.showItems();

      stage.setScene(scene);
      stage.show();
   }

}
