package sistemaerp.ui;

import java.io.IOException;

import javafx.event.ActionEvent;

public class ControllerMovimentacao {

    ControllerMudarTela mudarTela = new ControllerMudarTela();

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
