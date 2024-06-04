import java.util.*;

public class Exercício8_1 {

	public static void main(String[] args) {

		int numA;
		int numB;
		int numC;

		Scanner leia = new Scanner(System.in);

		System.out.println("Digite o valor do número A: ");
		numA = leia.nextInt();
		System.out.println("Digite o valor do número B: ");
		numB = leia.nextInt();
		System.out.println("Digite o valor do número C: ");
		numC = leia.nextInt();

		System.out.println("Resultado do método a: " + calcular1(numA, numB));
		
		calcular2(numA,numB,numC);

		System.out.println("Resultado do método c: " + calcular3(numA, numC));
	}

	public static int calcular1(int a, int b) {
		int soma = 0;
		for (int x = a + 1; x < b; x++) {
			soma = soma + x;
		}
		return soma;
	}

	public static void calcular2(int a, int b, int c) {
		for (int x = a + 1; x < b; x++) {
			if (x % c == 0) {
				System.out.println("Número " + x + " é divisível por " + c);
			}
		}
	}

	public static float calcular3(float a, float b) {
		float percent = (b / a) * 100;
		return percent;
	}

}
