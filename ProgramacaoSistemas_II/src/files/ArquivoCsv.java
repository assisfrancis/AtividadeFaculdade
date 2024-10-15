/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files;

import Model.Responsavel_Model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kim
 */
public class ArquivoCsv {
    
    static Responsavel_Model objResponsavel;
    private static String caminho = "./src/files/Responsavel.csv";
   
     public ArquivoCsv(){
       objResponsavel = new Responsavel_Model(); 
    }   
    //Adiciona dados no arquivo CSV
    public static void AdicionarResponsavel(Responsavel_Model objResponsavel){
        try{
           //Verificar se o arquivo existe
           boolean arqExiste = new File(caminho).exists();
           
            try ( //abre o file write para escrita no arquivo
                    FileWriter escreve = new FileWriter(caminho, StandardCharsets.ISO_8859_1 , true)) {
                if(!arqExiste){
                    escreve.write("Nome do Responsavel ,CPF , Endereço, Telefone, Email , Idade \n");
                }    //Escreve no arquivo 
                escreve.write(objResponsavel.getNome() + ";"+ objResponsavel.getCpf() +";"+ objResponsavel.getEndereco()+";"+ objResponsavel.getTelefone()+";"+objResponsavel.getEmail()+";"+objResponsavel.getIdade()+ "\n\n");
                //Escreve no arquivo
                escreve.flush();
                //Fecha o 
                escreve.close();
            }
           
       
        }catch(IOException erro){
           erro.getMessage();
        }
    }
    //******************************************************    
     public static ArrayList<Responsavel_Model> leitorCsv(String file){
        Scanner entrada; 
      ArrayList<Responsavel_Model> values = new ArrayList<Responsavel_Model>();
          try{
            entrada = new Scanner(Paths.get(file));
            
            entrada.nextLine();
            while(entrada.hasNext()){
                String[] dados = entrada.nextLine().split(";");
                  
                Responsavel_Model modResp = new Responsavel_Model();
                modResp.setNome(dados[0]);
                modResp.setCpf(dados[1]);
                modResp.setEndereco(dados[2]);
                modResp.setTelefone(dados[3]);
                modResp.setEmail(dados[4]);
                modResp.setIdade(Integer.parseInt(dados[5]));
                
                values.add(modResp);  
            }
     
          }catch(Exception e){
           e.getCause();
          }
        return values;   
    }
    public static ArrayList<Responsavel_Model> ListarResponsavel(String caminho){
  
        ArrayList<Responsavel_Model> lista = new ArrayList<>();
        
        try{
             BufferedReader objLeitura = new BufferedReader(new FileReader(caminho));
              String  linha;
              boolean firstline = false;
              
              while((linha = objLeitura.readLine()) != null){
                  if(firstline){
                      firstline = true;
                      continue;
                  }
                  String[] coluna = linha.split(",");
                  String nome     = coluna[0];
                  String  cpf     = coluna[1];
                  String endereco = coluna[2];
                  String teleone  = coluna[3]; 
                   String email   = coluna[4];
                  int    idade    = Integer.parseInt(coluna[5]);
                  
                 objResponsavel.setNome(objResponsavel.getNome());
                 objResponsavel.setCpf(objResponsavel.getCpf());
                 objResponsavel.setEndereco(objResponsavel.getEndereco());
                 objResponsavel.setTelefone(objResponsavel.getTelefone());
                 objResponsavel.setEmail(objResponsavel.getEmail());
                 objResponsavel.setIdade(objResponsavel.getIdade());
            
                  lista.add(objResponsavel);
                  System.out.println(nome+";"+ cpf +","+ endereco+","+teleone +","+ email+","+ idade); 
              }
            objLeitura.close();
            
        }catch(IOException err){
               err.printStackTrace();
        }
        return lista;
    }
}