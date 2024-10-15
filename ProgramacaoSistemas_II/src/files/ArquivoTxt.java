/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files;

import Model.Responsavel_Model;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author kim
 */
public class ArquivoTxt {
    
    /**
     * 
     * @param modResp
     * @param fileName 
     */
    public static void salvarDadosObjetos(Responsavel_Model modResp, String fileName){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(modResp);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
 
 /**
  * Arquivo não utilizado
  * @return
  * @throws IOException
  * @throws ClassNotFoundException 
  */
 public static Object recuperarDados() throws IOException, ClassNotFoundException{
        try {
           FileInputStream objArqResp = new FileInputStream("./src/files/Responsavel.txt");
            ObjectInputStream dadosResp = new ObjectInputStream(objArqResp);
       
            Object arquivo = dadosResp.readObject();
            
            return arquivo;
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return null;
       }
    }
 public static void salvaEmArquivoTxt() throws IOException{  
     Responsavel_Model model = new Responsavel_Model();
       FileOutputStream arq = null;
        String endArq = "./src/files/Responsavel.txt";
          try {   
              arq = new FileOutputStream(endArq);
             ObjectOutputStream rp = new ObjectOutputStream(arq);
             
             String[] dadosResp = null;
             model.setNome(model.getNome());
             dadosResp[1] =  model.getCpf();
             dadosResp[2] =  model.getEndereco();
             dadosResp[3] =  model.getTelefone();
             dadosResp[4] =  model.getEmail();
             dadosResp[5] =  String.valueOf(model.getIdade());
             
             rp.writeObject(dadosResp);
             rp.flush();
             
             JOptionPane.showMessageDialog(null, "Dados Gravados com sucesso: ");
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        } finally {
            try {
                arq.close();
            } catch (IOException ex) {
               ex.printStackTrace();
            }
        }
 }
}