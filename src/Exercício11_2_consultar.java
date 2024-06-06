import java.util.*;
import java.io.*;

public class Exercício11_2_consultar {

	public static class Cliente {
		char ativo;
		String codCliente;
		String nomeCliente;
		float vlrCompra;
		String anoPrimeiraCompra;
		boolean emDia;
	}

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		Scanner leia = new Scanner(System.in);
		RandomAccessFile arqCliente;
		String codClienteChave;
		byte escolha = 0;

		do {
			System.out.println(" ########## CONSULTA DE CLIENTES ##########");
			System.out.println(" [1] CONSULTAR APENAS 1 CLIENTE ");
			System.out.println(" [2] LISTA DE TODOS OS CLIENTES ");
			System.out.println(" [0] SAIR");
			do {
				System.out.print("\nEscolha entre as opções: ");
				escolha = leia.nextByte();
				if (escolha < 0 || escolha > 2) {
					System.out.println("Escolha inválida, digite novamente.\n");
				}
			} while (escolha < 0 || escolha > 2);

			if (escolha == 0) {
				System.out.println("\n############## Programa encerrado ##############");
			} else if (escolha == 1) {
				leia.nextLine();
				System.out.println("Digite o código do cliente para ver seu registro: ");
				codClienteChave = leia.nextLine();

				if (codClienteChave.equalsIgnoreCase("fim")) {
					break;
				}

				try {

					arqCliente = new RandomAccessFile("CLIENTES.DAT", "rw");

					while (true) {

						cliente.ativo = arqCliente.readChar();
						cliente.codCliente = arqCliente.readUTF();
						cliente.nomeCliente = arqCliente.readUTF();
						cliente.vlrCompra = arqCliente.readFloat();
						cliente.anoPrimeiraCompra = arqCliente.readUTF();
						cliente.emDia = arqCliente.readBoolean();

						if (codClienteChave.equals(cliente.codCliente) && cliente.ativo == 'S') {
							imprimirAluno(cliente);
							System.out.println("Fim do registro. Enter para continuar...");
							leia.nextLine();
							break;
						}

					}

				} catch (EOFException e) {
					System.out.println(
							"Código do cliente não encontrado. - Confira se digitou corretamente. \nEnter para continuar...");
					leia.nextLine();
				} catch (IOException e) {
					System.out.println("Erro ao abrir o arquivo. - O programa será encerrado.");
					System.exit(0);
				}
			} else if (escolha == 2) {

				try {
					arqCliente = new RandomAccessFile("CLIENTES.DAT", "rw");

					while (true) {

						cliente.ativo = arqCliente.readChar();
						cliente.codCliente = arqCliente.readUTF();
						cliente.nomeCliente = arqCliente.readUTF();
						cliente.vlrCompra = arqCliente.readFloat();
						cliente.anoPrimeiraCompra = arqCliente.readUTF();
						cliente.emDia = arqCliente.readBoolean();

						if (cliente.ativo == 'S') {
							imprimirAluno(cliente);
						}

					}
				} catch (EOFException e) {
					leia.nextLine();
					System.out.println("\nFim do registro. Enter para continuar...");
					leia.nextLine();
				} catch (IOException e) {
					System.out.println("Erro ao abrir o arquivo. - O programa será encerrado.");
					System.exit(0);
				}
			}
		} while (escolha != 0);

	}

	public static void imprimirAluno(Cliente cliente) {
		char emdia;
		System.out.println("\n" + cliente.nomeCliente);
		System.out.println(cliente.vlrCompra);
		System.out.println(cliente.anoPrimeiraCompra);
		if (cliente.emDia == true) {
			emdia = 'S';
		} else {
			emdia = 'N';
		}
		System.out.println(emdia);

	}

}
