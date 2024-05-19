import java.util.Objects;

public class Peao extends Peca implements Movimentavel{
    public boolean first ;
    private boolean promoted;
    private int step;

    public Peao(Casa casa,boolean branca) {
        super(casa) ;
        this.first = true ;
        this.branca = branca ;
        this.promoted = false;

        if(branca){
            step = 1;
        } else {
            step = -1;
        }
    }
    public String getClassName() {
        return Peao.class.getSimpleName() ;
    }
    //metodo que identifica que o peao ja realizou o primeiro movimento
    public void moved(){
        this.first = false;
    }

    //metodo que identifica se o peao ja foi promovido
    public void promote(){
        this.promoted = true;
    }

    int qntCasas = 0;
    int[][] proximas = new int[2][2];
    int qntinimigas = 0;
    int[][] inimigas = new int[2][2];

    //o metodo que movimenta o peao deve ter uma condicao: quando a coordenada de destino eh X,7 ele eh promovido a uma outra peca.

    //o metodo checknsave usa o metodo "isinrange" para verificar se a posicao x,y pertence ao tabuleiro
    //em caso positivo, verifica se a posicao esta ocupada
    //se nao, a posicao eh salva na lista de proximas posicoes e o contador eh atualizado
    //como a movimentacao e ataque do peao eh diferente, o metodo eh modificado: o peao mata em diagonal e pode andar duas casas se for o primeiro mov.
    public boolean checknsave(Tabuleiro tabuleiro, int X, int Y){
        boolean enemy = false;
        if(isinrange(X,Y)){ //verifica se pertence ao tabuleiro
            if(searchpeca(tabuleiro, X, Y + step) == 0){ //verifica se esta vazio
                proximas[qntCasas][0] = X;
                proximas[qntCasas][1] = Y + step;
                qntCasas += 1;
            } 
            if(first){
                if(searchpeca(tabuleiro ,X, Y + 2*step) == 0){ //verifica se esta vazio
                    proximas[qntCasas][0] = X;
                    proximas[qntCasas][1] = Y + 2*step;
                    qntCasas += 1;
                }
            }
            if (searchpeca(tabuleiro, X + 1, Y + step) ==  -1){ //procura inimiga
                inimigas[qntinimigas][0] = X + 1;
                inimigas[qntinimigas][1] = Y + step;
                qntinimigas += 1;
                enemy = true ;
            }
            if (searchpeca(tabuleiro, X - 1, Y + step) ==  -1){ //procura inimiga
                inimigas[qntinimigas][0] = X - 1;
                inimigas[qntinimigas][1] = Y + step;
                qntinimigas += 1;
                enemy = true ;
            }
        }
        return enemy ;
    }

    //o metodo listfreepositions toma as coordenadas atuais do cavalo e usa o metodo checknsave em loop para guardar todas posicoes livres possiveis
    public void listfreepositions(Tabuleiro tabuleiro, int X, int Y){
        checknsave(tabuleiro, X, Y);
    }

    //o metodo resetpositions zera os vetores de proximas posicoes possiveis e de pecas inimigas e refaz os dois
    public void resetpositions(Tabuleiro tabuleiro, int X, int Y){
        
        proximas[0][0] = 0;
        proximas[0][1] = 0;
        proximas[1][0] = 0;
        proximas[1][1] = 0;
        
        inimigas[0][0] = 0;
        inimigas[0][1] = 0;
        inimigas[1][0] = 0;
        inimigas[1][1] = 0;
        
        qntCasas = 0;
        qntinimigas = 0;

        listfreepositions(tabuleiro, X, Y);
    }

    int cx = 2;
    public int[][] movmap(){
        int[][] map = new int[cx][2];
        for (int i = 0; i < cx; i++){
            map[i][0] = proximas[i][0];
            map[i][1] = proximas[i][1];
        }
        return map;
    }

    /*
    public int[] proximasPossiveisPosicoes() {
        int[] proximas = new int[2] ;
        if (inicial) {
            if (branca) {
                proximas[0] = 2 ;
                proximas[1] = 3;
                inicial = false ;
            }
            else {
                proximas[0] = 5 ;
                proximas[1] = 4 ;
                inicial = false ;
            }
        }
        else {
            if(branca) {
                proximas[0] = proximas[1] = casa.getCoordenadaY() + 1 ;
            }
            else {
                proximas[0] = proximas[1] = casa.getCoordenadaY() - 1 ;
            }
        }
        return proximas ;
    }
    */


}
