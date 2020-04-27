/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeedBack;
import Cadastro_Cliente.Cliente;
/**
 *
 * @author Laboratorio
 */
public class Feedback {
    private String titulo,descricao;
    
    private Integer id_feedback;

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the id_feedback
     */
    public Integer getId_feedback() {
        return id_feedback;
    }

    /**
     * @param id_feedback the id_feedback to set
     */
    public void setId_feedback(Integer id_feedback) {
        this.id_feedback = id_feedback;
    }

    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    private String TipoFeedback;

    public String getTipoFeedback() {
        return TipoFeedback;
    }

    public void setTipoFeedback(String TipoFeedback) {
        this.TipoFeedback = TipoFeedback;
    }


   

    
    
}
