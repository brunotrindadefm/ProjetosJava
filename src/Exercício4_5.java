import java.util.*;

public class Exercício4_5 {
    public static void main(String[] args) {
        
        String jogador1;
        String jogador2;
        Scanner leia = new Scanner (System.in);

        System.out.println("As jogadas são: pedra, papel e tesoura");

        do {
        System.out.println("Digite a jogada do jogador 1: ");
        jogador1 = leia.nextLine();

        System.out.println("Digite a jogada do jogador 2: ");
        jogador2 = leia.nextLine();

        if (!jogador1.equals("papel") && !jogador1.equals("pedra") && !jogador1.equals("tesoura")) {
            System.out.println( jogador1 + " - Não é uma jogada permitida! Apenas as palavras 'papel' 'pedra' 'tesoura' são permitidas! ");
            break;
        }

        if (!jogador2.equals("papel") && !jogador2.equals("pedra") && !jogador2.equals("tesoura")) {
            System.out.println( jogador2 + " - Não é uma jogada permitida! Apenas as palavras 'papel' 'pedra' 'tesoura' são permitidas! ");
            break;
        }
        
        if (jogador1.equals("pedra") && jogador2.equals("tesoura")) {
            System.out.println("Jogador 1 venceu!");
        }
        if (jogador1.equals("tesoura") && jogador2.equals("papel")) {
            System.out.println("Jogador 1 venceu!");
        }
        if (jogador1.equals("pedra") && jogador2.equals("pedra")) {
            System.out.println("Empate!");
        }
        if (jogador1.equals("tesoura") && jogador2.equals("pedra")) {
            System.out.println("Jogador 2 venceu!");
        }
        if (jogador1.equals("tesoura") && jogador2.equals("tesoura")) {
            System.out.println("Empate!");
        }
        if (jogador1.equals("pedra") && jogador2.equals("papel")) {
            System.out.println("Jogador 2 venceu!");
        }
        if (jogador1.equals("papel") && jogador2.equals("pedra")) {
            System.out.println("Jogador 1 venceu!");
        } 
        if (jogador1.equals("papel") && jogador2.equals("tesoura")) {
            System.out.println("Jogador 2 venceu!");
        }
        if (jogador1.equals("papel") && jogador2.equals("papel")) {
            System.out.println("Empate!");
        }
        } while (true);
    }
}