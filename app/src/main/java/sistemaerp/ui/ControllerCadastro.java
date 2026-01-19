package sistemaerp.ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sistemaerp.inventory.InventoryManagement;

public class ControllerCadastro {

   @FXML
    
   private TextField descricao, codigo;

   InventoryManagement management = new InventoryManagement();

   ControllerMudarTela mudarTela = new ControllerMudarTela();

   public void takeText(ActionEvent e){
         String description = descricao.getText(); 
         String itemId = codigo.getText();

         management.registerItems(description, itemId, 0);

         descricao.setText("");
         codigo.setText("");
   }

   public void switchMain(ActionEvent event) throws IOException{
      mudarTela.switchMain(event);
   }

   public void switchVistas(ActionEvent event) throws IOException{
      mudarTela.switchVistas(event);
   }

}
