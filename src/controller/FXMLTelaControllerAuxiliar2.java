
package controller;


import dao.Auxiliar2DAO;
import dao.Conexao;
import dao.DiretorEsporteDAO;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;



import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;

import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Candidato;
import view.MainApp;


/**
 * FXML Controller class
 *
 * @author 3° INF
 */

public class FXMLTelaControllerAuxiliar2 implements Initializable {
    boolean cadidato = false;

    
    
    Stage stage;
    @FXML
    private TextField c1;
    @FXML
    private TextField c2;
    @FXML
    private Label lbNomeCandidato;
    @FXML
    private Label lbNomePartido;

    
   
    /**
     * Initializes the controller class.
     */
    
    
    
    private String AUDIO_URL = getClass().getResource(
   "/audio/toque.mp3").toString();
    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ex(c1);
        ex(c2);
        
        
         
   
        /*      FAZER O PASSAMENTO PARA O OUTRO CAMPO COM O EVENTO                  */
        
          c1.setOnKeyReleased(k->{
               if(c1.getText().length() == 0 ){
                   c1.requestFocus();
                   
                 
                   
                   
                    
               }else{
                   c2.requestFocus();
                   
               }
             
                   
                   
              
             /*     CHAMA OS DADOS DOS CANDITADO NO SEGUNDO CAMPO                 */
           
        });
        c2.setOnKeyReleased(k ->{
             chamaCandidato();
            
          
            
             
           
        });
        
        /*    APAGA TODOS OS DADOS DOS CAMPOS DIGITANDO A TECLA 'ESC'                 */
     
         c2.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent t) -> {
             if (t.getCode() == KeyCode.ESCAPE) {
                 limparCampos();
                 if(c2.getText().length() == 0){
                     c1.requestFocus();
                 }
                
            
            }
          });
         
         c2.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent t) -> {
             if (t.getCode() == KeyCode.ENTER) {
                 if(c2.getText().length() == 1){
                      vota();
                      JOptionPane.showMessageDialog(null, "Votado!");
                      limparCampos();
                      MainApp.carregaScene("FIM");
                       AudioClip clip = new AudioClip(AUDIO_URL);// 1
       clip.play();
       StackPane raiz = new StackPane();
       raiz.getChildren();
      
                      
                 }else{
                     JOptionPane.showMessageDialog(null, "Aperte o segundo número");
                 }
                
                
            
            }
          });
         /*    APAGA TODOS OS DADOS DOS CAMPOS DIGITANDO A TECLA 'ESC'                 */
         
         c1.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent t) -> {
             if (t.getCode() == KeyCode.ESCAPE) {
                 limparCampos();
                
            
            }
          });
        
        // TODO
    }    
    
  
    
   
    
    public void chamaCandidato(){
        
     Connection con = Conexao.abrirConexao();
        Auxiliar2DAO votoDAO = new Auxiliar2DAO(con);
        ArrayList<Candidato> lista = new ArrayList<Candidato>();        
      String n1 = c1.getText();
      String n2 = c2.getText();
      int numero =Integer.parseInt(n1 + n2);
      lista = (ArrayList<Candidato>) votoDAO.consultarAuxiliar2(numero); 
     
     
      if(lista.isEmpty()){
         lbNomeCandidato.setText("NULO");
                  lbNomePartido.setText("NULO");
      }else{
          lbNomeCandidato.setText(lista.get(0).getPartido());
          lbNomePartido.setText(lista.get(0).getNome());
      }
      
      
    }
   
    
    public void limparCampos(){
        c1.setText("");
        c2.setText("");
        lbNomeCandidato.setText("");
        lbNomePartido.setText("");
        System.out.println("chamou");
        c1.requestFocus();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void vota() {
       if(cadidato == true){
           //carrega a lista
           
       }
    }

  
        
            //DIGITA SO UM NUMERO
        public TextField ex(TextField tf){
            tf.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                if(newValue.length() > 1){
                    tf.setText(tf.getText().substring(0, 1));
                }
            });
            return tf;
        }  
        
        
  
   
    
}
