package Controller;
/**
 *
 * @author kim
 */
import Model.Crianca_Model;
import View.Crianca_view;

public class Crianca_Controller {
   
    private Crianca_Model cm;
    private Crianca_view cv;
        
    public Crianca_Controller(Crianca_Model cmd, Crianca_view vw ){
        this.cm = cmd;
        this.cv = vw;
    } 
    public void setNomeCrianca(String nome){
     cm.setNome(nome);
  }
    public void setSexoCrianca(String sexo){
        cm.setSexo(sexo);
    }
    public void setIdadeCrianca(int idade){
        cm.setIdade(idade);
    }
    public void atualizaView(){
        cv.printResponsavelDetalhes(cm.getNome());
       
    }  
}
