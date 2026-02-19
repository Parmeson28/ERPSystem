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

public class ControllerSearchWindow {
    
    @FXML
    TextField itemDescription, itemSku;
    @FXML
    ListView<String> productView;
    public String currentProduct;

    List<String[]> results;


    InventoryManagement management = new InventoryManagement();

    @FXML
    public String searchNonSpecItem(ActionEvent event){

        results = management.searchForNonSpecItem(itemDescription.getText(), itemSku.getText(), "nothing for now");
        
        productView.getItems().clear();

        for(String[] item : results){
            productView.getItems().add(Arrays.toString(item));
        }

        productView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2){

                currentProduct = productView.getSelectionModel().getSelectedItem();
                System.out.println(currentProduct);
            }
        });

        return currentProduct;
    }

    @FXML
    public void itemSelection(){
        
        
    }

}
