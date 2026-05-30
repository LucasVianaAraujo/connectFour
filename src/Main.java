import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("== CONNECT FOUR ==\n\nPressione 'Enter' para jogar: ");
        sc.nextLine();

        // int simboloJogador = simboloJogador();

        // if (simboloJogador == 0) {
        //  return;
        //}

        // String nomeJogador = nomeJogador();

        connectFour();
    }

    static void regrasDoJogo() {
        Scanner sc = new Scanner(System.in);
        // regras do jogo para um melhor dinamismo e interação
    }

    static void connectFour() {
        Scanner sc = new Scanner(System.in);

        String[][] tabuleiro = new String[6][7];

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = ".";
            }
        }

        boolean existeEspaco = true;

        while (existeEspaco) {
            for (int i = 0; i < tabuleiro.length; i++) {
                for (int j = 0; j < tabuleiro[i].length; j++) {
                    System.out.print(tabuleiro[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Escolha uma coluna (0 a 6):");
            int marcar = sc.nextInt();

            if (marcar < 0 || marcar >= tabuleiro.length) {
                System.out.println("Coluna inválida");
                return;
            }

            for (int i = tabuleiro.length - 1; i >= 0; i--) {
                if (tabuleiro[i][marcar] == ".") {
                    tabuleiro[i][marcar] = "X";
                    break;
                }
            }
        }
    }

    static int simboloJogador() {
        System.out.printf("Escolha um símbolo: \n\n1 - X\n\n2 - O\n\nSímbolo: ");

        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) {
            System.out.printf("\nEscolha inválida...\nDigite apenas números!\n\n");
            return 0;
        }

        int simbolo = sc.nextInt();

        return simbolo;
    }

    static String nomeJogador() {
        System.out.printf("\nNome do jogador: ");

        Scanner sc = new Scanner(System.in);
        String nome1 = sc.nextLine();

        return nome1;
    }
}