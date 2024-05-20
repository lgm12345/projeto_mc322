public class Print{
    
    Print(){
        System.out.println("Iniciando partida de jadrez");
        System.out.print("\n");
        System.out.println("Para a leitura do tabuleiro, atente-se:");
        System.out.println("1- Dentro do grid, cada peça é representada por uma letra.");
        System.out.println("2- As peças brancas começam na parte de baixo e são representadas por letra maiúscula.");
        System.out.println("3- As peças pretas começam na parte de cima e são representadas por letra minúscula.");
        System.out.println("4- As peças brancas são representadas por P (peao), H (cavalo), B (bispo), T (torre), Q (rainha), K (rei).");
        System.out.println("5- As peças pretas são representadas por p (peao), h (cavalo), b (bispo), t (torre), q (rainha), k (rei).");
        System.out.println("6- As peças em multiplicidade recebem um número após a letra, que representa sua posição inicial da esquerda para a direita.");
        System.out.println("O tabuleiro é como representado abaixo:");
        System.out.println("      1    2    3    4    5    6    7    8");
        /*
        -----------------------------------------
      1 | t1 | h1 | b1 | kk | qq | b2 | h2 | t2 |
        -----------------------------------------
      2 | p1 | p2 | p3 | p4 | p5 | p6 | p7 | p8 |
        -----------------------------------------
      3 |    |    |    |    |    |    |    |    |
        -----------------------------------------
      4 |    |    |    |    |    |    |    |    |
        -----------------------------------------
      5 |    |    |    |    |    |    |    |    |
        -----------------------------------------
      6 |    |    |    |    |    |    |    |    |
        -----------------------------------------
      7 | P1 | P2 | P3 | P4 | P5 | P6 | P7 | P8 |
        -----------------------------------------
      8 | T1 | H1 | B1 | KK | QQ | B2 | H2 | T2 |
        -----------------------------------------
                */

        System.out.print("\n");
        System.out.println("Como jogar:");
        System.out.println("1- A cada jogada o sistema pede para que o jogador digite a peça que deseja mover.");
        System.out.println("2- Em seguida o sistema mostrará as posições possíveis para aquela peça, marcando-as com '()'.");
        System.out.println("3- O jogador deve então inserir as coordenadaspara as quais deseja mover a peça, na forma 'xy'.");
        System.out.println("4- Em seguida o sistema retorna a nova configuração do tabuleiro e o outro jogador recebe a vez.");
        System.out.println("5- Também é possível inserir jogadas especiais, como 'roque' ou 'roque pequeno'.") ;
    }

    public void printh(){
        System.out.println("    ----------------------------------------");
    }

    public void coordx(){
        System.out.println("      1    2    3    4    5    6    7    8");
    }

    public void coordy(int y){
        System.out.print("  " + y + " ");
    }

    public String[][] createmap(Tabuleiro tabuleiro){
        String[][] map = new String[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if (tabuleiro.estaOcupada(i,j)){
                    map[i][j] = (tabuleiro.getCasa(i, j).getPeca()).toString();
                } else {
                    map[i][j] = "  ";
                }
            }
        }
        return map;
    }

    public String readmovmap(Tabuleiro tabuleiro, int[] pos){
        int x = pos[0];
        int y = pos[1];
        int[][]movmap = tabuleiro.getCasa(x, y).getPeca().movmap();
        String read = "  ";
        for (int i = 0; i < movmap.length; i++){
            if(movmap[i][0] == x && movmap[i][1] == y){
                read = "()";
            }
        }
        return read;
    }

    public String[][] createmap(Tabuleiro tabuleiro, int[] pos){
        String[][] map = new String[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if (tabuleiro.estaOcupada(i,j)){
                    map[i][j] = (tabuleiro.getCasa(i, j).getPeca()).toString();
                } else {
                    readmovmap(tabuleiro, pos);
                }
            }
        }
        return map;
    }



    public void print(String[][] map){
        coordx();
        printh();
        for(int i = 0; i < 8; i++){
            coordy(i);
            System.out.print("|");
            for(int j = 0; j < 8; j++){
                System.out.print(" ");
                System.out.print(map[i][j]);
                System.out.print(" |");
            }
            System.out.print("\n");
            printh();
        }
    }


/* 
      1    2    3    4    5    6    7    8
    -----------------------------------------
  1 | t1 | h1 | b1 | kk | qq | b2 | h2 | t2 |
    -----------------------------------------
  2 | p1 | p2 | p3 | p4 | p5 | p6 | p7 | p8 |
    -----------------------------------------
  3 |    |    |    |    |    |    |    |    |
    -----------------------------------------
  4 |    |    |    |    |    |    |    |    |
    -----------------------------------------
  5 |    |    |    |    |    |    |    |    |
    -----------------------------------------
  6 |    |    |    |    |    |    |    |    |
    -----------------------------------------
  7 | P1 | P2 | P3 | P4 | P5 | P6 | P7 | P8 |
    -----------------------------------------
  8 | T1 | H1 | B1 | KK | QQ | B2 | H2 | T2 |
    -----------------------------------------
*/















}