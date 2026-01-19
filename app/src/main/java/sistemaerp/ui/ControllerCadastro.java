package sistemaerp.ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import sistemaerp.inventory.InventoryManagement;

public class ControllerCadastro {
    
   private TextField descricao, codigo;

   InventoryManagement management = new InventoryManagement();

   ControllerMudarTela mudarTela = new ControllerMudarTela();

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
      mudarTela.switchMain(event);
   }

   public void switchVistas(ActionEvent event) throws IOException{
      mudarTela.switchVistas(event);
   }

}
