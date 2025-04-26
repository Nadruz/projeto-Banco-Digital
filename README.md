# Projeto Banco Digital

Este projeto exemplifica os pilares da Programação Orientada a Objetos (POO) em Java, aplicando **abstração**, **encapsulamento**, **herança** e **polimorfismo** para modelar um sistema bancário simples com contas correntes e poupança.

---

## 🎯 Visão Geral

- **Banco**: centraliza clientes e suas contas.  
- **Cliente**: representa o correntista, que pode ter várias contas.  
- **Conta (interface)**: define o contrato para depósitos, saques, transferências e impressão de extrato.  
- **ContaBancaria (abstract)**: implementa métodos comuns de `Conta`, gera números sequenciais e armazena o cliente.  
- **ContaCorrente / ContaPoupanca**: especializações que sobrescrevem `imprimirExtrato()` e podem adicionar regras próprias (tarifas, juros, etc.).  
- **Main**: demonstra depósito, transferência e extrato de duas contas de um mesmo cliente.

---

## 📦 Estrutura de Pacotes

```
src.com.seubanco
│
├── Banco.java
├── Cliente.java
├── Conta.java
├── ContaBancaria.java
├── ContaCorrente.java
├── ContaPoupanca.java
└── Main.java
```

---

## 🔑 Principais Classes

### `Banco`
```java
public class Banco {
    private String nome;
    private List<ContaBancaria> contas;
    // getters e setters…
}
```

### `Cliente`
```java
public class Cliente {
    private String nome;
    // getters e setters…
}
```

### `Conta` (Interface)
```java
public interface Conta {
    void sacar(double valor);
    void depositar(double valor);
    void transferir(double valor, Conta contaDestino);
    void imprimirExtrato();
}
```

### `ContaBancaria` (Classe Abstrata)
```java
public abstract class ContaBancaria implements Conta {
    private static int AGENCIA_PADRAO = 0;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public ContaBancaria(Cliente cliente) { … }

    @Override public void sacar(double valor) { … }
    @Override public void depositar(double valor) { … }
    @Override public void transferir(double valor, Conta contaDestino) { … }

    protected void imprimirInfosComuns() { … }
}
```

### `ContaCorrente` e `ContaPoupanca`
```java
public class ContaCorrente extends ContaBancaria {
    public ContaCorrente(Cliente c) { super(c); }
    public void imprimirExtrato() { … }
}

public class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(Cliente c) { super(c); }
    public void imprimirExtrato() { … }
}
```

### `Main` (Demonstração)
```java
public class Main {
    public static void main(String[] args) {
        Cliente juliana = new Cliente();
        juliana.setNome("Juliana");

        ContaBancaria corrente = new ContaCorrente(juliana);
        ContaBancaria poupanca = new ContaPoupanca(juliana);

        corrente.depositar(1000);
        corrente.transferir(500, poupanca);

        corrente.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
```

---

## 🧩 Diagrama de Classes (Mermaid)

```mermaid
classDiagram
    class Banco {
        - String nome
        - List~ContaBancaria~ contas
        + getNome()
        + setNome()
        + getContas()
        + setContas()
    }

    class Cliente {
        - String nome
        + getNome()
        + setNome()
    }

    interface Conta {
        + sacar(valor: double)
        + depositar(valor: double)
        + transferir(valor: double, destino: Conta)
        + imprimirExtrato()
    }

    abstract class ContaBancaria {
        - static AGENCIA_PADRAO: int
        - static SEQUENCIAL: int
        # int agencia
        # int numero
        # double saldo
        # Cliente cliente
        + ContaBancaria(cliente: Cliente)
        + sacar(valor: double)
        + depositar(valor: double)
        + transferir(valor: double, destino: ContaBancaria)
        # imprimirInfosComuns()
    }

    class ContaCorrente {
        + ContaCorrente(cliente: Cliente)
        + imprimirExtrato()
    }

    class ContaPoupanca {
        + ContaPoupanca(cliente: Cliente)
        + imprimirExtrato()
    }

    Banco "1" --> "*" ContaBancaria : contas
    Cliente "1" --> "*" ContaBancaria
    ContaBancaria <|-- ContaCorrente
    ContaBancaria <|-- ContaPoupanca
    ContaBancaria ..|> Conta
```

---

## 🚀 Funcionalidades

- **Depósito**, **saque** e **transferência** entre contas da mesma instituição.  
- **Geração automática** de número sequencial e agência padrão.  
- **Extratos** específicos por tipo de conta, demonstrando o uso de **polimorfismo**.  

---

## 📌 Conclusão

Este projeto mostra como organizar um sistema bancário em Java usando boas práticas de POO. É fácil estender para:

- Adicionar juros ou tarifas específicas à poupanca/corrente.  
- Implementar mais tipos de conta (investimento, salário, etc.).  
- Persistir dados em banco de dados ou arquivos.  
