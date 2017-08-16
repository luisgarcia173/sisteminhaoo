/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folha;

/**
 *
 * @author analiviameister
 */
public class FolhaException {
    private String descricao;  
    private Funcionario funcionario;  
    private Evento evento;  
    private Exception exception; 
    
    public FolhaException(String st) {   
        this.descricao = st;  
    }
    
    public FolhaException(String st, Funcionario f) {
        this.descricao = st;   
        this.funcionario = f;  
    }
    
    public FolhaException(String st, Funcionario f, Evento e) {   
        this.descricao = st;   
        this.funcionario = f;   
        this.evento = e;  
    } 
    
    public FolhaException(String st, Funcionario f, Exception ex) {   
        this.descricao = st;   
        this.funcionario = f;   
        this.exception = ex;  
    } 
    
    public String toString() {   
        return ("FuncionarioException: " + this.descricao +
                (this.funcionario == null ? " " : "\n " + this.funcionario) +
                (this.evento == null ? " " : "\n " + this.evento) +
                (this.exception == null ? " " : "\n " + this.exception));
    }
    
}
