package biblioteca.emprestimo;

import biblioteca.itens.Livro;
import biblioteca.usuario.Usuario;

public class Periodico extends Livro {

    public Periodico(String tit){
        super(tit);
    }

    @Override
    public boolean empresta(Usuario u, int prazo) {
        if(u.isProfessor()){
            return super.empresta (u, 7);
        }
        else{
            return false;
        }
    }
}