/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public abstract class DAO<E> {
    protected Connection conn;

    public abstract boolean inserir(E element);
    public abstract boolean alterar(E element);
    public abstract boolean excluir(E element);
    public abstract List<E> listar();

    public DAO(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //String url = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10309685?serverTimezone=UTC";
            //String user = "sql10309685";
            //String passwd = "7wpvsdu6vs";
            
            //Natália
            /*String url = "jdbc:mysql://localhost:3306/smart_market?serverTimezone=UTC";
            String user = "root";
            String passwd = "root";*/
            
            //Daniel
            String url = "jdbc:mysql://localhost:3306/smart_market?serverTimezone=UTC";
            String user = "root";
            String passwd = "";
            
            conn = DriverManager.getConnection(url, user, passwd);
        }catch(ClassNotFoundException e){
            System.out.printf("Erro no driver: %s\n",
                    e.getMessage());
        }catch(SQLException e){
            System.out.printf("Erro no banco: %s\n",
                    e.getMessage());
        }
    }
}
    

