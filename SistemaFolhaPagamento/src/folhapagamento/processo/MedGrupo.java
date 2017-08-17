package folhapagamento.processo;

import folhapagamento.processo.interfaces.InterfaceConvenio;
import folhapagamento.processo.interfaces.InterfaceFolha;

/**
* @author analiviameister
*/
public class MedGrupo implements InterfaceConvenio {

	@Override
	public void processaContrato(String id, InterfaceFolha f) throws Exception {
		if (id.equals("1")) {
			f.incluiDebito("Convenio MedGrupo", 30);
		} else {
			throw new Exception();
		}
	}

}
