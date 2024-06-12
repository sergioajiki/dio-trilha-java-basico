package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Conta> contas = new ArrayList<>();
        Banco banco = new Banco("Dio Banco", contas, new HashSet<>());

        Cliente sergio = new Cliente("Sergio","123456789-01");
        banco.adicionarCliente(sergio);
        Cliente cliente1 = new Cliente("Cliente1", "999999999-00");
        banco.adicionarCliente(cliente1);
        Cliente cliente2 = new Cliente("Cliente2", "123.456.789-00");
        banco.adicionarCliente(cliente2);
        Cliente cliente3 = new Cliente("Cliente3", "987.654.321-00");
        banco.adicionarCliente(cliente3);
        Cliente sergio2 = new Cliente("Sergio2","123456789-01");
        banco.adicionarCliente(sergio2);

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
        conta2.depositar(15);
        conta2.imprimirExtrato();
        conta2.sacar(100);



        Conta conta3 = new ContaPoupanca(cliente3);
        contas.add(conta3);
        conta3.depositar(1000);
        conta3.imprimirExtrato();
        conta3.transferir(1500, poupanca);

        banco.exibirTodasContas();
    }
}