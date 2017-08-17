package folhapagamento.evento;

import java.util.Date;

import folhapagamento.exception.FolhaException;

/**
* @author analiviameister
*/
public class EventoHoraExtra extends Evento {

	public EventoHoraExtra(Date dt, float val) throws FolhaException {
		super(dt, val);
		if (val > 4) {
			throw new FolhaException("HoraExtra com qtde. horas > 4.");
		}
	}
	
}
