public class timer {
    private int segundos = 0;
    private Timer timer;

    public timer() {
        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                segundos++;
            }
        };
        //Cria o Timer que chama o ActionListener a cada 1000 milissegundos (1 segundo)
        timer = new Timer(1000, action);
    }

    // Método para iniciar o cronômetro
    public void iniciar() {
        timer.start();
    }

    // Método para parar o cronômetro
    public void parar() {
        timer.stop();
    }
}
