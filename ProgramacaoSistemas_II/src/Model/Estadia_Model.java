/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author kim
 */
public class Estadia_Model {

    private double tempoNoBrinquedo;
    private double totalEstadia;
    final double valueMinuto = 1.50;

    /**
     * métodos getteres and setteres
     * @return 
     */
    public double getTempoNoBrinquedo() {
        return tempoNoBrinquedo;
    }

    public void setTempoNoBrinquedo(double tempoNoBrinquedo) {
        this.tempoNoBrinquedo = tempoNoBrinquedo;
    }

    public double getTotal() {
        return totalEstadia;
    }

    public void setTotal(double total) {
        this.totalEstadia = total;
    }
    /**
     * método que calcula o valor da estadia
     *
     * @param value1
     * @return estadia
     */
    public double calcularEstadia(double value1) {
        double estadia = 0;
        if (value1 >= 20 && value1 < 40) {
            estadia = ((value1 * valueMinuto) - ((value1 * valueMinuto) * 0.05));
        } else if (value1 >= 40 && value1 < 60) {
            estadia = ((value1 * valueMinuto) - ((value1 * valueMinuto) * 0.1));
        } else if (value1 >= 60) {
            estadia = ((value1 * valueMinuto) - ((value1 * valueMinuto) * 0.15));
        } else {
            estadia = value1 * valueMinuto;
        }
        return estadia;
    }
    /**
     * método para calcular o valor do desconto
     * @param value1
     * @return desconto
     */
    public double calcularDesconto(double value1) {
        double desconto = ((value1 * valueMinuto) - calcularEstadia(value1));
        return desconto;
    }
}