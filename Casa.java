public class Casa {
    private int[] coordenadas = new int[2] ;
    private boolean ocupada ;
    private Peca peca ;

    public Casa(int coordenadax,int coordenaday) {
        this.coordenadas[0] = coordenadax ;
        this.coordenadas[1] = coordenaday ;
        this.ocupada = false ;
        this.peca = null ;
    }

    public void colocarPeca(Peca peca) {
        this.peca = peca;
        this.ocupada = true;
    }

    public void removerPeca() {
        this.ocupada = false ;
        this.peca = null ;
    }

    public int getCoordenadaX() {
        return coordenadas[0] ;
    }

    public int getCoordenadaY() {
        return coordenadas[1] ;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public Peca getPeca() {
        return peca;
    }
}
