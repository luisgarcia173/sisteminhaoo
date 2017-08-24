package folhapagamento;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import folhapagamento.evento.Evento;
import folhapagamento.evento.EventoAtraso;
import folhapagamento.evento.EventoComissao;
import folhapagamento.evento.EventoFalta;
import folhapagamento.evento.EventoHoraExtra;
import folhapagamento.evento.EventoReajuste;
import folhapagamento.evento.EventoRescisao;
import folhapagamento.exception.FolhaException;
import folhapagamento.funcionario.Funcionario;

/**
* @author analiviameister
*/
public class InterfaceConsole {

	public static void printMenu() {
		System.out.println("\nSelecione uma opcao");
		System.out.println("1: Funcionarios");
		System.out.println("2: Eventos");
		System.out.println("0: Sair");
		System.out.print("> ");
	}
	
	public static void printFuncionarios(List<Funcionario> funcionarios) {
		System.out.println("\nFuncionarios");
		int i = 1;
		for (Funcionario funcionario : funcionarios) {
			System.out.println(i + ": "  + funcionario.toString());
			i++;
		}
		System.out.println("\n");
	}
	
	public static void printEventos(Scanner scanner, List<Funcionario> funcionarios) {
		System.out.println("\nEventos");
		System.out.println("1: Atraso");
		System.out.println("2: Comissao");
		System.out.println("3: Falta");
		System.out.println("4: HE (Hora Extra)");
		System.out.println("5: Reajuste");
		System.out.println("6: Rescisao");
		System.out.println("0: Menu");
		System.out.print("> ");
		
		String input = scanner.nextLine();
		
		switch (input) {
		case "1":
			System.out.print("Digite a quantidade de atraso: ");
			String valorAtraso = scanner.nextLine();
			try {
				Evento evento = new EventoAtraso(new Date(), Float.parseFloat(valorAtraso));
				registraEvento(scanner, funcionarios, evento);
				System.out.println("Evento registrado com sucesso!");
			} catch (NumberFormatException | FolhaException e) {
				System.out.println("Erro: " + e.getMessage());
			}
			break;
		case "2":
			System.out.print("Digite a quantidade de comissao: ");
			String valorComissao = scanner.nextLine();
			try {
				Evento evento = new EventoComissao(new Date(), Float.parseFloat(valorComissao));
				registraEvento(scanner, funcionarios, evento);
				System.out.println("Evento registrado com sucesso!");
			} catch (NumberFormatException | FolhaException e) {
				System.out.println("Erro: " + e.getMessage());
			}
			break;
		case "3":
			try {
				registraEvento(scanner, funcionarios, new EventoFalta(new Date(), 0));
				System.out.println("Evento registrado com sucesso!");
			} catch (NumberFormatException | FolhaException e) {
				System.out.println("Erro: " + e.getMessage());
			}
			break;
		case "4":
			System.out.print("Digite a quantidade de Hora Extra: ");
			String valorHE = scanner.nextLine();
			try {
				Evento evento = new EventoHoraExtra(new Date(), Float.parseFloat(valorHE));
				registraEvento(scanner, funcionarios, evento);
				System.out.println("Evento registrado com sucesso!");
			} catch (NumberFormatException | FolhaException e) {
				System.out.println("Erro: " + e.getMessage());
			}
			break;
		case "5":
			System.out.print("Digite a quantidade de Reajuste: ");
			String valorReajuste = scanner.nextLine();
			try {
				Evento evento = new EventoReajuste(new Date(), Float.parseFloat(valorReajuste));
				registraEvento(scanner, funcionarios, evento);
				System.out.println("Evento registrado com sucesso!");
			} catch (NumberFormatException | FolhaException e) {
				System.out.println("Erro: " + e.getMessage());
			}
			break;
		case "6":
			System.out.print("[1]Se Demitiu ou [2]Foi Demitido ou [3]Aposentado: ");
			String tipoRescisao = scanner.nextLine();
			System.out.print("Cumpriu aviso previo? [S/N]: ");
			String cumpriuAP = scanner.nextLine();
			try {
				Evento evento = new EventoRescisao(new Date(), Integer.parseInt(tipoRescisao), cumpriuAP.equalsIgnoreCase("S") ? true : false);
				registraEvento(scanner, funcionarios, evento);
				System.out.println("Evento registrado com sucesso!");
			} catch (NumberFormatException | FolhaException e) {
				System.out.println("Erro: " + e.getMessage());
			}
			break;
		default:
			System.out.println("Opcao nao reconhecida!");
			break;
		}
	}
	
	private static void registraEvento(Scanner scanner, List<Funcionario> funcionarios, Evento evento) throws FolhaException {
		printFuncionarios(funcionarios);
		System.out.print("Digite o numero do funcionario: ");
		String idFuncionario = scanner.nextLine();
		Funcionario funcionario = funcionarios.get((Integer.parseInt(idFuncionario) - 1));
		funcionario.registraEvento(evento);
	}
	
}
