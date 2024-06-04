import java.util.*;

public class Exercício9_4 {

	public static void main(String[] args) {

		String placaVeiculo;
		String dataMulta;
		float valorMulta;
		int contMultas = 0;
		float somaValorMulta = 0;
		float menorMulta = 999999;
		boolean valido;
		Scanner leia = new Scanner(System.in);

		while (true) {
			do {
				System.out.println("Placa do veículo: ");
				placaVeiculo = leia.nextLine();
				if (placaVeiculo.equalsIgnoreCase("fim")) {
					break;
				}
				valido = placaEhValida(placaVeiculo);
				if (!valido) {
					System.out.println("Placa inválida!");
				}
			} while (!valido);

			if (placaVeiculo.equalsIgnoreCase("fim")) {
				break;
			}

			do {
				System.out.println("Data da multa: ");
				dataMulta = leia.nextLine();
				valido = dataEhValida(dataMulta);
				if (!valido) {
					System.out.println("Data não permitida! ");
				}
			} while (!valido);

			do {
				System.out.println("Valor da multa: ");
				valorMulta = leia.nextFloat();
				leia.nextLine();
				if (valorMulta <= 0) {
					System.out.println("O valor da multa deverá ser maior que 0!");
				}
			} while (valorMulta <= 0);

			if (valorMulta < menorMulta) {
				menorMulta = valorMulta;
			}

			contMultas++;
			somaValorMulta = somaValorMulta + valorMulta;

		}

		System.out.println("Soma das multas: " + somaValorMulta);

		System.out.println("Menor multa: " + menorMulta);

		System.out.println("Média das multas: " + (somaValorMulta / contMultas));

	}

	public static boolean dataEhValida(String data) {
		boolean valido = true;
		int mes = Integer.parseInt(data.substring(3, 5));
		int dia = Integer.parseInt(data.substring(0, 2));
		int ano = Integer.parseInt(data.substring(6));

		if (data.length() != 10) {
			valido = false;
		}
		if (data.charAt(2) != '/' || data.charAt(5) != '/') {
			valido = false;
		}
		if (mes > 12 && mes < 1) {
			valido = false;
		}
		if (ano > 2024) {
			valido = false;
		}
		if (ano == 2024) {
			if (mes > 06) {
				valido = false;
			} else if (mes == 05) {
				if (dia > 22) {
					valido = false;
				}
			}
		}
		if (mes == 04 || mes == 06 || data.charAt(4) == '9' || mes == 11) {
			if (dia >= 30 || dia <= 0) {
				valido = false;
			}
		} else {
			if (dia >= 32 || dia <= 0) {
				valido = false;
			}
		}
		if (mes == 02) {
			if (ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0) {
				if (dia >= 30 || dia <= 0) {
					valido = false;
				}
			} else if (dia >= 29 || dia <= 0) {
				valido = false;
			}
		}
		return valido;
	}

	public static boolean placaEhValida(String placa) {
		boolean valido = true;

		if (placa.length() != 7) {
			valido = false;
		}

		for (int i = 0; i <= 2; i++) {
			if (!Character.isUpperCase(placa.charAt(i))) {
				valido = false;
			}
		}
		for (int i = 3; i <= 6; i++) {
			if (!Character.isDigit(placa.charAt(i))) {
				valido = false;
			}
		}
		// if (!placa.substring(0, 3).matches("[A-Z]*") &&
		// placa.substring(3).matches("[0-9]*")) {
		// valido = false;
		// }
		return valido;
	}

}