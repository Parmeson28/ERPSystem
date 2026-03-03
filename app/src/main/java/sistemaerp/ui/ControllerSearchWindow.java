package sistemaerp.ui;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sistemaerp.inventory.InventoryManagement;
import sistemaerp.model.Product;
import sistemaerp.util.AppState;

public class ControllerSearchWindow {
    
    @FXML
    TextField itemDescription, itemSku;
    @FXML
    ListView<Product> productView;
    public Product currentProduct;

    List<Product> results;


    InventoryManagement management = new InventoryManagement();
    ControllerOpenWindow openWindow = new ControllerOpenWindow();
    private AppState state;

    @FXML
    public void initialize(){

        productView.getSelectionModel().selectedItemProperty().addListener(
         (obs, oldValue, newValue) -> {

                currentProduct = newValue;

                if (currentProduct != null) {
                    System.out.println(currentProduct.getDescription());
                    state.setSelectedProduct(currentProduct);
                }
            }
        );

    }

    @FXML
    public void searchNonSpecItem(ActionEvent event){

        String description = itemDescription.getText();
        String sku = itemSku.getText();

        if(description != null && sku != null){

            results = management.searchForNonSpecItem(description, sku, "nothing for now");
            System.out.println(results);

        }
        
        productView.getItems().clear();

        productView.getItems().addAll(results);
        
    }

    public void setAppState(AppState state) {
        this.state = state;
    }
}
