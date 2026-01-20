package sistemaerp.ui;


import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import sistemaerp.inventory.InventoryManagement;

public class ControllerMain {


    @FXML
    private ListView<String> productsView;
    @FXML
    private Label myLabel;
    private String currentProduct;
    

   ControllerMudarTela mudarTela = new ControllerMudarTela();
   InventoryManagement management = new InventoryManagement();

  
   @FXML
   public void initialize(){

      productsView.getItems().addAll(management.showItems());
            productsView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

                @Override
                public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2){

                    currentProduct = productsView.getSelectionModel().getSelectedItem();
                    myLabel.setText(currentProduct);
                }
            });
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
