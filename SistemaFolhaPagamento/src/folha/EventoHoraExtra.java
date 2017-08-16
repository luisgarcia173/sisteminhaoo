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

import excecoes.FolhaException;
import java.util.Date;
public class EventoHoraExtra {
    private double gtdHoras;
    
    public EventoHoraExtra (Date dt, double qtd) throws FolhaException {
        super(dt, qtd);
        if (qtd > 4) 
            throw new FolhaException("HoraExtra com qtde. horas > 4.")
    }
}
