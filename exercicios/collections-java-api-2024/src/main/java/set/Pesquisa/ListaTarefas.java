package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ListaTarefas {
    private Set<Tarefa> listaTarefaSet;

    public ListaTarefas() {
        this.listaTarefaSet = new HashSet<>();
    }

    //Adiciona uma nova tarefa ao Set.
    public void adicionarTarefa(String descricao) {
        listaTarefaSet.add(new Tarefa(descricao));
    }

    //Remove uma tarefa do Set de acordo com a descrição, se estiver presente.
    public void removerTarefa(String descricao) {
        listaTarefaSet.remove(descricao);
    }

    //Exibe todas as tarefas da lista de tarefas.
    public void exibirTarefas() {
        for (Tarefa tarefa : listaTarefaSet) {
            System.out.println(tarefa);
        }
    }

    //Conta o número total de tarefas na lista de tarefas.
    public int contarTarefas() {
        return listaTarefaSet.size();
    }

    //Retorna um Set com as tarefas concluídas.
    public Set<Tarefa> obterTarefasConcluidas() {
        return listaTarefaSet.stream()
                //Verifica se a tarefa está concluida - isConcluido = true
                .filter(Tarefa::isConcluido)
                //Retorna os elementos filtrados novamente para 'Set'
                .collect(Collectors.toSet());
    }

    //Retorna um Set com as tarefas pendentes.
    public Set<Tarefa> obterTarefasPendentes() {
        return listaTarefaSet.stream()
                .filter(tarefa -> !tarefa.isConcluido())
                .collect(Collectors.toSet());
    }

    //Marca uma tarefa como concluída de acordo com a descrição.
    public void marcarTarefaConcluida(String descricao) {
        for (Tarefa tarefa : listaTarefaSet) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefa.setConcluido(true);
                break;
            }
        }
    }

    //Marca uma tarefa como pendente de acordo com a descrição.
    public void marcarTarefaPendente(String descricao) {
        for (Tarefa tarefa : listaTarefaSet) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefa.setConcluido(false);
                break;
            }
        }
    }

    //Remove todas as tarefas da lista de tarefas.
    public void limparListaTarefas() {
        listaTarefaSet.clear();
    }
}
