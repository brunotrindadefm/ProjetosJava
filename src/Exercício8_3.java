import java.util.*;
 
public class Exercício8_3 {
 
	static String vetCidades[] = { "BELO HORIZONTE", "SÃO PAULO", "RIO DE JANEIRO", "SALVADOR", "CURITIBA" };
	static int i;
 
	public static void main(String[] args) {
 
		String nome[] = new String[100];
		float vlrConta[] = new float[100];
		int diaEntrada;
		int diaSaida;
		String tipoQuarto;
		String cidadeHotel;
		boolean hotel;
		Scanner leia = new Scanner(System.in);
 
		for (i = 0; i < 100; i++) {
			System.out.println("Qual o nome do hóspede: ");
			nome[i] = leia.nextLine();
			if (nome[i].equalsIgnoreCase("fim")) {
				i--;
				break;
			}
 
			do {
				System.out.println("Qual o dia de entrada do " + nome[i] + " :");
				diaEntrada = leia.nextInt();
 
				System.out.println("Qual o dia de saída do " + nome[i] + " :");
				diaSaida = leia.nextInt();
 
				if (diaEntrada >= diaSaida) {
					System.out.println("O numero de saida deve ser maior que o numero de entrada!");
				}
 
			} while (diaEntrada > diaSaida);
 
			leia.nextLine();
 
			do {
				System.out.println("Qual o tipo de quarto: ");
				tipoQuarto = leia.nextLine();
 
				if (!tipoQuarto.equalsIgnoreCase("luxo") && !tipoQuarto.equalsIgnoreCase("super-luxo")
						&& !tipoQuarto.equalsIgnoreCase("standart")) {
					System.out.println("Digte luxo, super-luxo ou standart!");
				}
 
			} while (!tipoQuarto.equalsIgnoreCase("luxo") && !tipoQuarto.equalsIgnoreCase("super-luxo")
					&& !tipoQuarto.equalsIgnoreCase("standart"));
 
			do {
				System.out.println("Qual a cidade do hotel: ");
				cidadeHotel = leia.nextLine();
 
				hotel = cidadeEhValida(cidadeHotel);
				
				if (hotel == false) {
					System.out.println("Não temos hotel nessa cidade!");
				}
			} while (hotel == false);
 
			vlrConta[i] = calcularConta(diaSaida, diaEntrada, tipoQuarto);
		}
		System.out.print("Nome:       Valor da Conta:");
		for (int f = 0; f <= i; f++) {
			System.out.println("\n" + nome[f] + "      " + vlrConta[f]);
		}
 
	}
 
	public static float calcularConta(int s, int e, String tipoQuarto) {
		float valorConta;
		if (tipoQuarto.equalsIgnoreCase("STANDART")) {
			valorConta = (s - e) * 120;
		} else if (tipoQuarto.equalsIgnoreCase("LUXO")) {
			valorConta = (s - e) * 150;
		} else {
			valorConta = (s - e) * 180;
		}
		return valorConta;
	}
 
	public static boolean cidadeEhValida(String cidadeHotel) {
		boolean encontrou = false;
		for (int j = 0; j <= 4; j++)
			if (cidadeHotel.equalsIgnoreCase(vetCidades[j])) {
				encontrou = true;
			}
		return encontrou;
	}
 
}
 