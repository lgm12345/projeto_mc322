public class Rainha extends Peca{

    public Rainha(Casa casa, boolean branca) {
        super(casa) ;
        this.branca = branca ;
    }

    public int[][] possiveisProximasPosicoes() {
        int qntCasas = 0 ;
        int [][] possiveisCasas = new int[64][2] ;
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
        for (int i = 1;i < 9;i ++) {
            possiveisCasas[qntCasas][0] = i ;
            possiveisCasas[qntCasas][1] = casa.getCoordenadaY() ;
            qntCasas = qntCasas + 1 ;
        }
        for (int j = 1;j < 9;j ++) {
            possiveisCasas[qntCasas][0] = casa.getCoordenadaX() ;
            possiveisCasas[qntCasas][1] = j ;
            qntCasas = qntCasas + 1 ;
        }
        return possiveisCasas ;
    }
}
