public class PecaVazia extends Peca {
    // Instância única da classe PecaVazia
    private static final PecaVazia instance = new PecaVazia();

    // Construtor privado para impedir instanciamento externo
    private PecaVazia() {
        super("Vazio", null,false); // Chama o construtor da classe Peca com um nome apropriado e casa nula
    }

    // Método estático para acessar a única instância da classe
    public static PecaVazia getInstance() {
        return instance;
    }

    @Override
    public boolean move(Tabuleiro tabuleiro, int linha, int coluna) {
        // Implementação de uma peça vazia não se move
        return false;
    }

    @Override
    public String getClassName() {
        return "PecaVazia";
    }

    @Override
    public void movimento() {
        // Implementação de uma peça vazia não se move
    }

    @Override
    public void promote() {
        // Implementação de uma peça vazia não promove
    }

    @Override
    public void moved() {
        // Implementação de uma peça vazia não se move
    }

    @Override
    public int[][] movmap() {
        // Implementação de uma peça vazia não tem mapa de movimento
        return new int[0][0];
    }
}
