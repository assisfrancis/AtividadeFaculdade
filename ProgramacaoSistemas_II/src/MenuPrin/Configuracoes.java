/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuPrin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author kim
 */
public class Configuracoes extends JFrame implements ActionListener{
    
    JPanel panelSuperior, panelInferior;
    JLabel lb_configuracao, lb_banco, lb_driver, lb_url, lb_usuario, lb_senha, lb_ead;
    JTextField tf_driver, tf_url, tf_usuario, tf_senha;
    JComboBox<String> jcb_banco;
    JButton bt_getInfo, bt_setInfo;
    ImageIcon img_ead;
    
    public Configuracoes(){
       setTitle("Configuraçoes do Sistema ... ");        //Título do Formulário
       setSize(380, 400);                               //  FormulTamanho do Formulário
       setLocation(250, 180);                           // Posiciona o Formulário na tela 
       setResizable(true);                               // Se o formulário pode ser redimensionado ou não
       getContentPane().setLayout(null);                 // Define o layout como nulo
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // método para não fechar toda a aplicação
       
        panelSuperior = new JPanel();              //Inicializa a Panel Superior
        getContentPane().add(panelSuperior);       // Adiciona o componente ao contener
        panelSuperior.setBounds(10, 10, 345, 30);  // Posiciona o contener na tela
        panelSuperior.setBackground(Color.BLUE);   // Define a cor de fundo do componente como sendo azul, poderia ser outra
      
        lb_configuracao = new JLabel("Configurações");  //Inicializa a Label Superior
        panelSuperior.add(lb_configuracao);             // Adiciona a Label a panel superior
        
        panelInferior = new JPanel();                  // Inicializa a panel Inferior
        getContentPane().add(panelInferior);
        panelInferior.setBounds(10, 320, 345, 30);
        panelInferior.setBackground(Color.BLUE);
        
        lb_banco = new JLabel("Escolha o Banco:");
        getContentPane().add(lb_banco);
        lb_banco.setBounds(20, 50,120, 20);
        
        jcb_banco = new JComboBox<>();
        getContentPane().add(jcb_banco);
        jcb_banco.setBounds(120, 50, 210, 20) ;
        jcb_banco.addItem(" Oracle");
        jcb_banco.addItem(" Firebird");
        jcb_banco.addItem(" Mysql");
        jcb_banco.addItem(" SqlServer");
        jcb_banco.addItem(" PostGrees");
        
        lb_driver = new JLabel("Driver:");
        getContentPane().add(lb_driver);
        lb_driver.setBounds(20, 100,50, 20);
        
        tf_driver = new JTextField();
        getContentPane().add(tf_driver);
        tf_driver.setBounds(80, 100,180, 20);
        
        lb_url = new JLabel("URL:");
        getContentPane().add(lb_url);
        lb_url.setBounds(20, 130,50, 20);
        
        tf_driver = new JTextField();
        getContentPane().add(tf_driver);
        tf_driver.setBounds(80, 130,250, 20);
        
        lb_usuario = new JLabel("Usuário:");
        getContentPane().add(lb_usuario);
        lb_usuario.setBounds(20, 160,50, 20);
        
        tf_usuario = new JTextField();
        getContentPane().add(tf_usuario);
        tf_usuario.setBounds(80, 160,250, 20);
        
        lb_senha = new JLabel("Senha:");
        getContentPane().add(lb_senha);
        lb_senha.setBounds(20, 190,50, 20);
        
        tf_senha = new JTextField();
        getContentPane().add(tf_senha);
        tf_senha.setBounds(80, 190,250, 20);
        
        img_ead = new ImageIcon("./img/imgRedimensionada.gif");
        lb_ead = new JLabel(img_ead);
        getContentPane().add(lb_ead);
        lb_ead.setBounds(10,210,100,80);
        
        bt_setInfo = new JButton("SetInfo");
        getContentPane().add(bt_setInfo);
        bt_setInfo.setBounds(250, 250,80, 30);
        
        bt_getInfo = new JButton("GetInfo");
        getContentPane().add(bt_getInfo);
        bt_getInfo.setBounds(150, 250,80, 30);
        
        
        bt_setInfo.addActionListener(this);
        bt_getInfo.addActionListener(this);
        jcb_banco.addActionListener(this);
        
        
    }
    public static void main(String[] args) {
        JFrame confi = new Configuracoes();
        confi.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==jcb_banco){
          if(jcb_banco.getSelectedItem().equals("Firebird")){
              preencherCampos();
          }
      }
    }
    public void preencherCampos(){
            tf_driver.setText("org.firebirdsql.jdbc.FBDriver");
            tf_url.setText("jdbc:firebirdsql:localhost/3050:C:/caminho do banco");
            tf_usuario.setText("SYSDBA");
            tf_senha.setText("masterkey"); 
    }
}
