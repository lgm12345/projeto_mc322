import java.awt.image.BufferedImage ;
import java.io.File ;
import java.io.IOException ;
import javax.imageio.ImageIO ;
public class Peao extends Peca implements Movimentavel{
    public boolean first ;
    private boolean promoted;
    private int step;
    private BufferedImage imagemPretaFundoBranco ;
    private BufferedImage imagemBrancaFundoBranco ;
    private BufferedImage imagemPretaFundoVerde ;
    private BufferedImage imagemBrancaFundoVerde ;
    int qntCasas = 0;
    int[][] proximas = new int[4][2];
    int qntinimigas = 0;
    int[][] inimigas = new int[4][2];
    public Peao(String nome,Casa casa,boolean branca,String pretaFundoBranco,String brancaFundoBranco,String pretaFundoVerde,String brancaFundoVerde) {
        super(nome,casa,branca) ;
        this.first = true ;
        this.promoted = false;
        if(branca){
            step = 1;
        } else {
            step = -1;
        }
        try {
            String caminhoDaImagem = "imagens/" + pretaFundoBranco; // Caminho relativo
            this.imagemPretaFundoBranco = ImageIO.read(getClass().getClassLoader().getResourceAsStream(caminhoDaImagem));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String caminhoDaImagem = "imagens/" + brancaFundoBranco; // Caminho relativo
            this.imagemBrancaFundoBranco = ImageIO.read(getClass().getClassLoader().getResourceAsStream(caminhoDaImagem));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String caminhoDaImagem = "imagens/" + pretaFundoVerde; // Caminho relativo
            this.imagemPretaFundoVerde = ImageIO.read(getClass().getClassLoader().getResourceAsStream(caminhoDaImagem));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String caminhoDaImagem = "imagens/" + brancaFundoVerde; // Caminho relativo
            this.imagemBrancaFundoVerde = ImageIO.read(getClass().getClassLoader().getResourceAsStream(caminhoDaImagem));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //metodo que identifica que o peao ja realizou o primeiro movimento
    public void moved(){
        this.first = false;
    }

    //metodo que identifica se o peao ja foi promovido
    public void promote(){
        this.promoted = true;
    }


    //o metodo que movimenta o peao deve ter uma condicao: quando a coordenada de destino eh X,7 ele eh promovido a uma outra peca.

    //o metodo checknsave usa o metodo "isinrange" para verificar se a posicao x,y pertence ao tabuleiro
    //em caso positivo, verifica se a posicao esta ocupada
    //se nao, a posicao eh salva na lista de proximas posicoes e o contador eh atualizado
    //como a movimentacao e ataque do peao eh diferente, o metodo eh modificado: o peao mata em diagonal e pode andar duas casas se for o primeiro mov.
    public boolean checknsave(Tabuleiro tabuleiro, int linha, int coluna){
        boolean enemy = false;
        if(isinrange(linha,coluna)) { //verifica se pertence ao tabuleiro
            if (isinrange(linha + step, coluna)) {
                if (searchpeca(tabuleiro, linha + step, coluna) == 0) { //verifica se esta vazio
                    proximas[qntCasas][0] = linha + step;
                    proximas[qntCasas][1] = coluna;
                    qntCasas += 1;
                }
            }
            if (first) {
                if (isinrange(linha + 2 * step, coluna)) {
                    if (searchpeca(tabuleiro, linha + 2 * step, coluna) == 0) { //verifica se esta vazio
                        proximas[qntCasas][0] = linha + 2 * step;
                        proximas[qntCasas][1] = coluna;
                        qntCasas += 1;
                    }
                }
            }
            if (isinrange(linha + step, coluna + 1)) {
                if (searchpeca(tabuleiro, linha + step, coluna + 1) == -1) { //procura inimiga
                    inimigas[qntinimigas][0] = linha + step;
                    inimigas[qntinimigas][1] = coluna + 1;
                    qntinimigas += 1;
                    enemy = true;
                }
            }
            if (isinrange(linha + step, coluna - 1)) {
                if (searchpeca(tabuleiro, linha + step, coluna - 1) == -1) { //procura inimiga
                    inimigas[qntinimigas][0] = linha + step;
                    inimigas[qntinimigas][1] = coluna - 1;
                    qntinimigas += 1;
                    enemy = true;
                }
            }
        }
        qntCasas = 0 ;
        return enemy ;
    }

    //o metodo listfreepositions toma as coordenadas atuais do cavalo e usa o metodo checknsave em loop para guardar todas posicoes livres possiveis
    public void listfreepositions(Tabuleiro tabuleiro, int linha, int coluna){
        checknsave(tabuleiro, linha, coluna);
    }

    //o metodo resetpositions zera os vetores de proximas posicoes possiveis e de pecas inimigas e refaz os dois
    public void resetpositions(Tabuleiro tabuleiro, int linha,int coluna){
        
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

        listfreepositions(tabuleiro, linha, coluna);
    }

    public boolean move(Tabuleiro tabuleiro,int linhaDestino,int colunaDestino) {
        resetpositions(tabuleiro, super.getCasa().getLinha(), super.getCasa().getColuna());
        for (int i = 0; i < proximas.length; i++) {
            if ((proximas[i][0] == linhaDestino) && (proximas[i][1] == colunaDestino)) {
                tabuleiro.getCasa(super.getCasa().getLinha(), super.getCasa().getColuna()).removerPeca();
                tabuleiro.getCasa(linhaDestino, colunaDestino).colocarPeca(this);
                if (first) {
                    moved() ;
                }
                return true;
            }
        }
        for (int i = 0; i < inimigas.length; i++) {
            if ((inimigas[i][0] == linhaDestino) && (inimigas[i][1] == colunaDestino)) {
                tabuleiro.getCasa(super.getCasa().getLinha(), super.getCasa().getColuna()).removerPeca();
                tabuleiro.getCasa(linhaDestino, colunaDestino).removerPeca();
                tabuleiro.getCasa(linhaDestino, colunaDestino).colocarPeca(this);
                if (first) {
                    moved() ;
                }
                return true;
            }
        }
        return false;
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
    public BufferedImage getImagemPretaFundoBranco() {
        return imagemPretaFundoBranco;
    }

    public BufferedImage getImagemBrancaFundoBranco() {
        return imagemBrancaFundoBranco;
    }

    public BufferedImage getImagemPretaFundoVerde() {
        return imagemPretaFundoVerde ;
    }

    public BufferedImage getImagemBrancaFundoVerde() {
        return imagemBrancaFundoVerde ;
    }

    public void setImagemPretaFundoBranco(BufferedImage imagem) {
        this.imagemPretaFundoBranco = imagem;
    }

    public void setImagemBrancaFundoBranco(BufferedImage imagem) {
        this.imagemBrancaFundoBranco = imagem;
    }

    public int[][] getProximas() {
        return proximas ;
    }
    public int[][] getInimigas() {
        return inimigas ;
    }
    public boolean isBranca() {
        return branca ;
    }
}
