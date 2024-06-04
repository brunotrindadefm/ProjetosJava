import java.util.*;
public class Exercício2_5 {
    public static void main(String[] args) {
        
        float lado1, lado2, lado3;
        Scanner leia = new Scanner (System.in);

        do {
        System.out.println("Digite quanto mede o lado 1 (0 p/ fim): ");
        lado1 = leia.nextFloat();

        if (lado1 == 0) {
            break;
        }

        System.out.println("Digite quanto mede o lado 2: ");
        lado2 = leia.nextFloat();

        System.out.println("Digite quanto mede o lado 3: ");
        lado3 = leia.nextFloat();

        if (lado1 + lado2 < lado3 || lado1 + lado3 < lado2 || lado2 + lado3 < lado1) {
            System.out.println("não é um triângulo!");
        } else if (lado1 == lado2 && lado2 == lado3) {
            System.out.println("Triângulo equilátero!");
        } else if (lado1 == lado2 && lado2 != lado3 || lado3 == lado1 && lado1 != lado2 || lado3 == lado2 && lado3 != lado1) {
            System.out.println("Triângulo isósceles!");
        } else {
            System.out.println("Triângulo escaleno!");
        }

        } while (lado1 != 0);
    }
}
