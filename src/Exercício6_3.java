import java.util.*;

public class Exercício6_3 {
    public static void main(String[] args) {

        float estoque[][] = new float[9][9];
        float custo[] = new float[3];
        int maisProdutos = 0;
        int produtosTotal = 0;
        float custoP = 0;
        int armaMais = 0;
        int maisArmaProdutos = 0;
        Scanner leia = new Scanner(System.in);

        for (int j = 0; j <= 2; j++) {
            System.out.println("Digite o valor do produto " + (j + 1) + ":");
            custo[j] = leia.nextFloat();
        }
        for (int d = 0; d <= 2; d++) {
            for (byte i = 0; i <= 2; i++) {
                System.out.println("Quantidade em estoque de produtos " + (1 + i) + "no armazém " + (d + 1) + ": ");
                estoque[i][d] = leia.nextFloat();

                produtosTotal = produtosTotal + (int) estoque[i][d];
                armaMais += produtosTotal;
                if (armaMais > maisProdutos) {
                    maisProdutos = armaMais;
                    maisArmaProdutos = d + 1;
                }
                estoque[i][d] = custo[d] * estoque[i][d];
                armaMais = 0;
            }
        }

        System.out.println("Armazém com mais produtos foi o armazém " + maisArmaProdutos);
        System.out.println("Quantidades totais de produtos: " + produtosTotal);

        System.out.println("  \tProduto 1  \tProduto 2  \tProduto 3");
        for (int i = 0; i <= 2; i++) {
            System.out.println("Armazem " + (i + 1));
            for (int j = 0; j <= 2; j++) {
                System.out.print("\t\t" + estoque[i][j]);
            }
            System.out.println();
        }
    }
}
