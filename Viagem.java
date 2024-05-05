import java.util.Date;

public class Viagem {
    private String origem;
    private String destino;
    private Date dataIda;
    private Date dataVolta;
    private Onibus onibus;
    private double valor;

    public Viagem(String origem, String destino, Date dataIda, Date dataVolta, Onibus onibus, double valor) {
        this.origem = origem;
        this.destino = destino;
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
        this.onibus = onibus;
        this.valor = valor;
    }
    public void mostrarAssentosDisponiveis() {
        System.out.println("Assentos Disponíveis:");
        for (int i = 0; i < onibus.getAssentos().length; i++) {
            for (int j = 0; j < onibus.getAssentos()[i].length; j++) {
                if (onibus.getAssentos()[i][j].estaVazio(i, j)) {
                    System.out.println("Assento: " + (i + 1) + (j + 1));
                }
            }
        }
    }
    public boolean reservarAssento(int linha, int coluna, Cliente cliente) {
        if (onibus.reservarAssento(linha, coluna, cliente)) {
            return true;
        } else {
            return false; 
        }
    }
    @Override
    public String toString() {
        return "Viagem de " + origem + " para " + destino +"\n"+ ", Data de Ida: " + dataIda +"\n"+ ", Data de Volta: " + dataVolta + "\n" + valor;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getDataIda() {
        return dataIda;
    }

    public void setDataIda(Date dataIda) {
        this.dataIda = dataIda;
    }

    public Date getDataVolta() {
        return dataVolta;
    }

    public void setDataVolta(Date dataVolta) {
        this.dataVolta = dataVolta;
    }

    public Onibus getOnibus() {
        return onibus;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }

    public static void main(String[] args) {

        Onibus onibus1 = new Onibus(1);
        Onibus onibus2 = new Onibus(2);
        Onibus onibus3 = new Onibus(3);
        Onibus onibus4 = new Onibus(4);
        Onibus onibus5 = new Onibus(5);

        Viagem viagem1 = new Viagem("Vitoria", "Rio de Janeiro", new Date(), new Date(), onibus1, 250.0);
        Viagem viagem2 = new Viagem("Vitoria", "Belo Horizonte", new Date(), new Date(), onibus2, 350.0);
        Viagem viagem3 = new Viagem("Vitoria", "Santa Catarina", new Date(), new Date(), onibus3, 500.0);
        Viagem viagem4 = new Viagem("Vitoria", "Salvador", new Date(), new Date(), onibus4, 350.0);
        Viagem viagem5 = new Viagem("Vitoria", "Fortaleza", new Date(), new Date(), onibus5, 400.0);
    }
}