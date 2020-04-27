/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mercado;
import Mercado.CadastroDeMercados;
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
public class MercadoDAO extends DAO<Mercados>{
        @Override
    
    public boolean inserir(Mercados element) {

        try{
            String comando = "INSERT INTO mercado ("
                    + "id_mercado,"
                    + "nome,"
                    + "url,"
                    + " VALUES (?,?,?);";
            
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setNull(1, 0);
            stmt.setString(2,  element.getNome());
            stmt.setString(3,  element.getURL());
            stmt.setBoolean(4, false);
            
            
            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setId_Mercado(rs.getInt(1));
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao inserir: "+ e.getMessage());
        }
        return false;
    }
   
    
    @Override
    public List<Mercados> listar() {
        List<Mercados> lstMercados = new LinkedList<>();
        lstMercados = ObservableCollections.observableList(lstMercados);
        
        String sql = "SELECT * from mercado;";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Mercados m = new Mercados();
                m.setId_Mercado(rs.getInt("id_mercadoe"));
                m.setNome(rs.getString("nome_mercado"));
                m.setURL (rs.getString("URL"));
                lstMercados.add(m);               
            }
            
        }catch(SQLException e){
            System.out.println("erro ao listar");
        }
        return lstMercados;
    }
    
        @Override
    public boolean excluir(Mercados element) {
       try{
            String comando = "DELETE from mercados WHERE id_mercado = ?";         
                 
            
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
       
            int deleteCount = stmt.executeUpdate(comando);
            stmt.setInt(1, element.getId_Mercado());
            deleteCount = stmt.executeUpdate();
            return true;
       }
       catch(SQLException e){
            System.err.println(e.getMessage());
       }
         return false;
     
    }
    @Override
    public boolean alterar(Mercados element) {
        try{
            String comando = "UPDATE mercado set "                    
                    + "id_mercado=?,"
                    + "nome = ?,"
                    + "url = ?,"
                    + " WHERE id_mercado = ?";
            
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setInt   (1,  element.getId_Mercado());           
            stmt.setString(2,  element.getNome());
            stmt.setString(3,  element.getURL());
            stmt.setInt(4, element.getId_Mercado());
            
            stmt.executeUpdate();
            return true;            
        }catch(SQLException e){
            System.out.println("DAO erro ao alterar: "+ e.getMessage());
        }
        return false;
    }
    
    
}
