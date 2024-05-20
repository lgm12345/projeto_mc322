public class Rainha extends Peca{

    public Rainha(String nome,Casa casa, boolean branca) {
        super(nome,casa) ;
        this.branca = branca ;
    }

    int qntCasas = 0;
    int[][] proximas = new int[21][2];
    int qntinimigas = 0;
    int[][] inimigas = new int[8][2];


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
                enemy = true ;
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
        int [][][] positions = new int[8][14][2]; //lista de posicoes para serem verificadas
        int[] lengths = new int[8]; // Controla o número de posições
        for (int i = 1; i < 8; i++){//adicionando posicoes da torre
            positions[0][lengths[0]] = (new int[]{X + i, Y});//adicionando posicoes horizontais positivas
            lengths[0]++;
            positions[1][lengths[1]] = (new int[]{X, Y + i});//adicionando posicoes verticais positivas
            lengths[1]++;
            positions[2][lengths[2]] = (new int[]{X - i, Y});//adicionando posicoes horizontais negativas
            lengths[2]++;
            positions[3][lengths[3]] = (new int[]{X, Y - i});//adicionando posicoes verticais negativas
            lengths[3]++;
            positions[4][lengths[4]] = (new int[]{X + i, Y}); // Adicionando posições horizontais positivas
            lengths[4]++;
            positions[5][lengths[5]] = new int[]{X, Y + i}; // Adicionando posições verticais positivas
            lengths[5]++;
            positions[6][lengths[6]] = new int[]{X - i, Y}; // Adicionando posições horizontais negativas
            lengths[6]++;
            positions[7][lengths[7]] = new int[]{X, Y - i}; // Adicionando posições verticais negativas
            lengths[7]++;
        }

        for (int i = 0; i < 8; i++) {//varremos cada direcao individualmente
            for (int j = 0; j < lengths[i]; j++) {//tomamos as coordenadas do vetor positions
                int[] coord = positions[i][j];
                if (checknsave(tabuleiro, coord[0], coord[1])) {//escrevemos no vetor proximas, ate que uma inimiga seja encontrada
                    break;
                }
            }
        }
    }

    //o metodo resetpositions zera os vetores de proximas posicoes possiveis e de pecas inimigas e refaz os dois
    public void resetpositions(Tabuleiro tabuleiro, int X, int Y){
        for (int i = 0; i < 21; i++){
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

    int cx = 21;
    public int[][] movmap(){
        int[][] map = new int[cx][2];
        for (int i = 0; i < cx; i++){
            map[i][0] = proximas[i][0];
            map[i][1] = proximas[i][1];
        }
        return map;
    }

    public boolean move(Tabuleiro tabuleiro,int X,int Y) {
        resetpositions(tabuleiro,X,Y);
        for (int i = 0;i < proximas.length;i++) {
            if ((proximas[i][0] == X) && (proximas[i][1] == Y)) {
                tabuleiro.getCasa(super.getCasa().getCoordenadaX(),super.getCasa().getCoordenadaY()) ;
                tabuleiro.getCasa(X,Y).colocarPeca(this) ;
                return true ;
            }
        }
        for (int i = 0;i < inimigas.length;i++) {
            if ((inimigas[i][0] == X) && (inimigas[i][1] == Y)) {
                tabuleiro.getCasa(X,Y).removerPeca();
                tabuleiro.getCasa(X,Y).colocarPeca(this);
                return true ;
            }
        }
        return false ;
    /*
    public int[][] possiveisProximasPosicoes(Tabuleiro tabuleiro) {
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
            if (!tabuleiro.getCasa(i, casa.getCoordenadaY()).isOcupada()) {
                possiveisCasas[qntCasas][0] = i ;
                possiveisCasas[qntCasas][1] = casa.getCoordenadaY() ;
                qntCasas = qntCasas + 1 ;
            }
            else {
                break ;
            }
        }
        for (int j = 1;j < 9;j ++) {
            if (!tabuleiro.getCasa(casa.getCoordenadaX(), j).isOcupada()) {
                possiveisCasas[qntCasas][0] = casa.getCoordenadaX();
                possiveisCasas[qntCasas][1] = j;
                qntCasas = qntCasas + 1;
            }
            else {
                break ;
            }
        }
        return possiveisCasas ;
    }
    */
}
