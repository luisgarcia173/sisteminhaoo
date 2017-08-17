package folhapagamento.evento;

import java.util.Date;

import folhapagamento.exception.FolhaException;

/**
* @author analiviameister
*/
public class EventoComissao extends Evento {

	public EventoComissao(Date dt, float val) throws FolhaException {
		super(dt, val);
		if (val <= 0) {
			throw new FolhaException("Comissao com valor <= 0.");
		}
	}
	
}
