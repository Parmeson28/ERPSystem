package sistemaerp.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sistemaerp.inventory.InventoryManagement;

public class ControllerSearchWindow {
    
    @FXML
    TextField itemDescription, itemSku;


    InventoryManagement management = new InventoryManagement();

    @FXML
    public void searchNonSpecItem(ActionEvent event){

        management.searchForNonSpecItem(itemDescription.getText(), itemSku.getText(), "nothing for now");

    }

}
