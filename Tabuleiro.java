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

    String[][] map = new String[8][8];

    //metodo que mapeia as peças do tabuleiro
    public void map(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(casas[i][j].isOcupada()) {
                    map[i][j] = casas[i][j].getpeca().tostring();
                } else {
                    map[i][j] = " ";
                }
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

        map();
    }

    //Metodo que retorna a casa i,j do tabuleiro
    public Casa getCasa(int i,int j) {
        return casas[i][j] ;
    }

    //Metodo que checa se a casa i,j esta ocupada
    public boolean estaOcupada(int i,int j) {
        return casas[i][j].isOcupada() ;
    }

    //o metodo locatepeca recebe uma string contendo o nome de uma peça, pesquisa essa
    //peça no array de peças gerado pelo método map e retorna suas coordenadas
    public int[] locatepeca(String peca){
        int[] pos = new int[2];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(map[i][j].equals(peca)){
                    pos[0] = i;
                    pos[1] = j;
                    break;
                }
            }
        }
        return pos;
    }

    //metodo que faz a movimentação das pecas
    //ele toma o nome da peca, localiza a posicao inicial e final
    public void move(String peca, int xf, int yf){
        int[] pos = locatepeca(peca);
        int xi = pos[0];
        int yi = pos[1];
        if(estaocupada(xf, yf)){//se a posica final estiver ocupada, ele "mata" a peca primeiro.
            casas[xf][yf].getpeca().setcasa(null);
        }
        casas[xf][yf].colocarpeca(casas[xi][yi].getpeca());//peça colocada na nova posição
        casas[xi][yi].removerpeca();//peça removida da posição anterior

        map();//mapeamento refeito
    }

}
