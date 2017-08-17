package folhapagamento.evento;

import java.util.Date;

import folhapagamento.exception.FolhaException;

/**
* @author analiviameister
*/
public class EventoAtraso extends Evento {

	public EventoAtraso(Date dt, float val) throws FolhaException {
		super(dt, val);
		if (val > 2) {
			throw new FolhaException("Atraso com qtde. horas > 2");
		}
	}

}
