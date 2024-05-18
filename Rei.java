public class Rei extends Peca {

    public Rei(Casa casa, boolean branca) {
        super(casa) ;
        this.branca = branca ;
    }

    //observe que a movimentacao do rei tem que carregar: 1- a condicao de que ele nao fique em cheque
    //2- se nao houverem movimentacoes possiveis (do rei ou outras pecas) em que o rei escape do cheque, eh dado o mate.

    int qntcasas = 0;
    int[][] proximas = new int[8][2];
    int qntinimigas = 0;
    int[][] inimigas = new int[8][2];
    

    //o metodo checknsave usa o metodo "isinrange" para verificar se a posicao x,y pertence ao tabuleiro
    //em caso positivo, verifica se a posicao esta ocupada
    //se nao, a posicao eh salva na lista de proximas posicoes e o contador eh atualizado
    //se sim, verifica se eh inimiga, se for, salva como inimiga, se nao, nao salva
    public void checknsave(int X, int Y){
        if(isinrange(X,Y)){ //verifica se pertence ao tabuleiro
            if(searchpeca(X, Y) == 0){ //verifica se esta vazio
                proximas[qntcasas][0] = X;
                proximas[qntcasas][1] = Y;
                qntCasas += 1;
            } else if (searchpeca(X, Y) ==  -1){ //se nao esta vazio, verifica se eh inimiga
                inimigas[qntinimigas][0] = X;
                inimigas[qntinimigas][1] = Y;
                qntinimigas += 1;
            }
        }
    }

    //o metodo listfreepositions toma as coordenadas atuais do cavalo e usa o metodo checknsave em loop para guardar todas posicoes livres possiveis
    public void listfreepositions(int X, int Y){
        int [][] positions = new int[8][2]; //lista de posicoes para serem verificadas 
        positionsList.add(new int[]{X + 1, Y + 1});//adicionando diagonal positiva
        positionsList.add(new int[]{X - 1, Y - 1});//adicionando diagonal positiva

        positionsList.add(new int[]{X + 1, Y - 1});//adicionando diagonal negativa
        positionsList.add(new int[]{X - 1, Y + 1});//adicionando diagonal negativa

        positionsList.add(new int[]{X + 1, Y});//adicionando posicoes horizontais
        positionsList.add(new int[]{X - 1, Y});//adicionando posicoes horizontais

        positionsList.add(new int[]{X, Y + 1});//adicionando posicoes verticais
        positionsList.add(new int[]{X, Y - 1});//adicionando posicoes verticais

        for (int[] coord : positions){
            checknsave(coord[0], coord[1]);
        }
    }

    //o metodo resetpositions zera os vetores de proximas posicoes possiveis e de pecas inimigas e refaz os dois
    public void resetpositions(int X, int Y){
        
        proximas[i][0] = 0;
        proximas[i][1] = 0;
    
        inimigas[i][0] = 0;
        inimigas[i][1] = 0;
        
        qntcasas = 0;
        qntinimigas = 0;

        listfreepositions(X, Y);
    }

}