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
		this.motivo = tp;
		if (motivo != SE_DEMITIU && motivo != FOI_DEMITIDO && motivo != APOSENTADO) {
			throw new FolhaException("Rescisao com codigo de motivo invalido");
		}
		this.avisoPrevio = av;
	}

	public int getMotivo() {
		return this.motivo;
	}

	public boolean getAvisoPrevio() {
		return this.avisoPrevio;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getTipoEvento()).append(" em ").append(DATE_FORMAT.format(super.getDtEvento()));
		
		String detalheMotivo = "";
		if (this.motivo == 1) {
			detalheMotivo = "Pediu demissao";
		} else if (this.motivo == 2) {
			detalheMotivo = "Foi demitido";
		} else {
			detalheMotivo = "Aposentado";
		}
		sb.append(" > Motivo: ").append(detalheMotivo)
		  .append(" >  Cumpriu aviso previo: ").append(this.avisoPrevio ? "Sim" : "Nao");
		
		return sb.toString();
	}

}
