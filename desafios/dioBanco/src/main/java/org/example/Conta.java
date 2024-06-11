package org.example;

import lombok.Getter;
import org.example.interfaces.IConta;


@Getter
public class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    @Override
    public void sacar(double valor) {

    }

    @Override
    public void depositar(double valor) {

    }

    @Override
    public void tranferir(double valor, IConta contaDestino) {

    }

    @Override
    public void imprimirExtrato() {

    }
}
