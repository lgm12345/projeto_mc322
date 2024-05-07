public class Cavalo extends Peca {
    public Cavalo(Casa casa, boolean branca) {
        super(casa);
        this.branca = branca;
    }

    //Método que retorna em uma matriz as possiveis proximas posicoes para o cavalo ir sem contar ainda obstrução
    //no caminho,sendo a primeira coluna a posicao x e a segunda coluna a posicao y
    public int[][] proximaPosicaoCavalo() {
        int qntCasas = 0 ;
        int[][] proximas = new int[32][2];
        if (casa.getCoordenadaX() == 1) {
            if ((casa.getCoordenadaY()  < 7) && (casa.getCoordenadaY() > 2)) {
                proximas[qntCasas][0] = 2 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() + 2 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 3 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() + 1 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 2 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() - 2 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 3 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() - 1 ;
                qntCasas = qntCasas + 1 ;
            } else if (casa.getCoordenadaY() == 7) {
                proximas[qntCasas][0] = 3 ;
                proximas[qntCasas][1] = 8 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 2 ;
                proximas[qntCasas][1] = 5 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 3 ;
                proximas[qntCasas][1] = 6 ;
                qntCasas = qntCasas + 1 ;
            }
            else if (casa.getCoordenadaY() == 8) {
                proximas[qntCasas][0] = 2 ;
                proximas[qntCasas][1] = 6 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 3 ;
                proximas[qntCasas][1] = 7 ;
                qntCasas = qntCasas + 1 ;
            }
            else if (casa.getCoordenadaY() == 1) {
                proximas[qntCasas][0] = 2 ;
                proximas[qntCasas][1] = 3 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 3 ;
                proximas[qntCasas][1] = 2 ;
                qntCasas = qntCasas + 1 ;
            }
            else if (casa.getCoordenadaY() == 2) {
                proximas[qntCasas][0] = 3 ;
                proximas[qntCasas][1] = 1 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 3 ;
                proximas[qntCasas][1] = 3 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 2 ;
                proximas[qntCasas][1] = 4 ;
                qntCasas = qntCasas + 1 ;
            }
        }
        else if (casa.getCoordenadaX() == 2) {
            if ((casa.getCoordenadaY() > 2) && (casa.getCoordenadaY() < 7)) {
                proximas[qntCasas][0] = 1 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() + 2 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 1 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() - 2 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 3 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() + 2 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 3 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() - 2 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 4 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() + 1 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 4 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() - 1 ;
                qntCasas = qntCasas + 1 ;
            }
            else if (casa.getCoordenadaY() == 8) {
                proximas[qntCasas][0] = 1 ;
                proximas[qntCasas][1] = 6 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 3 ;
                proximas[qntCasas][1] = 6 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 4 ;
                proximas[qntCasas][1] = 7 ;
                qntCasas = qntCasas + 1 ;
            }
            else if (casa.getCoordenadaY() == 7) {
                proximas[qntCasas][0] = 1 ;
                proximas[qntCasas][1] = 5 ;
                qntCasas = qntCasas + 1;
                proximas[qntCasas][0] = 3 ;
                proximas[qntCasas][1] = 5 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 4 ;
                proximas[qntCasas][1] = 8 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 4 ;
                proximas[qntCasas][1] = 6 ;
                qntCasas = qntCasas + 1 ;
            }
            else if (casa.getCoordenadaY() == 2) {
                proximas[qntCasas][0] = 1 ;
                proximas[qntCasas][1] = 4 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 3 ;
                proximas[qntCasas][1] = 4 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 4 ;
                proximas[qntCasas][1] = 3 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 4 ;
                proximas[qntCasas][1] = 1 ;
                qntCasas = qntCasas + 1 ;
            }
            else if (casa.getCoordenadaY() == 1) {
                proximas[qntCasas][0] = 1 ;
                proximas[qntCasas][1] = 3 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 3 ;
                proximas[qntCasas][1] = 3 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 4 ;
                proximas[qntCasas][1] = 2 ;
                qntCasas = qntCasas + 1 ;
            }
        }
        else if (casa.getCoordenadaX() == 7) {
            if ((casa.getCoordenadaY() > 2) && (casa.getCoordenadaY() < 7)) {
                proximas[qntCasas][0] = 8 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() + 2 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 8 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() - 2 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 6 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() + 2 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 6 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() - 2 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 5 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() + 1 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 5 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() - 1 ;
                qntCasas = qntCasas + 1 ;
            }
            else if (casa.getCoordenadaY() == 8) {
                proximas[qntCasas][0] = 8 ;
                proximas[qntCasas][1] = 6 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 6 ;
                proximas[qntCasas][1] = 6 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 5 ;
                proximas[qntCasas][1] = 7 ;
                qntCasas = qntCasas + 1 ;
            }
            else if (casa.getCoordenadaY() == 7) {
                proximas[qntCasas][0] = 8 ;
                proximas[qntCasas][1] = 5 ;
                qntCasas = qntCasas + 1;
                proximas[qntCasas][0] = 6 ;
                proximas[qntCasas][1] = 5 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 5 ;
                proximas[qntCasas][1] = 8 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 5 ;
                proximas[qntCasas][1] = 6 ;
                qntCasas = qntCasas + 1 ;
            }
            else if (casa.getCoordenadaY() == 2) {
                proximas[qntCasas][0] = 8 ;
                proximas[qntCasas][1] = 4 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 6 ;
                proximas[qntCasas][1] = 4 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 4 ;
                proximas[qntCasas][1] = 3 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 4 ;
                proximas[qntCasas][1] = 1 ;
                qntCasas = qntCasas + 1 ;
            }
            else if (casa.getCoordenadaY() == 1) {
                proximas[qntCasas][0] = 8 ;
                proximas[qntCasas][1] = 3 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 6 ;
                proximas[qntCasas][1] = 3 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 5 ;
                proximas[qntCasas][1] = 2 ;
                qntCasas = qntCasas + 1 ;
            }
        }
        else if (casa.getCoordenadaX() == 8) {
            if ((casa.getCoordenadaY()  < 7) && (casa.getCoordenadaY() > 2)) {
                proximas[qntCasas][0] = 7 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() + 2 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 6 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() + 1 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 7 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() - 2 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 6 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() - 1 ;
                qntCasas = qntCasas + 1 ;
            } else if (casa.getCoordenadaY() == 7) {
                proximas[qntCasas][0] = 6 ;
                proximas[qntCasas][1] = 8 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 7 ;
                proximas[qntCasas][1] = 5 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 6 ;
                proximas[qntCasas][1] = 6 ;
                qntCasas = qntCasas + 1 ;
            }
            else if (casa.getCoordenadaY() == 8) {
                proximas[qntCasas][0] = 7 ;
                proximas[qntCasas][1] = 6 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 6 ;
                proximas[qntCasas][1] = 7 ;
                qntCasas = qntCasas + 1 ;
            }
            else if (casa.getCoordenadaY() == 1) {
                proximas[qntCasas][0] = 7 ;
                proximas[qntCasas][1] = 3 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 6 ;
                proximas[qntCasas][1] = 2 ;
                qntCasas = qntCasas + 1 ;
            }
            else if (casa.getCoordenadaY() == 2) {
                proximas[qntCasas][0] = 6 ;
                proximas[qntCasas][1] = 1 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 6 ;
                proximas[qntCasas][1] = 3 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = 7 ;
                proximas[qntCasas][1] = 4 ;
                qntCasas = qntCasas + 1 ;
            }
        }
        else if ((casa.getCoordenadaX() > 2) && (casa.getCoordenadaX() < 7)) {
            if ((casa.getCoordenadaY() > 2) && (casa.getCoordenadaY() < 7)) {
                proximas[qntCasas][0] = casa.getCoordenadaX() + 1 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() + 2 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = casa.getCoordenadaX() + 1 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() - 2 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = casa.getCoordenadaX() - 1 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() + 2 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = casa.getCoordenadaX() - 1 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() - 2 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = casa.getCoordenadaX() + 2 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() + 1 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = casa.getCoordenadaX() + 2 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() - 1 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = casa.getCoordenadaX() - 2 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() + 1 ;
                qntCasas = qntCasas + 1 ;
                proximas[qntCasas][0] = casa.getCoordenadaX() - 2 ;
                proximas[qntCasas][1] = casa.getCoordenadaY() - 1 ;
                qntCasas = qntCasas + 1 ;
            }
        }
        return proximas ;
    }
}
