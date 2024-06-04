import java.util.*;

public class Exercício5_4 {
    public static void main(String[] args) {

        char gabarito[] = new char[10];
        char opcoesMarc = 0;
        int frequencia[] = new int[11];
        int acertos = 0;
        int alunoAprov = 0;
        int contAlunos = 0;
        float percentual;
        int matricula = 0;
        int notaMaiorFrequencia = 0;
        int frequenciaNotaMaior = 0;
        Scanner leia = new Scanner(System.in);

        for (int k = 0; k <= 9; k++) {
            System.out.println("Digite o gabarito ('a' a 'e') da questão " + (k + 1) + " prova: ");
            gabarito[k] = leia.next().charAt(0);

            if (gabarito[k] != 'a' && gabarito[k] != 'b' && gabarito[k] != 'c' && gabarito[k] != 'd'
                    && gabarito[k] != 'e') {
                System.out.println("As alternativas são a, b, c, d ou e! ");
                k--;
                continue;
            }
        }

        while (matricula != 999) {
            System.out.println("Digite o número da matrícula do aluno (999 p/ fim): ");
            matricula = leia.nextInt();
            if (matricula == 999) {
                break;
            }
            for (int l = 0; l <= 9; l++) {
                System.out.println("Digite o que o aluno marcou na questão " + (l + 1) +" : ");
                opcoesMarc = leia.next().charAt(0);

                if (opcoesMarc != 'a' && opcoesMarc != 'b' && opcoesMarc != 'c' && opcoesMarc != 'd'
                        && opcoesMarc != 'e' && opcoesMarc != 'f') {
                    System.out.println("As alternativas são a, b, c, d ou e! ");
                    l--;
                    continue;
                }

                if (opcoesMarc == gabarito[l]) {
                    acertos++;
                }
            }
            frequencia[acertos]++;
            for (int conta = 0; conta <= 10; conta++) {
                    if (frequencia[conta] > frequenciaNotaMaior) {
                    frequenciaNotaMaior = frequencia[conta];
                    notaMaiorFrequencia = conta;
                    }
                }
            System.out.println("Acertos: " + acertos);
            if (acertos >= 6) {
                alunoAprov++;
            }
            contAlunos++;
            acertos = 0;
        }
       
        percentual = alunoAprov * 100 / contAlunos;
        System.out.println("Percentual de alunos aprovados: " + percentual +"%");
        System.out.println("Alunos: " + contAlunos);
        System.out.println("Nota com maior frequência: " + notaMaiorFrequencia + ". Quantas vezes essa nota apareceu: " + frequenciaNotaMaior);
        for (int cont = 0; cont <= 10; cont++) {
            System.out.println("Nota " + cont + " Quantos alunos tiraram essa nota: " + frequencia[cont]);
        }
    }
}
