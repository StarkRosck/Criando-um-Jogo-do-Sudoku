
import java.util.Scanner;

public class SudokuApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static Tabuleiro tabuleiro;

    public static void main(String[] args) {
        tabuleiro = new Tabuleiro();
        tabuleiro.preencherComParametros(args); // argumentos passados na execução

        int escolha;
        do {
            mostrarMenu();
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1 -> tabuleiro.mostrar();
                case 2 -> inserirNumero();
                case 3 -> apagarNumero();
                case 4 -> tabuleiro.verificarStatus();
                case 5 -> tabuleiro.resetar();
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (escolha != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Sudoku Digital ===");
        System.out.println("1 - Mostrar tabuleiro");
        System.out.println("2 - Inserir número");
        System.out.println("3 - Apagar número");
        System.out.println("4 - Verificar status");
        System.out.println("5 - Limpar jogo");
        System.out.println("6 - Sair");
        System.out.print("Escolha: ");
    }

    private static void inserirNumero() {
        System.out.print("Linha (0-8): ");
        int linha = scanner.nextInt();
        System.out.print("Coluna (0-8): ");
        int coluna = scanner.nextInt();
        System.out.print("Valor (1-9): ");
        int valor = scanner.nextInt();

        tabuleiro.inserir(linha, coluna, valor);
    }

    private static void apagarNumero() {
        System.out.print("Linha (0-8): ");
        int linha = scanner.nextInt();
        System.out.print("Coluna (0-8): ");
        int coluna = scanner.nextInt();

        tabuleiro.apagar(linha, coluna);
    }
}
