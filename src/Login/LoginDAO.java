/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Cadastro_Cliente.Cliente;
import Cadastro_Cliente.Endereco;
import DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author natalia
 */
public class LoginDAO extends DAO<Cliente>{

    @Override
    public boolean inserir(Cliente element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(Cliente element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Cliente element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Cliente login(Cliente element){
        Cliente clienteLogado = new Cliente();
        Endereco enderecoClienteLogado = new Endereco();
      
        String sql = "SELECT * from cliente C "+
                "LEFT JOIN endereco E ON(E.cliente_id = C.id_cliente) where C.email_cliente='"+element.getEmail()+"' and C.senha_cliente='"+element.getSenha()+"'";
                
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println(rs);
            
            System.out.printf(sql);
            System.out.println(rs.first());

            if(rs.first()){
                System.out.println(rs.getString("nome_cliente"));
                clienteLogado.setId_Cliente(rs.getInt("id_cliente"));
                clienteLogado.setAdministrador(rs.getBoolean("administrador_cliente"));
                clienteLogado.setNome(rs.getString("nome_cliente"));
                clienteLogado.setSobrenome(rs.getString("sobrenome_cliente"));
                
                enderecoClienteLogado.setId(rs.getInt("id"));
                enderecoClienteLogado.setTipoLogradouro(rs.getString("tipo_logradouro"));
                enderecoClienteLogado.setLogradouro(rs.getString("logradouro"));
                enderecoClienteLogado.setNumero(rs.getString("numero"));
                enderecoClienteLogado.setCidade(rs.getString("cidade"));
                enderecoClienteLogado.setEstado(rs.getString("estado"));
                enderecoClienteLogado.setBairro(rs.getString("bairro"));
                enderecoClienteLogado.setCep(rs.getString("cep"));
                
                clienteLogado.setEndereco(enderecoClienteLogado);
            }
        }
        catch(SQLException e){
           System.out.printf("Erro ao logar: %s", e.getMessage());
        }
       
        return clienteLogado;
    }
    public boolean AlterarSenha(Cliente c){
         try{
             Cliente element = new Cliente();
            String comando = "UPDATE cliente set senha_cliente = ?, confirmarSenha_cliente = ? where id_cliente = ?;";//+element.getEmail();
            PreparedStatement stmt = conn.prepareStatement(
                                comando);
            stmt.setString(1, c.getSenha());
            stmt.setString(2, c.getSenha());
            stmt.setInt(3, c.getId_Cliente());
            stmt.executeUpdate();
            return true;            
        }catch(SQLException e){
            System.out.println("DAO erro ao alterar senha: "+ e.getMessage());
            
        }
         
        return false;
    }
    
}
