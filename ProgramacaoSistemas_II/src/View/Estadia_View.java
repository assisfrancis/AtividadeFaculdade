/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;                                  // pacote 

import MenuPrin.ValorExtenso;
import Model.Crianca_Model;
import Model.Estadia_Model;
import Model.Responsavel_Model;
import java.awt.Color;
import java.awt.Font;                          // Área da importação das bibliotecas
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 *
 * @author kim
 */
public class Estadia_View extends JFrame implements ActionListener {                //classe Eatadia estendendo do JFrmame e implementando a interface ActionListener    

    JPanel panelSuperior, panelInferior;
    JLabel lb_pesquisar, lb_nomeResponsavel, lb_nome, lb_tempo, lb_vlr, lb_valorTotal, lb_logo, lb_Unicesumar;  // Área de Criação dos Conteners 
    static JTextField tf_pesquisar, tf_nomeResp, tf_nome, tf_tempo;
    JTable table;
    JButton bt_gravarcsv, bt_calcular;
    JComboBox<JTextField> cb_combo;
    JTextArea areaResumo;
    ImageIcon img_logo, img_Unicesumar, img_LerCsv;

    Crianca_Model crianca = new Crianca_Model();
    static Responsavel_Model model = new Responsavel_Model();
    static Estadia_Model estadiaModel = new Estadia_Model();

    static DecimalFormat objNumberFormat = new DecimalFormat();

    /**
     * Método Construtor
     */
    public Estadia_View() {

        setTitle("Cadastro de Estadia");        //Titulo do formulário
        setSize(380, 530);                           //Tamanho do formulário em pixels
        setLocation(150, 180);                       //Posiciona o formulário na tela 
        setResizable(false);                          //Se o formulário pode ser redimencionado ou não 
        getContentPane().setLayout(null);            //Set o Layout como nulo
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Método usado para nnão fechar toda a aplicação apenas esse formulário

        img_logo = new ImageIcon("./src/img/Icon.png");
        img_Unicesumar = new ImageIcon("./src/img/nome.png");
        img_LerCsv = new ImageIcon("./src/img/ler.gif");

        lb_pesquisar = new JLabel(" Pesquisar: ");     //Inicialização dos componentes da panel superior
        lb_pesquisar.setBounds(5, 2, 70, 25);
        lb_pesquisar.setForeground(Color.WHITE);

        tf_pesquisar = new JTextField(20);
        tf_pesquisar.setBounds(75, 5, 140, 20);
        cb_combo = new JComboBox<>();
        cb_combo.setBounds(220, 5, 125, 20);

        lb_logo = new JLabel(img_logo);
        getContentPane().add(lb_logo);
        lb_logo.setFont(new Font("Arial", Font.BOLD, 16));
        lb_logo.setForeground(Color.BLACK);
        lb_logo.setBounds(0, 175, 100, 35);

        lb_Unicesumar = new JLabel(img_Unicesumar);
        lb_Unicesumar.setFont(new Font("Arial", Font.BOLD, 16));
        lb_Unicesumar.setForeground(Color.WHITE);
        lb_Unicesumar.setBounds(8, 2, 120, 25);

        panelSuperior = new JPanel();                 //inicialização da panel superior
        getContentPane().add(panelSuperior);          //adiciona a panel ao contener
        panelSuperior.setBounds(10, 10, 350, 30);     //define o posicionamento da panel na tela
        panelSuperior.setBackground(Color.BLACK);      //atribui a cor azeul ao background da panel
        panelSuperior.add(lb_pesquisar);              //adidiona os componentes na panel superior
        panelSuperior.add(tf_pesquisar);
        panelSuperior.add(cb_combo);
        panelSuperior.setLayout(null);

        panelInferior = new JPanel();                   //inicializa a panel inferior
        getContentPane().add(panelInferior);            //adiciona a panel inferior ao content
        panelInferior.add(lb_Unicesumar);               //Adiciona uma imagem na panel
        panelInferior.setBounds(10, 450, 350, 30);
        panelInferior.setBackground(Color.BLACK);
        panelInferior.setLayout(null);

        lb_nomeResponsavel = new JLabel("Nome do Responsável:");
        getContentPane().add(lb_nomeResponsavel);
        lb_nomeResponsavel.setBounds(20, 50, 150, 20);

        tf_nomeResp = new JTextField();
        getContentPane().add(tf_nomeResp);
        tf_nomeResp.setBounds(20, 70, 320, 20);
        tf_nomeResp.setBackground(Color.lightGray);

        lb_nome = new JLabel("Nome da Criança:");
        getContentPane().add(lb_nome);
        lb_nome.setBounds(20, 90, 150, 20);

        tf_nome = new JTextField();
        getContentPane().add(tf_nome);
        tf_nome.setBounds(20, 110, 320, 20);
        tf_nome.setBackground(Color.lightGray);

        lb_tempo = new JLabel("Tempo Total Utilizado:");
        getContentPane().add(lb_tempo);
        lb_tempo.setBounds(20, 130, 150, 20);

        tf_tempo = new JTextField();
        getContentPane().add(tf_tempo);
        tf_tempo.setBounds(20, 150, 140, 20);

        lb_vlr = new JLabel("Valor Total:");         // Indica que o valor total será mostrado 
        getContentPane().add(lb_vlr);
        lb_vlr.setBounds(170, 150, 150, 20);

        lb_valorTotal = new JLabel();            //Recebe o resultado do calculo da estadia
        getContentPane().add(lb_valorTotal);
        lb_valorTotal.setBounds(250, 150, 100, 20);

        bt_calcular = new JButton("Calcular");  //botão calcuar estadia
        getContentPane().add(bt_calcular);
        bt_calcular.setBounds(190, 180, 160, 30);
        bt_calcular.setToolTipText("Calcular");
        bt_calcular.setFont(new Font("Arial", Font.BOLD, 14));

        bt_gravarcsv = new JButton(img_LerCsv);        //botão para gravar no arquivo csv
        getContentPane().add(bt_gravarcsv);
        bt_gravarcsv.setBounds(105, 180, 80, 30);
        bt_gravarcsv.setToolTipText("Gravar em Arquivo CSV");
        bt_gravarcsv.setFont(new Font("Arial", Font.BOLD, 14));

        areaResumo = new JTextArea();                  //mostra o resultado da aplicação
        getContentPane().add(areaResumo);
        areaResumo.setBounds(20, 220, 330, 220);
        bt_calcular.addActionListener(this);
        bt_gravarcsv.addActionListener(this);

        setIcon();

    }

    /**
     * método principal Main
     *
     * @param args
     */
    public static void main(String[] args) {
        JFrame estadia = new Estadia_View();
        estadia.setVisible(true);

    }

    /*
    public static void main2(){
        Responsavel_Model model = ProperResponsavel_MVC();               
        Responsavel_view view = new Responsavel_view();
        Responsavel_Controller controller = new Responsavel_Controller(model, view);
        
        controller.atualizaView();
        
        Crianca_Model crianca = properCriMVC();
        Crianca_view vw = new Crianca_view();
        Crianca_Controller control = new Crianca_Controller(crianca, vw);
        
        control.atualizaView();    
    } 
     */
    public void printDadosCalculos(double value) {
    }

    /**
     * método responsável por disparar as ações nos componentes
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt_gravarcsv) {
           // areaResumo.append(" ");
             preencherTextArea();
        }
        if (e.getSource() == bt_calcular) {
            transferirDadosCalculos();
            RelatorioDeEstadia(crianca);

        }
    }

    /**
     * método que faz a transição entre os métodos getteres and setteres e
     * passado para o Responsavelmodel
     *
     * @return
     */
    public static Responsavel_Model ProperResponsavel_MVC() {
        Responsavel_Model resp = new Responsavel_Model();
        resp.setNome(resp.getNome());

        return resp;
    }

    /**
     * método que faz a transição entre os métodos getteres and setteres e
     * passado para criancaModel
     *
     * @return um objeto tipo criança model
     */
    public static Crianca_Model properCriMVC() {
        Crianca_Model cri = new Crianca_Model();
        cri.setNome(cri.getNome());
        cri.setSexo(cri.getSexo());
        cri.setIdade(cri.getIdade());

        return cri;
    }

    /**
     * método para receber o nome do responsável passado por parâmetro
     *
     * @param responsa
     */
    public void receberResponsavel(Responsavel_Model responsa) {    //método para receber o responsável
        tf_nomeResp.setText(responsa.getNome());
    }

    /**
     * método para receber o nome da criança passado por parâmetro
     *
     * @param crianca
     */
    public void recebeCrianca(Crianca_Model crianca) {
        tf_nome.setText(crianca.getNome());
    }

    /**
     * método que recebe o tempo utilizado para fazer o calculo da estadia
     */
    public void transferirDadosCalculos() {
        estadiaModel.setTempoNoBrinquedo(Double.parseDouble(tf_tempo.getText()));
        this.receberDadosEstadia(estadiaModel);
    }

    /*
     enviar para formulario extenso
     */
    public void transferirTemposnoBrinquedo() {
        estadiaModel.setTempoNoBrinquedo(Double.parseDouble(tf_tempo.getText()));
        this.receberDadosEstadia(estadiaModel);
    }

    /**
     * método para calcular o tempo utilizado na estadia
     *
     * @param estModel
     */
    public void receberDadosEstadia(Estadia_Model estModel) {
        double resultado = estModel.calcularEstadia(estadiaModel.getTempoNoBrinquedo());
        objNumberFormat.applyPattern("R$ #,##0.00");
        lb_valorTotal.setText(objNumberFormat.format(resultado));
    }

    /**
     * método que exibe o relatório da estadia em um componente visual
     * JOptionPane
     *
     * @param crianca
     */
    public static void RelatorioDeEstadia(Crianca_Model crianca) {
        objNumberFormat.applyPattern("R$ #,##0.00");
        double value = Double.parseDouble(String.valueOf(estadiaModel.calcularEstadia(estadiaModel.getTempoNoBrinquedo())));
        double vlrDesconto = Double.parseDouble(String.valueOf(estadiaModel.calcularDesconto(estadiaModel.getTempoNoBrinquedo())));
        double total = value + vlrDesconto;
        try {
            FileInputStream arquivo = new FileInputStream("./src/files/objResponsavel.txt");
            ObjectInputStream obj_dados = new ObjectInputStream(arquivo);

            FileInputStream arqCrianca = new FileInputStream("./src/files/objCrianca.txt");
            ObjectInputStream obj = new ObjectInputStream(arqCrianca);

            Responsavel_Model objRespo = (Responsavel_Model) obj_dados.readObject();
            Crianca_Model objCrianca = (Crianca_Model) obj.readObject();

            JOptionPane.showMessageDialog(null, "\tDados da Estadia"
                    + "\n ******************************************"
                    + "\n  Nome do Respons\u00e1vel.: " + objRespo.getNome()
                    + "\nCPF do Responsável.: " + objRespo.getCpf()
                    + "\nEndereço do Responsável.: " + objRespo.getEndereco()
                    + "\nTelefone do Responsável.: " + objRespo.getTelefone()
                    + "\nEmail do Responsável.: " + objRespo.getEmail()
                    + "\nIdade do Responsável.: " + objRespo.getIdade()
                    + "\n******************************************"
                    + "\nNome da Criança.: " + objCrianca.getNome()
                    + "\nSexo da Criança: " + objCrianca.getSexo()
                    + "\nSexo da Criança: " + objCrianca.getIdade()
                    + "\n******************************************"
                    + "\nTempo utilizado: " + tf_tempo.getText()
                    + "\nO total calculado : " + objNumberFormat.format(total)
                    + "\nValor do Desconto: " + objNumberFormat.format(vlrDesconto)
                    + "\nValor a pagar: " + objNumberFormat.format(value));

        } catch (Exception erro_grava) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo:");
        }
    }

    /**
     * método para preencher a área de texto com os dados da estadia
     */

    public void preencherTextArea() {
        double value = Double.parseDouble(String.valueOf(estadiaModel.calcularEstadia(estadiaModel.getTempoNoBrinquedo())));
        double vlrDesconto = Double.parseDouble(String.valueOf(estadiaModel.calcularDesconto(estadiaModel.getTempoNoBrinquedo())));
        double total = value + vlrDesconto;
        try {
            FileInputStream arquivo = new FileInputStream("./src/files/objResponsavel.txt");
            ObjectInputStream obj_dados = new ObjectInputStream(arquivo);

            FileInputStream arqCrianca = new FileInputStream("./src/files/objCrianca.txt");
            ObjectInputStream obj = new ObjectInputStream(arqCrianca);

            Responsavel_Model objRespo = (Responsavel_Model) obj_dados.readObject();
            Crianca_Model objCrianca = (Crianca_Model) obj.readObject();

            areaResumo.append("Nome do Responsável.:  " + objRespo.getNome() + "\n");
            areaResumo.append("CPF do Responsável.:  " + objRespo.getCpf() + "\n");
            areaResumo.append("Endereço do Responsável.:  " + objRespo.getEndereco() + "\n");
            areaResumo.append(" Telefone do Responsável.:  " + objRespo.getTelefone() + "\n");
            areaResumo.append("nEmail do Responsável.:  " + objRespo.getEmail() + "\n");
            areaResumo.append("Idade do Responsável.:  " + objRespo.getIdade() + "\n");
            areaResumo.append("******************************************\n");
            areaResumo.append("Nome da Criança.:  " + objCrianca.getNome() + "\n");
            areaResumo.append("Sexo da Criança.:  " + objCrianca.getSexo() + "\n");
            areaResumo.append("Idade da Criança.:  " + objCrianca.getIdade() + "\n");
            areaResumo.append("******************************************\n");
            areaResumo.append("Tempo utilizado.:  " + tf_tempo.getText() + "\n");
            areaResumo.append("Total calculado : " + total + "\n");
           // areaResumo.append("Valor do Desconto: " + vlrDesconto + "\n");
           // areaResumo.append("Valor a pagar: " + value);
            
            String entry = "";
            if(entry.contains(" , ")){
                JOptionPane.showMessageDialog(null,ValorExtenso.get(new BigDecimal(
                   entry.replace(",", ".")), "real", "reais", "centavo","centavos")); 
            }else{
                areaResumo.append(ValorExtenso.get(Long.parseLong(entry))); 
            }
            
        } catch (Exception erro_grava) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo:");
        }
    }

    /**
     * método para trocar a imagem padrão do java
     */
    public void numeroPorEstenso() {
        //  try{          
        String entry = "";
        //  do {
        // JOptionPane.showMessageDialog(null,"Escreva um número inteiro ou um valor em reais: ");
        //  entry = tf_numeracao.getText().replaceAll("\\.", "");                
        try {
            if (entry.contains(",")) {
                       JOptionPane.showMessageDialog(null,ValorExtenso.get(new BigDecimal(
                   entry.replace(",", ".")), "real", "reais", "centavo","centavos"));
            } else {
               //    tf_numeroestenso.setText(NumeroExtenso.get(Long.parseLong(entry)));
                   
            }

        } catch (NumberFormatException e) {
            //     tf_numeroestenso.setText("Número inválido.");
            // continue;
        }
        //  } while (!"".equals(entry));
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
}
