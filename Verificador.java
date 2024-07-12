public class Verificador {

    public Verificador() {

    }

    public static boolean reiEmCheque(Tabuleiro tabuleiro,boolean branca) {
        //encontra a posicao do rei
        int linhaRei = 0;
        int colunaRei = 0;
        for (int i = 0;i < 8;i++) {
            for (int j = 0;j < 8;j++) {
                Peca peca = tabuleiro.getCasa(i,j).getPeca() ;
                if (peca instanceof Rei) {
                    Rei rei = (Rei) peca ;
                    if (rei.getcolor() == branca) {
                        linhaRei = rei.getCasa().getLinha() ;
                        colunaRei = rei.getCasa().getColuna() ;
                    }
                }
            }
        }
        System.out.println("Rei esta na linha" + linhaRei) ;
        System.out.println("Rei esta na coluna" + colunaRei) ;
        for (int i = 0;i < 8;i++) {
            for (int j =0;j < 8;j++) {
                Casa casa = tabuleiro.getCasa(i, j);
                if (casa.isOcupada()) {
                    Peca peca = casa.getPeca();
                    if (peca.getcolor() != branca) {
                        if (peca instanceof Peao) {
                            Peao peao = (Peao) peca;
                            peao.resetpositions(tabuleiro, i, j);
                            int[][] inimigas = peao.getInimigas();
                            for (int linha = 0; linha < inimigas.length; linha++) {
                                if ((inimigas[linha][0] == linhaRei) && (inimigas[linha][1] == colunaRei)) {
                                    System.out.println("Rei em cheque");
                                    return true;
                                }
                            }
                        } else if (peca instanceof Torre) {
                            Torre torre = (Torre) peca;
                            torre.resetpositions(tabuleiro, i, j);
                            int[][] inimigas = torre.getInimigas();
                            for (int linha = 0; linha < inimigas.length; linha++) {
                                if ((inimigas[linha][0] == linhaRei) && (inimigas[linha][1] == colunaRei)) {
                                    System.out.println("Rei em cheque");
                                    return true;
                                }
                            }
                        } else if (peca instanceof Cavalo) {
                            Cavalo cavalo = (Cavalo) peca;
                            cavalo.resetpositions(tabuleiro, i, j);
                            int[][] inimigas = cavalo.getInimigas();
                            for (int linha = 0; linha < inimigas.length; linha++) {
                                if ((inimigas[linha][0] == linhaRei) && (inimigas[linha][1] == colunaRei)) {
                                    System.out.println("Rei em cheque");
                                    return true;
                                }
                            }
                        } else if (peca instanceof Bispo) {
                            Bispo bispo = (Bispo) peca;
                            bispo.resetpositions(tabuleiro, i, j);
                            int[][] inimigas = bispo.getInimigas();
                            for (int linha = 0; linha < inimigas.length; linha++) {
                                if ((inimigas[linha][0] == linhaRei) && (inimigas[linha][1] == colunaRei)) {
                                    System.out.println("Rei em cheque");
                                    return true;
                                }
                            }
                        } else if (peca instanceof Rainha) {
                            Rainha rainha = (Rainha) peca;
                            rainha.resetpositions(tabuleiro, i, j);
                            int[][] inimigas = rainha.getInimigas();
                            for (int linha = 0; linha < inimigas.length; linha++) {
                                if ((inimigas[linha][0] == linhaRei) && (inimigas[linha][1] == colunaRei)) {
                                    System.out.println("Rei em cheque");
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Rei nao esta em cheque");
        return false ;
    }
    public static boolean checkMate(Tabuleiro tabuleiro,boolean branca) {
        int linhaRei = 0;
        int colunaRei = 0;
        for (int i = 0;i < 8;i++) {
            for (int j = 0;j < 8;j++) {
                Peca peca = tabuleiro.getCasa(i,j).getPeca() ;
                if (peca instanceof Rei) {
                    Rei rei = (Rei) peca ;
                    if (rei.getcolor() == branca) {
                        linhaRei = rei.getCasa().getLinha() ;
                        colunaRei = rei.getCasa().getColuna() ;
                    }
                }
            }
        }
        if (reiEmCheque(tabuleiro,branca)) {
            Rei rei = (Rei) tabuleiro.getCasa(linhaRei,colunaRei).getPeca() ;
            rei.resetpositions(tabuleiro,linhaRei,colunaRei);
            int[][] proximas = rei.getProximas() ;
            boolean checkMate = false ;
            int linhaAtual = linhaRei ;
            int colunaAtual = colunaRei ;
            for (int i = 0;i < proximas.length;i++) {
                int linhaProxima = proximas[i][0] ;
                int colunaProxima = proximas[i][1] ;
                tabuleiro.moverPeca(linhaAtual,colunaAtual,linhaProxima,colunaProxima) ;
                if (!reiEmCheque(tabuleiro,branca)) {
                    tabuleiro.moverPeca(linhaProxima,colunaProxima,linhaAtual,colunaAtual) ;
                    return false ;
                }
                else {
                    tabuleiro.moverPeca(linhaProxima,colunaProxima,linhaAtual,colunaAtual) ;
                    linhaAtual = linhaProxima ;
                    colunaAtual = colunaProxima ;
                }
            }
            System.out.println("Check mate");
            return true ;
        }
        return false ;
    }
}
