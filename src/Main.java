import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("====== CONNECT FOUR ======\n\nPressione 'Enter' para jogar: ");

        sc.nextLine();

        String[] nomes = nomeJogador();

        if (nomes == null) return;

        String simbolo = simboloJogador(nomes);

        if (simbolo == null) return;

        connectFour(nomes, simbolo);
    }

    static void connectFour(String[] nomes, String simbolo) {
        Scanner sc = new Scanner(System.in);

        String[][] tabuleiro = new String[6][7];

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = ".";
            }
        }

        int vez = 1;

        boolean ativo = true;

        String nomeJogador;
        String simboloAtual;

        while (ativo) {
            System.out.println();

            for (int i = 0; i < tabuleiro.length; i++) {
                for (int j = 0; j < tabuleiro[i].length; j++) {
                    System.out.print(tabuleiro[i][j] + " ");
                }
                System.out.println();
            }

            if (vez == 1) {
                nomeJogador = nomes[0];
                simboloAtual = simbolo;
            } else {
                nomeJogador = nomes[1];

                if (simbolo.equals("X")) {
                    simboloAtual = "O";
                } else {
                    simboloAtual = "X";
                }
            }

            System.out.printf("%s (%s), escolha uma coluna (0 a 6): ", nomeJogador, simboloAtual);

            if (!sc.hasNextInt()) {
                System.out.println("Insira um número inteiro...");
                sc.next();
                continue;
            }

            int marcar = sc.nextInt();

            if (marcar < 0 || marcar >= tabuleiro[0].length) {
                System.out.println("Coluna inválida!");
                continue;
            }

            boolean colocou = false;

            for (int i = tabuleiro.length - 1; i >= 0; i--) {
                if (tabuleiro[i][marcar].equals(".")) {
                    tabuleiro[i][marcar] = simboloAtual;
                    colocou = true;
                    break;
                }
            }

            if (!colocou) {
                System.out.println("Coluna cheia! Escolha outra.");
                continue;
            }

            String vencedor = verificarVencedor(tabuleiro);

            if (vencedor != null) {
                for (int i = 0; i < tabuleiro.length; i++) {
                    for (int j = 0; j < tabuleiro[i].length; j++)
                        System.out.print(tabuleiro[i][j] + " ");
                    System.out.println();
                }
                System.out.println(nomeJogador + " (" + vencedor + ") venceu! Parabéns!");
                break;
            }

            if (tabuleiroCheio(tabuleiro)) {
                for (int i = 0; i < tabuleiro.length; i++) {
                    for (int j = 0; j < tabuleiro[i].length; j++)
                        System.out.print(tabuleiro[i][j] + " ");
                    System.out.println();
                }
                System.out.println("O tabuleiro está cheio! O jogo terminou em empate.");
                break;
            }

            if (vez == 1) {
                vez = 2;
            } else {
                vez = 1;
            }
        }
    }

    static String simboloJogador(String[] nomes) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("%s, escolha um símbolo: \n\n1 - X\n\n2 - O\n\nSímbolo: ", nomes[0]);

        if (!sc.hasNextInt()) {
            System.out.println("\nEscolha inválida...");
            return null;
        }

        int escolha = sc.nextInt();

        if (escolha == 1) {
            return "X";
        }

        if (escolha == 2) {
            return "O";
        }

        System.out.println("Símbolo inválido!");
        return null;
    }

    static String[] nomeJogador() {
        System.out.printf("\nNome do jogador 1: ");

        Scanner sc = new Scanner(System.in);
        String nome1 = sc.nextLine();

        System.out.printf("\nNome do jogador 2: ");

        String nome2 = sc.nextLine();

        String[] nomes = {nome1, nome2};

        if ((nome1.trim().length() <= 2 && nome2.trim().length() <= 2) || (nome1.trim().length() == 0 && nome2.trim().length() == 0)) {
            System.out.println("Nome inválido ou muito curto...");
            return null;
        }

        return nomes;
    }

    static boolean tabuleiroCheio(String[][] tabuleiro) {
        for (int j = 0; j < tabuleiro[0].length; j++) {
            if (tabuleiro[0][j].equals(".")) return false;
        }

        return true;
    }

    static String verificarVencedor(String[][] tabuleiro) {
        int linhas = tabuleiro.length; // 6
        int colunas = tabuleiro[0].length; // 7

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                String posicaoAtual = tabuleiro[i][j];
                if (posicaoAtual.equals(".")) continue;

                // horizontal
                if (j + 3 < colunas &&
                        posicaoAtual.equals(tabuleiro[i][j + 1]) &&
                        posicaoAtual.equals(tabuleiro[i][j + 2]) &&
                        posicaoAtual.equals(tabuleiro[i][j + 3]))
                    return posicaoAtual;

                // vertical
                if (i + 3 < linhas &&
                        posicaoAtual.equals(tabuleiro[i + 1][j]) &&
                        posicaoAtual.equals(tabuleiro[i + 2][j]) &&
                        posicaoAtual.equals(tabuleiro[i + 3][j]))
                    return posicaoAtual;

                // diagonal direita
                if (i + 3 < linhas && j + 3 < colunas &&
                        posicaoAtual.equals(tabuleiro[i + 1][j + 1]) &&
                        posicaoAtual.equals(tabuleiro[i + 2][j + 2]) &&
                        posicaoAtual.equals(tabuleiro[i + 3][j + 3]))
                    return posicaoAtual;

                // diagonal esquerda
                if (i + 3 < linhas && j - 3 >= 0 &&
                        posicaoAtual.equals(tabuleiro[i + 1][j - 1]) &&
                        posicaoAtual.equals(tabuleiro[i + 2][j - 2]) &&
                        posicaoAtual.equals(tabuleiro[i + 3][j - 3]))
                    return posicaoAtual;
            }
        }

        return null;
    }
}