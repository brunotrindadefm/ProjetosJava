import java.util.*;

public class Exercício9_2 {

	public static void main(String[] args) {

		String codigo;
		boolean valido = true;
		Scanner leia = new Scanner(System.in);

		do {
			System.out.println("Digite seu código: ");
			codigo = leia.nextLine();

			if (codigo.length() != 11) {
				System.out.println("Inválido! São 11 dígitos");
				valido = false;
			} else {
				for (int x = 0; x <= 10; x++) {
					if (Character.digit(codigo.charAt(x), 10) == -1) {
						System.out.println("Inválido! Digite apenas números.");
						valido = false;
						break;
					}
				}
			}
			if (verificador(codigo) == true) {
				System.out.println("Digitos corretos! ");
			} else {
				System.out.println("Digitos inválidos!");
			}
		} while (!valido);

	}

	public static boolean verificador(String codigo) {
		boolean verificado = false;
		int soma = 0;
		int multiplicacao = 1;
		int numero;

		for (int x = 0; x <= 8; x++) {
			numero = Character.digit(codigo.charAt(x), 10);
			soma = soma + numero;
			multiplicacao = multiplicacao * numero;
		}
		int resultado1 = soma / 10;
		int resultado2 = multiplicacao % 10;
		int numero1 = Integer.parseInt(codigo.substring(9, 10));
		int numero2 = Integer.parseInt(codigo.substring(10));
		if (resultado1 == numero1 && resultado2 == numero2) {
			verificado = true;
		}
		return verificado;
	}

}
