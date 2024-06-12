package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Banco {
    private String nome;
    private List<Conta> contas;

    public List getAllContas() {
        return contas;
    }
    public void exibirTodasContas() {
        List<Conta> todasContas = this.getAllContas();
        System.out.println("Contas do banco:");
        for (Conta conta : todasContas) {
            conta.imprimirInfoComuns();
        }
    }
}
