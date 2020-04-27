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
import java.util.LinkedList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author moyad
 */
public class ClienteDAO extends DAO<Cliente>{
     @Override
    public boolean inserir(Cliente element) {

        try{
            String comandoCliente = "INSERT INTO cliente ("
                  /*1*/  + "id_cliente,"
                  /*2*/ + "nome_cliente,"
                  /*3*/  + "sobrenome_cliente,"
                  /*4*/  + "sexo_cliente,"
                  /*5*/  + "data_nasc_cliente,"
                  /*6*/  + "email_cliente,"
                  /*7*/  + "confirmarSenha_cliente,"
                  /*8*/  + "senha_cliente,"                    
                  /*9*/  + "administrador_cliente)"                 
                   + " VALUES (?,?,?,?,?,?,?,?,?);";
            
            PreparedStatement stmt = conn.prepareStatement(
                                comandoCliente,Statement.RETURN_GENERATED_KEYS);
            
            //stmt.setInt   (1,  element.getId_Cliente());
            stmt.setNull(1, 0);
            stmt.setString(2,  element.getNome());
            stmt.setString(3,  element.getSobrenome());
            stmt.setString(4,  element.getSexo());
            stmt.setDate  (5,  element.getDataNasc());            
            stmt.setString(6, element.getEmail());
            stmt.setString(7, element.getSenhaConfirmacao());
            stmt.setString(8, element.getSenha());            
            stmt.setBoolean(9, element.getAdministrador());
            
            
            int linhas = stmt.executeUpdate();
            if(linhas==1) {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setId_Cliente(rs.getInt(1));
                return true;
            }
        }catch(SQLException e){
            System.out.println("erro ao inserir: "+ e.getMessage());
        }
        return false;
    }
/*
    stmt = con.prepareStatement("UPDATE produto SET descricao = ? ,qtd = ?,preco = ? WHERE id = ?");
            stmt.setString(1, p.getDescricao());
            stmt.setInt(2, p.getQtd());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getId());

            stmt.executeUpdate();


    */
    @Override
    public boolean alterar(Cliente element) {
        try{
            String comando = "UPDATE cliente set "                    
                    + "id_cliente=?,"
                    + "nome_cliente = ?,"
                    + "sobrenome_cliente = ?"                    
                    + " WHERE id_cliente = ?";
            
            PreparedStatement stmt = conn.prepareStatement(
                                comando,Statement.RETURN_GENERATED_KEYS);
         System.out.println(element.getId_Cliente() + element.getCpf() + element.getNome() + element.getNome());   
            stmt.setInt   (1,  element.getId_Cliente());           
            stmt.setString(2,  element.getNome());
            stmt.setString(3,  element.getSobrenome());
            stmt.setInt(4, element.getId_Cliente());
            
            stmt.executeUpdate();
            return true;            
        }catch(SQLException e){
            System.out.println("DAO erro ao alterar: "+ e.getMessage());
        }
        return false;
    }

    @Override
    public boolean excluir(Cliente element) {
       try{
            String comando = "DELETE from cliente WHERE id_cliente = ?";     
               
            PreparedStatement stmt = conn.prepareStatement(
                                comando);
            stmt.setInt(1, element.getId_Cliente());
            int deleteCount = 0;
            deleteCount = stmt.executeUpdate();
            return true;
       }
       catch(SQLException e){
            System.err.println(e.getMessage());
       }
         return false;
     
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> lstClientes = new LinkedList<>();
        lstClientes = ObservableCollections.observableList(lstClientes);
        
        String sql = "SELECT * from cliente;";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId_Cliente(rs.getInt("id_cliente"));
                c.setAdministrador(rs.getBoolean("administrador_cliente"));
                c.setNome(rs.getString("nome_cliente"));
                c.setSobrenome(rs.getString("sobrenome_cliente")); 
                c.setEmail(rs.getString("email_cliente"));                
                lstClientes.add(c);               
            }
            
        }catch(SQLException e){
            System.out.println("erro ao listar " + e.getMessage());
        }
        return lstClientes;
    }

    public Cliente getByEmail(String email) {
        String sql = "select * from cliente where email_cliente=?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                Cliente c = new Cliente();
                c.setId_Cliente(rs.getInt("id_cliente"));
                c.setEmail(rs.getString("email_cliente")); 
                return c;
            }
            
        }catch(SQLException e){
            System.out.println("erro ao retornar cliente por email"+
                    e.getMessage());
        }
        return null;
    }
    
    public Cliente getById (int id){
        String sql = "select * from cliente where id_cliente=?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                Cliente c = new Cliente();
                c.setId_Cliente(rs.getInt("id_cliente"));
                c.setCpf(rs.getString("cpf_cliente"));
                c.setNome(rs.getString("nome_cliente"));
                c.setSobrenome(rs.getString("sobrenome_cliente"));  
                
            }
            
        }catch(SQLException e){
            System.out.println("erro ao retornar restaurante por id"+
                    e.getMessage());
        }
        return null;
    }
    public boolean CheckEmail(String email){
        try{
            Cliente element = new Cliente();
            String comando = "SELECT c.email_cliente, c.id_cliente from cliente c where email_cliente = ? ";
            PreparedStatement stmt = conn.prepareStatement(
                                comando);
            stmt.setString(1, email);
            //stmt.setString(1, email + "%");
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                System.out.println("ENCONTROU ALGO!");
                Cliente c = new Cliente();
                c.setEmail(rs.getString("email_cliente"));
                return true;
            }
            else{
                return false;
            }            
        }catch(SQLException e){
            System.out.println("DAO erro ao chegar E-mail: "+ e.getMessage());
        }
        return false;
    }
}
