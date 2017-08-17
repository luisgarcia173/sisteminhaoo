package biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import biblioteca.itens.Dvd;
import biblioteca.itens.Item;
import biblioteca.itens.Livro;
import biblioteca.usuario.Usuario;
import biblioteca.usuario.UsuarioAluno;
import biblioteca.usuario.UsuarioProfessor;

public class Principal {

	private static List<Item> livros = new ArrayList<>();
	private static List<Item> dvds = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();

	private static void cargaInicial() {
		livros.add(new Livro("Harry Potter"));
		livros.add(new Livro("Jogos Vorazes"));
		livros.add(new Livro("Percy Jackson"));
		
		dvds.add(new Dvd("Velozes e Furiosos 5"));
		dvds.add(new Dvd("Velozes e Furiosos 6"));
		dvds.add(new Dvd("Velozes e Furiosos 7"));
		
		usuarios.add(new UsuarioAluno(1, "Aluno A", new Date()));
		usuarios.add(new UsuarioProfessor(2, "Professor B"));
		usuarios.add(new Usuario(3, "Usuario C"));
	}
	
	public static void main(String[] args) {

		// Carga Inicial
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
					InterfaceConsole.printOpcoes(scanner, usuarios, livros, dvds);
					break;
				case "2":
					//atendimento();
					break;
				default:
					System.out.println("Opcao nao reconhecida!");
					InterfaceConsole.printMenu();
					break;
				}
            }
        }
		
        scanner.close();
	

		// atendimento: emprestimo, devolucaoo, bloqueio e desbloqueio de livros

		// o atendimento deve ser iniciado com a solicitação de um número de
		// usuário
		// retirada de livros,
		// devolução e consulta da situação do usuári

		// Adicionalmente, devem ser oferecidas as opções de bloqueio e
		// desbloqueio para professores
		// Nas operações de retirada, devolução, bloqueio edesbloqueio o
		// programa
		// exibe a situação do livro antes da operação, e caso a mesma seja
		// aceita,
		// o seu estado após operação

	}
}