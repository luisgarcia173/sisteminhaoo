package folhapagamento.evento;

import java.util.Date;

/**
* @author analiviameister
*/
public class EventoFalta extends Evento {

	public EventoFalta(Date dt, float val) {
		super(dt, 0);
	}

	public String toString() {
		return super.getTipoEvento() + " em " + DATE_FORMAT.format(super.getDtEvento());
	}

}
