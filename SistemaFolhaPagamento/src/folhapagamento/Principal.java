package folhapagamento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import folhapagamento.funcionario.Funcionario;
import folhapagamento.funcionario.FuncionarioComissionado;
import folhapagamento.funcionario.FuncionarioMensalista;

/**
* @author analiviameister
*/
public class Principal {

	private static List<Funcionario> funcionarios = new ArrayList<>();
	
	private static void cargaInicial() {
		funcionarios.add(new FuncionarioComissionado("Toretto", new Date(), 5000.00f));
		funcionarios.add(new FuncionarioMensalista("Brian", new Date(), 7500.00f));
	}
	
	public static void main(String[] args) {
		cargaInicial();
		
		// Input pelo console
		Scanner scanner = new Scanner(System.in);
		
		InterfaceConsole.printMenu();
		while (true) {

            String input = scanner.nextLine();

            if ("0".equals(input.trim())) {
                System.out.println("Sair!");
                break;
            } else {
            	switch (input) {
				case "1":
					InterfaceConsole.printFuncionarios(funcionarios);
					InterfaceConsole.printMenu();
					break;
				case "2":
					InterfaceConsole.printEventos(scanner, funcionarios);
					InterfaceConsole.printMenu();
					break;
				default:
					System.out.println("Opcao nao reconhecida!");
					InterfaceConsole.printMenu();
					break;
				}
            }
        }
		
        scanner.close();
	}
	
}
