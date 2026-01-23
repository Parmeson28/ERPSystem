package sistemaerp.ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sistemaerp.inventory.InventoryManagement;

public class ControllerCadastro {

   @FXML
   private TextField descricao, codigo, equipamento;

   InventoryManagement management = new InventoryManagement();

   ControllerMudarTela mudarTela = new ControllerMudarTela();

   public void takeText(ActionEvent e){
         String description = descricao.getText(); 
         String itemId = codigo.getText();
         String machinery = equipamento.getText();


         management.registerItems(description, itemId, 0, machinery);

         descricao.setText("");
         codigo.setText("");
         equipamento.setText("");
   }

   public void switchMain(ActionEvent event) throws IOException{
      mudarTela.switchMain(event);
   }

   public void switchVistas(ActionEvent event) throws IOException{
      mudarTela.switchVistas(event);
   }

   public void switchMovimentacao(ActionEvent event) throws IOException{
      mudarTela.switchMovimentacao(event);
   }

}
