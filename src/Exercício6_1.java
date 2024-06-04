import java.util.*;

public class Exercício6_1 {

    public static void main(String[] args) {

        String assento[][] = new String[21][7];
        int linha;
        int coluna;
        String nome;
        float valorPassagem;
        float totalFaturado = 0;
        float primeiraClasseFaturado = 0;
        int assentosVagosJanelas = 40;
        int contAssentos = 0;
        Scanner leia = new Scanner(System.in);

        for (byte i = 0; i <= 119; i++) {
            System.out.println("Digite o nome do passageiro (fim p/ fim): ");
            nome = leia.nextLine();

            if (nome.equals("fim")) {
                i--;
                break;
            }

            do {
                System.out.println("Digite em qual fileira " + nome + " irá sentar");
                linha = leia.nextInt();

                if (linha < 1 || linha > 20) {
                    System.out.println("Inválido! São 20 fileiras");
                }
            } while (linha < 1 || linha > 20);

            do {
                System.out.println("Digite em qual cadeira " + nome + " irá sentar");
                coluna = leia.nextInt();

                if (coluna < 1 || coluna > 6) {
                    System.out.println("Inválido! São 6 cadeiras em cada fileira!");
                }
            } while (coluna < 1 || coluna > 6);

            assento[linha][coluna] = nome;
            leia.nextLine();

            if (linha <= 3) {
                valorPassagem = 900;
                primeiraClasseFaturado += valorPassagem;
            } else if (linha >= 9) {
                valorPassagem = 350;
            } else {
                valorPassagem = 700;
            }
            totalFaturado += valorPassagem;

            if (coluna == 1 || coluna == 6) {
                contAssentos++;
            }
        }

        System.out.println("Mapa do voo: ");
        for (int e = 1; e <= 20; e++) {
            for (int i = 1; i <= 6; i++) {
                if (assento[e][i] == null) {
                    System.out.println("\tVazio");
                } else {
                    System.out.println("\nLinha " + e + "\tColuna " + i);
                    System.out.println(assento[e][i]);
                }
            }
        }
        System.out.println("\nTotal faturado no voo: " + totalFaturado);
        System.out.println("Total faturamento da primeira classe: " + primeiraClasseFaturado);
        System.out.println("Quantidade de assentos vagos na janela: " + (assentosVagosJanelas - contAssentos));
    }
}