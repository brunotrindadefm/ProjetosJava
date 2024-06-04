import java.util.*;

public class Exercício10_1 {

    public static void main(String[] args) {

        String nomeD;
        Scanner leia = new Scanner(System.in);

        System.out.println("Digite o nome em letras minúsculas: ");
        nomeD = leia.nextLine();

        System.out.println("Nome alterado 1: " + primLetraMaiusc(nomeD));

        System.out.println("Nome alterado 2: " + todasPrimLetrasMaisc(nomeD));

        System.out.println("Nome alterado 3: " + semEspacoEsquerda(nomeD));

        System.out.println("Nome alterado 4: " + semEspacoDireita(nomeD));

        System.out.println("Nome alterado 5: " + semEspacosAMaisNoMeio(nomeD));

    }

    public static String primLetraMaiusc(String nome1) {

        nome1 = Character.toUpperCase(nome1.charAt(0)) + nome1.substring(1);

        return nome1;
    }

    public static String todasPrimLetrasMaisc(String nome2) {
        nome2 = primLetraMaiusc(nome2);

        for (int x = 1; x < nome2.length(); x++) {
            try {
                if (nome2.charAt(x) == ' ') {
                    nome2 = nome2.substring(0, x + 1) + Character.toUpperCase(nome2.charAt(x + 1)) +
                            nome2.substring(x + 2);
                }
            } catch (StringIndexOutOfBoundsException erro) {

            }
        }

        return nome2;
    }

    public static String semEspacoEsquerda(String nome3) {
        nome3 = todasPrimLetrasMaisc(nome3);
        nome3 = primLetraMaiusc(nome3);
        while (nome3.charAt(0) == ' ') {
            nome3 = nome3.substring(1);
        }
        return nome3;
    }

    public static String semEspacoDireita(String nome4) {
        nome4 = semEspacoEsquerda(nome4);
        nome4 = primLetraMaiusc(nome4);
        nome4 = todasPrimLetrasMaisc(nome4);

        while (nome4.charAt(nome4.length() - 1) == ' ') {
            nome4 = nome4.substring(0, nome4.length() - 1);
        }

        return nome4;
    }

    public static String semEspacosAMaisNoMeio(String nome5) {
        nome5 = primLetraMaiusc(nome5);
        nome5 = semEspacoEsquerda(nome5);
        nome5 = todasPrimLetrasMaisc(nome5);
        nome5 = semEspacoEsquerda(nome5);

        String nome = "";
        boolean espacoEncontrado = false;

        for (int i = 0; i < nome5.length(); i++) {

            if (nome5.charAt(i) == ' ') {
                if (!espacoEncontrado) {
                    nome = nome + ' ';
                }
                espacoEncontrado= true;
            } else {
                nome = nome + nome5.charAt(i);
                espacoEncontrado = false;
            }
        }
        return nome;
    }

}