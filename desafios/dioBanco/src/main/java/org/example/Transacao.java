package org.example;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class Transacao {
    private String dataHoraTransacao;
    private String transacao;
    private double valor;
    private double saldoAposTransacao;

    public Transacao (String transacao, double valor, double saldoAposTransacao) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.dataHoraTransacao = LocalDateTime.now().format(formatter);
        this.transacao = transacao;
        this.valor = valor;
        this.saldoAposTransacao = saldoAposTransacao;
    }
}
