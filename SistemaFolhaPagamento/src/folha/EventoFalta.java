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

public class EventoFalta extends Evento {
    
public EventoFalta(Date dt) {
    super(dt, 0);
} 
 
 public String toString() {
     return super.getTipoEvento() + " em " + super.getDtEvento();  
 }
    
}
