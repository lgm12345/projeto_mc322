public class Tabuleiro {
    private Casa[][] casas;

    //Construtor que cria o Tabuleiro e as 64 casas cada uma com suas respectivas coordenadas
    public Tabuleiro() {
        casas = new Casa[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                casas[i][j] = new Casa(i, j);
            }
        }
    }

    //Metodo que inicializa o tabuleiro com cada peca no respectivo lugar
    public void inicializaTabuleliro() {
        Torre T1 = new Torre(casas[0][0],true) ;//torre branca esquerda
        Cavalo H1 = new Cavalo(casas[0][1],true);//cavalo branco esquerdo
        Bispo B1 = new Bispo(casas[0][2],true);//bispo branco esquerdo
        Rei KK = new Rei(casas[0][3],true);//rei branco
        Rainha QQ = new Rainha(casas[0][4],true);//rainha branca
        Bispo B2 = new Bispo(casas[0][5],true);//bispo branco esquerdo
        Cavalo H2 = new Cavalo(casas[0][6],true);//cavalo branco esquerdo
        Torre T2 = new Torre(casas[0][7],true) ;//torre branca direita
        Peao P1 = new Peao(casas[1][0], true);//sequencia de peoes
        Peao P2 = new Peao(casas[1][1], true);
        Peao P3 = new Peao(casas[1][2], true);
        Peao P4 = new Peao(casas[1][3], true);
        Peao P5 = new Peao(casas[1][4], true);
        Peao P6 = new Peao(casas[1][5], true);
        Peao P7 = new Peao(casas[1][6], true);
        Peao P8 = new Peao(casas[1][7], true);

        Torre t1 = new Torre(casas[7][0], false); // torre branca esquerda
        Cavalo h1 = new Cavalo(casas[7][1], false); // cavalo branco esquerdo
        Bispo b1 = new Bispo(casas[7][2], false); // bispo branco esquerdo
        Rei kk = new Rei(casas[7][3], false); // rei branco
        Rainha qq = new Rainha(casas[7][4], false); // rainha branca
        Bispo b2 = new Bispo(casas[7][5], false); // bispo branco esquerdo
        Cavalo h2 = new Cavalo(casas[7][6], false); // cavalo branco esquerdo
        Torre t2 = new Torre(casas[7][7], false); // torre branca direita
        Peao p1 = new Peao(casas[6][0], false); // sequencia de peoes
        Peao p2 = new Peao(casas[6][1], false);
        Peao p3 = new Peao(casas[6][2], false);
        Peao p4 = new Peao(casas[6][3], false);
        Peao p5 = new Peao(casas[6][4], false);
        Peao p6 = new Peao(casas[6][5], false);
        Peao p7 = new Peao(casas[6][6], false);
        Peao p8 = new Peao(casas[6][7], false);

    }

    //Metodo que retorna a casa i,j do tabuleiro
    public Casa getCasa(int i,int j) {
        return casas[i][j] ;
    }

    //Metodo que checa se a casa i,j esta ocupada
    public boolean estaOcupada(int i,int j) {
        return casas[i][j].isOcupada() ;
    }

    //metodo que devolve um mapa das pecas
    public String[][] map(){
        String[][] map = new String[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(casas[i][j].isOcupada()) {
                    map[i][j] = casas[i][j].getpeca();
                } else {
                    map[i][j] = " ";
                }
            }
        }
        return map;
    }
}
