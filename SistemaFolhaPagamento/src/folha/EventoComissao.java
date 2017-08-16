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

public class EventoComissao extends Evento {
    
    public EventoComissao(Date dt, double val) throws FolhaException {
        super(dt, val);
        if (val <= 0)
            throw new FolhaException("Comissao com valor <= 0.");  
    }
    
}
