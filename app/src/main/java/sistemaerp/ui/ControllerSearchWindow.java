package sistemaerp.ui;

import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sistemaerp.inventory.InventoryManagement;

public class ControllerSearchWindow {
    
    @FXML
    TextField itemDescription, itemSku;
    @FXML
    ListView<String> productsView;


    InventoryManagement management = new InventoryManagement();

    @FXML
    public void searchNonSpecItem(ActionEvent event){

        productsView.getItems().clear();

        List<String[]> results = management.searchForNonSpecItem(itemDescription.getText(), itemSku.getText(), "nothing for now");

        for(String[] item : results){
            productsView.getItems().addAll(Arrays.toString(item));
        }

    }

}
