import java.io.*;
import java.util.*;

public class Exercício11_2_alteração {

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
		RandomAccessFile arqCliente;
		Scanner leia = new Scanner(System.in);
		boolean encontrou;
		String codClienteChave;
		long posicaoReg = 0;
		byte escolha;
		char emdia;
		char confirmacao;

		do {
			do {
				System.out.println("############## Clientes ##############");
				System.out.print(
						"Digite o código do cliente para alterar seu registro \n(fim p/ finalizar o programa): ");
				codClienteChave = leia.nextLine();
				if (codClienteChave.equalsIgnoreCase("fim")) {
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

						if (cliente.codCliente.equals(codClienteChave) && cliente.ativo == 'S') {
							encontrou = true;
							break;
						}
					}
					arqCliente.close();
				} catch (EOFException e) {
					System.out.println("Não foi encontrado o código do cliente. Enter para continuar...");
					encontrou = false;
					leia.nextLine();
				} catch (IOException e) {
					System.out.println("Erro para abrir o arquivo. - O propragama será encerrado.");
					System.exit(0);
				}

			} while (!encontrou);

			if (codClienteChave.equalsIgnoreCase("fim")) {
				System.out.println("############## Programa encerrado ##############");
				break;
			}

			cliente.ativo = 'S';
			cliente.codCliente = codClienteChave;

			if (cliente.emDia = true) {
				emdia = 'S';
			} else {
				emdia = 'N';
			}

			do {
				System.out.println("[ 1 ]Nome do cliente: " + cliente.nomeCliente);
				System.out.println("[ 2 ]Valor da compra do " + cliente.nomeCliente + " : " + cliente.vlrCompra);
				System.out.println("[ 3 ]Ano da primeira compra do: " + cliente.anoPrimeiraCompra);
				System.out.println("[ 4 ] está com as contas em dia: " + emdia);
				do {
					System.out.println("Digite o que deseja alterar (0 p/ finalizar alterações)");
					escolha = leia.nextByte();

					if (escolha < 0 || escolha > 4) {
						System.out.println("Escolha apenas de 0 até 4!");
					}
				} while (escolha < 0 || escolha > 4);

				if (escolha == 1) {
					leia.nextLine();
					System.out.println("Digite o novo nome do cliente: ");
					cliente.nomeCliente = leia.nextLine();
				} else if (escolha == 2) {
					leia.nextLine();
					System.out.println("Digite o novo Valor de compra do cliente ");
					cliente.vlrCompra = leia.nextFloat();
				} else if (escolha == 3) {
					leia.nextLine();
					System.out.println("Digite o novo ano da primeira compra do cliente: ");
					cliente.anoPrimeiraCompra = leia.nextLine();
				} else if (escolha == 4) {
					leia.nextLine();
					System.out.println("Digite se o cliente está em dia S/N: ");
					emdia = leia.next().charAt(0);

					if (emdia == 'S') {
						cliente.emDia = true;
					} else {
						cliente.emDia = false;
					}
				}
			} while (escolha != 0);

			do {
				System.out.println("Tem certeza que deseja alterar o registro S/N ? ");
				confirmacao = leia.next().charAt(0);

				if (confirmacao == 'S') {
					try {
						arqCliente = new RandomAccessFile("CLIENTES.DAT", "rw");

						arqCliente.seek(posicaoReg);

						// Excluindo o outro registro
						arqCliente.writeChar('N');

						// Registrando o novo registro
						arqCliente.seek(arqCliente.length());
						arqCliente.writeChar(cliente.ativo);
						arqCliente.writeUTF(cliente.codCliente);
						arqCliente.writeUTF(cliente.nomeCliente);
						arqCliente.writeFloat(cliente.vlrCompra);
						arqCliente.writeUTF(cliente.anoPrimeiraCompra);
						arqCliente.writeBoolean(cliente.emDia);

						arqCliente.close();

						System.out.println("Dados novos gravados com sucesso! Enter para continuar...");
						leia.nextLine();

					} catch (IOException e) {
						System.out.println("Erro ao gravar o novo registro. - O programa será encerrado");
						System.exit(0);
					}
				}

			} while (confirmacao != 'S' && confirmacao != 'N');
			leia.nextLine();
		} while (!codClienteChave.equalsIgnoreCase("fim"));
		leia.close();
	}

}
