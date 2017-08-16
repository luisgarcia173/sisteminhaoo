package biblioteca.usuario;

import java.util.Date;

public class UsuarioAluno extends Usuario{
    private Date dataLimite;

    public UsuarioAluno(Integer id, String st, Date dt){
        super(id, st);
        this.dataLimite=dt;
    }

    public void renovaCartao(Date dt){
        this.dataLimite=dt;
    }

    public boolean isRegular(){
        Date hoje=new Date();
        return dataLimite.after(hoje);
    }

    public boolean isARenovar(){
        return !isRegular();
    }
    
    @Override
    public int getCotaMaxima(){
        return (isRegular() ? 3 : super.getCotaMaxima());
    }
    
    @Override
    public int getPrazoMaximo(){
        return (isRegular()? 7 : super.getPrazoMaximo());
    }
    
    @Override
    public String toString(){
        return("Aluno " + getNome());
    }
    
}