package controller;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import view.MainApp;




public class TelaFim implements Initializable {
 

    Stage stage;
    
    @FXML
    private VBox cena;

    @FXML
    private Label fim;
    @FXML
    private TextField pert;
   
    
   
    /**
     * Initializes the controller class.
     */
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
pert.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent t) -> {
        ;
    if (t.getCode() == KeyCode.ENTER) {
       MainApp.carregaScene("PRESIDENTE");
      
    }
    
       
});


     

    
    }
}