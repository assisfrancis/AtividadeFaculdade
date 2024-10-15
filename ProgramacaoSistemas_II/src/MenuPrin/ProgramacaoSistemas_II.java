package MenuPrin;

import View.Crianca_view;
import View.Estadia_View;
import View.Responsavel_view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.*;
/**
 * classe principal
 * @author kim
 */
public class ProgramacaoSistemas_II extends JFrame implements ActionListener {
    /**
     * @param args the command line arguments
     */
        JMenuBar barraMenu; 
        JMenu cadastro, pesquisa, backup, confbanco;
        JMenuItem jmiResp, jmiCrianca, jmiEstadia, jmipesquisar, jmibackstore, jmiconfig;
        JPanel panelInferior, panelGeral;
        static JLabel welcome, labelInferior, lb_dataHora, lb_geral, lb_ead, lb_oneself;
        ImageIcon img_eduDistancia, img_unicesumar, img_ead, img_Icon;
        Locale local = Locale.getDefault();
        Calendar calend = Calendar.getInstance();
       
    /**
     * método construtor
     */
    public ProgramacaoSistemas_II(){
      
        setTitle(" Mapa Programação de Sistemas II ");
        setSize(400, 500);
        setLocation(500, 180);
        setResizable(false);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setIcon();
        
         //Inicialização dos componebtes
        barraMenu    = new JMenuBar();
        cadastro     = new JMenu("Cadastro");
        pesquisa     = new JMenu("Pesquisa");
        backup       = new JMenu("Backup");
        confbanco    = new JMenu("Configurações");
        
        cadastro     .setFont(new Font("Arial", Font.BOLD,14));
        pesquisa     .setFont(new Font("Arial", Font.BOLD,14));
        backup       .setFont(new Font("Arial", Font.BOLD,14));
        confbanco    .setFont(new Font("Arial", Font.BOLD,14));
        
        jmiResp      = new JMenuItem("Responsável");
        jmipesquisar = new JMenuItem("Search");
        jmibackstore = new JMenuItem("Restore");
        jmiconfig    = new JMenuItem("Banco");
        jmiCrianca   = new JMenuItem("Criança ");
        jmiEstadia    = new JMenuItem("Estadia");
        
        jmiResp      .setFont(new Font("Arial", Font.BOLD,14));
        jmipesquisar .setFont(new Font("Arial", Font.BOLD,14));
        jmibackstore .setFont(new Font("Arial", Font.BOLD,14));
        jmiconfig    .setFont(new Font("Arial", Font.BOLD,14));
        jmiCrianca   .setFont(new Font("Arial", Font.BOLD,14));
        jmiEstadia   .setFont(new Font("Arial", Font.BOLD,14));
        
        img_unicesumar    = new ImageIcon("./src/img/nome.png");
        img_eduDistancia  = new ImageIcon("./src/img/educacaoADistancia.jpeg");
        img_ead           = new ImageIcon("./src/img/ead.png");
        img_Icon          = new ImageIcon("./src/img/icon.png");
        
        welcome        = new JLabel("Welcome to System ");
        getContentPane().add(welcome);
        welcome      .setBounds(10, 0, 200, 100);
        welcome      .setForeground(Color.red);
        welcome      .setFont(new Font("Arial", Font.BOLD,16));
        
        labelInferior= new JLabel(img_unicesumar);
        labelInferior.setFont(new Font("Arial", Font.BOLD,16));
        labelInferior.setForeground(Color.WHITE);
        labelInferior.setBounds(2, 2, 150, 25);
        
        lb_geral = new JLabel(img_eduDistancia);
        lb_geral.setFont(new Font("Arial", Font.BOLD,16));
        lb_geral.setForeground(Color.WHITE);
        lb_geral.setBounds(80, 100, 200, 200);
        
        lb_ead        = new JLabel(img_ead);
        getContentPane().add(lb_ead);
        lb_ead          .setBounds(310, 0, 50, 100);
        lb_ead          .setForeground(Color.red);
        
        lb_dataHora= new JLabel();
        lb_dataHora.setFont(new Font("Arial", Font.BOLD,12));
        lb_dataHora.setForeground(Color.WHITE);
        lb_dataHora.setBounds(180, 2, 170, 25);
        
         lb_oneself = new JLabel("RA: 1918714-5 ");
         getContentPane().add(lb_oneself);
        lb_oneself.setFont(new Font("Arial", Font.BOLD,16));
        lb_oneself.setForeground(Color.YELLOW);
        lb_oneself.setBounds(130, 310, 220, 25);
        
        //Adicionando os menu na barra de menu
        setJMenuBar(barraMenu);
        barraMenu.add(cadastro);
        barraMenu.add(pesquisa);
        barraMenu.add(backup);
        barraMenu.add(confbanco);
        
        cadastro.add(jmiResp);
        cadastro.add(jmiCrianca);
         cadastro.add(jmiEstadia);
        pesquisa.add(jmipesquisar);
        backup.add(jmibackstore);
        confbanco.add(jmiconfig);
        
        //Adicionar os componentes no contente
        getContentPane().add(barraMenu);
       
        panelInferior = new JPanel();
        panelInferior.add(labelInferior);
        panelInferior.add(lb_dataHora);
        getContentPane().add(panelInferior);
        panelInferior.setLayout(null);
        panelInferior.setBackground(Color.BLACK);
        panelInferior.setBounds(10, 400, 367, 30);
        
        panelGeral = new JPanel();
        panelGeral.add(lb_geral);
        panelGeral.add(lb_ead);
        getContentPane().add(panelGeral);
        panelGeral.setLayout(null);
        panelGeral.setBackground(Color.BLACK);
        panelGeral.setBounds(10, 10, 367, 385);
        
        //Adicionando ações para 
        jmiconfig .addActionListener(this);
        jmiResp   .addActionListener(this);
        jmiCrianca.addActionListener(this);
        jmiEstadia.addActionListener(this);
        
        lerData();
    }
    /**
     * método principal Main
     * @param args 
     */
    public static void main(String[] args) {
       JFrame shop = new ProgramacaoSistemas_II();
       shop.setVisible(true);
    }
    /**
     * mpetodo responsável por disparar ações nos components
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jmiResp){
             JFrame cadPadrao = new Responsavel_view();
            cadPadrao.setVisible(true);
            this.dispose();
        }
        if(e.getSource()==jmiconfig){
            JFrame Configura = new Configuracoes();
            Configura.setVisible(true);
        }
        if(e.getSource()==jmiCrianca){
            JFrame crianca = new Crianca_view();
            crianca.setVisible(true);
        }
        if(e.getSource()==jmiEstadia){
            JFrame estad = new Estadia_View();
            estad.setVisible(true);
        }   
    }
    /**
     * método para leitura da data e hora
     */
    public void lerData(){
        
        LocalDate agora = LocalDate.now();
         LocalTime hora = LocalTime.now();
     lb_dataHora.setText("Data: "+String.valueOf(agora)+" Hora: "+ hora);
    }
    /**
     * método para trocar o ícone padrão do java
     */
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
}
