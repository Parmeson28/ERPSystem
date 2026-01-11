package sistemaerp;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {


   @FXML

   TextField descricao, codigo;

   public void takeText(ActionEvent e){
        
        System.out.println(descricao.getText());
        System.out.println(codigo.getText());

        descricao.setText("");
        codigo.setText("");
   }

}
