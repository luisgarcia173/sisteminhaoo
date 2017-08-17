package folhapagamento.evento;

import java.util.Date;

import folhapagamento.exception.FolhaException;

/**
* @author analiviameister
*/
public class EventoRescisao extends Evento {

	private int motivo;
	private boolean avisoPrevio;
	
	public static final int SE_DEMITIU = 1;
	public static final int FOI_DEMITIDO = 2;
	public static final int APOSENTADO = 3;
	public static boolean CUMPRIU_AVISO = true;
	public static boolean AVISO_INDENIZADO = false;

	public EventoRescisao(Date dt, int tp, boolean av) throws FolhaException {
		super(dt, 0);
		if (motivo != SE_DEMITIU && motivo != FOI_DEMITIDO && motivo != APOSENTADO) {
			throw new FolhaException("Rescisao com codigo de motivo invalido");
		}
		this.motivo = tp;
		this.avisoPrevio = av;
	}

	public int getMotivo() {
		return this.motivo;
	}

	public boolean getAvisoPrevio() {
		return this.avisoPrevio;
	}

	public String toString() {
		return super.getTipoEvento() + " em " + super.getDtEvento() + " motivo=" + this.motivo + " aviso previo= "
				+ this.avisoPrevio;
	}

}
