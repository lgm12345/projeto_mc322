public class Torre extends Peca{
    public Torre(Casa casa,boolean branca) {
        super(casa) ;
        this.branca = branca ;
    }

    //Funcao que guarda as proximas possiveis posicoes para a torre sem contar ainda as casas ocupadas,e guarda em uma
    //matriz em que a primeira coluna armazena a coordenada x e a segunda a coordenada y
    public int[][] possivisProximasPosicoes(Tabuleiro tabuleiro) {
        int qntCasas = 0 ;
        int[][] posssiveisCasas = new int[32][2] ;
        for (int i = 1;i < 9;i ++) {
            if (!tabuleiro.getCasa(i, casa.getCoordenadaY()).isOcupada()) {
                posssiveisCasas[qntCasas][0] = i ;
                posssiveisCasas[qntCasas][1] = casa.getCoordenadaY() ;
                qntCasas = qntCasas + 1 ;
            }
            else {
                break;
            }
        }
        for (int j = 1;j < 9;j ++) {
            if (!tabuleiro.getCasa(casa.getCoordenadaX(),j).isOcupada()) {
                posssiveisCasas[qntCasas][0] = casa.getCoordenadaX() ;
                posssiveisCasas[qntCasas][1] = j ;
                qntCasas = qntCasas + 1 ;
            }
            else {
                break ;
            }
        }
        return posssiveisCasas ;
    }
}
