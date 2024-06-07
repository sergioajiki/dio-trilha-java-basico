package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    //Adiciona um contato à agenda, associando o nome do contato ao número de telefone correspondente.
    public void adicionarContato(String nome, Integer telefone) {
        agendaContatoMap.put(nome, telefone);
    }

    //Remove um contato da agenda, dado o nome do contato.
    public void removerContato(String nome) {
        if (!agendaContatoMap.isEmpty()) {
            agendaContatoMap.remove(nome);
        }
    }

    //Exibe todos os contatos da agenda, mostrando o nome e o número de telefone de cada contato.
    public void exibirContatos() {
        System.out.println(agendaContatoMap);
    }

    //Pesquisa um contato pelo nome e retorna o número de telefone correspondente.
    public Integer pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;
        if (!agendaContatoMap.isEmpty()) {
            numeroPorNome = agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }
}
