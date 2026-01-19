package sistemaerp.ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import sistemaerp.inventory.InventoryManagement;

public class ControllerVistaExplodida {


    ControllerMudarTela mudarTela = new ControllerMudarTela();

    InventoryManagement management = new InventoryManagement();

    public void switchMain(ActionEvent event) throws IOException{
        mudarTela.switchMain(event);
     }


   public void switchCadastro(ActionEvent event) throws IOException{
        mudarTela.switchCadastro(event);
    }
}
