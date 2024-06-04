import java.util.*;
public class Exercício5_1 {
    public static void main(String[] args) {
        
        float notas[]; notas = new float[5];
        float somaNoatas5 = 0;
        float mediaA;
        float somaTotal = 0;
        float mediaT;

        Scanner leia = new Scanner (System.in);
        
        for (byte k = 0; k <= 29; k++) {
            for (byte cont = 0; cont <= 4; cont++) {
                System.out.println("Digite as 5 notas do aluno " + (k + 1) + ":");
                notas[cont] = leia.nextFloat();

                somaNoatas5 = notas[cont] + somaNoatas5;
            }   
            mediaA = somaNoatas5 / 5;
            somaTotal = somaNoatas5 + somaTotal;
        
            somaNoatas5 = 0;

            System.out.println("Média do aluno: " + mediaA);    
        }
        mediaT = somaTotal / 30;

        System.out.println("Média total das notas dos alunos: " + mediaT);

    }
}
