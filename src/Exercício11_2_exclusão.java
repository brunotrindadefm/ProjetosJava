import java.util.*;
import java.io.*;

public class Exercício11_2_exclusão {

	public static class Cliente {
		char ativo;
		String codCliente;
		String nomeCliente;
		float vlrCompra;
		String anoPrimeiraCompra;
		boolean emDia;
	}

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		Cliente cliente = new Cliente();
		RandomAccessFile arqCliente;
		String codClienteChave;
		boolean encontrou;
		long posicaoReg = 0;
		char certeza;

		do {
			do {
				System.out.println("\n########## EXCLUSÃO DE CLIENTES ##########");
				System.out.println("Digite o código do cliente que quer excluir ('fim p/ finalizar): ");
				codClienteChave = leia.nextLine();

				if (codClienteChave.equalsIgnoreCase("fim")) {
					System.out.println("\n############## Programa encerrado ##############");
					break;
				}

				encontrou = false;

				try {

					arqCliente = new RandomAccessFile("CLIENTES.DAT", "rw");

					while (true) {

						posicaoReg = arqCliente.getFilePointer();
						cliente.ativo = arqCliente.readChar();
						cliente.codCliente = arqCliente.readUTF();
						cliente.nomeCliente = arqCliente.readUTF();
						cliente.vlrCompra = arqCliente.readFloat();
						cliente.anoPrimeiraCompra = arqCliente.readUTF();
						cliente.emDia = arqCliente.readBoolean();

						if (codClienteChave.equals(cliente.codCliente) && cliente.ativo == 'S') {
							encontrou = true;
							break;
						}

					}

				} catch (EOFException e) {
					System.out.println("Código do cliente não encontrado. Enter para digitar novamente...");
					encontrou = false;
					leia.nextLine();
				} catch (IOException e) {
					System.out.println("Erro ao abrir o arquivo. - O programa será encerrado.");
					System.exit(0);
				}
			} while (!encontrou);

			if (codClienteChave.equalsIgnoreCase("fim")) {
				break;
			}

			cliente.ativo = 'N';
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

			do {
				System.out.println("Tem certeza que deseja excluir o cliente S/N ?");
				certeza = leia.next().charAt(0);
				if (certeza == 'S') {
					try {
						arqCliente = new RandomAccessFile("CLIENTES.DAT", "rw");

						arqCliente.seek(posicaoReg);
						arqCliente.writeChar(cliente.ativo);
						arqCliente.close();

						System.out.println("Cliente excluido com sucesso! Enter para continuar...");
						leia.nextLine();

					} catch (IOException e) {
						System.out.println("Erro ao abrir o arquivo. - O programa será encerrado.");
						System.exit(0);
					}
				}

			} while (certeza != 'S' && certeza != 'N');
			leia.nextLine();
		} while (!codClienteChave.equalsIgnoreCase("fim"));

	}

}
