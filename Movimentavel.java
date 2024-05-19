public interface Movimentavel {
    boolean checknsave(Tabuleiro tabuleiro,int X,int Y) ;
    void listfreepositions(Tabuleiro tabuleiro, int X, int Y) ;
    void resetpositions(Tabuleiro tabuleiro, int X, int Y) ;
}
