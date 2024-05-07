public class Tabuleiro {
    private Casa[][] casas;

    //Construtor que cria o Tabuleiro e as 64 casas cada uma com suas respectivas coordenadas
    //
    public Tabuleiro() {
        casas = new Casa[8][8];
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                casas[i][j] = new Casa(i, j);
            }
        }
    }

    //Metodo que inicializa o tabuleiro com cada peca no respectivo lugar





    //Metodo que retorna a casa i,j do tabuleiro

    public Casa getCasa(int i,int j) {
        return casas[i][j] ;
    }


    //Método que checa se a casa i,j esta ocupada
    public boolean estaOcupada(int i,int j) {
        return casas[i][j].isOcupada() ;
    }


}
