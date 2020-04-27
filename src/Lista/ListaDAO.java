/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Laboratorio
 */
public class ListaDAO extends DAO<Lista>{
    
    @Override
    public boolean inserir(Lista element){
           try{
               String comando = "INSERT INTO lista" +
                       "(nome) VALUES " +
                       "(?);";
               
               PreparedStatement stmt = conn.prepareStatement(comando, Statement.RETURN_GENERATED_KEYS);
               
               stmt.setString(1, element.getNome());
               
               int linhas = stmt.executeUpdate();
               
               if(linhas == 1){
                   ResultSet rs = stmt.getGeneratedKeys();
                   rs.next();
                   element.setId(rs.getInt(1));
                   return true;
               }
               else{
                   System.out.printf("Deu erroooo");
               }
           }
           catch(SQLException e){
           
           }
        return false;
    }
    
    @Override
    public List<Lista> listar() {
        List<Lista> lstLista = new LinkedList<>();
        lstLista = ObservableCollections.observableList(lstLista);
        
        String sql = "SELECT * from lista;";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Lista l = new Lista();
                l.setId(rs.getInt("id"));
                l.setNome(rs.getString("nome"));
                lstLista.add(l);
            }
            
        }catch(SQLException e){
            System.out.println("erro ao listar");
        }
        return lstLista;
    }

    @Override
    public boolean alterar(Lista element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Lista element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
