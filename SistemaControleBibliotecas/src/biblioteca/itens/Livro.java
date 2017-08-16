package biblioteca.itens;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Livro extends Item {
    
    public Livro(String tit) {
        super(tit);
    }

    @Override
    public String toString() {
        String st;
        if(isDisponivel()){
            return this.titulo+" disponivel";
        }
        if(isEmprestado()){
            st = " retirado por " + retiradoPor + " em " + dma(dtEmprestimo)+ " ate " + dma(dtDevolucao);
        }
        else{
            st = " bloqueado por " + bloqueadoPor + " em " + dma(dtBloqueio)+ " ate " + dma(dtDesbloqueio);
        }
        return titulo+st;
    }
    
    private String dma(Date dt){
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dt);
    }

}