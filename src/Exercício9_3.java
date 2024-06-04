import java.util.*;

public class Exercício9_3 {
    public static void main(String[] args) {

        String horarioInicial;
        String horarioFinal;
        float custo = 0;
        int horasInicial;
        int horasFinal;
        int minutosInicial;
        int minutosFinal;
        int minutos = 0;
        float totalContaTelefonica = 0;
        boolean valid = false;
        Scanner leia = new Scanner(System.in);

        do {
            do {
                do {
                    System.out.println("Digite o horário inicial da chamada ('fim' p/ fim): ");
                    horarioInicial = leia.nextLine();
                    if (horarioInicial.equalsIgnoreCase("fim")) {
                        custo = 0;
                        break;
                    } 
                    horasInicial = Integer.parseInt(horarioInicial.substring(0, 2));
                    minutosInicial = Integer.parseInt(horarioInicial.substring(3, 5));

                    System.out.println("Digite o horário final da chamada: ");
                    horarioFinal = leia.nextLine();

                    horasFinal = Integer.parseInt(horarioFinal.substring(0, 2));
                    minutosFinal = Integer.parseInt(horarioFinal.substring(3, 5));

                    valid = horaEhValida(horasFinal, horasInicial, minutosFinal, minutosInicial);
                    if (!valid) {
                        System.out.println("Horário inválido! O dia tem 24 horas e minutos são de 00 a 60! ");
                    }

                    if (horasInicial > horasFinal || horasFinal == horasInicial && minutosInicial > minutosFinal) {
                        System.out.println("Horário final deve ser depois do horário inicial! ");
                    }

                    int hora1 = Integer.parseInt(horarioInicial.substring(0, 1));
                    int hora2 = Integer.parseInt(horarioInicial.substring(1, 2));

                    minutos = (minutosFinal - minutosInicial) + (horasFinal - horasInicial) * 60;

                    if (hora2 > 0 && hora2 < 6 && hora1 == 0) {
                        custo = minutos * (float) 0.10;
                    } else if (hora2 >= 6 && hora2 < 8 && hora1 == 0) {
                        custo = minutos * (float) 0.15;
                    } else if (hora1 == 1 && hora2 >= 8 || hora2 > 0 && hora1 == 2) {
                        custo = minutos * (float) 0.15;
                    } else {
                        custo = minutos * (float) 0.20;
                    }

                } while (horasInicial > horasFinal || horasFinal == horasInicial && minutosInicial > minutosFinal);
            } while (!valid);

                totalContaTelefonica = totalContaTelefonica + custo;

                if (!horarioInicial.equalsIgnoreCase("fim")) {
                    System.out.println("Custo da chamada: " + custo);
                }
                    
        } while (!horarioInicial.equalsIgnoreCase("fim"));

        System.out.println("Custo total da conta telefônica: " + totalContaTelefonica);
    }

    public static boolean horaEhValida(int horasFin, int horasIni, int minutosFin, int minutosIni) {
        boolean valido = false;

        if (horasFin >= 00 && horasFin <= 23 && horasIni >= 00 && horasIni <= 23) {
            valido = true;
        } 
        if (minutosIni >= 00 && minutosIni <= 59 && minutosFin >= 00 && minutosFin <= 59) {
            valido = true;
        } else {
            valido = false;
        }

        return valido;
    }

}