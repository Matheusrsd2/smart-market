
package FeedBack;

import Cadastro_Cliente.ClienteDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import DAO.DAO;
import java.util.List;
import java.util.ArrayList;


public class FeedbackDAO extends DAO<Feedback>{
    
    public boolean inserir(Feedback element) {
        ClienteDAO cd = new ClienteDAO();
        if (element.getCliente().getId_Cliente()==null){
            cd.inserir(element.getCliente());
            
        }
        else {
            cd.alterar(element.getCliente());
        }
        try{
            String sql = "INSERT INTO feedback "
                    + "(titulo, descricao,id_cliente,tipo_feedback) VALUES "
                    + "(?,?,?,?);";
            
            PreparedStatement stmt = conn.prepareStatement(
                                sql,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, element.getTitulo());
            stmt.setString(2, element.getDescricao());
            stmt.setInt(3, element.getCliente().getId_Cliente());
            stmt.setString(4, element.getTipoFeedback());

            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setId_feedback(rs.getInt(1));
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao inserir: "+ e.getMessage());
        }
        return false;
    }

    @Override
    public boolean alterar(Feedback element) {
        ClienteDAO cd = new ClienteDAO();
       try{
            String sql = "UPDATE feedback SET "
                    + "titulo=?, descricao=?, tipo_feedback=? where id_feedback = ?";
            
            PreparedStatement stmt = conn.prepareStatement(
                                sql);
            
            stmt.setString(1, element.getTitulo());
            stmt.setString(2, element.getDescricao());
            stmt.setString(3, element.getTipoFeedback());
            stmt.setInt(4, element.getId_feedback());
           

            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao alterar: "+ e.getMessage());
        }
        return false;
    }

    @Override
    public boolean excluir(Feedback element) {
        try{
            String sql = "DELETE FROM feedback WHERE id_fedback = ? ";

            PreparedStatement stmt = conn.prepareStatement(
                                sql,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, element.getTitulo());
            stmt.setString(2, element.getDescricao());
           

            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setId_feedback(rs.getInt(1));
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao inserir: "+ e.getMessage());
        }
        return false;
    }

    @Override
    public List<Feedback> listar() {
        List <Feedback> lstFeedback = new ArrayList<>();
        ClienteDAO cd = new ClienteDAO();
        
        String sql = "SELECT * FROM FEEDBACK; ";
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Feedback f = new Feedback ();
                f.setId_feedback(rs.getInt("id_feedback"));
                f.setTitulo (rs.getString("titulo"));
                f.setDescricao(rs.getString("descricao"));
                f.setCliente(cd.getById(rs.getInt("id_cliente")));
                lstFeedback.add(f);
            }
        } catch(SQLException e)
        {
            System.out.printf("Erro ao listar ", e.getMessage());
        }
        return lstFeedback;
    }
}
