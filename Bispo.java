public class Bispo extends Peca{

    public Bispo(Casa casa,boolean branca) {
        super(casa) ;
        this.branca = branca ;
    }

    //funcao que salva em uma matriz de 13 linhas e 2 colunas as possiveis casas que o bispo pode ir(sem levar em conta
    //a ocupacao ou nao da casa primeira coluna salva a coordenadax e a segunda salva a coordenaday,posteriormente
    //checaremos se as casas sao realmente possiveis de ir
    public int[][] possiveisProximasPosicoes() {
        int qntCasas = 0 ;
        int[][] possiveisCasas = new int[32][2] ;
        for (int i = casa.getCoordenadaX() - 1;i > 0;i--) {
            if (casa.getCoordenadaY() - i > 0) {
                possiveisCasas[qntCasas][0] = i ;
                possiveisCasas[qntCasas][1] = casa.getCoordenadaY() - i ;
                qntCasas = qntCasas + 1 ;
            }
            if (casa.getCoordenadaY() + i < 9) {
                possiveisCasas[qntCasas][0] = i ;
                possiveisCasas[qntCasas][1] = casa.getCoordenadaY() + i ;
                qntCasas = qntCasas + 1 ;
            }
        }
        for (int i = casa.getCoordenadaX() + 1;i < 9;i++) {
            if (casa.getCoordenadaY() - i > 0) {
                possiveisCasas[qntCasas][0] = i ;
                possiveisCasas[qntCasas][1] = casa.getCoordenadaY() - i ;
                qntCasas = qntCasas + 1 ;
            }
            if (casa.getCoordenadaY() + i < 9) {
                possiveisCasas[qntCasas][0] = i ;
                possiveisCasas[qntCasas][1] = casa.getCoordenadaY() + i ;
                qntCasas = qntCasas + 1 ;
            }
        }
        return possiveisCasas ;
    }
}
