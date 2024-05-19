public class Cavalo extends Peca implements  Movimentavel{
    public Cavalo(Casa casa, boolean branca) {
        super(casa);
        this.branca = branca;
    }
    
    int qntCasas = 0;
    int[][] proximas = new int[8][2];
    int qntinimigas = 0;
    int[][] inimigas = new int[8][2];
    
    public String getClassName() {
        return Cavalo.class.getSimpleName() ;
    }
    //o metodo checknsave usa o metodo "isinrange" para verificar se a posicao x,y pertence ao tabuleiro
    //em caso positivo, verifica se a posicao esta ocupada
    //se nao, a posicao eh salva na lista de proximas posicoes e o contador eh atualizado
    //se sim, verifica se eh inimiga, se for, salva como inimiga, se nao, nao salva
    public boolean checknsave(Tabuleiro tabuleiro, int X, int Y){
        boolean enemy = false ;
        if(isinrange(X,Y)){ //verifica se pertence ao tabuleiro
            if(searchpeca(tabuleiro, X, Y) == 0){ //verifica se esta vazio
                proximas[qntCasas][0] = X;
                proximas[qntCasas][1] = Y;
                qntCasas += 1;
            } else if (searchpeca(tabuleiro, X, Y) ==  -1){ //se nao esta vazio, verifica se eh inimiga
                inimigas[qntinimigas][0] = X;
                inimigas[qntinimigas][1] = Y;
                qntinimigas += 1;
                enemy = true ;
            }
        }
        return enemy ;
    }

    //o metodo listfreepositions toma as coordenadas atuais do cavalo e usa o metodo checknsave em loop para guardar todas posicoes livres possiveis
    public void listfreepositions(Tabuleiro tabuleiro, int X, int Y){
        int [][] positions = {{X+1,Y+2}, {X+1, Y-2}, {X+2, Y+1},{X+2, Y-1}, {X-1, Y+2}, {X-1, Y-2}, {X-2, Y+1}, {X-2, Y-1}};
        for (int[] coord : positions){
            checknsave(tabuleiro, coord[0], coord[1]);
        }
    }

    //o metodo resetpositions zera os vetores de proximas posicoes possiveis e de pecas inimigas e refaz os dois
    public void resetpositions(Tabuleiro tabuleiro, int X, int Y){
        for (int i = 0; i < 8; i++){
            proximas[i][0] = 0;
            proximas[i][1] = 0;
        }
        for (int i = 0; i < 8; i++){
            inimigas[i][0] = 0;
            inimigas[i][1] = 0;
        }
        qntCasas = 0;
        qntinimigas = 0;

        listfreepositions(tabuleiro, X, Y);
    }

    int cx = 8;
    public int[][] movmap(){
        int[][] map = new int[cx][2];
        for (int i = 0; i < cx; i++){
            map[i][0] = proximas[i][0];
            map[i][1] = proximas[i][1];
        }
        return map;
    }


    /*
    //Método que retorna em uma matriz as possiveis proximas posicoes para o cavalo ir sem contar ainda obstrução
    //no caminho,sendo a primeira coluna a posicao x e a segunda coluna a posicao y
    public int[][] proximaPosicaoCavalo(Tabuleiro tabuleiro) {


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
    */
}
