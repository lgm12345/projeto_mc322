public class Casa {
    private int[] coordenadas = new int[2] ;
    private boolean ocupada ;
    private Peca peca ;

    public Casa(int linha,int coluna) {
        this.coordenadas[0] = linha ;
        this.coordenadas[1] = coluna ;
        this.ocupada = false ;
        this.peca = null ;
    }

    public void colocarPeca(Peca peca) {
        this.peca = peca;
        this.ocupada = true;
        peca.setCasa(this);
        String linha = String.valueOf(coordenadas[0]) ;
        String coluna = String.valueOf(coordenadas[1]) ;
        System.out.println(peca.getNome() + "colocada na posicao" + linha + coluna) ;
    }
    public void removerPeca() {
        String linha = String.valueOf(coordenadas[0]) ;
        String coluna = String.valueOf(coordenadas[1]) ;
        System.out.println(peca.getNome() + "removida da posicao" + linha + coluna) ;
        this.ocupada = false ;
        this.peca = null ;
    }

    public int getLinha() {
        return coordenadas[0] ;
    }

    public int getColuna() {
        return coordenadas[1] ;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public Peca getPeca() {
        return peca;
    }

}
