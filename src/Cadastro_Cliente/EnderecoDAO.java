/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadastro_Cliente;

import DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author natalia
 */
public class EnderecoDAO extends DAO<Endereco>{

    @Override
    public boolean inserir(Endereco element) {
        try{
            String comandoCliente = "INSERT INTO endereco ("
                    + "cliente_id,"
                    + "tipo_logradouro,"
                    + "logradouro,"
                    + "numero,"
                    + "bairro,"
                    + "cidade,"
                    + "estado,"
                    + "cep)"                 
                    + " VALUES (?,?,?,?,?,?,?,?);";
            
            PreparedStatement stmt = conn.prepareStatement(
                                comandoCliente,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1,  element.getCliente().getId_Cliente());
            stmt.setString(2,  element.getTipoLogradouro());
            stmt.setString(3,  element.getLogradouro());
            stmt.setString(4,  element.getNumero());
            stmt.setString(5,  element.getBairro());            
            stmt.setString(6, element.getCidade());
            stmt.setString(7, element.getEstado());
            stmt.setString(8, element.getCep());            
            
            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setId(rs.getInt(1));
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao inserir endereco: "+ e.getMessage());
        }
        return false;
    }

    @Override
    public boolean alterar(Endereco element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Endereco element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Endereco> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
