/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.itens;

import biblioteca.usuario.TipoUsuario;

/**
 *
 * @author analiviameister
 */
public class Dvd extends Item {
    
	private TipoUsuario privilegio;
	
    public Dvd(String tit) {
        super(tit);
    }

}
