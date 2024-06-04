import java.util.*;
public class Exercício3_4 {
    public static void main(String[] args) {
        
        float contAlunos2 = 0;
        int contAlunos = 0;
        float notaFinal = 0;
        String alunoMaiorNota = "";
        float maiorNota = 0;
        int matricula = 0;
        float notasTodas = 0;
        float nota1, nota2, nota3;
        String alunos;
        Scanner leia = new Scanner (System.in);

        while (matricula != 999) {
            System.out.println("Digite o número da matrícula do aluno: ");
            matricula = leia.nextInt();

            leia.nextLine();

            if (matricula == 999) {
                break;
            }
            System.out.println("Digite o nome do aluno: ");
            alunos = leia.nextLine();

            System.out.println("Digite a nota 1 do aluno:");
            nota1 = leia.nextFloat();

            System.out.println("Digite a nota 2 do aluno:");
            nota2 = leia.nextFloat();

            System.out.println("Digite a nota 3 do aluno:");
            nota3 = leia.nextFloat();

            notaFinal = nota1 + nota2 + nota3;
            notasTodas = notaFinal + notasTodas;

            if (notaFinal > maiorNota) {
                maiorNota = notaFinal;
                alunoMaiorNota = alunos;
            }

            if (notaFinal >= 60) {
                System.out.println("Aluno aprovado!");
                contAlunos++;
                contAlunos2++;
            } else {
                System.out.println("Aluno reprovado!"); 
                contAlunos++;
                contAlunos2++;
            }
            
            System.out.println("Nota final do aluno: " + notaFinal);

        } 

        System.out.println("Quantidade de alunos: " + contAlunos);
        
        System.out.println("Média de todas as notas finais da turma: " + (notasTodas / contAlunos2));

        System.out.println("Nome do aluno com a maior nota: " + alunoMaiorNota + "\n Nota do aluno com a maior nota: " + maiorNota);

    }    
}
