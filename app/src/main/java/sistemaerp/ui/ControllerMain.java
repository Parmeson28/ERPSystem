package sistemaerp.ui;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sistemaerp.inventory.InventoryManagement;
import sistemaerp.model.Product;
import sistemaerp.util.AppState;

public class ControllerMain {


    @FXML
    private ListView<Product> productsView;
    @FXML
    private TextField descricao, codigo;
    private Product currentProduct;
    
   ControllerTelas mudarTela = new ControllerTelas();
   ControllerOpenWindow openWindow = new ControllerOpenWindow();
   InventoryManagement management = new InventoryManagement();
   private AppState state;
  
   @FXML
   public void initialize(){

      productsView.getItems().addAll(management.showItem());

      productsView.getSelectionModel().selectedItemProperty().addListener(
         (obs, oldValue, newValue) -> {

            currentProduct = newValue;

            if (currentProduct != null) {
               System.out.println(currentProduct.getDescription());
            }
         }
      );

   }

   @FXML
   public void searchForItem(ActionEvent event){

      Product searchResult = management.searchForItem(descricao.getText(), codigo.getText());

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

                  Product item = state.getSelectedProduct();

                  descricao.setText(item.getDescription());
                  codigo.setText(item.getSku());
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
