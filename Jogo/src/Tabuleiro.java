
public class Tabuleiro {
    private final Celula[][] celulas = new Celula[9][9];

    public Tabuleiro() {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                celulas[i][j] = new Celula();
    }

    public void preencherComParametros(String[] args) {
        for (String entrada : args) {
            String[] partes = entrada.split(";");
            String[] pos = partes[0].split(",");
            int linha = Integer.parseInt(pos[1]);
            int coluna = Integer.parseInt(pos[0]);
            int valor = Integer.parseInt(partes[1]);
            boolean fixa = Boolean.parseBoolean(partes[2]);

            celulas[linha][coluna] = new Celula(valor, fixa);
        }
    }

    public void mostrar() {
        System.out.println("\n--- Tabuleiro Atual ---");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) System.out.println("------+-------+------");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) System.out.print("| ");
                System.out.print(celulas[i][j].getValorVisual() + " ");
            }
            System.out.println();
        }
    }

    public void inserir(int linha, int coluna, int valor) {
        if (!celulas[linha][coluna].isFixa()) {
            celulas[linha][coluna].setValor(valor);
        } else {
            System.out.println("Não é possível alterar uma célula fixa.");
        }
    }

    public void apagar(int linha, int coluna) {
        if (!celulas[linha][coluna].isFixa()) {
            celulas[linha][coluna].setValor(0);
        } else {
            System.out.println("Não é possível apagar uma célula fixa.");
        }
    }

    public void verificarStatus() {
        boolean completo = true;
        boolean erros = false;

        for (int i = 0; i < 9; i++) {
            boolean[] linha = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int valor = celulas[i][j].getValor();
                if (valor == 0) completo = false;
                if (valor > 0) {
                    if (linha[valor]) erros = true;
                    linha[valor] = true;
                }
            }
        }

        System.out.println("Status: " + (completo ? (erros ? "Com erros" : "Finalizado") : "Em andamento"));
    }

    public void resetar() {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (!celulas[i][j].isFixa())
                    celulas[i][j].setValor(0);

        System.out.println("Jogo resetado.");
    }
}
