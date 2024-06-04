import java.util.*;
public class Exercício2_3 {
    public static void main(String[] args) {
     
        float nota1, nota2, nota3;
        String aluno;
        Scanner leia = new Scanner (System.in);

        System.out.println("Esse programa deverá calcular a média de 3 notas do aluno.\nNotas apenas de 0 até 10!");
        
        while (true){
        System.out.println("\nDigite o nome do aluno (fim p/ fim): ");
        aluno = leia.nextLine();

        if (aluno.equals("fim")) {
            break;
        }

        System.out.println("\nDigite a nota 1 do aluno: ");
        nota1 = leia.nextFloat();

        leia.nextLine();

        if (nota1 < 0 || nota1 > 10) {
            System.out.println("\nNotas são apenas de 0 até 10!");
            continue;
        }

        System.out.println("\nDigite a nota 2 do aluno: ");
        nota2 = leia.nextFloat();

        leia.nextLine();

        if (nota2 < 0 || nota2 > 10) {
            System.out.println("\nNotas são apenas de 0 até 10!");
            continue;
        }

        System.out.println("\nDigite a nota 3 do aluno: ");
        nota3 = leia.nextFloat();

        leia.nextLine();

        if (nota3 < 0 || nota3 > 10) {
            System.out.println("\nNotas são apenas de 0 até 10!");
            continue;
        }

        float media = (nota1 + nota2 + nota3) / 3;

        if (media >= 7) {
            System.out.println("\n"+ aluno + " está aprovado!");
        } else if (media <= 4) {
            System.out.println("\n"+aluno + " está reprovado!");
        } else {
            System.out.println("\n"+aluno +" está de recuperação!");
        }

        }
    }
}