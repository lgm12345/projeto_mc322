public abstract class Peca {
    //os atributos da peca nao podem ser protegidos, senao outras classes nao vao conseguir ler esses dados
    protected Casa casa ;
    protected boolean branca ;

    Peca(Casa casa) {
        this.casa = casa ;
    }
    public void movimento() {

    }


    public void setCasa(Casa casa) {
        this.casa = casa ;
    }

    public boolean getcolor(){
        return branca;
    }

    //metodo isinrange verifica se a posicao x,y esta dentro dos limites do tabuleiro
    public boolean isinrange(int X, int Y){
        boolean range = false;
        if( (X <= 7) && (X >= 0) && (Y <= 7) && (Y >= 0)){
            range = true;
        }
        return range;
    }

    //metodo searchpeca verifica se tem uma peca na posicao x,y
    //retorna 0 se x,y vazio; retorna 1 se peca eh amiga (peca == this.branca); retorna -1 se peca eh inimiga
    public int searchpeca(int X, int Y){
        int pecatype = 0;
        if(!tabuleiro.getCasa(X, Y).isOcupada()){
            if(tabuleiro.getCasa(X, Y).getpeca().getcolor() == branca){
                pecatype = 1;
            } else {
                pecatype = -1;
            }
        }
        return pecatype;

    }

}
