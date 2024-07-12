import java.util.Objects;

public class Tabuleiro {
    private Casa[][] casas;
    private boolean jogadorAtualbranca = true;

    //Construtor que cria o Tabuleiro e as 64 casas cada uma com suas respectivas coordenadas
    public Tabuleiro() {
        casas = new Casa[8][8];
        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                casas[linha][coluna] = new Casa(linha, coluna);
            }
        }
    }

    public void trocaJogador() {
        if (jogadorAtualbranca) {
            jogadorAtualbranca = false;
        } else {
            jogadorAtualbranca = true;
        }
    }

    String[][] map = new String[8][8];

    //metodo que mapeia as peças do tabuleiro
    public void map() {
        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                if (casas[linha][coluna].isOcupada()) {
                    map[linha][coluna] = casas[linha][coluna].getPeca().getNome();
                } else {
                    map[linha][coluna] = " ";
                }
            }
        }
    }

    //Metodo que inicializa o tabuleiro com cada peca no respectivo lugar
    public void inicializaTabuleliro() {
        Torre T1 = new Torre("T1", casas[0][0], true, "torre_preta_fundo_branco.jpeg", "torre_preta_fundo_verde.png", "torre_branca_fundo_branco.png", "torre_branca_fundo_verde.png");
        casas[0][0].colocarPeca(T1);//torre branca esquerda
        Cavalo H1 = new Cavalo("H1", casas[0][1], true, "cavalo_preto_fundo_branco.jpeg", "cavalo_preto_fundo_verde.png", "cavalo_branco_fundo_branco.png", "cavalo_branco_fundo_verde.png");
        casas[0][1].colocarPeca(H1);//cavalo branco esquerdo
        Bispo B1 = new Bispo("B1", casas[0][2], true, "bispo_preto_fundo_branco.png", "bispo_preto_fundo_verde.png", "bispo_branco_fundo_verde.png", "bispo_branco_fundo_branco.png");
        casas[0][2].colocarPeca(B1);//bispo branco esquerdo
        Rei KK = new Rei("KK", casas[0][3], true, "rei_preto_fundo_branco.jpeg", "rei_preto_fundo_verde.png", "rei_branco_fundo_branco.png", "rei_branco_fundo_verde.png");
        casas[0][3].colocarPeca(KK);//rei branco
        Rainha QQ = new Rainha("QQ", casas[0][4], true, "rainha_preta_fundo_branco.jpeg", "rainha_preta_fundo_verde.png", "rainha_branca_fundo_branco.png", "rainha_branca_fundo_verde.png");
        casas[0][4].colocarPeca(QQ);//rainha branca
        Bispo B2 = new Bispo("B2", casas[0][5], true, "bispo_preto_fundo_branco.png", "bispo_preto_fundo_verde.png", "bispo_branco_fundo_verde.png", "bispo_branco_fundo_branco.png");
        casas[0][5].colocarPeca(B2);//bispo branco esquerdo
        Cavalo H2 = new Cavalo("H2", casas[0][6], true, "cavalo_preto_fundo_branco.jpeg", "cavalo_preto_fundo_verde.png", "cavalo_branco_fundo_branco.png", "cavalo_branco_fundo_verde.png");
        casas[0][6].colocarPeca(H2);//cavalo branco esquerdo
        Torre T2 = new Torre("T2", casas[0][7], true, "torre_preta_fundo_branco.jpeg", "torre_preta_fundo_verde.png", "torre_branca_fundo_branco.png", "torre_branca_fundo_verde.png");
        casas[0][7].colocarPeca(T2);//torre branca direita
        Peca P1 = new Peao("P1", casas[1][0], true, "peao.jpeg", "peao_branco.png", "peao_preto_fundo_verde.png", "peao_branco_fundo_verde.png");
        casas[1][0].colocarPeca(P1);//sequencia de peoes
        Peca P2 = new Peao("P2", casas[1][1], true, "peao.jpeg", "peao_branco.png", "peao_preto_fundo_verde.png", "peao_branco_fundo_verde.png");
        casas[1][1].colocarPeca(P2);
        Peao P3 = new Peao("P3", casas[1][2], true, "peao.jpeg", "peao_branco.png", "peao_preto_fundo_verde.png", "peao_branco_fundo_verde.png");
        casas[1][2].colocarPeca(P3);
        Peao P4 = new Peao("P4", casas[1][3], true, "peao.jpeg", "peao_branco.png", "peao_preto_fundo_verde.png", "peao_branco_fundo_verde.png");
        casas[1][3].colocarPeca(P4);
        Peao P5 = new Peao("P5", casas[1][4], true, "peao.jpeg", "peao_branco.png", "peao_preto_fundo_verde.png", "peao_branco_fundo_verde.png");
        casas[1][4].colocarPeca(P5);
        Peao P6 = new Peao("P6", casas[1][5], true, "peao.jpeg", "peao_branco.png", "peao_preto_fundo_verde.png", "peao_branco_fundo_verde.png");
        casas[1][5].colocarPeca(P6);
        Peao P7 = new Peao("P7", casas[1][6], true, "peao.jpeg", "peao_branco.png", "peao_preto_fundo_verde.png", "peao_branco_fundo_verde.png");
        casas[1][6].colocarPeca(P7);
        Peao P8 = new Peao("P8", casas[1][7], true, "peao.jpeg", "peao_branco.png", "peao_preto_fundo_verde.png", "peao_branco_fundo_verde.png");
        casas[1][7].colocarPeca(P8);
        Torre t1 = new Torre("t1", casas[7][0], false, "torre_preta_fundo_branco.jpeg", "torre_preta_fundo_verde.png", "torre_branca_fundo_branco.png", "torre_branca_fundo_verde.png"); // torre branca esquerda
        casas[7][0].colocarPeca(t1);
        Cavalo h1 = new Cavalo("h1", casas[7][1], false, "cavalo_preto_fundo_branco.jpeg", "cavalo_preto_fundo_verde.png", "cavalo_branco_fundo_branco.png", "cavalo_branco_fundo_verde.png");// cavalo branco esquerdo
        casas[7][1].colocarPeca(h1);
        Bispo b1 = new Bispo("b1", casas[7][2], false, "bispo_preto_fundo_branco.png", "bispo_preto_fundo_verde.png", "bispo_branco_fundo_verde.png", "bispo_branco_fundo_branco.png"); // bispo branco esquerdo
        casas[7][2].colocarPeca(b1);
        Rei kk = new Rei("kk", casas[7][3], false, "rei_preto_fundo_branco.jpeg", "rei_preto_fundo_verde.png", "rei_branco_fundo_branco.png", "rei_branco_fundo_verde.png"); // rei branco
        casas[7][3].colocarPeca(kk);
        Rainha qq = new Rainha("qq", casas[7][4], false, "rainha_preta_fundo_branco.jpeg", "rainha_preta_fundo_verde.png", "rainha_branca_fundo_branco.png", "rainha_branca_fundo_verde.png"); // rainha branca
        casas[7][4].colocarPeca(qq);
        Bispo b2 = new Bispo("b2", casas[7][5], false, "bispo_preto_fundo_branco.png", "bispo_preto_fundo_verde.png", "bispo_branco_fundo_verde.png", "bispo_branco_fundo_branco.png"); // bispo branco esquerdo
        casas[7][5].colocarPeca(b2);
        Cavalo h2 = new Cavalo("h2", casas[7][6], false, "cavalo_preto_fundo_branco.jpeg", "cavalo_preto_fundo_verde.png", "cavalo_branco_fundo_branco.png", "cavalo_branco_fundo_verde.png"); // cavalo branco esquerdo
        casas[7][6].colocarPeca(h2);
        Torre t2 = new Torre("t2", casas[7][7], false, "torre_preta_fundo_branco.jpeg", "torre_preta_fundo_verde.png", "torre_branca_fundo_branco.png", "torre_branca_fundo_verde.png"); // torre branca direita
        casas[7][7].colocarPeca(t2);
        Peao p1 = new Peao("p1", casas[6][0], false, "peao.jpeg", "peao_branco.png", "peao_preto_fundo_verde.png", "peao_branco_fundo_verde.png"); // sequencia de peoes
        casas[6][0].colocarPeca(p1);
        Peao p2 = new Peao("p2", casas[6][1], false, "peao.jpeg", "peao_branco.png", "peao_preto_fundo_verde.png", "peao_branco_fundo_verde.png");
        casas[6][1].colocarPeca(p2);
        Peao p3 = new Peao("p3", casas[6][2], false, "peao.jpeg", "peao_branco.png", "peao_preto_fundo_verde.png", "peao_branco_fundo_verde.png");
        casas[6][2].colocarPeca(p3);
        Peao p4 = new Peao("p4", casas[6][3], false, "peao.jpeg", "peao_branco.png", "peao_preto_fundo_verde.png", "peao_branco_fundo_verde.png");
        casas[6][3].colocarPeca(p4);
        Peao p5 = new Peao("p5", casas[6][4], false, "peao.jpeg", "peao_branco.png", "peao_preto_fundo_verde.png", "peao_branco_fundo_verde.png");
        casas[6][4].colocarPeca(p5);
        Peao p6 = new Peao("p6", casas[6][5], false, "peao.jpeg", "peao_branco.png", "peao_preto_fundo_verde.png", "peao_branco_fundo_verde.png");
        casas[6][5].colocarPeca(p6);
        Peao p7 = new Peao("p7", casas[6][6], false, "peao.jpeg", "peao_branco.png", "peao_preto_fundo_verde.png", "peao_branco_fundo_verde.png");
        casas[6][6].colocarPeca(p7);
        Peao p8 = new Peao("p8", casas[6][7], false, "peao.jpeg", "peao_branco.png", "peao_preto_fundo_verde.png", "peao_branco_fundo_verde.png");
        casas[6][7].colocarPeca(p8);
        map();
    }

    //Metodo que retorna a casa i,j do tabuleiro
    public Casa getCasa(int linha, int coluna) {
        return casas[linha][coluna];
    }

    //Metodo que checa se a casa i,j esta ocupada
    public boolean estaOcupada(int linha, int coluna) {
        return casas[linha][coluna].isOcupada();
    }

    //o metodo locatepeca recebe uma string contendo o nome de uma peça, pesquisa essa
    //peça no array de peças gerado pelo método map e retorna suas coordenadas
    public int[] locatepeca(String peca) {
        int[] pos = new int[2];
        pos[0] = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j].equals(peca)) {
                    pos[0] = i;
                    pos[1] = j;
                    break;
                }
            }
        }
        return pos;
    }

    public boolean moverPeca(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        Peca peca = getCasa(linhaOrigem, colunaOrigem).getPeca();
        if (peca.getcolor() == jogadorAtualbranca) {
            //Vericar se o rei do jogador nao esta em check,se estiver quem deve ser movido é o rei
            if (peca instanceof Peao) {
                Peao peao = (Peao) peca;
                trocaJogador();
                return peao.move(this, linhaDestino, colunaDestino);
            } else if (peca instanceof Torre) {
                Torre torre = (Torre) peca;
                trocaJogador();
                return torre.move(this, linhaDestino, colunaDestino);
            } else if (peca instanceof Cavalo) {
                Cavalo cavalo = (Cavalo) peca;
                trocaJogador();
                return cavalo.move(this, linhaDestino, colunaDestino);
            } else if (peca instanceof Bispo) {
                Bispo bispo = (Bispo) peca;
                trocaJogador();
                return bispo.move(this, linhaDestino, colunaDestino);
            } else if (peca instanceof Rainha) {
                trocaJogador();
                Rainha rainha = (Rainha) peca;
                return rainha.move(this, linhaDestino, colunaDestino);
            } else if (peca instanceof Rei) {
                Rei rei = (Rei) peca;
                trocaJogador();
                return rei.move(this, linhaDestino, colunaDestino);
            }
        }
        System.out.println("Não é sua vez de jogar");
        return false;
    }

    public boolean getJogadorAtual() {
        return jogadorAtualbranca;
    }
}
