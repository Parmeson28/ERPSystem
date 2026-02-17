package sistemaerp.ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sistemaerp.inventory.InventoryManagement;

import sistemaerp.util.ValidationUtils;

public class ControllerMovimentacao {

    @FXML
    private Label itemName;
    @FXML
    private TextField estoqueAtual, novoEstoque, descricao, codigo;
    @FXML
    Button pesquisar, alterar;

    ControllerTelas mudarTela = new ControllerTelas();
    InventoryManagement management = new InventoryManagement();
    ValidationUtils validation = new ValidationUtils();
    

    @FXML
    public void searchItem(ActionEvent event){
        String item = descricao.getText();
        String itemCodigo = codigo.getText();

        String[] product = management.searchForItem(item, itemCodigo);

        estoqueAtual.setText(product[2]);
        estoqueAtual.setEditable(false);
    }

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
