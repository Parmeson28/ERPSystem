package sistemaerp.ui;


import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sistemaerp.inventory.InventoryManagement;
import sistemaerp.util.AppState;

public class ControllerMain {


    @FXML
    private ListView<String> productsView;
    @FXML
    private TextField descricao, codigo;
    private String currentProduct;
    
   ControllerTelas mudarTela = new ControllerTelas();
   ControllerOpenWindow openWindow = new ControllerOpenWindow();
   InventoryManagement management = new InventoryManagement();
   private AppState state;
  
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

         openWindow.openSearchWindow(state);
      
      }else{
         productsView.getItems().clear();
         System.out.println("Pesquisa deu certo");

         System.out.println(searchResult);

         productsView.getItems().addAll(searchResult);
      }

   }

   public void setAppState(AppState appState) {
      this.state = appState;

      state.selectedProductProperty().addListener(
         (obs, oldVal, newVal) -> {
               if (newVal != null) {
                  System.out.println("Updated in Main: " + newVal);

                  String item = state.getSelectedProduct();
                  if(item != null){
                     String[] produto = item.split(",");
                     produto[0] = produto[0].replace("[", "");
                     produto[1] = produto[1].replace(" ", "");
                     produto[2] = produto[2].replace("]", "");

                     descricao.setText(produto[0]);
                     codigo.setText(produto[1]);
                  }
               }
         }
      );
         
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
