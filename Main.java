import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main{
    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.inicializatabuleliro();
        
        Print print = new print();

        int timer;
        Scanner scanner = new Scanner(System.in);
        int timer = scanner.nextInt();
        long startTime = System.currentTimeMillis();

        system.out.println("Digite enter para começar");
        scanner.nextLine();
    }

    while((System.currentTimeMillis() - startTime) < n * 60 * 1000){//na proxima versao será utilizada a classe timer para uma implementação mais sofisticada
        print.printgrid(print.createmap(tabuleiro));//o tabuleiro atual é impresso

        system.out.println("Brancas: insira a peça que deseja movimentar");

        while(true){//validação da jogada do jogador das brancas
            String peca = scanner.nextLine();
            int[] coord = new int[2];
            coord[0] = locatepeca(peca)[0];
            coord[1] = locatepeca(peca)[1];
            if(coord[0] == -1){
                system.out.println("Peça não encontrada");
            } else {
                while(true){
                    print.printgrid(print.createmap(tabuleiro, [coord[0], coord[1]]));
                    system.out.println("Brancas: insira a casa no formato 'linhacoluna'");
                    int pos = scanner.nextInt();
                    int posx = pos/10;
                    int posx = pos%10;
                    if( !((posx <= 8) && (posx >= 1) && (posy <= 8) && (posy >= 1))){
                        system.out.println("Posição não encontrada");
                    } else {
                        tabuleiro.getcasa(posx, posy).getpeca().move(tabuleiro, posx, posy);
                        break;
                    }
                }
                break;
            }
        }//finaliza jogada da branca

        Thread.sleep(1000);//breve pausa para troca de jogador

        print.printgrid(print.createmap(tabuleiro));//o tabuleiro atual é impresso

        system.out.println("Negras: insira a peça que deseja movimentar");

        while(true){//validação da jogada do jogador das brancas
            String peca = scanner.nextLine();
            int[] coord = new int[2];
            coord[0] = locatepeca(peca)[0];
            coord[1] = locatepeca(peca)[1];
            if(coord[0] == -1){
                system.out.println("Peça não encontrada");
            } else {
                while(true){
                    print.printgrid(print.createmap(tabuleiro, [coord[0], coord[1]]));
                    system.out.println("Negras: insira a casa no formato 'linhacoluna'");
                    int pos = scanner.nextInt();
                    int posx = pos/10;
                    int posx = pos%10;
                    if( !((posx <= 8) && (posx >= 1) && (posy <= 8) && (posy >= 1))){
                        system.out.println("Posição não encontrada");
                    } else {
                        tabuleiro.getcasa(posx, posy).getpeca().move(tabuleiro, posx, posy);
                        break;
                    }
                }
                break;
            }
        }//finaliza jogada da negra

    }

    system.out.println("Tempo encerrado, o jogo acabou. Determine o vencedor");//futuras versões terão implementações mais sofisticadas do vencedor

}