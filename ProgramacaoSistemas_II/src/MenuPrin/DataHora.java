/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuPrin;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kim
 */
public class DataHora {
    

   public String dia_sem,dia_mes,mes,ano,hora;
    SimpleDateFormat formato_hora = new SimpleDateFormat(" HH:mm:ss ");
    
    public void ler_data()
    {
    	Date data = new Date();
    	 // dia_sem = ""+data.getDay();
    	  dia_mes = ""+data.getDate();
    	 // mes     = ""+data.getMonth();
    	  ano    =""+(1900+data.getYear());
    	
    	  switch(data.getDay())
    	  {
    	  case 0: dia_sem = "Domingo";break;
    	  case 1: dia_sem = "Segunda-feira";break;
    	  case 2: dia_sem = "Terça-Feira";break;
    	  case 3: dia_sem = "Quarta-Feira";break;
    	  case 4: dia_sem = "Quinta-Feira";break;
    	  case 6: dia_sem = "Sexta-Feira";break;
    	  case 7: dia_sem = "Sábado";break;
    	  }
    	
    	switch(data.getMonth())
    	{
    	 case 0:  mes = "Janeiro  ";break;
    	 case 1:  mes = "Fevereiro";break;
    	 case 2:  mes = "Março    ";break;
    	 case 3:  mes = "Abril    ";break;
    	 case 4:  mes = "Maio     ";break;
    	 case 5:  mes = "Junho    ";break;
    	 case 6:  mes = "Julho    ";break;
    	 case 7:  mes = "Agosto   ";break;
    	 case 8:  mes = "Setembro ";break; 
    	 case 9:  mes = "Outubro  ";break;
    	 case 10: mes = "Novembro ";break;
    	 case 11: mes = "Dezembro ";break;
    	}
    }
    public void leia_hora()
    {
       Date horas = new Date();
       hora = formato_hora.format(horas);  
    }
}

