/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produto;

/**
 *
 * @author natalia
 */
public class TipoProduto {
    private String descricao;
    private Integer id;
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public Integer getId(){
        return this.id;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
}
