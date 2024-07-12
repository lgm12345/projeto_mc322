import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage ;
import javax.imageio.ImageIO;
public class CasaView extends JButton{
    private int linha ;
    private int coluna ;
    private Tabuleiro tabuleiro ;
    private ImageIcon imagemPeca ;
    private ImageIcon possivelPosicao ;
    private TabuleiroFrame tabuleiroFrame ;
    public CasaView(int linha,int coluna,Tabuleiro tabuleiro,TabuleiroFrame tabuleiroFrame) {
        this.linha = linha ;
        this.coluna = coluna ;
        this.tabuleiro = tabuleiro ;
        this.tabuleiroFrame = tabuleiroFrame ;
        addActionListener(e -> {
            System.out.println("Casa clicada: Linha " + linha + ", Coluna " + coluna);

        });

        /*
        addActionListener(e -> {
            mostraPossiveisPosicoes() ;
        });
       */

       addActionListener(e -> {
           tabuleiroFrame.selecionaCasa(this);
       });



       addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                atualizarIcone();
            }
        });

       this.setIcon(imagemPeca);
       this.setBackground(Color.WHITE);
    }

    public void atualizarIcone() {
        if (tabuleiro.getCasa(linha, coluna).isOcupada()) {
            Peca peca = tabuleiro.getCasa(linha, coluna).getPeca();
            if (peca instanceof Peao) {
                Peao peao = (Peao) peca ;
                SwingUtilities.invokeLater(() -> {
                    int largura = getWidth();
                    int altura = getHeight();
                    if (peao.isBranca()) {
                        if ((linha % 2 == 0) && (coluna % 2 == 0)) {
                            imagemPeca = criarIconeRedimensionado(peao.getImagemBrancaFundoVerde(), largura, altura);
                        }
                        else if ((linha % 2 == 1) && (coluna % 2 == 1)) {
                            imagemPeca = criarIconeRedimensionado(peao.getImagemBrancaFundoVerde(), largura, altura);
                        }
                        else {
                            imagemPeca = criarIconeRedimensionado(peao.getImagemBrancaFundoBranco(), largura, altura);
                        }
                    }
                    else {
                        if ((linha % 2 == 0) && (coluna % 2 == 0)) {
                            imagemPeca = criarIconeRedimensionado(peao.getImagemPretaFundoVerde(), largura, altura);
                        }
                        else if ((linha % 2 == 1) && (coluna % 2 == 1)) {
                            imagemPeca = criarIconeRedimensionado(peao.getImagemPretaFundoVerde(), largura, altura);
                        }else {
                            imagemPeca = criarIconeRedimensionado(peao.getImagemPretaFundoBranco(), largura, altura);
                        }
                    }
                    setIcon(imagemPeca);
                });
            }
            else if (peca instanceof Torre) {
                Torre torre = (Torre) peca ;
                SwingUtilities.invokeLater(() -> {
                    int largura = getWidth();
                    int altura = getHeight();
                    if (torre.isBranca()) {
                        if ((linha % 2 == 0) && (coluna % 2 == 0)) {
                            imagemPeca = criarIconeRedimensionado(torre.getImagemBrancaFundoVerde(), largura, altura);
                        }
                        else if ((linha % 2 == 1) && (coluna % 2 == 1)) {
                            imagemPeca = criarIconeRedimensionado(torre.getImagemBrancaFundoVerde(), largura, altura);
                        }
                        else {
                            imagemPeca = criarIconeRedimensionado(torre.getImagemBrancaFundoBranco(), largura, altura);
                        }
                    }
                    else {
                        if ((linha % 2 == 0) && (coluna % 2 == 0)) {
                            imagemPeca = criarIconeRedimensionado(torre.getImagemPretaFundoVerde(), largura, altura);
                        }
                        else if ((linha % 2 == 1) && (coluna % 2 == 1)) {
                            imagemPeca = criarIconeRedimensionado(torre.getImagemPretaFundoVerde(), largura, altura);
                        }else {
                            imagemPeca = criarIconeRedimensionado(torre.getImagemPretaFundoBranco(), largura, altura);
                        }
                    }
                    setIcon(imagemPeca);
                });
            }
            else if (peca instanceof Cavalo) {
                Cavalo cavalo = (Cavalo) peca ;
                SwingUtilities.invokeLater(() -> {
                    int largura = getWidth();
                    int altura = getHeight();
                    if (cavalo.isBranca()) {
                        if ((linha % 2 == 0) && (coluna % 2 == 0)) {
                            imagemPeca = criarIconeRedimensionado(cavalo.getImagemBrancaFundoVerde(), largura, altura);
                        }
                        else if ((linha % 2 == 1) && (coluna % 2 == 1)) {
                            imagemPeca = criarIconeRedimensionado(cavalo.getImagemBrancaFundoVerde(), largura, altura);
                        }
                        else {
                            imagemPeca = criarIconeRedimensionado(cavalo.getImagemBrancaFundoBranco(), largura, altura);
                        }
                    }
                    else {
                        if ((linha % 2 == 0) && (coluna % 2 == 0)) {
                            imagemPeca = criarIconeRedimensionado(cavalo.getImagemPretaFundoVerde(), largura, altura);
                        }
                        else if ((linha % 2 == 1) && (coluna % 2 == 1)) {
                            imagemPeca = criarIconeRedimensionado(cavalo.getImagemPretaFundoVerde(), largura, altura);
                        }
                        else {
                            imagemPeca = criarIconeRedimensionado(cavalo.getImagemPretaFundoBranco(), largura, altura);
                        }
                    }
                    setIcon(imagemPeca);
                });
            }
            else if (peca instanceof Bispo) {
                Bispo bispo = (Bispo) peca ;
                SwingUtilities.invokeLater(() -> {
                    int largura = getWidth();
                    int altura = getHeight();
                    if (bispo.isBranca()) {
                        if ((linha % 2 == 0) && (coluna % 2 == 0)) {
                            imagemPeca = criarIconeRedimensionado(bispo.getImagemBrancaFundoVerde(), largura, altura);
                        }
                        else if ((linha % 2 == 1) && (coluna % 2 == 1)) {
                            imagemPeca = criarIconeRedimensionado(bispo.getImagemBrancaFundoVerde(), largura, altura);
                        }
                        else {
                            imagemPeca = criarIconeRedimensionado(bispo.getImagemBrancaFundoBranco(), largura, altura);
                        }
                    }
                    else {
                        if ((linha % 2 == 0) && (coluna % 2 == 0)) {
                            imagemPeca = criarIconeRedimensionado(bispo.getImagemPretaFundoVerde(), largura, altura);
                        }
                        else if ((linha % 2 == 1) && (coluna % 2 == 1)) {
                            imagemPeca = criarIconeRedimensionado(bispo.getImagemPretaFundoVerde(), largura, altura);
                        }else {
                            imagemPeca = criarIconeRedimensionado(bispo.getImagemPretaFundoBranco(), largura, altura);
                        }
                    }
                    setIcon(imagemPeca);
                });
            }
            else if (peca instanceof Rainha) {
                Rainha rainha = (Rainha) peca ;
                SwingUtilities.invokeLater(() -> {
                    int largura = getWidth();
                    int altura = getHeight();
                    if (rainha.isBranca()) {
                        if ((linha % 2 == 0) && (coluna % 2 == 0)) {
                            imagemPeca = criarIconeRedimensionado(rainha.getImagemBrancaFundoVerde(), largura, altura);
                        }
                        else if ((linha % 2 == 1) && (coluna % 2 == 1)) {
                            imagemPeca = criarIconeRedimensionado(rainha.getImagemBrancaFundoVerde(), largura, altura);
                        }else {
                            imagemPeca = criarIconeRedimensionado(rainha.getImagemBrancaFundoBranco(), largura, altura);
                        }
                    }
                    else {
                        if ((linha % 2 == 0) && (coluna % 2 == 0)) {
                            imagemPeca = criarIconeRedimensionado(rainha.getImagemPretaFundoVerde(), largura, altura);
                        }
                        else if ((linha % 2 == 1) && (coluna % 2 == 1)) {
                            imagemPeca = criarIconeRedimensionado(rainha.getImagemPretaFundoVerde(), largura, altura);
                        }else {
                            imagemPeca = criarIconeRedimensionado(rainha.getImagemPretaFundoBranco(), largura, altura);
                        }
                    }
                    setIcon(imagemPeca);
                });
            }
            else if (peca instanceof Rei) {
                Rei rei= (Rei) peca ;
                SwingUtilities.invokeLater(() -> {
                    int largura = getWidth();
                    int altura = getHeight();
                    if (rei.isBranca()) {
                        if ((linha % 2 == 0) && (coluna % 2 == 0)) {
                            imagemPeca = criarIconeRedimensionado(rei.getImagemBrancaFundoVerde(), largura, altura);
                        }
                        else if ((linha % 2 == 1) && (coluna % 2 == 1)) {
                            imagemPeca = criarIconeRedimensionado(rei.getImagemBrancaFundoVerde(), largura, altura);
                        }else {
                            imagemPeca = criarIconeRedimensionado(rei.getImagemBrancaFundoBranco(), largura, altura);
                        }
                    }
                    else {
                        if ((linha % 2 == 0) && (coluna % 2 == 0)) {
                            imagemPeca = criarIconeRedimensionado(rei.getImagemPretaFundoVerde(), largura, altura);
                        }
                        else if ((linha % 2 == 1) && (coluna % 2 == 1)) {
                            imagemPeca = criarIconeRedimensionado(rei.getImagemPretaFundoVerde(), largura, altura);
                        }else {
                            imagemPeca = criarIconeRedimensionado(rei.getImagemPretaFundoBranco(), largura, altura);
                        }
                    }
                    setIcon(imagemPeca);
                });
            }
        } else {
            setIcon(null); // Limpar o ícone se a casa estiver vazia
        }
    }

    public void mostraPossiveisPosicoes() {
        if (tabuleiro.getCasa(linha,coluna).isOcupada()) {
            Peca peca = tabuleiro.getCasa(linha,coluna).getPeca() ;
            if (peca instanceof Peao) {
                Peao peao = (Peao) peca ;
                peao.listfreepositions(tabuleiro,linha,coluna);
                int[][] proximas = peao.getProximas() ;
                int[][] inimigas = peao.getInimigas() ;
                pintaProximas(proximas);
            }
        }
    }

    public void pintaProximas(int[][] proximas) {
        for (int i = 0; i < proximas.length; i++) {
            tabuleiroFrame.getCasa(proximas[i][0], proximas[i][1]).isProxima();
        }
    }

    public void pintaInimigas(int[][] inimigas) {

    }

    private ImageIcon criarIconeRedimensionado(BufferedImage imagem, int largura, int altura) {
        Image scaledImage = imagem.getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    private void isProxima() {

    }

    public int getLinha() {
        return linha ;
    }

    public  int getColuna() {
        return coluna ;
    }
}
