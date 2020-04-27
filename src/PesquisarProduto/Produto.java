/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PesquisarProduto;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Laboratorio
 */
public class Produto {
    private String nome;
    private Integer id;
    private String Descricao;
    private String UltimaAtualizacao;
    private int IdProdutoLista;
    private String preco;
    private String imagem;
    
    //Getters
    
    public String getNome(){
        return nome;
    }
    
    public String getPreco(){
        return preco;
    }
    
    public ImageIcon getImagem() throws MalformedURLException{
        ImageIcon img = null;
        if(this.imagem != null){
            img = new ImageIcon(new URL(this.imagem));
            if(img != null){
                Image imageMenor = img.getImage();
                Image newimg = imageMenor.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                img = new ImageIcon(newimg);  // transform it back
            }
        }
        
        return img;
    }
    
    public String getImagemLink(){
        return this.imagem;
    }
    
    public Integer getId(){
        return id;
    }
    
    public String getDescricao(){
        return Descricao;
    }
    
    public String getUltimaAtualizacao(){
        return UltimaAtualizacao;
    }
    
    public int getIdProdutoLista(){
        return IdProdutoLista;
    }
    
    //Setters
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setPreco(String preco){
        this.preco = preco;
    }
    
    public void setImagem(String imagem){
        this.imagem = imagem;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public void setDescricao(String descricao){
        Descricao = descricao;
    }
        
    public void setUltimaAtualizacao(String UltimaAtt){
        UltimaAtualizacao = UltimaAtt;
    }
    
    public void setIdProdutoLista(int idprodutolista){
        IdProdutoLista = idprodutolista;
    }
}