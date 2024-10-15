/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Responsavel_Controller;
import Model.Crianca_Model;
import Model.Responsavel_Model;
import files.ArquivoCsv;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * classe responsável
 *
 * @author kim
 */
public class Responsavel_view extends JFrame implements ActionListener {

    JPanel panelSuperior, panelInferior, panelOrdenacao;
    JLabel lb_pesquisar, all_InfullHouse, lb_cpf, lb_nome, lb_idade, lb_endereco, lb_fone, lb_email, lb_foto, lb_logo, lb_Icon, lb_unicumar;
    static JTextField tf_pesquisar, tf_cpf, tf_nome, tf_idade, tf_endereco, tf_fone, tf_email;
    JTable table;
    JButton bt_abreFoto, bt_gravarcsv, bt_avancar, bt_lerCsv;
    JComboBox<JTextField> cb_combo;
    ButtonGroup bg_ordenacao;
    JRadioButton rb_codigo, rb_nome;
    ImageIcon img_semFoto, img_logo, img_avancar, img_arqcsv, img_LerCsv, img_Icon, img_unicesumar;

    static Responsavel_Model model;
    Crianca_Model crianca;
    static Estadia_View estadiaView;

    private String caminho = "./src/files/Responsavel.csv";
    private String endArq = "./src/files/Responsavel.txt";
    private int maiorIdade = 18;

    /**
     * Método construtor
     */
    public Responsavel_view() {
        this.crianca = new Crianca_Model();
        this.model = new Responsavel_Model();
        this.estadiaView = new Estadia_View();
        setTitle("Cadastro de Responsáveis");
        setSize(500, 490);
        setLocation(300, 180);
        setResizable(false);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        all_InfullHouse = new JLabel(" All InfullHouse ");
        getContentPane().add(all_InfullHouse);
        all_InfullHouse.setBounds(10, 50, 300, 25);
        all_InfullHouse.setFont(new Font("Arial", Font.BOLD, 20));

        lb_pesquisar = new JLabel(" Pesquisar: ");
        lb_pesquisar.setBounds(5, 5, 90, 25);
        lb_pesquisar.setFont(new Font("Arial", Font.BOLD, 14));
        lb_pesquisar.setForeground(Color.white);

        tf_pesquisar = new JTextField(20);
        tf_pesquisar.setBounds(85, 5, 200, 20);

        cb_combo = new JComboBox<>();
        cb_combo.setBounds(290, 5, 170, 20);

        panelSuperior = new JPanel();
        getContentPane().add(panelSuperior);
        panelSuperior.setBounds(10, 10, 465, 30);
        panelSuperior.setBackground(Color.BLACK);
        panelSuperior.add(lb_pesquisar);
        panelSuperior.add(tf_pesquisar);
        panelSuperior.add(cb_combo);
        panelSuperior.setLayout(null);

        img_logo = new ImageIcon("./src/img/nomeUnicesumar.png");
        img_semFoto = new ImageIcon("./src/img/usuarios.png");
        img_avancar = new ImageIcon("./src/img/avancar.gif");
        img_arqcsv = new ImageIcon("./src/img/gravar.gif");
        img_LerCsv = new ImageIcon("./src/img/ler.gif");
        img_Icon = new ImageIcon("./src/img/Icon.png");
        img_unicesumar = new ImageIcon("./src/img/nome.png");

        lb_unicumar = new JLabel(img_unicesumar);
        lb_unicumar.setFont(new Font("Arial", Font.BOLD, 16));
        lb_unicumar.setForeground(Color.WHITE);
        lb_unicumar.setBounds(2, 0, 150, 30);

        lb_logo = new JLabel(img_logo);
        getContentPane().add(lb_logo);
        lb_logo.setBounds(2, 0, 250, 80);

        lb_Icon = new JLabel(img_Icon);
        getContentPane().add(lb_Icon);
        lb_Icon.setBounds(380, 40, 90, 80);

        lb_foto = new JLabel(img_semFoto);
        getContentPane().add(lb_foto);
        lb_foto.setBounds(320, 80, 150, 120);

        panelInferior = new JPanel();
        panelInferior.add(lb_unicumar);
        getContentPane().add(panelInferior);
        panelInferior.setBounds(10, 410, 465, 30);
        panelInferior.setBackground(Color.BLACK);
        panelInferior.setLayout(null);

        lb_nome = new JLabel("Nome:");
        getContentPane().add(lb_nome);
        lb_nome.setBounds(20, 100, 50, 20);

        tf_nome = new JTextField();
        getContentPane().add(tf_nome);
        tf_nome.setBounds(60, 100, 270, 20);
        tf_nome.requestFocus();

        lb_cpf = new JLabel("CPF:");
        getContentPane().add(lb_cpf);
        lb_cpf.setBounds(20, 135, 50, 20);

        tf_cpf = new JTextField();
        getContentPane().add(tf_cpf);
        tf_cpf.setBounds(60, 135, 270, 20);

        lb_endereco = new JLabel("Endereço:");
        getContentPane().add(lb_endereco);
        lb_endereco.setBounds(20, 170, 70, 20);

        tf_endereco = new JTextField();
        getContentPane().add(tf_endereco);
        tf_endereco.setBounds(85, 170, 360, 20);

        lb_fone = new JLabel("Fone:");
        getContentPane().add(lb_fone);
        lb_fone.setBounds(20, 205, 40, 20);

        tf_fone = new JTextField();
        getContentPane().add(tf_fone);
        tf_fone.setBounds(60, 205, 270, 20);

        lb_email = new JLabel("Email:");
        getContentPane().add(lb_email);
        lb_email.setBounds(20, 240, 40, 20);

        tf_email = new JTextField();
        getContentPane().add(tf_email);
        tf_email.setBounds(60, 240, 270, 20);

        lb_idade = new JLabel("Idade:");
        getContentPane().add(lb_idade);
        lb_idade.setBounds(20, 275, 40, 20);

        tf_idade = new JTextField();
        getContentPane().add(tf_idade);
        tf_idade.setBounds(60, 275, 180, 20);

        bt_abreFoto = new JButton("...");
        getContentPane().add(bt_abreFoto);
        bt_abreFoto.setBounds(335, 135, 30, 20);
        bt_abreFoto.setFont(new Font("Arial", Font.BOLD, 14));
        bt_abreFoto.setToolTipText("Selecionar Imagem");

        bt_lerCsv = new JButton(img_LerCsv);
        getContentPane().add(bt_lerCsv);
        bt_lerCsv.setBounds(320, 300, 40, 30);
        bt_lerCsv.setToolTipText("Leitura do arquivo CSV");
        bt_lerCsv.setFont(new Font("Arial", Font.BOLD, 14));

        bt_gravarcsv = new JButton(img_arqcsv);
        getContentPane().add(bt_gravarcsv);
        bt_gravarcsv.setBounds(370, 300, 40, 30);
        bt_gravarcsv.setToolTipText("Gravar em Arquivo CSV");
        bt_gravarcsv.setFont(new Font("Arial", Font.BOLD, 14));

        bt_avancar = new JButton(img_avancar);
        getContentPane().add(bt_avancar);
        bt_avancar.setBounds(420, 300, 40, 30);
        bt_avancar.setToolTipText("Avança para próxima tela...!");
        bt_avancar.setFont(new Font("Arial", Font.BOLD, 14));

        bg_ordenacao = new ButtonGroup();
        rb_codigo = new JRadioButton("Código");
        rb_nome = new JRadioButton("  Nome");

        bg_ordenacao.add(rb_codigo);
        bg_ordenacao.add(rb_nome);

        panelOrdenacao = new JPanel();
        getContentPane().add(panelOrdenacao);
        panelOrdenacao.setBounds(375, 200, 90, 65);
        panelOrdenacao.setBackground(Color.darkGray);
        panelOrdenacao.add(rb_codigo);
        panelOrdenacao.add(rb_nome);

        setIcon();

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{"Código", "Nome", "Idade", "CPF"}
        ));

        getContentPane().add(table);
        table.setBounds(20, 350, 450, 50);

        bt_lerCsv.addActionListener(this);
        bt_gravarcsv.addActionListener(this);
        bt_avancar.addActionListener(this);
        bt_abreFoto.addActionListener(this);
    }

    /**
     * Método principal Main
     *
     * @param args
     */
    public static void main(String[] args) {
        JFrame respView = new Responsavel_view();
        respView.setVisible(true);

        Responsavel_Model model = Prop_MVC();
        Responsavel_view view = new Responsavel_view();
        Responsavel_Controller controller = new Responsavel_Controller(model, view);

        controller.atualizaView();
    }

    /**
     * Método responsável por disparar ações nos components
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt_avancar) {
            //  ValidaCamposResponsavel();
            if (validarCampoIdade()) {
                exportarDados();
                gravarDadosResponsavelEmObjeto();
            }
            this.dispose();
        }
        if (e.getSource() == bt_gravarcsv) {

            GravarArquivoCsv();
        }
        if (e.getSource() == bt_lerCsv) {

            lerCsv();
        }
        if (e.getSource() == bt_abreFoto) {

        }
    }

    /**
     * Método quando chamado faz a impressão no console
     *
     * @param nome
     * @param cpf
     * @param endereco
     * @param telefone
     * @param email
     * @param idade
     */
    public void printDadosResponsavel(String nome, String cpf, String endereco, String telefone, String email, int idade) {
        System.out.println(" Responsavel: " + nome);
        System.out.println(" cpf: " + cpf);
        System.out.println(" endereco: " + endereco);
        System.out.println(" Telefone: " + telefone);
        System.out.println(" email: " + email);
        System.out.println(" idade: " + idade);
    }

    /**
     * método para pegar o que for digitado nos TexTField e passado para o model
     *
     * @return model
     */
    public static Responsavel_Model Prop_MVC() {
        model.setNome(tf_nome.getText());
        model.setCpf(tf_cpf.getText());
        model.setEndereco(tf_endereco.getText());
        model.setTelefone(tf_fone.getText());
        model.setEmail(tf_email.getName());
        model.setIdade(Integer.parseInt(tf_idade.getText()));

        return model;
    }

    /**
     * método para exportar o nome do responsável para o formulário da criança
     */
    public void exportarDados() {
        Crianca_view crianca = new Crianca_view();
        model.setNome(tf_nome.getText());
        validarCampoIdade();                //método para validar a idade esse método só pode ser chamadoa após a chamada do método validarIdade
        crianca.receberDados(model);
        crianca.setVisible(true);
    }

    /**
     * Método para exportar os dados do responsável para o relatório
     *
     * @return
     */
    public void exportarDadosResponsavelRelatorio() {
        model.setNome(tf_nome.getText());
        model.setCpf(model.getCpf());
        model.setEndereco(model.getEndereco());
        model.setTelefone(model.getTelefone());
        model.setEmail(model.getEmail());
        model.setIdade(model.getIdade());
    }

    /**
     * Método para validar se o responsável é maior de idade, se for menor de
     * idade sai do sistema
     *
     * @return
     */
    public boolean validarCampoIdade() {
        model.setIdade(Integer.parseInt(tf_idade.getText()));
        if ((model.getIdade() < maiorIdade) || (tf_nome.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Você é menor de idade\n Ou deve preencher o campo nome");
            // System.exit(1);
        } else {
            //   System.exit(0);
        }
        return true;
    }

    /**
     * Método para limpar os campos
     *
     * @return true
     */
    public boolean LimparCampos() {
        tf_nome.setText("");
        tf_cpf.setText("");
        tf_endereco.setText("");
        tf_fone.setText("");
        tf_email.setText("");
        tf_idade.setText("");
        return false;
    }

    /**
     * Método para validar se os campos foram preenchidos, se não foram sai do
     * sistema
     */
    public void ValidaCamposResponsavel() {

        if (tf_nome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo nome:");
        } else if (tf_cpf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo CPF:");
        } else if (tf_endereco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo endereço:");
        } else if (tf_fone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Telefone:");
        } else if (tf_email.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Email:");
        } else if (tf_idade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Idade:");
        }
    }

    //método para gravar os dados em arquivo csv
    public void GravarArquivoCsv() {
        ArquivoCsv.AdicionarResponsavel(model);
    }

    public void lerCsv() {
        ArquivoCsv.leitorCsv(caminho);
    }

    /**
     * método de gravação dos dados do responsável em objeto
     */
    public void gravarDadosResponsavelEmObjeto() {
        Responsavel_Model objRespo = new Responsavel_Model();
        objRespo.setNome(tf_nome.getText());
        objRespo.setCpf(tf_cpf.getText());
        objRespo.setEndereco(tf_endereco.getText());
        objRespo.setTelefone(tf_fone.getText());
        objRespo.setEmail(tf_email.getText());
        objRespo.setIdade(Integer.parseInt(tf_idade.getText()));
        try {
            FileOutputStream arquivo = new FileOutputStream("./src/files/objResponsavel.txt");
            ObjectOutputStream obj_dados = new ObjectOutputStream(arquivo);
            obj_dados.writeObject(objRespo);
            obj_dados.flush();
            // JOptionPane.showMessageDialog(null,"Parabéns, arquivo de configurações gerados com sucesso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para trocar o ícone padrão do java
     */
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
}