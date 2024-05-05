import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SistemaPassagem {
    /*Concertar o erro de que quando seleciona a viagem só aparece o assento 11 e 12 e depois da erro no código e também quando é escolhido
     * os outros números nada acontece e quando escolho para ver os assentos disponíveis da o mesmo erro, tirar a opção ver assentos disponíveis
     * e tornar fazer ela aparecer quando vejo as viagens disponíveis
     */
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = null;
        Viagem[] viagens = SistemaPassagem.verificarViagens();

        
        while (true) {
            System.out.println("1. Comprar Passagem");
            System.out.println("2. Verificar Viagens Disponíveis");
            System.out.println("3. Verificar suas Passagens");
            System.out.println("4. Verificar Assentos Disponíveis");
            System.out.println("5. Cancelar Viagem");
            System.out.println("6. Sair do Menu");
            System.out.print("Escolha um número: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  
            
            switch (opcao) {
                case 1:
                    comprarPassagem(scanner, viagens);
                    break;
                case 2:
                    verificarViagens();
                    break;
                case 3:
                    verificarPassagensCliente(cliente, viagens);
                    break;
                case 4:
                    verificarAssentosDisponiveis(viagens);
                    break;
                case 5:
                    cancelarViagem(cliente, viagens, null);
                    break;
                case 6:
                    System.out.println("Saindo do Menu...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    private static void comprarPassagem(Scanner scanner, Viagem[] viagens) {
        System.out.println("----- Compra de Passagem -----");
            verificarViagens();
    
         System.out.println("Viagens Disponíveis:");
             for (int i = 0; i < viagens.length; i++) {
                System.out.println((i + 1) + ". " + viagens[i].toString());
            }
        
    
        System.out.print("Escolha o número da viagem desejada: ");
        int numeroViagemEscolhida = scanner.nextInt();
        scanner.nextLine();  

        if (numeroViagemEscolhida < 1 || numeroViagemEscolhida > viagens.length) {
            System.out.println("Número de viagem inválido.");
            return;
        }

        Viagem viagemEscolhida = viagens[numeroViagemEscolhida - 1];

        viagemEscolhida.mostrarAssentosDisponiveis();

        System.out.print("Escolha o número do assento desejado: ");
        String assentoEscolhido = scanner.nextLine();

        System.out.print("Nome do Cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Email do Cliente: ");
        String emailCliente = scanner.nextLine();
        System.out.print("CPF do Cliente: ");
        String cpfCliente = scanner.nextLine();

        Cliente cliente = new Cliente(nomeCliente, emailCliente, cpfCliente);

        viagemEscolhida.reservarAssento(numeroViagemEscolhida, numeroViagemEscolhida, cliente);

        System.out.println("Passagem comprada com sucesso para o assento " + assentoEscolhido + ".");
    }

    public void reservarAssento(String numeroAssento, Cliente cliente, Onibus onibus) {
        int linha = Character.getNumericValue(numeroAssento.charAt(0)) - 1;
        int coluna = Character.getNumericValue(numeroAssento.charAt(1)) - 1;

        if (linha >= 0 && linha < onibus.getAssentos().length && coluna >= 0 && coluna < onibus.getAssentos()[linha].length) {
            if (onibus.getAssentos()[linha][coluna].estaVazio(linha, coluna)) {
                onibus.getAssentos()[linha][coluna].reservarAssento(linha, coluna, cliente);
            } else {
                System.out.println("O assento selecionado já está ocupado.");
            }
        } else {
            System.out.println("O número do assento selecionado é inválido.");
        }
    }
    






    private static Viagem[] verificarViagens() {
        Onibus onibus1 = new Onibus(1);
        Onibus onibus2 = new Onibus(2);
        Onibus onibus3 = new Onibus(3);
        Onibus onibus4 = new Onibus(4);
        Onibus onibus5 = new Onibus(5);
    
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
        Date dataIda1 = null;
        Date dataVolta1 = null;
        Date dataIda2 = null;
        Date dataVolta2 = null;
        Date dataIda3 = null;
        Date dataVolta3 = null;
        Date dataIda4 = null;
        Date dataVolta4 = null;
        Date dataIda5 = null;
        Date dataVolta5 = null;
        try {
            dataIda1 = dateFormat.parse("01/05/2024");
            dataVolta1 = dateFormat.parse("05/05/2024");
            dataIda2 = dateFormat.parse("10/05/2024");
            dataVolta2 = dateFormat.parse("15/05/2024");
            dataIda3 = dateFormat.parse("20/05/2024");
            dataVolta3 = dateFormat.parse("25/05/2024");
            dataIda4 = dateFormat.parse("01/06/2024");
            dataVolta4 = dateFormat.parse("05/06/2024");
            dataIda5 = dateFormat.parse("10/06/2024");
            dataVolta5 = dateFormat.parse("15/06/2024");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    
        Viagem viagem1 = new Viagem("Vitoria", "Rio de Janeiro", new Date(), new Date(), onibus1, 250.0);
        Viagem viagem2 = new Viagem("Vitoria", "Belo Horizonte", new Date(), new Date(), onibus2, 350.0);
        Viagem viagem3 = new Viagem("Vitoria", "Santa Catarina", new Date(), new Date(), onibus3, 500.0);
        Viagem viagem4 = new Viagem("Vitoria", "Salvador", new Date(), new Date(), onibus4, 350.0);
        Viagem viagem5 = new Viagem("Vitoria", "Fortaleza", new Date(), new Date(), onibus5, 400.0);
        return new Viagem[] {viagem1, viagem2,viagem3, viagem4, viagem5};
    }
        
        private static void verificarPassagensCliente(Cliente cliente, Viagem[] viagens) {
            if (cliente == null) {
                System.out.println("Nenhum cliente registrado.");
                return;
            }
            
            System.out.println("----- Passagens do Cliente -----");
            boolean temPassagens = false;
            
            for (Viagem viagem : viagens) {
                Assento[][] assentos = viagem.getOnibus().getAssentos();
                
                for (int i = 0; i < assentos.length; i++) {
                    for (int j = 0; j < assentos[i].length; j++) {
                        if (assentos[i][j] != null && assentos[i][j].getCliente() == cliente) {
                            System.out.println("Viagem: " + viagem.getOrigem() + " para " + viagem.getDestino() + ", Assento: " + (i+1) + (j+1));
                            temPassagens = true;
                            break;
                        }
                    }
                }
            }
            
            if (!temPassagens) {
                System.out.println("O cliente não possui passagens reservadas.");
            }
        }
    
        private static void verificarAssentosDisponiveis(Viagem[] viagens) {
            if (viagens == null || viagens.length == 0) {
                System.out.println("Nenhuma viagem disponível.");
                return;
            }
            
            System.out.println("----- Assentos Disponíveis nos Ônibus -----");
            
            for (Viagem viagem : viagens) {
                Onibus onibus = viagem.getOnibus();
                System.out.println("Ônibus: " + onibus.getNumeroOnibus());
                Assento[][] assentos = onibus.getAssentos();
                
                for (int i = 0; i < assentos.length; i++) {
                    for (int j = 0; j < assentos[i].length; j++) {
                        if (assentos[i][j].estaVazio(i, j)) {
                            System.out.println("Assento " + (i+1) + (j+1) + " está disponível.");
                        }
                    }
                }
                System.out.println();
            }
        }
        private static void cancelarViagem(Cliente cliente, Viagem[] viagens, Viagem viagemEscolhida) {
            if (viagemEscolhida == null) {
                System.out.println("Nenhum cliente registrado.");
                return;
            }
            
            System.out.println("----- Cancelar Viagem -----");
            
            boolean passagensEncontradas = false;
            for (Viagem viagem : viagens) {
                Assento[][] assentos = viagem.getOnibus().getAssentos();
                for (int i = 0; i < assentos.length; i++) {
                    for (int j = 0; j < assentos[i].length; j++) {
                        if (assentos[i][j] != null && assentos[i][j].getCliente() == cliente) {
 
                            System.out.println("Viagem: " + viagem.getOrigem() + " para " + viagem.getDestino() +
                                               ", Assento: " + (i+1) + (j+1));
                            passagensEncontradas = true;
                        }
                    }
                }
            }
            
            if (!passagensEncontradas) {
                System.out.println("O cliente não possui passagens reservadas para cancelar.");
                return;
            }
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Selecione o número do assento da passagem que deseja cancelar: ");
            String assentoCanceladoStr = scanner.nextLine();
            
            int numeroAssento = Integer.parseInt(assentoCanceladoStr);
            int linha = (numeroAssento - 1) / 5; 
            int coluna = (numeroAssento - 1) % 5; 

            if (viagemEscolhida != null) {
            Assento[][] assentos = viagemEscolhida.getOnibus().getAssentos();
    
            if (linha >= 0 && linha < assentos.length && coluna >= 0 && coluna < assentos[linha].length) {
            if (!assentos[linha][coluna].estaVazio(linha, coluna)) {
            assentos[linha][coluna] = null; 
            System.out.println("Passagem para o assento " + assentoCanceladoStr + " cancelada com sucesso.");
            } else {
            System.out.println("O assento selecionado já está vazio.");
            }
            } else {
            System.out.println("O número do assento selecionado é inválido.");
            }
            } else {
            System.out.println("Nenhuma viagem selecionada.");
        }
    }
}