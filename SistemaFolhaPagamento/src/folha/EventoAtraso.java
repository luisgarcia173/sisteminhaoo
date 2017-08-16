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

public class EventoAtraso extends Evento{
    
    public EventoAtraso(Date dt, double qtd) throws FolhaException {   
        super(dt, qtd);
        if (qtd > 2)
            throw new FolhaException("Atraso com qtde. horas > 2");  
    }
    
}
