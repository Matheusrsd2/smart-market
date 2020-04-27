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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natalia
 */
public class ListaProdutoDAO extends DAO<ListaProduto>{

    @Override
    public boolean inserir(ListaProduto element) {
        try {
            String comando = "INSERT INTO lista_produto "+
                "(lista_id, tipo_produto_id, produto_id) "+
                "VALUES (?,?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(comando, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, element.getLista().getId());
            stmt.setInt(2, element.getTipoProduto().getId());
            stmt.setInt(3, element.getProduto().getId());
            
            int linhas = stmt.executeUpdate();
            
            if(linhas == 1){
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setId(rs.getInt(1));
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ListaProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean alterar(ListaProduto element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(ListaProduto element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ListaProduto> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
