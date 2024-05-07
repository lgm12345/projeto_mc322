import java.util.Objects;

public class Peao extends Peca{
    private boolean inicial ;
    public Peao(Casa casa,boolean branca) {
        super(casa) ;
        this.inicial = true ;
        this.branca = branca ;
    }

    public int[] proximasPossiveisPosicoes() {
        int[] proximas = new int[2] ;
        if (inicial) {
            if (branca) {
                proximas[0] = 2 ;
                proximas[1] = 3;
            }
            else {
                proximas[0] = 5 ;
                proximas[1] = 4 ;
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



}
