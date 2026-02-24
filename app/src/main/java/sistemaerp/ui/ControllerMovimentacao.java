package sistemaerp.ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sistemaerp.inventory.InventoryManagement;
import sistemaerp.util.AppState;
import sistemaerp.util.ValidationUtils;

public class ControllerMovimentacao {

    @FXML
    private Label itemName;
    @FXML
    private TextField estoqueAtual, novoEstoque, descricao, codigo;
    @FXML
    Button pesquisar, alterar;

    String[] produto;

    ControllerTelas mudarTela = new ControllerTelas();
    ControllerOpenWindow openWindow = new ControllerOpenWindow();
    InventoryManagement management = new InventoryManagement();
    ValidationUtils validation = new ValidationUtils();
    AppState state;

    //Need to include the search window for an improved items search
    @FXML
    public void searchItem(){
        String item = descricao.getText();
        String itemCodigo = codigo.getText();

        String product = management.searchForItem(item, itemCodigo);

        if(product == null){
       
            openWindow.openSearchWindow(state);
            
        }else{

            estoqueAtual.setText(produto[2]);
            estoqueAtual.setEditable(false);
       
        }
    }

    //PUT THE LOGIC INTO InventoryManagement
    @FXML
    public void alterQuantity(ActionEvent event){

        String estoqueN = novoEstoque.getText();

        if(validation.validateNum(estoqueN)){

            int n = Integer.parseInt(estoqueN);

            if(n < 0){
                System.out.println("Valor não pode ser negativo");
            }else{
                String item = descricao.getText();
                String itemCodigo = codigo.getText();

                management.changeItemQuantity(item, itemCodigo, n);

                estoqueAtual.setText(estoqueN);
                
                novoEstoque.setText("");
            }

        }else{
            System.out.println("Valor nulo para quantidade!");
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
                     produto = item.split(",");
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


    public void switchMain(ActionEvent event) throws IOException{
        mudarTela.switchMain(event);
    }
    
    public void switchCadastro(ActionEvent event) throws IOException{
        mudarTela.switchCadastro(event);
    }

    public void switchVistas(ActionEvent event) throws IOException{
        mudarTela.switchVistas(event);
    }

}
