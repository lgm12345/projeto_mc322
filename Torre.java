import java.awt.image.BufferedImage ;
import java.io.File ;
import java.io.IOException ;
import javax.imageio.ImageIO ;
public class Torre extends Peca implements Movimentavel{
    private BufferedImage imagemPretaFundoBranco ;
    private BufferedImage imagemPretaFundoVerde ;
    private BufferedImage imagemBrancaFundoBranco ;
    private BufferedImage imagemBrancaFundoVerde ;
    int qntCasas = 0;
    int[][] proximas = new int[14][2];
    int qntinimigas = 0;
    int[][] inimigas = new int[4][2];
    public Torre(String nome,Casa casa,boolean branca,String pretaFundoBranco,String pretaFundoVerde,String brancaFundoBranco,String brancaFundoVerde) {
        super(nome,casa,branca) ;
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
        return NomePeca.TORRE.getNome();
    }
    //o metodo checknsave usa o metodo "isinrange" para verificar se a posicao x,y pertence ao tabuleiro
    //em caso positivo, verifica se a posicao esta ocupada
    //se nao, a posicao eh salva na lista de proximas posicoes e o contador eh atualizado
    //se sim, verifica se eh inimiga, se for, salva como inimiga, se nao, nao salva
    public boolean checknsave(Tabuleiro tabuleiro, int linha, int coluna){
        boolean enemy = false;
        if(isinrange(linha,coluna)){ //verifica se pertence ao tabuleiro
            if(searchpeca(tabuleiro, linha, coluna) == 0){ //verifica se esta vazio
                proximas[qntCasas][0] = linha;
                proximas[qntCasas][1] = coluna;
                qntCasas += 1;
            } else if (searchpeca(tabuleiro, linha, coluna) ==  -1){ //se nao esta vazio, verifica se eh inimiga
                inimigas[qntinimigas][0] = linha;
                inimigas[qntinimigas][1] = coluna;
                qntinimigas += 1;
                enemy = true;
            }
        }
        return enemy;
    }

    //o metodo listfreepositions toma as coordenadas atuais do cavalo e usa o metodo checknsave em loop para guardar todas posicoes livres possiveis
    public void listfreepositions(Tabuleiro tabuleiro, int linha, int coluna){
        int [][][] positions = new int[4][14][2]; //lista de posicoes para serem verificadas
        int[] lengths = new int[4]; // Controla o número de posições
        for (int i = 1; i < 8; i++){//adicionando posicoes da torre
            positions[0][lengths[0]] = new int[]{linha, coluna + i}; // Adicionando posições horizontais positivas
            lengths[0]++;
            positions[1][lengths[1]] = new int[]{linha + i, coluna}; // Adicionando posições verticais positivas
            lengths[1]++;
            positions[2][lengths[2]] = new int[]{linha, coluna - i}; // Adicionando posições horizontais negativas
            lengths[2]++;
            positions[3][lengths[3]] = new int[]{linha - i, coluna}; // Adicionando posições verticais negativas
            lengths[3]++;
        }
        for (int i = 0; i < 4; i++) {//varremos cada direcao individualmente
            for (int j = 0; j < lengths[i]; j++) {//tomamos as coordenadas do vetor positions
                int[] coord = positions[i][j];
                if (checknsave(tabuleiro, coord[0], coord[1])) {//escrevemos no vetor proximas, ate que uma inimiga seja encontrada
                    break;
                }
            }
        }
    }

    //o metodo resetpositions zera os vetores de proximas posicoes possiveis e de pecas inimigas e refaz os dois
    public void resetpositions(Tabuleiro tabuleiro, int linha, int coluna){
        for (int i = 0; i < 14; i++){
            proximas[i][0] = 0;
            proximas[i][1] = 0;
        }
        for (int i = 0; i < 4; i++){
            inimigas[i][0] = 0;
            inimigas[i][1] = 0;
        }
        qntCasas = 0;
        qntinimigas = 0;

        listfreepositions(tabuleiro, linha, coluna);
    }

    public boolean move(Tabuleiro tabuleiro,int linha,int coluna) {
        resetpositions(tabuleiro, super.getCasa().getLinha(), super.getCasa().getColuna());
        for (int i = 0; i < proximas.length; i++) {
            if ((proximas[i][0] == linha) && (proximas[i][1] == coluna)) {
                tabuleiro.getCasa(super.getCasa().getLinha(), super.getCasa().getColuna()).removerPeca();
                tabuleiro.getCasa(linha,coluna).colocarPeca(this);
                return true;
            }
        }
        for (int i = 0; i < inimigas.length; i++) {
            if ((inimigas[i][0] == linha) && (inimigas[i][1] == coluna)) {
                tabuleiro.getCasa(super.getCasa().getLinha(), super.getCasa().getColuna()).removerPeca();
                tabuleiro.getCasa(linha, coluna).removerPeca();
                tabuleiro.getCasa(linha, coluna).colocarPeca(this);
                return true;
            }
        }
        System.out.println(proximas.length) ;
        System.out.println("Nao encontrou possivel posicao") ;
        return false;
    }

    int cx = 14;
    public int[][] movmap(){
        int[][] map = new int[cx][2];
        for (int i = 0; i < cx; i++){
            map[i][0] = proximas[i][0];
            map[i][1] = proximas[i][1];
        }
        return map;
    }

    public BufferedImage getImagemPretaFundoBranco() {
        return imagemPretaFundoBranco ;
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

    public void setImagemPretaVerde(BufferedImage imagem) {
        this.imagemPretaFundoBranco = imagem;
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
