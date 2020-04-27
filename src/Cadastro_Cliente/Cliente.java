/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadastro_Cliente;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author moyad
 */
public class Cliente {
    private String sobrenome,sexo,ruaAvenida,logradouro,numeroResidencia,
           bairro,cidade,estado,email,senha,senhaConfirmacao,cpf,cep,celular;
    private Date DataNasc;
    private Integer id_Cliente;
    private boolean administrador;
    
    private Endereco endereco;

    public Integer getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(Integer id_Cliente) {
        this.id_Cliente = id_Cliente;
    }
    
    public Date getDataNasc() {
        return DataNasc;
    }

    public void setDataNasc(Date DataNasc) {
        this.DataNasc = DataNasc;
    }
    private boolean termos;
    

    private String nome;

    public static final String PROP_NOME = "nome";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
    }
    
    public void setAdministrador(boolean administrador){
        this.administrador = administrador;
    }
    
    public boolean getAdministrador(){
        return this.administrador;
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRuaAvenida() {
        return ruaAvenida;
    }

    public void setRuaAvenida(String ruaAvenida) {
        this.ruaAvenida = ruaAvenida;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(String numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenhaConfirmacao() {
        return senhaConfirmacao;
    }

    public void setSenhaConfirmacao(String senhaConfirmacao) {
        this.senhaConfirmacao = senhaConfirmacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public boolean isTermos() {
        return termos;
    }

    public void setTermos(boolean termos) {
        this.termos = termos;
    }
    
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
    
    public Endereco getEndereco(){
        return this.endereco;
    }
}
