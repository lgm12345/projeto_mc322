import static java.sql.JDBCType.NULL;

public abstract class Peca {
    //os atributos da peca nao podem ser protegidos, senao outras classes nao vao conseguir ler esses dados
    protected String nome ;
    protected Casa casa ;
    protected boolean branca ;
    public String getClassName() {
        return "";
    }

    Peca(String nome,Casa casa) {
        this.nome = nome ;
        this.casa = casa;
    }

    public void movimento() {

    }
    public String getNome() {
        return nome ;
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
    //retorna 0 se x,y vazio; retorna 1 se peca eh amiga retorna -1 se peca eh inimiga
    public int searchpeca(Tabuleiro tabuleiro, int X, int Y){
        int pecatype = 0;
        if(!tabuleiro.getCasa(X, Y).isOcupada()){
            if(tabuleiro.getCasa(X, Y).getPeca().getcolor() == branca){
                pecatype = 1;
            } else {
                pecatype = -1;
            }
        }
        return pecatype;
    }
    public void promote() {

    }
    public void moved() {

    }
    public int[][] movmap() {
        return new int[0][0] ;
    }
}
