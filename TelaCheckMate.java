import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
public class TelaCheckMate {
    public static void exibirCheckMateFrame(boolean vencedorBranco) {
        JFrame checkMateFrame = new JFrame("Checkmate");
        checkMateFrame.setSize(400, 200);
        checkMateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String mensagem = vencedorBranco ? "Checkmate! Brancas vencem!" : "Checkmate! Pretas vencem!";
        JLabel label = new JLabel(mensagem, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        checkMateFrame.add(label);
        checkMateFrame.setLocationRelativeTo(null); // Centraliza o frame na tela
        checkMateFrame.setVisible(true);
    }
}
