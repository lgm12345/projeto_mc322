public class Print{
    
    Print(){
        System.out.println("Iniciando partida de jadrez");
        system.out.print("\n");
        system.out.println("Para a leitura do tabuleiro, atente-se:");
        system.out.println("1- Dentro do grid, cada peça é representada por uma letra.");
        system.out.println("2- As peças brancas começam na parte de baixo e são representadas por letra maiúscula.");
        system.out.println("3- As peças pretas começam na parte de cima e são representadas por letra minúscula.");
        system.out.println("4- As peças brancas são representadas por P (peao), H (cavalo), B (bispo), T (torre), Q (rainha), K (rei).");
        system.out.println("5- As peças pretas são representadas por p (peao), h (cavalo), b (bispo), t (torre), q (rainha), k (rei).");
        system.out.println("6- As peças em multiplicidade recebem um número após a letra, que representa sua posição inicial da esquerda para a direita.");
        system.out.println("O tabuleiro é como representado abaixo:");
        system.out.println("      1    2    3    4    5    6    7    8
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
        -----------------------------------------");

        system.out.print("\n");
        system.out.println("Como jogar:");
        System.out.println("1- A cada jogada o sistema pede para que o jogador digite a peça que deseja mover.");
        system.out.println("2- Em seguida o sistema mostrará as posições possíveis para aquela peça, marcando-as com '()'.");
        system.out.println("3- O jogador deve então inserir as coordenadaspara as quais deseja mover a peça, na forma 'xy'.");
        system.out.println("4- Em seguida o sistema retorna a nova configuração do tabuleiro e o outro jogador recebe a vez.");
        system.out.println("5- Também é possível inserir jogadas especiais, como 'roque' ou 'roque pequeno'.")
    }

    public void printh(){
        system.out.println("    ----------------------------------------");
    }

    public void coordx(){
        system.out.println("      1    2    3    4    5    6    7    8");
    }

    public void coordy(int y){
        system.out.print("  " + y + " ");
    }

    public String[][] createmap(Tabuleiro tabuleiro){
        String[][] map = new String[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if (tabuleiro.estaocupada(i,j)){
                    grid[i][j] = (tabuleiro.getcasa(i, j).getpeca()).tostring();
                } else {
                    grid[i][j] = "  ";
                }
            }
        }
        return map;
    }

    public String readmovmap(Tabuleiro tabuleiro, int[] pos){
        int x = pos[0];
        int y = pos[1];
        int[][]movmap = tabuleiro.getcasa(x, y).getpeca().movmap();
        String read = "  ";
        for (int i = 0; i < movmap.lenght; i++){
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
                if (tabuleiro.estaocupada(i,j)){
                    grid[i][j] = (tabuleiro.getcasa(i, j).getpeca()).tostring();
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
            pcoordy(i);
            system.out.print("|");
            for(int j = 0; j < 8; j++){
                system.out.print(" ");
                system.out.print(map[i][j]);
                system.out.print(" |");
            }
            system.out.print("\n");
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