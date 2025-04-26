public class ContaPoupanca extends ContaBancaria{ //Classe Filha

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void imprimirExtrato() {
        System.out.println("==== Extrato Conta Poupança ====");
        super.imprimirInfosComuns();
    }   
}


