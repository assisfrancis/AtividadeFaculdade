/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 * classe Controller
 *
 * @author kim
 */
import View.*;
import Model.*;

public class Responsavel_Controller {

    private Responsavel_view respWiew;
    private Responsavel_Model respModel;
    private Crianca_Model crianca;

    /**
     * Método construtor
     *
     * @param model
     * @param view
     */
    public Responsavel_Controller(Responsavel_Model model, Responsavel_view view) {
        this.respModel = model;
        this.respWiew = view;
    }

    /**
     * métodos para recuperar e setar os dados
     *
     * @param nome
     */
    public void setNomeResponsavel(String nome) {
        respModel.setNome(nome);
    }

    public void setRespCpfResponsavel(String cpf) {
        respModel.setCpf(cpf);
    }

    public void setRespResEnderecoponsavel(String endereco) {
        respModel.setEndereco(endereco);
    }

    public void setResptelefoneResponsavel(String telefone) {
        respModel.setTelefone(telefone);
    }

    public void setRespEmailResponsavel(String email) {
        respModel.setEmail(email);
    }

    public void setRespIdadeResponsavel(int idade) {
        respModel.setIdade(idade);
    }

    public String getResponsavelNome() {
        return respModel.getNome();
    }

    public String getResponsavelCpf() {
        return respModel.getCpf();
    }

    public String getResponsavelEndereo() {
        return respModel.getEndereco();
    }

    public String getResponsavelTelefone() {
        return respModel.getTelefone();
    }

    public String getResponsavelEmail() {
        return respModel.getEmail();
    }

    public String getResponsavelIdade() {
        return (String.valueOf(respModel.getIdade()));
    }

    /**
     * Método para atualizar a view
     */
    public void atualizaView() {
        respWiew.printDadosResponsavel(respModel.getNome(), respModel.getCpf(), respModel.getEndereco(),
                respModel.getTelefone(), respModel.getEmail(), respModel.getIdade());
    }
}
