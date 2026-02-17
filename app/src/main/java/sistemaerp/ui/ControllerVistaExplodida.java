package sistemaerp.ui;

import java.io.IOException;

import javafx.event.ActionEvent;

public class ControllerVistaExplodida {


    ControllerTelas mudarTela = new ControllerTelas();

    public void switchMain(ActionEvent event) throws IOException{
        mudarTela.switchMain(event);
     }


   public void switchCadastro(ActionEvent event) throws IOException{
        mudarTela.switchCadastro(event);
    }

    public void switchMovimentacao(ActionEvent event) throws IOException{
        mudarTela.switchMovimentacao(event);
     }
}
