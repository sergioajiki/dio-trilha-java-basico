package org.example;

import lombok.Getter;
import org.example.interfaces.IConta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<Transacao> transacaoList;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.transacaoList = new ArrayList<>();
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            transacaoList.add(new Transacao("Saque", valor, saldo));
        } else {
            System.out.println(LocalDateTime.now().format(formatter)
                    + " - Saque - R$ "
                    + valor
                    + " - Saldo insuficiente para saque."
            );
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        transacaoList.add(new Transacao("Depósito", valor, saldo));
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            transacaoList.add(new Transacao("Tranferência", valor, saldo));
        } else {
            System.out.println(LocalDateTime.now().format(formatter)
                    + " - Transferência - R$ "
                    + valor
                    + " - Saldo insuficiente para transferência."
            );
        }
    }

    public void imprimirInfoComuns() {
        System.out.println(String.format("\nTitular: %s", this.cliente.getNome()));
        System.out.println(String.format("CPF: %s", this.cliente.getCpf()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("---Extrato de Transações---");
        for (Transacao transacao : transacaoList) {
            System.out.println(String.format("%s - %s - R$%.2f - Saldo após transação: R$%.2f",
                    transacao.getDataHoraTransacao(),
                    transacao.getTransacao(),
                    transacao.getValor(),
                    transacao.getSaldoAposTransacao()));
        }
    }
}
