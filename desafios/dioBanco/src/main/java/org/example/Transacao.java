package org.example;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Transacao {
    private LocalDateTime dataHoraTransacao;
    private String transacao;
    private double valor;
    private double saldoAposTransacao;

    public Transacao (String transacao, double valor, double saldoAposTransacao) {
        this.dataHoraTransacao = LocalDateTime.now();
        this.transacao = transacao;
        this.valor = valor;
        this.saldoAposTransacao = saldoAposTransacao;
    }
}
