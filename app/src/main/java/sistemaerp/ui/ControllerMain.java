package sistemaerp.ui;


import java.io.IOException;
import java.util.Arrays;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sistemaerp.inventory.InventoryManagement;

public class ControllerMain {


    @FXML
    private ListView<String> productsView;
    @FXML
    private TextField descricao, codigo;
    private String currentProduct;
    

   ControllerTelas mudarTela = new ControllerTelas();
   InventoryManagement management = new InventoryManagement();

  
   @FXML
   public void initialize(){

      productsView.getItems().addAll(management.showItem());

      productsView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

         @Override
         public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2){

            currentProduct = productsView.getSelectionModel().getSelectedItem();
            System.out.println(currentProduct);

         }
      });

   }

   @FXML
   public void searchForItem(ActionEvent event){

      String searchResult = management.searchForItem(descricao.getText(), codigo.getText());

      if(searchResult == null){

         mudarTela.openSearchWindow(event);
      
      }else{
         productsView.getItems().clear();
         System.out.println("Pesquisa deu certo");

         System.out.println(searchResult);

         productsView.getItems().addAll(searchResult);
      }

   }


   public void switchCadastro(ActionEvent event) throws IOException{
      mudarTela.switchCadastro(event);
   }

   public void switchVistas(ActionEvent event) throws IOException{
      mudarTela.switchVistas(event);
   }

   public void switchMovimentacao(ActionEvent event) throws IOException{
      mudarTela.switchMovimentacao(event);
   }

}
