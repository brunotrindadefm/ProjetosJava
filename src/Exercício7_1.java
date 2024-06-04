import java.util.*;

public class Exercício7_1 {

	public static void main(String[] args) {

		String cidade[] = new String[20];
		int distancia[] = new int[20];
		String cidadePesquisa;
		float preco;
		boolean encontrou;
		byte g = 0;
		float tempoVoo;
		int escala;
		Scanner leia = new Scanner(System.in);

		for (byte i = 0; i <= 19; i++) {
			System.out.println("Digite o nome da cidade ('fim' p/ finalizar): ");
			cidade[i] = leia.nextLine();
			if (cidade[i].equals("fim")) {
				break;
			}
			if (cidade[i].equals("")) {
				System.out.println("O preenchimento da cidade deve ser obrigatório!");
				i--;
				continue;
			}

			do {
				System.out.println("Digite a distância em km de " + cidade[i] + " até Belo Horizonte: ");
				distancia[i] = leia.nextInt();
				leia.nextLine();

				if (distancia[i] < 500) {
					System.out.println("A distância até Belo Horizonte deverá ser no mínimo 500 km!");
				}
			} while (distancia[i] < 500);
		}
		do {
			System.out.println("Digite o nome da cidade para ser consultada: ");
			cidadePesquisa = leia.nextLine();
			if (cidadePesquisa.equals("fim")) {
				break;
			}
			encontrou = false;
			for (byte i = 0; i <= 19; i++) {
				if (cidadePesquisa.equals(cidade[i])) {
					encontrou = true;
					g = i;
					break;
				}
			}
			if (encontrou) {
				System.out.println("A cidade " + cidade[g] + " está " + distancia[g] + " KM de Belo Horizonte");
				preco = distancia[g] * (float) 0.25;
				tempoVoo = distancia[g] / (float) 800 * (float) 60;
				escala = (distancia[g] / (int) 800) / (int) 3;
				System.out.println("Preço do voo: " + preco);
				System.out.println("Tempo de voo: " + tempoVoo);
				System.out.println("Número de escalas: " + escala);
			} else {
				System.out.println("Não foi armazenado nada dessa cidade digitada");
			}
		} while (!cidadePesquisa.equals("fim"));

	}

}
