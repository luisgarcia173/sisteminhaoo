/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folha;

/**
 *
 * @author analiviameister
 */
import java.util.Date;
import excecoes.FolhaException;
public class EventoReajuste extends Evento {
    
     public EventoReajuste(Date dt, double val) throws FolhaException {
         super(dt, val);   
         if (val < 300)
             throw new FolhaException("Reajuste com novo salario < 300.");  
     }
    
}
