import java.util.*;
public class Exercício2_8 {
    public static void main(String[] args) {
        
        int ano;
        int mes;
        int dia;
        int anoA = 2024;
        int mesA = 4;
        int diaA = 3;
        int idade = 0;
        Scanner leia = new Scanner (System.in);

        System.out.println("Digite o ano em que você nasceu: ");
        ano = leia.nextInt();

        System.out.println("Digite o mês em que você nasceu: ");
        mes = leia.nextInt();

        System.out.println("Digite o dia em que você nasceu: ");
        dia = leia.nextInt();

        if (mes > 4 || mes == 4 && dia > 3) {
            idade = anoA - ano;
            idade = idade -1;
            System.out.println("Sua idade: " + idade);
        } else {
            idade = anoA - ano;
            System.out.println("Sua idade: " + idade);
        }

        

        

    }
}