package biblioteca.usuario;

import biblioteca.itens.Livro;

public class UsuarioProfessor extends Usuario{

    public UsuarioProfessor(Integer id, String st) {
        super(id, st);
    }

    public boolean bloqueiaLivro(Livro it, int prazo) {
        return it.bloqueia((Usuario)this, prazo);
    }
    
    public boolean desbloqueiaLivro (Livro it) {
        return it.desbloqueia((Usuario)this);
    }
    
    public int getCargaLimite(){
        return 5;
    }
    
    @Override
    public int getPrazoMaximo(){
        return 14;
    }
    
    @Override
    public boolean isProfessor(){
        return true;
    }
    
    @Override
    public String toString(){
        return "Prof. "+super.getNome();
    }

}