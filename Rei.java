public class Rei extends Peca implements Movimentavel{
    public boolean first ;

    public Rei(String nome,Casa casa, boolean branca) {
        super(nome,casa) ;
        this.branca = branca ;
        this.first = true;
    }

    //observe que a movimentacao do rei tem que carregar: 1- a condicao de que ele nao fique em cheque
    //2- se nao houverem movimentacoes possiveis (do rei ou outras pecas) em que o rei escape do cheque, eh dado o mate.

    int qntCasas = 0;
    int[][] proximas = new int[8][2];
    int qntinimigas = 0;
    int[][] inimigas = new int[8][2];
    
    public String getClassName() {
        return NomePeca.REI.getNome();
    }
    //o metodo checknsave usa o metodo "isinrange" para verificar se a posicao x,y pertence ao tabuleiro
    //em caso positivo, verifica se a posicao esta ocupada
    //se nao, a posicao eh salva na lista de proximas posicoes e o contador eh atualizado
    //se sim, verifica se eh inimiga, se for, salva como inimiga, se nao, nao salva
    public boolean checknsave(Tabuleiro tabuleiro, int X, int Y){
        boolean enemy = false;
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
        int [][] positions = {{X,Y+1}, {X, Y-1}, {X+1, Y+1},{X+1, Y-1}, {X-1, Y+1}, {X-1, Y-1}, {X+1, Y}, {X-1, Y}};

        for (int[] coord : positions){
            checknsave(tabuleiro, coord[0], coord[1]);
        }
    }

    //o metodo resetpositions zera os vetores de proximas posicoes possiveis e de pecas inimigas e refaz os dois
    public void resetpositions(Tabuleiro tabuleiro, int X, int Y){
        
        proximas[X][0] = 0;
        proximas[X][1] = 0;
    
        inimigas[X][0] = 0;
        inimigas[X][1] = 0;
        
        qntCasas = 0;
        qntinimigas = 0;

        listfreepositions(tabuleiro, X, Y);
    }

    public boolean move(Tabuleiro tabuleiro,int X,int Y) {
        resetpositions(tabuleiro, X, Y);
        for (int i = 0; i < proximas.length; i++) {
            if ((proximas[i][0] == X) && (proximas[i][1] == Y)) {
                tabuleiro.getCasa(super.getCasa().getCoordenadaX(), super.getCasa().getCoordenadaY());
                tabuleiro.getCasa(X, Y).colocarPeca(this);
                return true;
            }
        }
        for (int i = 0; i < inimigas.length; i++) {
            if ((inimigas[i][0] == X) && (inimigas[i][1] == Y)) {
                tabuleiro.getCasa(X, Y).removerPeca();
                tabuleiro.getCasa(X, Y).colocarPeca(this);
                return true;
            }
        }
        return false;
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

}