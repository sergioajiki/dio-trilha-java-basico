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
        listaTarefaSet.removeIf(tarefa -> tarefa.getDescricao().equalsIgnoreCase(descricao));
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

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();
        listaTarefas.adicionarTarefa("Tarefa 1");
        listaTarefas.adicionarTarefa("Tarefa 2");
        listaTarefas.adicionarTarefa("Tarefa 3");
        listaTarefas.adicionarTarefa("Tarefa 4");

        System.out.println("Todas as tarefas:");
        listaTarefas.exibirTarefas();

        listaTarefas.marcarTarefaConcluida("Tarefa 2");
        listaTarefas.marcarTarefaConcluida("Tarefa 3");


        System.out.println("\nTarefas concluídas:");
        listaTarefas.obterTarefasConcluidas().forEach(System.out::println);

        System.out.println("\nTarefas pendentes:");
        listaTarefas.obterTarefasPendentes().forEach(System.out::println);

        listaTarefas.removerTarefa("Tarefa 2");

        System.out.println("\nTarefas após remover 'Tarefa 2':");
        listaTarefas.exibirTarefas();

        System.out.println("\nNúmero total de tarefas: " + listaTarefas.contarTarefas());

        listaTarefas.limparListaTarefas();

        System.out.println("\nTarefas após limpar a lista:");
        listaTarefas.exibirTarefas();

        System.out.println("Quantidade de tarefas: " + listaTarefas.contarTarefas());
    }

}
