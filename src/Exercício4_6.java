import java.util.*;

public class Exercício4_6 {
    public static void main(String[] args) {
     
        float arrecadouMenos = Float.POSITIVE_INFINITY;
        float arrecadouMais = 0;
        float valorFinal = 0;
        float valor;
        byte passageiro;
        int vooArrecadouMenos = 0;
        int vooArrecadouMais = 0;
        int voo;
        Scanner leia = new Scanner (System.in);

        do {
        System.out.println("Digite qual o voo (1, 2 ou 3 || 0 p/ fim): ");
        voo = leia.nextInt();
        if (voo == 0) {
            break;
        }
        if (voo != 1 && voo != 2 && voo != 3) {
            System.out.println("Só existe voo 1, 2 e 3!");
            continue;
        }

        if (voo == 1) {
                System.out.println("Digite quantos passageiros são: ");
                passageiro = leia.nextByte();

                if (passageiro >= 70) {
                    valor = (100 * passageiro) * (float) 0.40;
                    valorFinal = valor + valorFinal;
                } else if (passageiro < 50) {
                    valor = (passageiro * 100);
                    valorFinal = valor + valorFinal;
                } else {
                    valor = (passageiro * 100) * (float) 0.70;
                    valorFinal = valor + valorFinal;
                }
                if (valor > arrecadouMais) {
                    arrecadouMais = valor;
                    vooArrecadouMais = voo;
                }
                if (valor < arrecadouMenos) {
                    arrecadouMenos = valor;
                    vooArrecadouMenos = voo;
                }

        }
        if (voo == 2) {
                System.out.println("Digite quantos passageiros são: ");
                passageiro = leia.nextByte();

                if (passageiro >= 70) {
                    valor = (150 * passageiro) * (float) 0.40;
                    valorFinal = valor + valorFinal;
                } else if (passageiro < 50) {
                    valor = (passageiro * 150);
                    valorFinal = valor + valorFinal;
                } else {
                    valor = (passageiro * 150) * (float) 0.70;
                    valorFinal = valor + valorFinal;
                }
                if (valor > arrecadouMais) {
                    arrecadouMais = valor;
                    vooArrecadouMais = voo;
                }
                if (valor < arrecadouMenos) {
                    arrecadouMenos = valor;
                    vooArrecadouMenos = voo;
                }

        }
        if (voo == 3) {
                System.out.println("Digite quantos passageiros são: ");
                passageiro = leia.nextByte();

                if (passageiro >= 70) {
                    valor = (200 * passageiro) * (float) 0.40;
                    valorFinal = valor + valorFinal;
                } else if (passageiro < 50) {
                    valor = (passageiro * 200);
                    valorFinal = valor + valorFinal;
                } else {
                    valor = (passageiro * 200) * (float) 0.70;
                    valorFinal = valor + valorFinal;
                }
                if (valor > arrecadouMais) {
                    arrecadouMais = valor;
                    vooArrecadouMais = voo;
                }
                if (valor < arrecadouMenos) {
                    arrecadouMenos = valor;
                    vooArrecadouMenos = voo;
                }

        }
    } while (voo != 0);
    System.out.println("Número do voo que arrecadou mais: " + vooArrecadouMais);
    System.out.println("Maior valor arrecadado: " + arrecadouMais);
    float media = valorFinal / 3;
    System.out.println("Média de arrecadação dos 3 voos: " + media);
    System.out.println("Menor valor arrecadado: " + arrecadouMenos);
    System.out.println("Número do voo que arrecadou menos: " + vooArrecadouMenos);
    }
}
