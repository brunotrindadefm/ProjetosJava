import java.util.*;

public class Exercício5_3 {
    public static void main(String[] args) {

        int ltp[] = new int[150];
        int contDois = 0;
        int ltpp = 0;
        int calculoo = 0;
        int k;
        Scanner leia = new Scanner(System.in);

        for ( k = 0; k <= 149; k++) {
            System.out.println("Digite a matrícula do aluno cursando LTP (999 p/ fim): ");
            ltpp = leia.nextInt();
            ltp[k] = ltpp;
            if (ltpp == 999) {
                break;
            }
        }

        for (int x = 0; x <= 219; x++) {
            System.out.println("Digite a matrícula do aluno cursando cálculo (999 p/ fim): ");
            calculoo = leia.nextInt();

            if (calculoo == 999) {
                break;
            }
            for (int y = 0; y <= k; y++) {
                if (calculoo == ltp[y]) {
                    contDois++;
                }
            }
        }

        System.out.println("Alunos matriculados nas duas disciplinas: " + contDois);
    }
}