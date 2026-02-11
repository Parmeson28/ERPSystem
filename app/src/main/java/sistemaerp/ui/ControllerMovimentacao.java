package sistemaerp.ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sistemaerp.inventory.InventoryManagement;

public class ControllerMovimentacao {

    @FXML
    private Label itemName;
    @FXML
    private TextField estoqueAtual, novoEstoque, descricao, codigo;
    @FXML
    Button pesquisar;

    ControllerMudarTela mudarTela = new ControllerMudarTela();
    InventoryManagement management = new InventoryManagement();
    


    @FXML
    public void searchItem(ActionEvent event){
        String item = descricao.getText();
        String itemCodigo = codigo.getText();

        String[] product = management.searchForItem(item, itemCodigo);

        estoqueAtual.setText(product[2]);
        estoqueAtual.setEditable(false);

        String estoqueN = novoEstoque.getText();

        
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
