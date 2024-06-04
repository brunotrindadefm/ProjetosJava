import java.util.*;

public class Exercício4_2 {

	public static void main(String[] args) {

		byte voto;
		byte candidato1 = 0, candidato2 = 0, candidato3 = 0;
		byte nulo = 0;
		byte branco = 0;
		byte vencedor;
		Scanner leia = new Scanner (System.in);

		for (int contEleitor = 0; contEleitor <= 150; contEleitor++) {
			
		
			
			do {
				System.out.println("Vote: 1 p/ candidato 1 - 2 p/ candidato 2 \n "
						+ "3 p/ candidato 3 - 4 p/ nulo - 5 p/ votar em branco. \n"
						+ "Vote: ");
				voto = leia.nextByte();
				if (voto <= 0 || voto > 5) {
					System.out.println("Votos são apenas de 1 até 5! \nVote novamente: ");
				}
			} while (voto <= 0 || voto > 5); 
			

			if (voto == 1) {
				candidato1++;
			} else if (voto == 2) {
				candidato2++;
			} else if (voto == 3) {
				candidato3++;
			} else if (voto == 4) {
				nulo++;
			} else {
				branco++;	
			} 		
		}
		if (candidato1 > candidato3 && candidato1 > candidato2); {
			vencedor = 1;
		} if (candidato2 > candidato1 && candidato2 > candidato3); {
			vencedor = 2;
			if (candidato3 > candidato1 && candidato3 > candidato2); {
				vencedor = 3 ;
			}
			System.out.println("Vencedor: " + vencedor);
			System.out.println("Número de votos brancos: " + branco);
			System.out.println("Número de votos nulo: " + nulo);
		}
	}
}
