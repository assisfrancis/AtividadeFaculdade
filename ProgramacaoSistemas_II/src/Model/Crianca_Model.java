/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.Responsavel_view;
import java.io.Serializable;

/**
 *
 * @author kim
 */
public class Crianca_Model implements Serializable {  
   
    private Responsavel_view resposnsa;
    private String nome;
    private int idade;
    private String sexo;

    public Crianca_Model() { }
    
    
    public Responsavel_view getResposnsa() {
        return resposnsa;
    }

    public void setResposnsa(Responsavel_view resposnsa) {
        this.resposnsa = resposnsa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    } 
}
