/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;                                  // pacote 

import Controller.Responsavel_Controller;
import Model.Crianca_Model;
import Model.Responsavel_Model;
import java.awt.Color;
import java.awt.Font;                          // Área da importação das bibliotecas
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;                  
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 * classe criancaView
 * @author kim
 */
public class Crianca_view extends JFrame implements ActionListener{    
    
    JPanel panelSuperior, panelInferior;
    JLabel lb_pesquisar, lb_nomeResponsavel, lb_nome, lb_idade, lb_sexo, lb_foto, lb_logo,lb_unicesumar, lb_icon;  
    JTextField tf_pesquisar, tf_nomeResponsavel, tf_nome, tf_idade, tf_sexo;
    JTable table;
    JButton bt_abreFoto, bt_gravartxt, bt_avancar, bt_lertxt;
    JComboBox<JTextField> cb_combo;  
    ImageIcon  img_semFoto, img_avancar, img_arqtxt, img_Lertxt,img_unicesumar, img_icon;
    
    Responsavel_Model model         = new Responsavel_Model();
    static Crianca_Model modCrianca = new Crianca_Model();
    Estadia_View estadia            = new Estadia_View();
    
    private int IdadeDeBrincar = 10;
    
    /**
     * Método Construtor
     */
    public Crianca_view(){                            
        setTitle("Cadastro da Criança");        //Titulo do formulário
        setSize(385, 450);                           //Tamanho do formulário em pixels
        setLocation(150, 180);                       //Posiciona o formulário na tela 
        setResizable(false);                          //Se o formulário pode ser redimencionado ou não 
        getContentPane().setLayout(null);            //Set o Layout como nulo
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Método usado para nnão fechar toda a aplicação apenas esse formulário
        
         setIcon();
        
        img_semFoto    = new ImageIcon("./src/img/usuarios.png");
        img_avancar    = new ImageIcon("./src/img/avancar.gif");
        img_arqtxt     = new ImageIcon("./src/img/gravar.gif");
        img_Lertxt     = new ImageIcon("./src/img/ler.gif");
        img_unicesumar = new ImageIcon("./src/img/nome.png");
        img_icon       = new ImageIcon("./src/img/Icon.png");
         
        lb_pesquisar = new JLabel(" Pesquisar: ");
        lb_pesquisar.setBounds(5, 5, 70, 25);
        lb_pesquisar .setFont(new Font("Arial", Font.BOLD,12));
        lb_pesquisar .setForeground(Color.WHITE);
        
        tf_pesquisar = new JTextField(25);
        tf_pesquisar.setBounds(75, 5, 140, 20);
        
        cb_combo     = new JComboBox<>();
        cb_combo     .setBounds(220, 5, 125, 20);
        
        lb_unicesumar = new JLabel(img_unicesumar);
        lb_unicesumar .setFont(new Font("Arial", Font.BOLD,16));
        lb_unicesumar .setForeground(Color.WHITE);
        lb_unicesumar .setBounds(2, 2, 130, 30);
        
        lb_nomeResponsavel = new JLabel("Nome do Responsável:");
        getContentPane().add(lb_nomeResponsavel);
        lb_nomeResponsavel.setBounds(20, 50, 150, 20); 
          
        panelSuperior = new JPanel();
        getContentPane().add(panelSuperior);
        panelSuperior.setBounds(10, 10, 350, 30);
        panelSuperior.setBackground(Color.BLACK);
        panelSuperior.add(lb_pesquisar);
        panelSuperior.add(tf_pesquisar);
        panelSuperior.add(cb_combo);
        panelSuperior.setLayout(null);
        
        panelInferior = new JPanel();
        panelInferior.add(lb_unicesumar);
        getContentPane().add(panelInferior);
        panelInferior .setBounds(10, 375, 350, 30);
        panelInferior .setBackground(Color.BLACK);
        panelInferior.setLayout(null);
        
        tf_nomeResponsavel = new JTextField();
        getContentPane().add(tf_nomeResponsavel);
        tf_nomeResponsavel.setBounds(20, 70, 320, 20);
        tf_nomeResponsavel.setBackground(Color.lightGray);
        
        lb_nome = new JLabel("Nome da Criança:");
        getContentPane().add(lb_nome);
        lb_nome.setBounds(20, 90, 150, 20); 
        
         tf_nome   = new JTextField();
        getContentPane().add(tf_nome);
        tf_nome.setBounds(20, 110, 320, 20);
       
        lb_sexo = new JLabel("Sexo da Criança:");
        getContentPane().add(lb_sexo);
        lb_sexo.setBounds(20, 130, 150, 20);
        
        tf_sexo = new JTextField();
        getContentPane().add(tf_sexo);
        tf_sexo.setBounds(20, 150, 180, 20);
        
        lb_idade= new JLabel("Idade da Crinça:");
        getContentPane().add(lb_idade);
        lb_idade.setBounds(20, 170, 150, 20);
        
        tf_idade = new JTextField();
        getContentPane().add(tf_idade);
        tf_idade.setBounds(20, 190, 180, 20);
        
        lb_icon = new JLabel(img_icon);
        getContentPane().add(lb_icon);
        lb_icon.setBounds(1, 190, 90, 130);
        
        bt_abreFoto = new JButton("...");
        getContentPane().add(bt_abreFoto);
        bt_abreFoto.setBounds(210, 150, 40,20);
        bt_abreFoto.setFont(new Font("Arial", Font.BOLD, 14));
       
        lb_foto = new JLabel(img_semFoto);
        getContentPane().add(lb_foto);
        lb_foto.setBounds(245, 120, 100, 80);
        
        bt_lertxt = new JButton(img_Lertxt);
        getContentPane().add(bt_lertxt);
        bt_lertxt.setBounds(210, 240, 40,30);
        bt_lertxt.setToolTipText("Leitura do arquivo texto");
        bt_lertxt.setFont(new Font("Arial", Font.BOLD, 14));
        
        bt_gravartxt = new JButton(img_arqtxt);
        getContentPane().add(bt_gravartxt);
        bt_gravartxt.setBounds(255, 240, 40,30);
        bt_gravartxt.setToolTipText("Gravar em Arquivo texto");
        bt_gravartxt.setFont(new Font("Arial", Font.BOLD, 14));
        
        bt_avancar = new JButton(img_avancar);
        getContentPane().add(bt_avancar);
        bt_avancar.setBounds(300, 240, 40,30);
        bt_avancar.setToolTipText("Avança para próxima tela...!");
        bt_avancar.setFont(new Font("Arial", Font.BOLD, 14));
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
             new Object[][]{
                 {null, null, null, null},
                 {null, null, null, null},
                 {null, null, null, null},
                 {null, null, null, null}
             },
             new String[]{"Código","Nome", "Idade","CPF"}   
        ));
        
        getContentPane().add(table);
        table.setBounds(20, 290, 330, 50);
       
        bt_lertxt       .addActionListener(this);
        bt_gravartxt    .addActionListener(this);
        bt_avancar      .addActionListener(this);
        bt_abreFoto     .addActionListener(this);   
        
    }
    /**
     * método principal Main
     * @param args 
     */
   public static void main(String[] args) {
        JFrame crianca = new Crianca_view();
        crianca.setVisible(true);
        
        Responsavel_Model model = ProprerResponsavel_MVC();
        Responsavel_view view      = new Responsavel_view();
        Responsavel_Controller controller = new Responsavel_Controller(model, view);
        
        controller.atualizaView();
       
    }
   /**
    * método responsável por disparar ações nos components
    * @param e 
    */
      @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bt_avancar){
              exportarDados();
              ValidaIdadeDeBrincar();
              exportaDadosCrianca(); 
              
              this.dispose();
              
        }
        if(e.getSource()==bt_gravartxt){
           gravarDadoDaCriancaEmObjeto();
        }
        if(e.getSource()== bt_lertxt){
            
        }
    }
    /**
     * 
     * @param respName 
     */
    public void printResponsavelDetalhes(String respName ){}  
   /**
    * 
    * @return objeto responsávelModel
    */
    public static Responsavel_Model ProprerResponsavel_MVC(){
        Responsavel_Model resp = new Responsavel_Model();
        resp.setNome(resp.getNome());
        resp.setCpf(resp.getCpf());
        resp.setEndereco(resp.getEndereco());
        resp.setTelefone(resp.getTelefone());
        resp.setEmail(resp.getEmail());
        resp.setIdade(resp.getIdade());
        return resp;
    } 
    /**
     * 
     * @return objeto criancaModel
     */
    public static Crianca_Model properCrianca(){
        modCrianca.setNome(modCrianca.getNome());
        modCrianca.setSexo(modCrianca.getSexo());
        modCrianca.setIdade(modCrianca.getIdade());
        
        return modCrianca;
    }
    /**
     * método para receber o mome do responsável por parâmetro
     * @param responsa 
     */
     public void receberDados(Responsavel_Model responsa){  
           tf_nomeResponsavel.setText(responsa.getNome());
    }
     /**
      * método que exporta o nome do responsável para o Formulário de Estadia
      */
    public void exportarDados(){      
       model.setNome(tf_nomeResponsavel.getText()); 
       estadia.receberResponsavel(model);
       estadia.setVisible(true);
       gravarDadoDaCriancaEmObjeto();               //chama o método que grava os dados em objetos
    } 
    /**
     * método para exportar o nome da criança para o formulário de estadia
     */
     public void exportaDadosCrianca(){   
         modCrianca.setNome(tf_nome.getText());
         estadia.recebeCrianca(modCrianca);
        // estadia.setVisible(true);   
     }
     /**
      * método para validar a idade da criança
      * @return 
      */
    public boolean ValidaIdadeDeBrincar(){
      modCrianca.setIdade(Integer.parseInt(tf_idade.getText()));
      if((modCrianca.getIdade() <= IdadeDeBrincar)){
       //   JOptionPane.showMessageDialog(null, "Você pode brincar...");  
      }else if((modCrianca.getIdade() > IdadeDeBrincar)){ 
          JOptionPane.showMessageDialog(null, "Você não tem mais idade para brincar com esse tipos de brinquedos... ");  
          System.exit(0);
      }
        return true;
  }
  /**
   * método genérico para limpar os campos
   * @return 
   */
  public boolean camposVazios(){
      tf_nomeResponsavel.setText("");
      tf_nome.setText("");
      tf_sexo.setText("");
      tf_idade.setText("");
      return true;
  }
   /**
    * método para gravar os dados da criança em arquivo de texto como objeto
    */
    public void gravarDadoDaCriancaEmObjeto(){
          Crianca_Model objCria = new Crianca_Model(); 
          objCria.setNome(tf_nome.getText());
          objCria.setSexo(tf_sexo.getText());
          objCria.setIdade(Integer.parseInt(tf_idade.getText()));        
          try
          {
             FileOutputStream arquivo = new FileOutputStream ("./src/files/objCrianca.txt");
             ObjectOutputStream  obj_dados  = new ObjectOutputStream(arquivo);
             obj_dados.writeObject(objCria);
             obj_dados.flush();
           //  JOptionPane.showMessageDialog(null,"Parabéns, arquivo de texto gerados com sucesso");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * método para trocar o ícone padrão do java
     */
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
}