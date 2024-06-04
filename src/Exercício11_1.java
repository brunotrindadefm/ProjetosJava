import java.io.*;
import java.util.*;

public class Exercício11_1 {
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
		String codClienteChave;
		boolean encontrou;
		char confirmacao;
		char emdia;
		int dia;
		int mes;
		int ano;

		do {
			do {
				do {
					System.out.println("############## Clientes ##############");
					System.out.print("Digite o código do cliente (fim p/ encerrar):");
					codClienteChave = leia.nextLine();

					if (codClienteChave.equalsIgnoreCase("fim")) {
						break;
					}

					if (Integer.parseInt(codClienteChave) <= 0) {
						System.out.println("Código do cliente deve ser maior que 0!");
					}

				} while (Integer.parseInt(codClienteChave) <= 0);

				if (codClienteChave.equalsIgnoreCase("fim")) {
					break;
				}

				encontrou = false;

				try {
					arqCliente = new RandomAccessFile("CLIENTES.DAT", "rw");

					while (true) {
						cliente.ativo = arqCliente.readChar();
						cliente.codCliente = arqCliente.readUTF();
						cliente.nomeCliente = arqCliente.readUTF();
						cliente.vlrCompra = arqCliente.readFloat();
						cliente.anoPrimeiraCompra = arqCliente.readUTF();
						cliente.emDia = arqCliente.readBoolean();

						if (cliente.codCliente.equalsIgnoreCase(codClienteChave) && cliente.ativo == 'S') {
							System.out.println("Código do cliente já está cadastrado! \nDigite novamente.");
							encontrou = true;
							break;
						}
					}

				} catch (EOFException e) {
					encontrou = false;
				} catch (IOException e) {
					System.out.println("Erro na abertura do arquivo. - O arquivo será encerrado.");
					System.exit(0);
				}

			} while (encontrou);
			if (codClienteChave.equalsIgnoreCase("fim")) {
				System.out.println("############## Programa encerrado ##############");
				break;
			}

			cliente.ativo = 'S';
			cliente.codCliente = codClienteChave;
			do {
				System.out.println("Digite o nome do cliente: ");
				cliente.nomeCliente = leia.nextLine();

				if (cliente.nomeCliente.length() < 10) {
					System.out.println("O nome deverá ter no mínimo 10 caracteres!");
				}

			} while (cliente.nomeCliente.length() < 10);

			do {

				System.out.println("Digite o valor da compra: ");
				cliente.vlrCompra = leia.nextFloat();

				if (cliente.vlrCompra <= 0) {
					System.out.println("O valor da compra deve ser maior que zero!");
				}

			} while (cliente.vlrCompra <= 0);

			leia.nextLine();

			do {

				System.out.println("Digite o ano da primeira compra: ");
				cliente.anoPrimeiraCompra = leia.nextLine();
				
				ano = Integer.parseInt(cliente.anoPrimeiraCompra.substring(6));
				mes = Integer.parseInt(cliente.anoPrimeiraCompra.substring(3,5));
				dia = Integer.parseInt(cliente.anoPrimeiraCompra.substring(0,2));

				if (ano >= 2014) {
					System.out.println("O ano da primeira compra deve ser menor ou igual a 2013!");
				}
				if (mes > 12) {
					System.out.println("São 12 meses!");
				}
				if (dia > 31) {
					System.out.println("Os dias são até 31!");
				}

			} while (ano >= 2014 || mes > 12 || dia > 31);

			do {
				System.out.println("Digite se o cliente está com as compras em dia (S/N) para não: ");
				emdia = leia.next().charAt(0);

				if (emdia == 'S') {
					cliente.emDia = true;
				} else {
					cliente.emDia = false;
				}

				if (emdia != 'S' && emdia != 'N') {
					System.out.println("Apenas 'S' pu 'N'!");
				}
			} while (emdia != 'S' && emdia != 'N');

			do {
				System.out.println("Tem certeza que está tudo correto (S/N) ? ");
				confirmacao = leia.next().charAt(0);
				if (confirmacao == 'S') {
					try {
						arqCliente = new RandomAccessFile("CLIENTES.DAT", "rw");

						arqCliente.seek(arqCliente.length());

						arqCliente.writeChar(cliente.ativo);
						arqCliente.writeUTF(cliente.codCliente);
						arqCliente.writeUTF(cliente.nomeCliente);
						arqCliente.writeFloat(cliente.vlrCompra);
						arqCliente.writeUTF(cliente.anoPrimeiraCompra);
						arqCliente.writeBoolean(cliente.emDia);

						arqCliente.close();

						System.out.println("Dados gravados com sucesso! ");

					} catch (IOException e) {
						System.out.println("Erro na gravação dos registros. - Programa será encerrado");
						System.exit(0);
					}
				}

			} while (confirmacao != 'S' && confirmacao != 'N');
			leia.nextLine();
		} while (!codClienteChave.equalsIgnoreCase("fim"));
		leia.close();

	}

}
