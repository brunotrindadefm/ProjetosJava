import java.util.*;

public class Exercício4_1 {

	public static void main(String[] args) {
		
		String nomeEmpreg;
		double media;
		double salario;
		byte numEmpreg;
		double novoSalario;
		double somaNovoSalario = 0;
		int contSalario = 0;
		float numDependen;
		Scanner leia = new Scanner (System.in);
		
		for (numEmpreg = 1; numEmpreg <= 10; numEmpreg++) {
			System.out.println("Digite o nome do empregado: ");
			nomeEmpreg = leia.nextLine();
			System.out.println("Digite o salário do empregado: ");
			salario = leia.nextInt();
			System.out.println("Digite o número de dependentes: ");
			numDependen = leia.nextByte();
			
			if (salario < 1000) {
			novoSalario = salario + salario * 0.30;
			} else if (salario > 2000) {
				novoSalario = salario + salario * 0.10;
			} else {
				novoSalario = salario + salario * 0.20;
			}
			numDependen = 50 * numDependen;
			novoSalario = novoSalario + numDependen;
			
			somaNovoSalario = novoSalario + somaNovoSalario;
			if (novoSalario > 1700) {
				contSalario++;
			}
			
			System.out.println("Novo salário do empregado: " + novoSalario);
			leia.nextLine();
		}
			media = somaNovoSalario / numEmpreg;
			System.out.println("Soma dos novos salários: " + somaNovoSalario);
			System.out.println("Média dos novos salários: " + media);
			System.out.println("Número de empregados com novo salário acima de 1700: " + contSalario);
		
	}
}