/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.itens;

/**
 *
 * @author analiviameister
 */
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import biblioteca.usuario.Usuario;

/**
 *
 * @author analiviameister
 */
public abstract class Item {

	String titulo;
	Usuario retiradoPor;
	Date dtEmprestimo;
	Date dtDevolucao;

	Usuario bloqueadoPor;
	Date dtDesbloqueio;
	Date dtBloqueio;

	public Item(String tit) {
		titulo = tit;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isEmprestado() {
		return (!(retiradoPor == null));
	}

	public boolean isEmAtraso() {
		Date hoje = new Date();
		return (isEmprestado() && dtDevolucao.before(hoje));
	}

	public boolean isDisponivel() {
		Date hoje = new Date();
		return this.retiradoPor == null && (this.bloqueadoPor == null || this.dtDesbloqueio.before(hoje));

	}

	public boolean isBloqueado() {
		Date hoje = new Date();
		return this.retiradoPor == null && !(this.bloqueadoPor == null) && !(this.dtDesbloqueio.before(hoje));
	}

	public boolean empresta(Usuario u, int prazo) {
		GregorianCalendar cal = new GregorianCalendar();
		if (isDisponivel()) {
			retiradoPor = u;
			dtEmprestimo = cal.getTime();
			cal.add(Calendar.DATE, prazo);
			dtDevolucao = cal.getTime();
			return (true);
		} else
			return (false);
	}

	public boolean bloqueia(Usuario u, int prazo) {
		GregorianCalendar cal = new GregorianCalendar();
		if (this.isDisponivel() && u.isProfessor()) {
			this.bloqueadoPor = u;
			this.dtBloqueio = cal.getTime();
			cal.add(Calendar.DATE, (prazo > 20 ? 20 : prazo));
			this.dtDesbloqueio = cal.getTime();
			return true;
		}
		return false;
	}

	public boolean desbloqueia(Usuario u) {
		if (u == this.bloqueadoPor) {
			this.bloqueadoPor = null;
			return true;
		}
		return false;
	}

	public boolean retorna(Usuario u) {
		if (u == retiradoPor) {
			retiradoPor = null;
			return (true);
		} else
			return (false);
	}

}
