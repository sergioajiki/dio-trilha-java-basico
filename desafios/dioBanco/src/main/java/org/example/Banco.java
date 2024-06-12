package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class Banco {
    private String nome;
    private List<Conta> contas;
    private Set<String> cpfRegistradoSet;
    private List<Cliente> clienteList;

    public boolean adicionarCliente(Cliente cliente) {
        if (cpfRegistradoSet.contains(cliente.getCpf())) {
            System.out.println(String.format("\nO Cpf %s já está cadastrado neste banco", cliente.getCpf()));
            return false;
        }
        cpfRegistradoSet.add(cliente.getCpf());
        clienteList.add(cliente);
        return true;
    }

    public List<Conta> getAllContas() {
        return contas;
    }

    public void exibirTodasContas() {
        List<Conta> todasContas = this.getAllContas();
        System.out.println("\nContas do banco:");
        for (Conta conta : todasContas) {
            conta.imprimirInfoComuns();
        }
    }

    public List<String> getAllClientes() {
        List<String> allClientes = new ArrayList<>();
        for (Cliente cliente : clienteList) {
            allClientes.add(String.format("Nome: %s, Cpf: %s", cliente.getNome(), cliente.getCpf()));
        }
        return allClientes;
    }

    public void exibirTodosClientes() {
        System.out.println("\nClientes do banco:");
        for (String clienteInfo : this.getAllClientes()) {
            System.out.println(clienteInfo);
        }
    }
}
