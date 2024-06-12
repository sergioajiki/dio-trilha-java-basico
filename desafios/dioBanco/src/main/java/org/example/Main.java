package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Conta> contas = new ArrayList<>();
        Banco banco = new Banco("Dio Banco", contas);

        Cliente sergio = new Cliente("Sergio","123456789-01");
        Cliente cliente1 = new Cliente("Cliente1", "999999999-00");
        Cliente cliente2 = new Cliente("João Silva", "123.456.789-00");
        Cliente cliente3 = new Cliente("Maria Souza", "987.654.321-00");

        Conta cc = new ContaCorrente(sergio);
        contas.add(cc);
        Conta poupanca = new ContaPoupanca(sergio);
        contas.add(poupanca);


        cc.depositar(100);
        cc.imprimirExtrato();
        cc.transferir(30, poupanca);
        poupanca.sacar(25);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        Conta cc1 = new ContaCorrente(cliente1);
        contas.add(cc1);
        Conta poupanca1 = new ContaPoupanca(cliente1);
        contas.add(poupanca1);
        cc1.depositar(1000);
        cc1.imprimirExtrato();
        cc1.transferir(540, poupanca1);

        cc1.imprimirExtrato();
        poupanca1.imprimirExtrato();

        Conta conta2 = new ContaCorrente(cliente2);
        contas.add(conta2);

        Conta conta3 = new ContaPoupanca(cliente3);
        contas.add(conta3);

        banco.exibirTodasContas();
    }
}