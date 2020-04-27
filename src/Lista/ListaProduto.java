/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import PesquisarProduto.Produto;
import Produto.TipoProduto;
import java.net.MalformedURLException;
import javax.swing.ImageIcon;

/**
 *
 * @author natalia
 */
public class ListaProduto {
    private Integer id;
    private Lista lista;
    private TipoProduto tipoProduto;
    private Produto produto;
    //Função para retornar a descrição do tipo do produto
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public Integer getId(){
        return this.id;
    }
    
    public void setLista(Lista lista){
        this.lista = lista;
    }
    
    public Lista getLista(){
        return this.lista;
    }
    
    public void setTipoProduto(TipoProduto tipoProduto){
        this.tipoProduto = tipoProduto;
    }
    
    public TipoProduto getTipoProduto(){
        return this.tipoProduto;
    }
    
    public void setProduto(Produto produto){
        this.produto = produto;
    }
    
    public Produto getProduto(){
        return this.produto;
    }
}
