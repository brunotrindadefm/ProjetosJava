import java.util.*;
public class Exercício8_2 {

    public static void main(String[] args) {
        
        String nome[] = new String[100];
        float salario[] = new float[100];
        int numPeças;
        int codEmpreg;
        int h = 0;
        Scanner leia = new Scanner (System.in);

        for (int i = 0; i <= 1; i++) {
            
            System.out.println("Digite o nome do empregado: ");
            nome[i] = leia.nextLine();

            System.out.println("Digite o código do empregado: ");
            codEmpreg = leia.nextInt();

            System.out.println("Digite o número de peças fabricadas pelo " + nome[i] + " no mês: ");
            numPeças = leia.nextInt();

            salario[i] = calcularSalario(numPeças); 

            h = i;

            leia.nextLine();
        }
        for (int i = 0; i <= h; i++) {
            System.out.println("Nome do empregado " + nome[i] + "  salário : " + salario[i]);
        }
    }

    public static float calcularSalario (float peças) {
        float salario = 0;
        if (peças >= 1 && peças <= 200) {
            salario = (float) 2;
            salario = salario * peças;
        } else if (peças > 400) {
            salario = (float) 2.50;
            salario = salario * peças;
        } else {
            salario = (float) 2.30;
            salario = salario * peças;
        }
        return salario;
    }
}