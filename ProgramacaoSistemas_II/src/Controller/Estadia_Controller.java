/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Crianca_Model;
import Model.Estadia_Model;
import Model.Responsavel_Model;
import View.Estadia_View;

/**
 * classe estadia controller
 *
 * @author kim
 */
public class Estadia_Controller {

    private Estadia_View EstWiew;
    private Estadia_Model EstModel;
    private Responsavel_Model respModel;
    private Crianca_Model crianca;

    /**
     * Método construtor
     *
     * @param model
     * @param view
     */
    public Estadia_Controller(Estadia_Model model, Estadia_View view) {
        this.EstModel = model;
        this.EstWiew = view;
    }

    public void atualizaEstadiaView() {
        EstWiew.printDadosCalculos(EstModel.getTotal());
        EstWiew.printDadosCalculos(EstModel.getTempoNoBrinquedo());
    }

    /**
     * Método para autualizar a view
     */
    public void atualizaWiew() {
        EstWiew.receberResponsavel(respModel);
        EstWiew.recebeCrianca(crianca);
    }
}
