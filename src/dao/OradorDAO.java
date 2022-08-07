package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Candidato;

public class OradorDAO extends ExecuteSQL{

    public OradorDAO(Connection con) {
        super(con);
    }
    public List<Candidato> consultarOrador(int numero){
        ArrayList<Candidato> lista = new ArrayList<Candidato>();
        Candidato candidato = new Candidato();
        String sql = "select  nome,partido_codigo from candidato where numero = "+ numero+"";
        try {
            PreparedStatement pstm = getCon().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery(sql);
            if(rs != null){
                while(rs.next()){
                     candidato.setPartido(rs.getString(1));
                     candidato.setNome(rs.getString(2));
                      lista.add(candidato);     
                }
            }
           
            return lista;
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Deu errado");
            return null;
        }
    }
    
    
    
}
