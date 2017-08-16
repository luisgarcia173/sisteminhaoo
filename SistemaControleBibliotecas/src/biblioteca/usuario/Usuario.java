package biblioteca.usuario;

import java.util.ArrayList;
import java.util.Iterator;

import biblioteca.itens.Livro;

public class Usuario {

	private Integer id;
	private String nome;
	private ArrayList<Livro> livrosRetirados;

	public Usuario(Integer id, String st) {
		this.id = id;
		this.nome = st;
		this.livrosRetirados = new ArrayList<Livro>();
	}

	public boolean retiraLivro(Livro it) {
		if (this.isAptoARetirar()) {
			if (it.empresta(this, getPrazoMaximo())) {
				this.livrosRetirados.add(it);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean devolveLivro(Livro it) {
		if (it.retorna(this)) {
			this.livrosRetirados.remove(it);
			return true;
		} else {
			return false;
		}
	}

	public int getCotaMaxima() {
		return 2;
	}

	public int getPrazoMaximo() {
		return 4;
	}

	public boolean isADevolver() {
		return ((this.livrosRetirados.size() >= this.getCotaMaxima() || this.temPrazoVencido()) ? true : false);
	}

	public boolean isAptoARetirar() {
		return (!this.isADevolver());
	}

	public boolean temPrazoVencido() {
		Iterator<Livro> it = livrosRetirados.iterator();
		while (it.hasNext()) {
			Livro livro = it.next();
			if (livro.isEmAtraso()) {
				return true;
			}
		}
		return false;
	}

	public boolean isProfessor() {
		return false;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return this.nome;
	}

	@Override
	public String toString() {
		return "Usuario " + nome;
	}

	public void listaCarga() {
		System.out.println(
				this.toString() + " Limite: " + this.getCotaMaxima() + " Carga atual: " + this.livrosRetirados.size());
		Iterator<Livro> it = this.livrosRetirados.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
