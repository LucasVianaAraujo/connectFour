import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("== CONNECT FOUR ==\n\nPressione 'Enter' para jogar: ");
        sc.nextLine();

        int simboloJogador = simboloJogador();

        if (simboloJogador == 0) {
            return;
        }

        String nomeJogador = nomeJogador();
    }

    static void regrasDoJogo() {
        Scanner sc = new Scanner(System.in);
        // regras do jogo para um melhor dinamismo e interação
    }

    static void connectFour() {
        Scanner sc = new Scanner(System.in);
        // o jogo em si
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