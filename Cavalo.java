public class Cavalo extends Peca {
    public Cavalo(Casa casa, boolean branca) {
        super(casa);
        this.branca = branca;
    }

    //Método que retorna em uma matriz as possiveis proximas posicoes para o cavalo ir sem contar ainda obstrução
    //no caminho,sendo a primeira coluna a posicao x e a segunda coluna a posicao y
    public int[][] proximaPosicaoCavalo(Tabuleiro tabuleiro) {
        int qntCasas = 0 ;
        int[][] proximas = new int[32][2];
        if (casa.getCoordenadaX() == 1) {
            if ((casa.getCoordenadaY()  < 7) && (casa.getCoordenadaY() > 2)) {
                if (!tabuleiro.getCasa(2,casa.getCoordenadaY() + 2).isOcupada()) {
                    proximas[qntCasas][0] = 2;
                    proximas[qntCasas][1] = casa.getCoordenadaY() + 2;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(3,casa.getCoordenadaY() + 1).isOcupada()) {
                    proximas[qntCasas][0] = 3;
                    proximas[qntCasas][1] = casa.getCoordenadaY() + 1;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(2,casa.getCoordenadaY() - 2).isOcupada()) {
                    proximas[qntCasas][0] = 2;
                    proximas[qntCasas][1] = casa.getCoordenadaY() - 2;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(3,casa.getCoordenadaY() - 1).isOcupada()) {
                    proximas[qntCasas][0] = 3;
                    proximas[qntCasas][1] = casa.getCoordenadaY() - 1;
                    qntCasas = qntCasas + 1;
                }
            } else if (casa.getCoordenadaY() == 7) {
                if (!tabuleiro.getCasa(3,8).isOcupada()) {
                    proximas[qntCasas][0] = 3;
                    proximas[qntCasas][1] = 8;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(2,5).isOcupada()) {
                    proximas[qntCasas][0] = 2;
                    proximas[qntCasas][1] = 5;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(3,6).isOcupada()) {
                    proximas[qntCasas][0] = 3;
                    proximas[qntCasas][1] = 6;
                    qntCasas = qntCasas + 1;
                }
            }
            else if (casa.getCoordenadaY() == 8) {
                if (!tabuleiro.getCasa(2,6).isOcupada()) {
                    proximas[qntCasas][0] = 2;
                    proximas[qntCasas][1] = 6;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(3,7).isOcupada()) {
                    proximas[qntCasas][0] = 3;
                    proximas[qntCasas][1] = 7;
                    qntCasas = qntCasas + 1;
                }
            }
            else if (casa.getCoordenadaY() == 1) {
                if (tabuleiro.getCasa(2,3).isOcupada()) {
                    proximas[qntCasas][0] = 2;
                    proximas[qntCasas][1] = 3;
                    qntCasas = qntCasas + 1;
                }
                if  (!tabuleiro.getCasa(3,2).isOcupada()) {
                    proximas[qntCasas][0] = 3;
                    proximas[qntCasas][1] = 2;
                    qntCasas = qntCasas + 1;
                }
            }
            else if (casa.getCoordenadaY() == 2) {
                if (!tabuleiro.getCasa(3,1).isOcupada()) {
                    proximas[qntCasas][0] = 3;
                    proximas[qntCasas][1] = 1;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(3,3).isOcupada()) {
                    proximas[qntCasas][0] = 3;
                    proximas[qntCasas][1] = 3;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(2,4).isOcupada()) {
                    proximas[qntCasas][0] = 2;
                    proximas[qntCasas][1] = 4;
                    qntCasas = qntCasas + 1;
                }
            }
        }
        else if (casa.getCoordenadaX() == 2) {
            if ((casa.getCoordenadaY() > 2) && (casa.getCoordenadaY() < 7)) {
                if (!tabuleiro.getCasa(1,casa.getCoordenadaY() + 2).isOcupada()) {
                    proximas[qntCasas][0] = 1;
                    proximas[qntCasas][1] = casa.getCoordenadaY() + 2;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(1,casa.getCoordenadaY() - 2).isOcupada()) {
                    proximas[qntCasas][0] = 1;
                    proximas[qntCasas][1] = casa.getCoordenadaY() - 2;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(3,casa.getCoordenadaY() + 2).isOcupada()) {
                    proximas[qntCasas][0] = 3;
                    proximas[qntCasas][1] = casa.getCoordenadaY() + 2;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(3,casa.getCoordenadaY() - 2).isOcupada()) {
                    proximas[qntCasas][0] = 3;
                    proximas[qntCasas][1] = casa.getCoordenadaY() - 2;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(4,casa.getCoordenadaY() + 1).isOcupada()) {
                    proximas[qntCasas][0] = 4;
                    proximas[qntCasas][1] = casa.getCoordenadaY() + 1;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(4,casa.getCoordenadaY() - 1).isOcupada()) {
                    proximas[qntCasas][0] = 4;
                    proximas[qntCasas][1] = casa.getCoordenadaY() - 1;
                    qntCasas = qntCasas + 1;
                }
            }
            else if (casa.getCoordenadaY() == 8) {
                if (!tabuleiro.getCasa(1,6).isOcupada()) {
                    proximas[qntCasas][0] = 1;
                    proximas[qntCasas][1] = 6;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(3,6).isOcupada()) {
                    proximas[qntCasas][0] = 3;
                    proximas[qntCasas][1] = 6;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(4,7).isOcupada()) {
                    proximas[qntCasas][0] = 4;
                    proximas[qntCasas][1] = 7;
                    qntCasas = qntCasas + 1;
                }
            }
            else if (casa.getCoordenadaY() == 7) {
                if (!tabuleiro.getCasa(1,5).isOcupada()) {
                    proximas[qntCasas][0] = 1;
                    proximas[qntCasas][1] = 5;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(3,5).isOcupada()) {
                    proximas[qntCasas][0] = 3;
                    proximas[qntCasas][1] = 5;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(4,8).isOcupada()) {
                    proximas[qntCasas][0] = 4;
                    proximas[qntCasas][1] = 8;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(4,6).isOcupada()) {
                    proximas[qntCasas][0] = 4;
                    proximas[qntCasas][1] = 6;
                    qntCasas = qntCasas + 1;
                }
            }
            else if (casa.getCoordenadaY() == 2) {
                if (!tabuleiro.getCasa(1,4).isOcupada()) {
                    proximas[qntCasas][0] = 1;
                    proximas[qntCasas][1] = 4;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(3,4).isOcupada()) {
                    proximas[qntCasas][0] = 3;
                    proximas[qntCasas][1] = 4;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(4,3).isOcupada()) {
                    proximas[qntCasas][0] = 4;
                    proximas[qntCasas][1] = 3;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(4,1).isOcupada()) {
                    proximas[qntCasas][0] = 4;
                    proximas[qntCasas][1] = 1;
                    qntCasas = qntCasas + 1;
                }
            }
            else if (casa.getCoordenadaY() == 1) {
                if (!tabuleiro.getCasa(1,3).isOcupada()) {
                    proximas[qntCasas][0] = 1;
                    proximas[qntCasas][1] = 3;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(3,3).isOcupada()) {
                    proximas[qntCasas][0] = 3;
                    proximas[qntCasas][1] = 3;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(4,2).isOcupada()) {
                    proximas[qntCasas][0] = 4;
                    proximas[qntCasas][1] = 2;
                    qntCasas = qntCasas + 1;
                }
            }
        }
        else if (casa.getCoordenadaX() == 7) {
            if ((casa.getCoordenadaY() > 2) && (casa.getCoordenadaY() < 7)) {
                if (!tabuleiro.getCasa(8,casa.getCoordenadaY() + 2).isOcupada()) {
                    proximas[qntCasas][0] = 8;
                    proximas[qntCasas][1] = casa.getCoordenadaY() + 2;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(8,casa.getCoordenadaY() - 2).isOcupada()) {
                    proximas[qntCasas][0] = 8;
                    proximas[qntCasas][1] = casa.getCoordenadaY() - 2;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(6,casa.getCoordenadaY() + 2).isOcupada()) {
                    proximas[qntCasas][0] = 6;
                    proximas[qntCasas][1] = casa.getCoordenadaY() + 2;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(6,casa.getCoordenadaY() - 2).isOcupada()) {
                    proximas[qntCasas][0] = 6;
                    proximas[qntCasas][1] = casa.getCoordenadaY() - 2;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(5,casa.getCoordenadaY() + 1).isOcupada()) {
                    proximas[qntCasas][0] = 5;
                    proximas[qntCasas][1] = casa.getCoordenadaY() + 1;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(5,casa.getCoordenadaY() - 1).isOcupada()) {
                    proximas[qntCasas][0] = 5;
                    proximas[qntCasas][1] = casa.getCoordenadaY() - 1;
                    qntCasas = qntCasas + 1;
                }
            }
            else if (casa.getCoordenadaY() == 8) {
                if (!tabuleiro.getCasa(8,6).isOcupada()) {
                    proximas[qntCasas][0] = 8;
                    proximas[qntCasas][1] = 6;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(6,6).isOcupada()) {
                    proximas[qntCasas][0] = 6;
                    proximas[qntCasas][1] = 6;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(5,7).isOcupada()) {
                    proximas[qntCasas][0] = 5;
                    proximas[qntCasas][1] = 7;
                    qntCasas = qntCasas + 1;
                }
            }
            else if (casa.getCoordenadaY() == 7) {
                if (!tabuleiro.getCasa(8,5).isOcupada()) {
                    proximas[qntCasas][0] = 8;
                    proximas[qntCasas][1] = 5;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(6,5).isOcupada()) {
                    proximas[qntCasas][0] = 6;
                    proximas[qntCasas][1] = 5;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(5,8).isOcupada()) {
                    proximas[qntCasas][0] = 5;
                    proximas[qntCasas][1] = 8;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(5,6).isOcupada()) {
                    proximas[qntCasas][0] = 5;
                    proximas[qntCasas][1] = 6;
                    qntCasas = qntCasas + 1;
                }
            }
            else if (casa.getCoordenadaY() == 2) {
                if (!tabuleiro.getCasa(8,4).isOcupada()) {
                    proximas[qntCasas][0] = 8;
                    proximas[qntCasas][1] = 4;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(6,4).isOcupada()) {
                    proximas[qntCasas][0] = 6;
                    proximas[qntCasas][1] = 4;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(4,3).isOcupada()) {
                    proximas[qntCasas][0] = 4;
                    proximas[qntCasas][1] = 3;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(4,1).isOcupada()) {
                    proximas[qntCasas][0] = 4;
                    proximas[qntCasas][1] = 1;
                    qntCasas = qntCasas + 1;
                }
            }
            else if (casa.getCoordenadaY() == 1) {
                if (!tabuleiro.getCasa(8,3).isOcupada()) {
                    proximas[qntCasas][0] = 8;
                    proximas[qntCasas][1] = 3;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(6,3).isOcupada()) {
                    proximas[qntCasas][0] = 6;
                    proximas[qntCasas][1] = 3;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(5,2).isOcupada()) {
                    proximas[qntCasas][0] = 5;
                    proximas[qntCasas][1] = 2;
                    qntCasas = qntCasas + 1;
                }
            }
        }
        else if (casa.getCoordenadaX() == 8) {
            if ((casa.getCoordenadaY()  < 7) && (casa.getCoordenadaY() > 2)) {
                if (!tabuleiro.getCasa(7,casa.getCoordenadaY() + 2).isOcupada()) {
                    proximas[qntCasas][0] = 7;
                    proximas[qntCasas][1] = casa.getCoordenadaY() + 2;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(6,casa.getCoordenadaY() + 1).isOcupada()) {
                    proximas[qntCasas][0] = 6;
                    proximas[qntCasas][1] = casa.getCoordenadaY() + 1;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(7,casa.getCoordenadaY() - 2).isOcupada()) {
                    proximas[qntCasas][0] = 7;
                    proximas[qntCasas][1] = casa.getCoordenadaY() - 2;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(6,casa.getCoordenadaY() - 1).isOcupada()) {
                    proximas[qntCasas][0] = 6;
                    proximas[qntCasas][1] = casa.getCoordenadaY() - 1;
                    qntCasas = qntCasas + 1;
                }
            } else if (casa.getCoordenadaY() == 7) {
                if (!tabuleiro.getCasa(6,8).isOcupada()) {
                    proximas[qntCasas][0] = 6;
                    proximas[qntCasas][1] = 8;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(7,5).isOcupada()) {
                    proximas[qntCasas][0] = 7;
                    proximas[qntCasas][1] = 5;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(6,6).isOcupada()) {
                    proximas[qntCasas][0] = 6;
                    proximas[qntCasas][1] = 6;
                    qntCasas = qntCasas + 1;
                }
            }
            else if (casa.getCoordenadaY() == 8) {
                if (!tabuleiro.getCasa(7,6).isOcupada()) {
                    proximas[qntCasas][0] = 7;
                    proximas[qntCasas][1] = 6;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(6,7).isOcupada()) {
                    proximas[qntCasas][0] = 6;
                    proximas[qntCasas][1] = 7;
                    qntCasas = qntCasas + 1;
                }
            }
            else if (casa.getCoordenadaY() == 1) {
                if (!tabuleiro.getCasa(7,3).isOcupada()) {
                    proximas[qntCasas][0] = 7;
                    proximas[qntCasas][1] = 3;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(6,2).isOcupada()) {
                    proximas[qntCasas][0] = 6;
                    proximas[qntCasas][1] = 2;
                    qntCasas = qntCasas + 1;
                }
            }
            else if (casa.getCoordenadaY() == 2) {
                if (tabuleiro.getCasa(6,1).isOcupada()) {
                    proximas[qntCasas][0] = 6;
                    proximas[qntCasas][1] = 1;
                    qntCasas = qntCasas + 1;
                }
                if (tabuleiro.getCasa(6,3).isOcupada()) {
                    proximas[qntCasas][0] = 6;
                    proximas[qntCasas][1] = 3;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(7,4).isOcupada()) {
                    proximas[qntCasas][0] = 7;
                    proximas[qntCasas][1] = 4;
                    qntCasas = qntCasas + 1;
                }
            }
        }
        else if ((casa.getCoordenadaX() > 2) && (casa.getCoordenadaX() < 7)) {
            if ((casa.getCoordenadaY() > 2) && (casa.getCoordenadaY() < 7)) {
                if (!tabuleiro.getCasa(casa.getCoordenadaX() + 1,casa.getCoordenadaY() + 2).isOcupada()) {
                    proximas[qntCasas][0] = casa.getCoordenadaX() + 1;
                    proximas[qntCasas][1] = casa.getCoordenadaY() + 2;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(casa.getCoordenadaX() + 1,casa.getCoordenadaY() - 2).isOcupada()) {
                    proximas[qntCasas][0] = casa.getCoordenadaX() + 1;
                    proximas[qntCasas][1] = casa.getCoordenadaY() - 2;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(casa.getCoordenadaX() - 1,casa.getCoordenadaY() + 2).isOcupada()) {
                    proximas[qntCasas][0] = casa.getCoordenadaX() - 1;
                    proximas[qntCasas][1] = casa.getCoordenadaY() + 2;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(casa.getCoordenadaX() - 1,casa.getCoordenadaY() - 2).isOcupada()) {
                    proximas[qntCasas][0] = casa.getCoordenadaX() - 1;
                    proximas[qntCasas][1] = casa.getCoordenadaY() - 2;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(casa.getCoordenadaX() + 2,casa.getCoordenadaY() + 1).isOcupada()) {
                    proximas[qntCasas][0] = casa.getCoordenadaX() + 2;
                    proximas[qntCasas][1] = casa.getCoordenadaY() + 1;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(casa.getCoordenadaX() + 2,casa.getCoordenadaY() - 1).isOcupada()) {
                    proximas[qntCasas][0] = casa.getCoordenadaX() + 2;
                    proximas[qntCasas][1] = casa.getCoordenadaY() - 1;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(casa.getCoordenadaX() - 2,casa.getCoordenadaY() + 1).isOcupada()) {
                    proximas[qntCasas][0] = casa.getCoordenadaX() - 2;
                    proximas[qntCasas][1] = casa.getCoordenadaY() + 1;
                    qntCasas = qntCasas + 1;
                }
                if (!tabuleiro.getCasa(casa.getCoordenadaX() - 2,casa.getCoordenadaY() - 1).isOcupada()) {
                    proximas[qntCasas][0] = casa.getCoordenadaX() - 2;
                    proximas[qntCasas][1] = casa.getCoordenadaY() - 1;
                    qntCasas = qntCasas + 1;
                }
            }
        }
        return proximas ;
    }
}
