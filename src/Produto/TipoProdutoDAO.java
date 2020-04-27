/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produto;

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
 * @author natalia
 */
public class TipoProdutoDAO extends DAO<TipoProduto>{

    @Override
    public boolean inserir(TipoProduto element) {
        try{ 
            String comando = "INSERT INTO tipo_produto" +
                    "(descricao) VALUES" +
                    "(?);";
                        
            PreparedStatement stmt = conn.prepareStatement(comando, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, element.getDescricao());
            
            int linhas = stmt.executeUpdate();
            
            if(linhas == 1){
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setId(rs.getInt(1));
                return true;
            }
            else{
                System.out.printf("Deu erro");
            }
            
        }catch(SQLException e){
        
        }
        
        return false;
    }

    @Override
    public boolean alterar(TipoProduto element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(TipoProduto element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoProduto> listar() {
        List<TipoProduto> lstTipoProduto = new LinkedList<>();
        lstTipoProduto = ObservableCollections.observableList(lstTipoProduto);
        
        String comando = "SELECT * FROM tipo_produto";
        
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(comando);
            
            while(rs.next()){
                TipoProduto tp = new TipoProduto();
                tp.setId(rs.getInt("id"));
                tp.setDescricao(rs.getString("descricao"));
                lstTipoProduto.add(tp);
            }
        }
        catch(SQLException e){
            System.out.println("Erro ao lista tipos de produto");
        }
        
        return lstTipoProduto;
    }
    
}
