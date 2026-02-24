package sistemaerp.ui;

import java.util.Arrays;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sistemaerp.inventory.InventoryManagement;
import sistemaerp.util.AppState;

public class ControllerSearchWindow {
    
    @FXML
    TextField itemDescription, itemSku;
    @FXML
    ListView<String> productView;
    public String currentProduct;

    List<String[]> results;


    InventoryManagement management = new InventoryManagement();
    ControllerOpenWindow openWindow = new ControllerOpenWindow();
    private AppState state;

    @FXML
    public void initialize(){

        productView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){

                
            
                state.setSelectedProduct(newValue);

                if(currentProduct != null){

                    System.out.println("Precisa fechar essa janela");
                    
                }
                
            }
        });

    }

    @FXML
    public void searchNonSpecItem(ActionEvent event){

        String description = itemDescription.getText();
        String sku = itemSku.getText();

        if(description != null && sku != null){
            results = management.searchForNonSpecItem(description, sku, "nothing for now");
        }

        productView.getItems().clear();

        for(String[] item : results){

            productView.getItems().add(Arrays.toString(item));
        
        }
        
    }

    public void setAppState(AppState state) {
        this.state = state;
    }
}
