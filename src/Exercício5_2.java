import java.util.*;
public class Exercício5_2 {
    public static void main(String[] args) {
		
		int notas = 0;
		int cont;
		int frequencia[] = new int [11];
		Scanner leia = new Scanner (System.in);
		
		for (cont = 0; cont <= 99; cont++) {
			System.out.println("Digite as notas do aluno " + (cont + 1) + " :");
			notas = leia.nextInt();
			frequencia[notas]++;
			
		}
		for (cont = 0; cont <= 10; cont++) {
		System.out.println("Nota " + cont +" Frequências: " + frequencia[cont]);
		}
		}
	}
