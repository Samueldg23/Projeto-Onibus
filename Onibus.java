public class Onibus {
    private Assento[][] assentos;
    private int numeroOnibus;

    public Onibus(int numeroOnibus) {
        this.numeroOnibus = numeroOnibus;
        assentos = new Assento[10][5];
        inicializarAssentos();
    }

    private void inicializarAssentos() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                if (j != 2) { // Ignorar a coluna do meio
                    assentos[i][j] = new Assento();
                }
            }
        }
    }
    public boolean reservarAssento(int linha, int coluna, Cliente cliente) {
        if (assentos[linha][coluna].estaVazio(linha, coluna)) {
            assentos[linha][coluna].reservarAssento(linha, coluna, cliente);
            return true;
        } else {
            return false; 
        }
    }

    public Assento[][] getAssentos() {
        return assentos;
    }

    public int getNumeroOnibus() {
        return numeroOnibus;
    }
}