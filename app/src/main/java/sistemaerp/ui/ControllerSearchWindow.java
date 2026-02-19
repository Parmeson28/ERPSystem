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
    ListView<String> productView;

    List<String[]> results;


    InventoryManagement management = new InventoryManagement();

    @FXML
    public void searchNonSpecItem(ActionEvent event){

        results = management.searchForNonSpecItem(itemDescription.getText(), itemSku.getText(), "nothing for now");
        
        productView.getItems().clear();

        for(String[] item : results){
            productView.getItems().add(Arrays.toString(item));
        }
        
        System.out.println(results.size());

    }

}
