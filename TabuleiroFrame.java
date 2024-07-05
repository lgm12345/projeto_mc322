import javax.swing.JFrame ;
import java.awt.*;

public class TabuleiroFrame extends JFrame{
    private Tabuleiro tabuleiro ;
    private CasaView[][] casasFrame ;
    private Peca pecaSelecionada ;
    //preciso guardar a casaSelecionada conforme o clique no mouse e esta precisa ser unica,se na casa tiver uma
    //peca esta é a pecaSelecionada,ao mudar a casaSelecionada por consequencia muda a pecaSelecionada
    public TabuleiroFrame(Tabuleiro tabuleiro) {
        casasFrame = new CasaView[8][8] ;
        this.tabuleiro = tabuleiro ;
        this.setTitle("Tabuleiro de xadrez");
        this.setLayout(new GridLayout(8,8));
        this.setSize(420,420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 7;i >= 0;i--) {
            for (int j = 0;j < 8;j++) {
                CasaView casa = new CasaView(i,j,tabuleiro,this) ;
                if ((i % 2 == 0) && (j % 2 == 0)) {
                    casa.setBackground(new Color(0,128,0));
                }
                else if ((i % 2 == 1) && (j % 2 == 1)) {
                    casa.setBackground(new Color(0,128,0));
                }
                casa.setPreferredSize(new Dimension(50, 50));
                casasFrame[i][j] = casa ;
                this.add(casa) ;
            }
        }
        this.setVisible(true);
        this.pecaSelecionada = PecaVazia.getInstance() ;
    }

    public CasaView getCasa(int linha,int coluna) {
        return casasFrame[linha][coluna] ;
    }

    public void selecionaCasa(CasaView casa) {
        boolean branca = true ;
        boolean inimiga = false ;
        if (tabuleiro.getCasa(casa.getLinha(),casa.getColuna()).isOcupada()) {
            //preciso analisar se é uma das ininigas da peca selecionada
            Peca peca = tabuleiro.getCasa(casa.getLinha(),casa.getColuna()).getPeca() ;
            branca = peca.getcolor();
            inimiga = !peca.getcolor() ;
            if (pecaSelecionada != PecaVazia.getInstance()) {
                System.out.println(branca) ;
                if (!Verificador.reiEmCheque(tabuleiro, branca)) {
                    if (pecaSelecionada instanceof Peao) {
                        Peao peao = (Peao) pecaSelecionada;
                        peao.resetpositions(tabuleiro, peao.getCasa().getLinha(), peao.getCasa().getColuna());
                        int[][] inimigas = peao.getInimigas();
                        for (int i = 0; i < inimigas.length; i++) {
                            if ((inimigas[i][0] == casa.getLinha()) && (inimigas[i][1] == casa.getColuna())) {
                                Casa casaAnterior = peao.getCasa();
                                tabuleiro.moverPeca(peao.getCasa().getLinha(), peao.getCasa().getColuna(), casa.getLinha(), casa.getColuna());
                                System.out.println(casaAnterior.isOcupada());
                                casasFrame[casaAnterior.getLinha()][casaAnterior.getColuna()].atualizarIcone();
                                casasFrame[casa.getLinha()][casa.getColuna()].atualizarIcone();
                                this.pecaSelecionada = PecaVazia.getInstance();
                                if (Verificador.checkMate(tabuleiro,inimiga)) {
                                    this.dispose();
                                    TelaCheckMate.exibirCheckMateFrame(branca);
                                }
                            }
                        }
                    } else if (pecaSelecionada instanceof Torre) {
                        Torre torre = (Torre) pecaSelecionada;
                        torre.resetpositions(tabuleiro, torre.getCasa().getLinha(), torre.getCasa().getColuna());
                        int[][] inimigas = torre.getInimigas();
                        for (int i = 0; i < inimigas.length; i++) {
                            if ((inimigas[i][0] == casa.getLinha()) && (inimigas[i][1] == casa.getColuna())) {
                                Casa casaAnterior = torre.getCasa();
                                tabuleiro.moverPeca(torre.getCasa().getLinha(), torre.getCasa().getColuna(), casa.getLinha(), casa.getColuna());
                                casasFrame[casaAnterior.getLinha()][casaAnterior.getColuna()].atualizarIcone();
                                casasFrame[casa.getLinha()][casa.getColuna()].atualizarIcone();
                                this.pecaSelecionada = PecaVazia.getInstance();
                                if (Verificador.checkMate(tabuleiro,inimiga)) {
                                    this.dispose();
                                    TelaCheckMate.exibirCheckMateFrame(branca);
                                }
                            }
                        }
                    } else if (pecaSelecionada instanceof Bispo) {
                        Bispo bispo = (Bispo) pecaSelecionada;
                        bispo.resetpositions(tabuleiro, bispo.getCasa().getLinha(), bispo.getCasa().getColuna());
                        int[][] inimigas = bispo.getInimigas();
                        for (int i = 0; i < inimigas.length; i++) {
                            if ((inimigas[i][0] == casa.getLinha()) && (inimigas[i][1] == casa.getColuna())) {
                                Casa casaAnterior = bispo.getCasa();
                                tabuleiro.moverPeca(bispo.getCasa().getLinha(), bispo.getCasa().getColuna(), casa.getLinha(), casa.getColuna());
                                casasFrame[casaAnterior.getLinha()][casaAnterior.getColuna()].atualizarIcone();
                                casasFrame[casa.getLinha()][casa.getColuna()].atualizarIcone();
                                this.pecaSelecionada = PecaVazia.getInstance();
                                if (Verificador.checkMate(tabuleiro,inimiga)) {
                                    this.dispose();
                                    TelaCheckMate.exibirCheckMateFrame(branca);
                                }
                            }
                        }
                    } else if (pecaSelecionada instanceof Cavalo) {
                        Cavalo cavalo = (Cavalo) pecaSelecionada;
                        cavalo.resetpositions(tabuleiro, cavalo.getCasa().getLinha(), cavalo.getCasa().getColuna());
                        int[][] inimigas = cavalo.getInimigas();
                        for (int i = 0; i < inimigas.length; i++) {
                            if ((inimigas[i][0] == casa.getLinha()) && (inimigas[i][1] == casa.getColuna())) {
                                Casa casaAnterior = cavalo.getCasa();
                                tabuleiro.moverPeca(cavalo.getCasa().getLinha(), cavalo.getCasa().getColuna(), casa.getLinha(), casa.getColuna());
                                casasFrame[casaAnterior.getLinha()][casaAnterior.getColuna()].atualizarIcone();
                                casasFrame[casa.getLinha()][casa.getColuna()].atualizarIcone();
                                this.pecaSelecionada = PecaVazia.getInstance();
                                if (Verificador.checkMate(tabuleiro,inimiga)) {
                                    this.dispose();
                                    TelaCheckMate.exibirCheckMateFrame(branca);
                                }
                            }
                        }
                    } else if (peca instanceof Rainha) {
                        Rainha rainha = (Rainha) pecaSelecionada;
                        rainha.resetpositions(tabuleiro, rainha.getCasa().getLinha(), rainha.getCasa().getColuna());
                        int[][] inimigas = rainha.getInimigas();
                        for (int i = 0; i < inimigas.length; i++) {
                            if ((inimigas[i][0] == casa.getLinha()) && (inimigas[i][1] == casa.getColuna())) {
                                Casa casaAnterior = rainha.getCasa();
                                tabuleiro.moverPeca(rainha.getCasa().getLinha(), rainha.getCasa().getColuna(), casa.getLinha(), casa.getColuna());
                                casasFrame[casaAnterior.getLinha()][casaAnterior.getColuna()].atualizarIcone();
                                casasFrame[casa.getLinha()][casa.getColuna()].atualizarIcone();
                                this.pecaSelecionada = PecaVazia.getInstance();
                                if (Verificador.checkMate(tabuleiro,inimiga)) {
                                    this.dispose();
                                    TelaCheckMate.exibirCheckMateFrame(branca);
                                }
                            }
                        }
                    } else if (pecaSelecionada instanceof Rei) {
                        Rei rei = (Rei) pecaSelecionada;
                        rei.resetpositions(tabuleiro, rei.getCasa().getLinha(), rei.getCasa().getColuna());
                        int[][] inimigas = rei.getInimigas();
                        for (int i = 0; i < inimigas.length; i++) {
                            if ((inimigas[i][0] == casa.getLinha()) && (inimigas[i][1] == casa.getColuna())) {
                                Casa casaAnterior = rei.getCasa();
                                tabuleiro.moverPeca(rei.getCasa().getLinha(), rei.getCasa().getColuna(), casa.getLinha(), casa.getColuna());
                                casasFrame[casaAnterior.getLinha()][casaAnterior.getColuna()].atualizarIcone();
                                casasFrame[casa.getLinha()][casa.getColuna()].atualizarIcone();
                                this.pecaSelecionada = PecaVazia.getInstance();
                                if (Verificador.checkMate(tabuleiro,inimiga)) {
                                    this.dispose();
                                    TelaCheckMate.exibirCheckMateFrame(branca);
                                }
                            }
                        }
                    }
                }
                else {
                    System.out.println("Seu Rei esta em cheque");
                    if (pecaSelecionada instanceof Rei) {
                        Rei rei = (Rei) pecaSelecionada;
                        rei.resetpositions(tabuleiro, rei.getCasa().getLinha(), rei.getCasa().getColuna());
                        int[][] inimigas = rei.getInimigas();
                        for (int i = 0; i < inimigas.length; i++) {
                            if ((inimigas[i][0] == casa.getLinha()) && (inimigas[i][1] == casa.getColuna())) {
                                Casa casaAnterior = rei.getCasa();
                                tabuleiro.moverPeca(rei.getCasa().getLinha(), rei.getCasa().getColuna(), casa.getLinha(), casa.getColuna());
                                casasFrame[casaAnterior.getLinha()][casaAnterior.getColuna()].atualizarIcone();
                                casasFrame[casa.getLinha()][casa.getColuna()].atualizarIcone();
                                this.pecaSelecionada = PecaVazia.getInstance();
                            }
                            }
                        }
                    else {
                        this.dispose();
                        TelaCheckMate.exibirCheckMateFrame(branca);
                    }
                }
            }
            else {
                System.out.println("Peca selecionada" + peca.getNome()) ;
                this.pecaSelecionada = peca;
            }
        }
        else {
            if (pecaSelecionada != PecaVazia.getInstance()) {
                Peca peca = pecaSelecionada;
                branca = peca.getcolor() ;
                inimiga = !peca.getcolor() ;
                boolean moveu = false;
                if (!Verificador.reiEmCheque(tabuleiro, branca)) {
                    if (peca instanceof Peao) {
                        System.out.println("Aqui");
                        Peao peao = (Peao) peca;
                        peao.resetpositions(tabuleiro, peao.getCasa().getLinha(), peao.getCasa().getColuna());
                        int[][] proximas = peao.getProximas();
                        System.out.println(proximas.length);
                        for (int i = 0; i < proximas.length; i++) {
                            if ((proximas[i][0] == casa.getLinha()) && (proximas[i][1] == casa.getColuna())) {
                                Casa casaAnterior = peao.getCasa();
                                tabuleiro.moverPeca(peao.getCasa().getLinha(), peao.getCasa().getColuna(), casa.getLinha(), casa.getColuna());
                                casasFrame[casaAnterior.getLinha()][casaAnterior.getColuna()].atualizarIcone();
                                casasFrame[casa.getLinha()][casa.getColuna()].atualizarIcone();
                                this.pecaSelecionada = PecaVazia.getInstance();
                                moveu = true;
                            }
                        }
                        if (!moveu) {
                            this.pecaSelecionada = PecaVazia.getInstance();
                        }
                    } else if (peca instanceof Torre) {
                        Torre torre = (Torre) peca;
                        torre.resetpositions(tabuleiro, torre.getCasa().getLinha(), torre.getCasa().getColuna());
                        int[][] proximas = torre.getProximas();
                        System.out.println(proximas.length);
                        for (int i = 0; i < proximas.length; i++) {
                            if ((proximas[i][0] == casa.getLinha()) && (proximas[i][1] == casa.getColuna())) {
                                System.out.println("moveu");
                                Casa casaAnterior = torre.getCasa();
                                tabuleiro.moverPeca(torre.getCasa().getLinha(), torre.getCasa().getColuna(), casa.getLinha(), casa.getColuna());
                                casasFrame[casaAnterior.getLinha()][casaAnterior.getColuna()].atualizarIcone();
                                casasFrame[casa.getLinha()][casa.getColuna()].atualizarIcone();
                                this.pecaSelecionada = PecaVazia.getInstance();
                                moveu = true;
                                //preciso fazer isso graficamente tambem
                            }
                        }
                        if (!moveu) {
                            this.pecaSelecionada = PecaVazia.getInstance();
                        }
                    } else if (peca instanceof Bispo) {
                        Bispo bispo = (Bispo) peca;
                        bispo.resetpositions(tabuleiro, bispo.getCasa().getLinha(), bispo.getCasa().getColuna());
                        int[][] proximas = bispo.getProximas();
                        for (int i = 0; i < proximas.length; i++) {
                            if ((proximas[i][0] == casa.getLinha()) && (proximas[i][1] == casa.getColuna())) {
                                Casa casaAnterior = bispo.getCasa();
                                tabuleiro.moverPeca(bispo.getCasa().getLinha(), bispo.getCasa().getColuna(), casa.getLinha(), casa.getColuna());
                                casasFrame[casaAnterior.getLinha()][casaAnterior.getColuna()].atualizarIcone();
                                casasFrame[casa.getLinha()][casa.getColuna()].atualizarIcone();
                                this.pecaSelecionada = PecaVazia.getInstance();
                                moveu = true;
                                //preciso fazer isso graficamente tambem
                            }
                        }
                        if (!moveu) {
                            this.pecaSelecionada = PecaVazia.getInstance();
                        }
                    } else if (peca instanceof Cavalo) {
                        Cavalo cavalo = (Cavalo) peca;
                        cavalo.listfreepositions(tabuleiro, cavalo.getCasa().getLinha(), cavalo.getCasa().getColuna());
                        int[][] proximas = cavalo.getProximas();
                        for (int i = 0; i < proximas.length; i++) {
                            if ((proximas[i][0] == casa.getLinha()) && (proximas[i][1] == casa.getColuna())) {
                                Casa casaAnterior = cavalo.getCasa();
                                tabuleiro.moverPeca(cavalo.getCasa().getLinha(), cavalo.getCasa().getColuna(), casa.getLinha(), casa.getColuna());
                                casasFrame[casaAnterior.getLinha()][casaAnterior.getColuna()].atualizarIcone();
                                casasFrame[casa.getLinha()][casa.getColuna()].atualizarIcone();
                                this.pecaSelecionada = PecaVazia.getInstance();
                                moveu = true;
                                //preciso fazer isso graficamente tambem
                            }
                        }
                        if (!moveu) {
                            this.pecaSelecionada = PecaVazia.getInstance();
                        }
                    } else if (peca instanceof Rainha) {
                        Rainha rainha = (Rainha) peca;
                        rainha.resetpositions(tabuleiro, rainha.getCasa().getLinha(), rainha.getCasa().getColuna());
                        int[][] proximas = rainha.getProximas();
                        for (int i = 0; i < proximas.length; i++) {
                            System.out.println((proximas[i][0]));
                            System.out.println(proximas[i][1]);
                            if ((proximas[i][0] == casa.getLinha()) && (proximas[i][1] == casa.getColuna())) {
                                Casa casaAnterior = rainha.getCasa();
                                tabuleiro.moverPeca(rainha.getCasa().getLinha(), rainha.getCasa().getColuna(), casa.getLinha(), casa.getColuna());
                                casasFrame[casaAnterior.getLinha()][casaAnterior.getColuna()].atualizarIcone();
                                casasFrame[casa.getLinha()][casa.getColuna()].atualizarIcone();
                                this.pecaSelecionada = PecaVazia.getInstance();
                                moveu = true;
                                //preciso fazer isso graficamente tambem
                            }
                        }
                        if (!moveu) {
                            this.pecaSelecionada = PecaVazia.getInstance();
                        }
                    } else if (peca instanceof Rei) {
                        Rei rei = (Rei) peca;
                        rei.resetpositions(tabuleiro, rei.getCasa().getLinha(), rei.getCasa().getColuna());
                        int[][] proximas = rei.getProximas();
                        for (int i = 0; i < proximas.length; i++) {
                            System.out.println((proximas[i][0]));
                            System.out.println(proximas[i][1]);
                            if ((proximas[i][0] == casa.getLinha()) && (proximas[i][1] == casa.getColuna())) {
                                Casa casaAnterior = rei.getCasa();
                                tabuleiro.moverPeca(rei.getCasa().getLinha(), rei.getCasa().getColuna(), casa.getLinha(), casa.getColuna());
                                casasFrame[casaAnterior.getLinha()][casaAnterior.getColuna()].atualizarIcone();
                                casasFrame[casa.getLinha()][casa.getColuna()].atualizarIcone();
                                this.pecaSelecionada = PecaVazia.getInstance();
                                moveu = true ;
                            }
                        }
                        if (!moveu) {
                            this.pecaSelecionada = PecaVazia.getInstance();
                        }
                    }
                    if (moveu) {
                        if (Verificador.checkMate(tabuleiro,inimiga)) {
                            this.dispose();
                            TelaCheckMate.exibirCheckMateFrame(branca);
                        }
                    }
                }
                else {
                    if (peca instanceof Rei) {
                        Rei rei = (Rei) peca ;
                        System.out.println("chegou aqui") ;
                        rei.resetpositions(tabuleiro,rei.getCasa().getLinha(),rei.getCasa().getColuna());
                        int[][] proximas = rei.getProximas() ;
                        for (int i = 0; i < proximas.length; i++) {
                            System.out.println((proximas[i][0]));
                            System.out.println(proximas[i][1]);
                            if ((proximas[i][0] == casa.getLinha()) && (proximas[i][1] == casa.getColuna())) {
                                Casa casaAnterior = rei.getCasa();
                                tabuleiro.moverPeca(rei.getCasa().getLinha(), rei.getCasa().getColuna(), casa.getLinha(), casa.getColuna());
                                casasFrame[casaAnterior.getLinha()][casaAnterior.getColuna()].atualizarIcone();
                                casasFrame[casa.getLinha()][casa.getColuna()].atualizarIcone();
                                this.pecaSelecionada = PecaVazia.getInstance();
                            }
                        }
                    }
                }
            }
            else {
                inimiga = false;
            }
        }
    }

    public Peca getPecaSelecionada() {
        return pecaSelecionada ;
    }
}
