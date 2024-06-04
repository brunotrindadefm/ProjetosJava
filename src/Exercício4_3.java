import java.util.*;
public class Exercício4_3 {
    public static void main(String[] args) {

        float altura;
        char sexo = ' ';
        float maiorAltura = 0;
        float menorAltura = 999;
        int contMulher = 0;
        float somaAlturasHomem = 0;
        int contHomem = 0;
        float somaAlturas = 0;
        int contAtletas = 0; 
        Scanner leia = new Scanner (System.in);

        while (sexo != 'g') {
        System.out.println("Digite o sexo '(M ou F)' (g p/ fim) do atleta: ");
        sexo = leia.next().charAt(0);
        if (sexo == 'g') {
            break;
        }
        System.out.println("Digite a altura do atleta: ");
        altura = leia.nextFloat();

        if (sexo != 'M' && sexo != 'F') {
            System.out.println("Digite um sexo válido!");
        }
        if (altura < 0 || altura > 2.50) {
            System.out.println("Digite uma altura válida!");
        }
        if (altura > maiorAltura) {
            maiorAltura = altura;
        }
        if (altura < menorAltura) {
            menorAltura = altura;
        }
        if (sexo == 'F') {
            contMulher++;
            contAtletas++;
        } else if (sexo == 'M') {
            contHomem++;
            contAtletas++;
            somaAlturasHomem = altura + somaAlturasHomem;
        }
        somaAlturas = altura + somaAlturas;
        }

        System.out.println("Maior altura encontrada: " + maiorAltura);
        System.out.println("Menor altura encontrada: " + menorAltura);
        System.out.println("Número de atletas do sexo feminino: " + contMulher);
        float mediaHomem = somaAlturasHomem / contHomem;
        System.out.println("Média das alturas dos atletas homens: " + mediaHomem);
        float mediaTotal = somaAlturas / contAtletas;
        System.out.println("Média das alturas dos atletas: " + mediaTotal);
       }
}