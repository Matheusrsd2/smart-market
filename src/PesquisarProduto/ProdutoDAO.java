package PesquisarProduto;

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
public class ProdutoDAO extends DAO<Produto>{

    @Override
    public boolean inserir(Produto element) {

        try{
            String comando = "INSERT INTO produto "
                    + "(nome, preco, imagem)"
                    + " VALUES (?,?,?);";
            
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getPreco());
            stmt.setString(3, element.getImagemLink());
            
            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setId(rs.getInt(1));
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao inserir: "+ e.getMessage());
        }
        return false;
    }

    /**
     *
     * @param element
     * @return
     */
    @Override
    public boolean alterar(Produto element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Produto element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> listar() {
        List<Produto> lstProdutos = new LinkedList<>();
        lstProdutos = ObservableCollections.observableList(lstProdutos);
        
        String sql = "SELECT * from produto;";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Produto p = new Produto();
                p.setNome(rs.getString("nome"));
                p.setId(rs.getInt("id"));
                lstProdutos.add(p);
            }
            
        }catch(SQLException e){
            System.out.println("erro ao listar");
        }
        return lstProdutos;
    }
}