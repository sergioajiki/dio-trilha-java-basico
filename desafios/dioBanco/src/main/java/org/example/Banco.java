package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class Banco {
    private String nome;
    private List<Conta> contas;
    private Set<String> cpfRegistradoSet;

    public boolean adicionarCliente(Cliente cliente) {
        if (cpfRegistradoSet.contains(cliente.getCpf())) {
            System.out.println(String.format("\nO cpf %s já está cadastrado neste banco", cliente.getCpf()));
            return false;
        }
        cpfRegistradoSet.add(cliente.getCpf());
        return true;
    }

    public List getAllContas() {
        return contas;
    }
    public void exibirTodasContas() {
        List<Conta> todasContas = this.getAllContas();
        System.out.println("\nContas do banco:");
        for (Conta conta : todasContas) {
            conta.imprimirInfoComuns();
        }
    }
}
