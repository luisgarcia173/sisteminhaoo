package biblioteca;

import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

import biblioteca.itens.Dvd;
import biblioteca.itens.Item;
import biblioteca.itens.Livro;
import biblioteca.itens.TipoItem;
import biblioteca.usuario.TipoUsuario;
import biblioteca.usuario.Usuario;
import biblioteca.usuario.UsuarioAluno;
import biblioteca.usuario.UsuarioProfessor;

public class InterfaceConsole {

	public static void printMenu() {
		System.out.println("\nSelecione uma opcao");
		System.out.println("1: Cadastro");
		System.out.println("2: Atendimento");
		System.out.println("0: Sair");
		System.out.print("> ");
	}
	
	public static void printOpcoes(Scanner scanner, List<Usuario> usuarios, List<Item> livros, List<Item> dvds) {
		System.out.println("\nCadastro");
		System.out.println("1: Aluno");
		System.out.println("2: Professor");
		System.out.println("3: Usuario");
		System.out.println("4: Livro");
		System.out.println("5: DVD");
		System.out.println("0: Menu");
		System.out.print("> ");
		
		String input = scanner.nextLine();
		
		switch (input) {
		case "1":
			printCadastro(scanner, usuarios, null, TipoUsuario.ALUNO, null);
			break;
		case "2":
			printCadastro(scanner, usuarios, null, TipoUsuario.PROFESSOR, null);
			break;
		case "3":
			printCadastro(scanner, usuarios, null, TipoUsuario.COMUM, null);
			break;
		case "4":
			printCadastro(scanner, null, livros, null, TipoItem.LIVRO);
			break;
		case "5":
			printCadastro(scanner, null, dvds, null, TipoItem.DVD);
			break;
		default:
			printMenu();
			break;
		}
	}
	
	private static void printCadastro(Scanner scanner, List<Usuario> usuarios, List<Item> itens, TipoUsuario tipoUsuario, TipoItem tipoItem) {
		boolean isUsuario = false;
		if (usuarios != null && usuarios.size() > 0) {
			isUsuario = true;
			System.out.println("\nListando Usuarios:");
			for (Usuario usuario : usuarios) {
				System.out.println(usuario.getId() +": "+ usuario.getNome());
			}
		}
		
		if (itens != null && itens.size() > 0) {
			System.out.println("\nListando Itens:");
			for (Item item: itens) {
				System.out.println(item.getTitulo());
			}
		}
		
		System.out.println("\nSelecione uma opcao");
		System.out.println("1: Incluir");
		System.out.println("2: Remover");
		System.out.println("0: Menu");
		System.out.print("> ");
		
		String input = scanner.nextLine();
		
		switch (input) {
		case "1":
			if (isUsuario) {
				System.out.print("Nome do Usuario: ");
				input = scanner.nextLine();
				if (TipoUsuario.ALUNO.equals(tipoUsuario)) {
					usuarios.add(new UsuarioAluno(new Random(1000).nextInt(), input, new Date()));
				} else if (TipoUsuario.PROFESSOR.equals(tipoUsuario)) {
					usuarios.add(new UsuarioProfessor(new Random(1000).nextInt(), input));
				} else {
					usuarios.add(new Usuario(new Random(1000).nextInt(), input));
				}
			} else {
				System.out.print("Nome do Item: ");
				input = scanner.nextLine();
				if (TipoItem.LIVRO.equals(tipoItem)) {
					itens.add(new Livro(input));
				} else {
					itens.add(new Dvd(input));
				}
			}
			break;
		case "2":
			if (isUsuario) {
				System.out.print("Remover usuario: ");
				input = scanner.nextLine();
				ListIterator<Usuario> iter = usuarios.listIterator();
				boolean removed = false;
				while(iter.hasNext()){
				    if(iter.next().getNome().equalsIgnoreCase(input)){
				        iter.remove();
				        removed = true;
				        break;
				    }
				}
				if (removed) {
					System.out.println(input + " removido com sucesso!");
				} else {
					System.out.println(input + " nao encontrado!");
				}
			} else {
				System.out.print("Remover item: ");
				input = scanner.nextLine();
				ListIterator<Item> iter = itens.listIterator();
				boolean removed = false;
				while(iter.hasNext()){
				    if(iter.next().getTitulo().equalsIgnoreCase(input)){
				        iter.remove();
				        removed = true;
				        break;
				    }
				}
				if (removed) {
					System.out.println(input + " removido com sucesso!");
				} else {
					System.out.println(input + " nao encontrado!");
				}
			}
			break;
		default:
			break;
		}
		printMenu();
	}
}
