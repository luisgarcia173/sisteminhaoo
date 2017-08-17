package folhapagamento.evento;

import java.util.Date;

import folhapagamento.exception.FolhaException;

/**
* @author analiviameister
*/
public class EventoReajuste extends Evento {

	public EventoReajuste(Date dt, float val) throws FolhaException {
		super(dt, val);
		if (val < 300) {
			throw new FolhaException("Reajuste com novo salario < 300.");
		}
	}
	
}
