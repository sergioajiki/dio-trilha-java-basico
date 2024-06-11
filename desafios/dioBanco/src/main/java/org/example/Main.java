package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente sergio = new Cliente("Sergio","123456789-01");
        Conta cc = new ContaCorrente(sergio);
        Conta poupanca = new ContaPoupanca(sergio);

        cc.depositar(100);
        cc.imprimirExtrato();
        cc.transferir(30, poupanca);
        poupanca.sacar(25);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();


//        Cliente cliente1 = new Cliente("Cliente1", "999999999-00");
//
//
//        Conta cc1 = new ContaCorrente(cliente1);
//        Conta poupanca1 = new ContaPoupanca(cliente1);
//
//        cc1.depositar(1000);
//        cc1.imprimirExtrato();
//        cc1.transferir(540, poupanca1);
//
//        cc1.imprimirExtrato();
//        poupanca1.imprimirExtrato();
    }
}