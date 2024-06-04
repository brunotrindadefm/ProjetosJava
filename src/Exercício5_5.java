import java.util.*;

public class Exercício5_5 {
    public static void main(String[] args) {

        String nome;
        int nota; // inteiras de 0 a 100
        char sexo;
        int contFem = 0;
        int contMasc = 0;
        int aprovMasc = 0;
        int reprovFem = 0;
        int somaNotasFem = 0;
        int somaNotasTotal = 0;
        String nomeA[] = new String[50];
        int notaA[] = new int[50];
        int h = 0;
        Scanner leia = new Scanner(System.in);

        for (int k = 0; k <= 50; k++) {
            System.out.println("Digite o nome do aluno: ");
            nome = leia.nextLine();

            System.out.println("Digite a nota do aluno: ");
            nota = leia.nextInt();
            if (nota < 0 || nota > 100) {
                System.out.println("Digite notas inteiras de 0 a 100!");
                k--;
                leia.nextLine();
                continue;
            }

            System.out.println("Digite o sexo do aluno: ");
            sexo = leia.next().charAt(0);
            if (sexo != 'f' && sexo != 'm') {
                System.out.println("Digite 'm' para masculino e 'f' para feminino!");
                k--;
                leia.nextLine();
                continue;
            }
            h = k;

                if (nota >= 60) {
                    nomeA[k] = nome;
                    notaA[k] = nota;
                }

            if (sexo == 'f') {
                contFem++;
                somaNotasFem = nota + somaNotasFem;
                if (nota < 60) {
                    reprovFem++;
                }
            } else if (sexo == 'm') {
                contMasc++;
                if (nota >= 60) {
                    aprovMasc++;
                }
            }
            somaNotasTotal = nota + somaNotasTotal;
            leia.nextLine();
        }
        System.out.println("Número de pessoas do sexo masculino aprovadas: " + aprovMasc);
        System.out.println("Número de pessoas do sexo feminino reprovadas: " + reprovFem);
        float mediaFem = somaNotasFem / contFem;
        System.out.println("Média das notas femininas: " + mediaFem);
        float mediaTotal = somaNotasTotal / (contFem + contMasc);
        System.out.println("Média das notas totais: " + mediaTotal);
        for (int y = 0; y <= h; y++) {
            if (nomeA[y] == null && notaA[y] == 0) {
            } else {
                System.out.println("Nome do aprovado: " + nomeA[y] + " || Nota do aprovado: " + notaA[y]);
            }
        }
    }
}
