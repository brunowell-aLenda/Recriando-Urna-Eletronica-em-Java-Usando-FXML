package view;

import controller.ControllerTelaPresidente;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




/**
 *
 * @author 3° INF
 */
public class MainApp extends Application {
    
   
    private static Scene scenePresidente;
    private static Scene sceneVicePresidente;
    private static Scene sceneSecretario;
    private static Scene sceneEsporte;
    private static Scene sceneCultural;
    private static Scene sceneTesoureiro;
    private static Scene sceneOrador;
    private static Scene sceneMarkent;
    private static Scene sceneAuxiliar1;
    private static Scene sceneAuxiliar2;
    private static Scene sceneFim;
   
  
    
    private static Stage stage;   
    ControllerTelaPresidente controller  = new ControllerTelaPresidente();
    
public static void main(String[] args) {
        launch(args);
    }
   
   
    @Override
    public void start(Stage palco) throws IOException{
         stage = palco;
        
       
        Parent presidente = FXMLLoader.load(getClass().getResource("FXMLTelaPresidente.fxml"));
        Parent vicePresidente = FXMLLoader.load(getClass().getResource("FXMLTelaDoVice.fxml"));
        Parent secretario = FXMLLoader.load(getClass().getResource("FXMLTelaDoSecretario.fxml"));
        Parent esporte = FXMLLoader.load(getClass().getResource("FXMLTelaDoDiretorEsporte.fxml"));
        Parent cultural = FXMLLoader.load(getClass().getResource("FXMLTelaDiretorSocioCultural.fxml"));
        Parent tesoureiro = FXMLLoader.load(getClass().getResource("FXMLTelaDoTesoureiro.fxml"));
        Parent orador = FXMLLoader.load(getClass().getResource("FXMLTelaDoOrador.fxml"));
        Parent markent = FXMLLoader.load(getClass().getResource("FXMLTelaDoDiretorMarkent.fxml"));
        Parent auxiliar1 = FXMLLoader.load(getClass().getResource("FXMLTelaDoAuxiliar_1.fxml"));
        Parent auxiliar2 = FXMLLoader.load(getClass().getResource("FXMLTelaDoAuxiliar_2.fxml"));
        Parent fim = FXMLLoader.load(getClass().getResource("FXMLTelaFim.fxml"));
     
     
     
       
        scenePresidente = new Scene(presidente);
        sceneVicePresidente = new Scene(vicePresidente);
        sceneSecretario = new Scene(secretario);
        sceneEsporte = new Scene(esporte);
        sceneCultural = new Scene(cultural);
        sceneTesoureiro = new Scene(tesoureiro);
        sceneOrador = new Scene(orador);
        sceneMarkent = new Scene(markent);
        sceneAuxiliar1 = new Scene(auxiliar1);
        sceneAuxiliar2 = new Scene(auxiliar2);
        sceneFim = new Scene(fim);
        
    
     
     
       stage.setTitle("Tela Do PRESIDENTE");
      //stage.initStyle(StageStyle.UNDECORATED);
       //palco.setResizable(false);
       stage.setScene(sceneFim);
       
        controller.setStage(palco);
        
       palco.show();
        

   
    }
    
    public static  void  carregaScene(String cena){
        switch(cena){
            
            
            case "PRESIDENTE" : stage.setScene(scenePresidente);break;
            case "VICEPRESIDENTE" : stage.setScene(sceneVicePresidente);
                stage.setTitle("Tela Votação para VICE-PRESIDENTE");  break;
            case "SECRETARIO" : stage.setScene(sceneSecretario); 
                stage.setTitle("Tela Votação para SECRETARIO"); break;
            case "ESPORTE" : stage.setScene(sceneEsporte); 
                stage.setTitle("Tela Votação para DIRETOR DE ESPORTE"); break; 
            case "CULTURAL" : stage.setScene(sceneCultural); 
                stage.setTitle("Tela Votação para DIRETOR SOCIO CULTURAL"); break;
            case "TESOUREIRO" : stage.setScene(sceneTesoureiro); 
                stage.setTitle("Tela Votação para TESOUREIRO"); break;
            case "ORADOR" : stage.setScene(sceneOrador); 
                stage.setTitle("Tela Votação para ORADOR"); break;
            case "MARKENT" : stage.setScene(sceneMarkent); 
                stage.setTitle("Tela Votação para DIRETOR DE MARKENT"); break;
            case "AUXILIAR1" : stage.setScene(sceneAuxiliar1); 
                stage.setTitle("Tela Votação para AUXILIAR 1"); break;
            case "AUXILIAR2" : stage.setScene(sceneAuxiliar2); 
                stage.setTitle("Tela Votação para AUXILIAR 2"); break;
            case "FIM" : stage.setScene(sceneFim); 
                stage.setTitle("Tela FIM"); break;
            
        
          
        }       
    }
}