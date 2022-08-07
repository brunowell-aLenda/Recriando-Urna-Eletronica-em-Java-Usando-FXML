
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexao {
    public static Connection abrirConexao(){
        Connection con = null;    
    try{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/URNA";
        con = DriverManager.getConnection(url, "root", "");  
        //JOptionPane.showMessageDialog(null, "Conexão feita com sucesso");
    }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na conexão");
    }
    return con;    
     
    }   
    public static void fecharConexao(Connection con){
        try {   
        con.close();
        }catch (Exception e) {
          JOptionPane.showMessageDialog(null, e.getMessage());
            
        }  
    }
   
}