public class Assento {
        private Cliente[][] assentos;
    
        public Assento() {
            assentos = new Cliente[10][5];
        }
    
        public boolean estaVazio(int linha, int coluna) {
            return assentos[linha][coluna] == null;
        }
        public Cliente getCliente(int linha, int coluna) {return assentos[linha] [coluna];}
    
        public boolean reservarAssento(int linha, int coluna, Cliente cliente) {
            if (estaVazio(linha, coluna)) {
                assentos[linha][coluna] = cliente;
                return true;
            } else {
                return false; 
            }
        }
    
        public boolean cancelarReserva(int linha, int coluna) {
            if (!estaVazio(linha, coluna)) {
                assentos[linha][coluna] = null;
                return true;
            } else {
                return false; 
            }
        }

        public Cliente getCliente() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getCliente'");
        }

        public Cliente[][] getAssentos() {
            return assentos;
        }

        public void setAssentos(Cliente[][] assentos) {
            this.assentos = assentos;
        }
    }
