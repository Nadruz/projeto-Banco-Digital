public  class ContaCorrente extends ContaBancaria{ //Classe Filha
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public void imprimirExtrato() {
        System.out.println("==== Extrato Conta Corrente ====");
        super.imprimirInfosComuns();
    }
}
