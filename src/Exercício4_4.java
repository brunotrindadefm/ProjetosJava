import java.util.*;

public class Exercício4_4 {
    public static void main(String[] args) {
        
        int codOperario;
        char classe;
        double peças;
        double salarioTotal = 0;
        double salario;
        double peçasTotal = 0;
        double peçasB = 0;
        double menosPeças = 999;
        int contOperarioB = 0;
        int codMenorPeças = 0;
        Scanner leia = new Scanner (System.in);

        while (true) {
        System.out.println("Digite o código do operário ('0' p/ fim):  ");
        codOperario = leia.nextInt();
        if (codOperario == 0) {
            break;
        }
        System.out.println("Digite a classe do operário (A, B, C): ");
        classe = leia.next().charAt(0);
        if (classe != 'A' && classe != 'B' && classe != 'C') {
            System.out.println("Classe inválida!");
            continue;
        }

        System.out.println("Digite o número de peças fabricadas no mês pelo funcionário: ");
        peças = leia.nextInt();

        if (peças < 0) {
            System.out.println("Número de peças deverá ser maior que zero!");
            continue;
        }
    

        if (classe == 'A')  {
            if (peças <= 30) {
            salario = 500 + (2 * peças);
            salarioTotal = (salarioTotal + salario);
            peçasTotal = peçasTotal + peças;
            }
            else if (peças > 40)  {
            salario = 500 + (2.30 * peças);
            salarioTotal = (salarioTotal + salario);
            peçasTotal = peçasTotal + peças;
             }
            else  {
            salario = 500 + (2.80 * peças);
            salarioTotal = (salarioTotal + salario);
            peçasTotal = peçasTotal + peças;
             }
        }
        else if (classe == 'B') {
            contOperarioB++;
            salario = 1200;
            salarioTotal = (salarioTotal + salario);
            peçasTotal = peçasTotal + peças;
            peçasB = peçasB + peças;
        }
        else if (classe == 'C')  {
            if (peças <= 50) {
            salario = (40 * peças);
            peçasTotal = peçasTotal + peças;
            salarioTotal = (salarioTotal + salario);
        }
        else {
            salario = (45 * peças);
            peçasTotal = peçasTotal + peças;
            salarioTotal = (salarioTotal + salario);
        }
    }
        if (peças < menosPeças) {
            menosPeças = peças;
            codMenorPeças = codOperario;
            }
    }
        double mediaB = (peçasB / contOperarioB);
        System.out.println("Gasto total da empresa com o pagamento dos saláros: " + salarioTotal);
        System.out.println("Número total de peças fabricadas: " + peçasTotal);
        System.out.println("Código do operador que fabricou o menor número de peças: " + codMenorPeças);

        if (contOperarioB == 0) {
            System.out.println("Não teve operário de classe B!");
        }
        else {
        System.out.println("Média da quantidade de peças fabricadas por empregados da classe B: " +  mediaB);
        }


    }
}