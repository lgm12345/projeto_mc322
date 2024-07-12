import java.awt.image.BufferedImage ;
import java.io.File ;
import java.io.IOException ;
import javax.imageio.ImageIO ;
public class Cavalo extends Peca implements  Movimentavel{
    private BufferedImage imagemPretaFundoBranco ;
    private BufferedImage imagemPretaFundoVerde ;
    private BufferedImage imagemBrancaFundoBranco ;
    private BufferedImage imagemBrancaFundoVerde ;
    int qntCasas = 0;
    int[][] proximas = new int[8][2];
    int qntinimigas = 0;
    int[][] inimigas = new int[8][2];
    public Cavalo(String nome,Casa casa, boolean branca,String pretaFundoBranco,String pretaFundoVerde,String brancaFundoBranco,String brancaFundoVerde) {
        super(nome,casa,branca);
        try {
            String caminhoDaImagem = "imagens/" + pretaFundoBranco; // Caminho relativo
            this.imagemPretaFundoBranco = ImageIO.read(getClass().getClassLoader().getResourceAsStream(caminhoDaImagem));
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
            String caminhoDaImagem = "imagens/" + brancaFundoBranco; // Caminho relativo
            this.imagemBrancaFundoBranco = ImageIO.read(getClass().getClassLoader().getResourceAsStream(caminhoDaImagem));
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
    public String getClassName() {
        return NomePeca.CAVALO.getNome();
    }
    //o metodo checknsave usa o metodo "isinrange" para verificar se a posicao x,y pertence ao tabuleiro
    //em caso positivo, verifica se a posicao esta ocupada
    //se nao, a posicao eh salva na lista de proximas posicoes e o contador eh atualizado
    //se sim, verifica se eh inimiga, se for, salva como inimiga, se nao, nao salva
    public boolean checknsave(Tabuleiro tabuleiro, int linha, int coluna){
        boolean enemy = false ;
        if(isinrange(linha,coluna)){ //verifica se pertence ao tabuleiro
            if(searchpeca(tabuleiro, linha, coluna) == 0){ //verifica se esta vazio
                proximas[qntCasas][0] = linha;
                proximas[qntCasas][1] = coluna;
                qntCasas += 1;
            } else if (searchpeca(tabuleiro, linha, coluna) ==  -1){ //se nao esta vazio, verifica se eh inimiga
                inimigas[qntinimigas][0] = linha;
                inimigas[qntinimigas][1] = coluna;
                qntinimigas += 1;
                enemy = true ;
            }
        }
        return enemy ;
    }

    //o metodo listfreepositions toma as coordenadas atuais do cavalo e usa o metodo checknsave em loop para guardar todas posicoes livres possiveis
    public void listfreepositions(Tabuleiro tabuleiro, int linha, int coluna){
        int [][] positions = {{linha+1,coluna+2}, {linha+1, coluna-2}, {linha+2, coluna+1},{linha+2, coluna-1}, {linha-1, coluna+2}, {linha-1, coluna-2}, {linha-2, coluna+1}, {linha-2, coluna-1}};
        for (int[] coord : positions){
            checknsave(tabuleiro, coord[0], coord[1]);
        }
    }

    //o metodo resetpositions zera os vetores de proximas posicoes possiveis e de pecas inimigas e refaz os dois
    public void resetpositions(Tabuleiro tabuleiro, int linha, int coluna){
        for (int i = 0; i < 8; i++){
            proximas[i][0] = 0;
            proximas[i][1] = 0;
        }
        for (int i = 0; i < 8; i++){
            inimigas[i][0] = 0;
            inimigas[i][1] = 0;
        }
        qntCasas = 0;
        qntinimigas = 0;

        listfreepositions(tabuleiro, linha, coluna);
    }

    int cx = 8;
    public int[][] movmap(){
        int[][] map = new int[cx][2];
        for (int i = 0; i < cx; i++){
            map[i][0] = proximas[i][0];
            map[i][1] = proximas[i][1];
        }
        return map;
    }

    public boolean move(Tabuleiro tabuleiro,int linha,int coluna) {
        resetpositions(tabuleiro,super.getCasa().getLinha(), super.getCasa().getColuna());
        for (int i = 0;i < proximas.length;i++) {
            if ((proximas[i][0] == linha) && (proximas[i][1] == coluna)) {
                tabuleiro.getCasa(super.getCasa().getLinha(),super.getCasa().getColuna()).removerPeca(); ;
                tabuleiro.getCasa(linha,coluna).colocarPeca(this) ;
                return true ;
            }
        }
        for (int i = 0;i < inimigas.length;i++) {
            if ((inimigas[i][0] == linha) && (inimigas[i][1] == coluna)) {
                tabuleiro.getCasa(super.getCasa().getLinha(), super.getCasa().getColuna()).removerPeca();
                tabuleiro.getCasa(linha,coluna).removerPeca();
                tabuleiro.getCasa(linha,coluna).colocarPeca(this);
                return true ;
            }
        }
        return false ;
    }
    public BufferedImage getImagemPretaFundoBranco() {
        return imagemPretaFundoBranco;
    }

    public BufferedImage getImagemPretaFundoVerde() {
        return imagemPretaFundoVerde ;
    }

    public BufferedImage getImagemBrancaFundoBranco() {
        return imagemBrancaFundoBranco ;
    }

    public BufferedImage getImagemBrancaFundoVerde() {
        return imagemBrancaFundoVerde ;
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
