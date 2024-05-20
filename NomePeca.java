public enum NomePeca {
    PEAO("Peão"),
    TORRE("Torre"),
    CAVALO("Cavalo"),
    BISPO("Bispo"),
    RAINHA("Rainha"),
    REI("Rei");

    private final String nome;

    NomePeca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
