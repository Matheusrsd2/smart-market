/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import javax.swing.JButton;

/**
 *
 * @author Lab04
 */
public class Lista {
    private String nome;
    private Integer id;
    private JButton button;
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public Integer getId(){
        return this.id;
    }
    
    public void setButton(JButton button){
        this.button = button;
    }
    
    public JButton getButton(){
        return this.button;
    }
}
