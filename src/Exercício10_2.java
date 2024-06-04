import java.util.*;

public class Exercício10_2 {
	public static void main(String[] args) {

		String nome;
		boolean valido = true;
		Scanner leia = new Scanner(System.in);

		for (int i = 0; i <= 29; i++) {

			do {
				System.out.println("Digite o nome para ser gerado um login e uma senha (fim p/ finalizar): ");
				nome = leia.nextLine();

				if (nome.equalsIgnoreCase("fim")) {
					break;
				}

				if (nome.length() <= 14) {
					System.out.println("O nome deverá ter pelo menos 15 caracteres!");
					valido = false;
				}

				if (nome.charAt(0) == ' ') {
					System.out.println("Não deve existir espaço antes do primeiro nome!");
					valido = false;
				}

				for (int j = 1; j < nome.length(); j++) {

					if (nome.charAt(j) == ' ' && nome.charAt(j + 1) == ' ') {
						System.out.println("Deve existir apenas um espaço entre os nomes!");
						valido = false;
						break;
					}
				}

				String espaco = " ";
				if (!nome.contains(espaco)) {
					System.out.println("O nome deverá ter nome e sobrenome!");
					valido = false;
				}

				for (int j = 0; j < nome.length(); j++) {
					if (nome.charAt(j) != ' ') {
						if (nome.charAt(j) < 'A' || nome.charAt(j) > 'Z' && nome.charAt(j) < 'a'
								|| nome.charAt(j) > 'z') {
							System.out.println("Digite letras!");
							valido = false;
							break;
						}
					}
				}

			} while (!valido);

			if (nome.equalsIgnoreCase("fim")) {
				break;
			}

			String login = login(nome);
			System.out.println("Login: " + login);
			System.out.println("Senha: " + senha(login));
		}

	}

	public static String login(String nome) {
		String login = nome.substring(0, 1);

		for (int i = 1; i < nome.length(); i++) {
			if (nome.charAt(i) == ' ') {
				login = login + nome.charAt(i + 1);
				login = login.toUpperCase();
			}
		}

		return login;

	}

	public static String senha(String login) {
		String senha = "";
		String logins = "";

		for (int i = 0; i < login.length(); i++) {
			logins = String.valueOf((int) login.charAt(i));
			senha = senha + logins.charAt(0);
		}

		return senha;

	}
}