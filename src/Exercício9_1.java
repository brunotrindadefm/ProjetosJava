import java.util.*;
public class Exercício9_1 {

	public static void main(String[] args) {
		
		String dataNasc;
		String dataHoje;
		Scanner leia = new Scanner (System.in);
		
		System.out.println("Digite a data de nascimento: ");
		dataNasc = leia.nextLine();
		
		System.out.println("Digite a data de hoje: ");
		dataHoje = leia.nextLine();
		
		System.out.println("Idade: " + calcularIdade(dataHoje, dataNasc));

	}
	
	public static int calcularIdade(String dataAtual, String dataNascimen) {
		int idade;
		
		idade = Integer.parseInt(dataAtual.substring(6)) - Integer.parseInt(dataNascimen.substring(6));
		
		if ( Integer.parseInt(dataAtual.substring(0,2)) < Integer.parseInt(dataNascimen.substring(0, 2)) && Integer.parseInt(dataAtual.substring(3,5)) < Integer.parseInt(dataNascimen.substring(3, 5))) {
			idade = idade - 1;
		}
		
		return idade;
	}
}
