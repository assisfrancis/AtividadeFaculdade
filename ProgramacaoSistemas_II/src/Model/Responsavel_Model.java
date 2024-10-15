/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kim
 */
public class Responsavel_Model implements Serializable {
    /**
     * @return the 
     */
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;
    private int idade;

     private ArrayList<Responsavel_Model> responsavel;
    
    public Responsavel_Model(String nome, String cpf, String telefone, String email, String endereco, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.idade = idade;
    }
    public Responsavel_Model(){
      responsavel = new ArrayList<>();
    }
      
    public String getCpf() {
        return cpf;
    }
    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    /**
     * @param endereco the endereco to set
     */
 
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }                                                                                               

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    @Override
    public String toString() {
        return "Responsavel_Model{" + "nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", email=" + email + ","
                + " endereco=" + endereco + ", idade=" + idade + '}';
    }
    public void adicionarResponsavel(Responsavel_Model responsa){
        responsavel.add(responsa);
    }
}

