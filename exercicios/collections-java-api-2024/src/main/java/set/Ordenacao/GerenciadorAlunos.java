package main.java.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    //Adiciona um aluno ao conjunto.
    public void adicionarAluno(String nome, Long matricula, double media) {
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    //Remove um aluno ao conjunto a partir da matricula, se estiver presente.
    public void removerAluno(long matricula) {
        alunoSet.removeIf(aluno -> aluno.getMatricula().equals(matricula));
    }

    //Exibe todos os alunos do conjunto em ordem alfabética pelo nome.
    public Set<Aluno> exibirAlunosPorNome() {
        Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet);
        return alunosPorNome;
    }

    //Exibe todos os alunos do conjunto em ordem crescente de nota.
    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunoPorMedia = new TreeSet<>(new Aluno.ComparatorPorNota());
        alunoPorMedia.addAll(alunoPorMedia);
        return alunoPorMedia;
    }

    //Exibe todos os alunos do conjunto.
    public void exibirAlunos() {
        for (Aluno aluno : alunoSet) {
            System.out.println(aluno);
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciador = new GerenciadorAlunos();

        gerenciador.adicionarAluno("Aluno7", 1L, 8.5);
        gerenciador.adicionarAluno("Aluno2", 2L, 7.0);
        gerenciador.adicionarAluno("Aluno8", 3L, 9.0);
        gerenciador.adicionarAluno("Aluno99", 4L, 5.0);
        gerenciador.adicionarAluno("Aluno4", 3L, 6.5);
        gerenciador.adicionarAluno("Aluno3", 5L, 6.5);

        System.out.println("Todos os alunos:");
        gerenciador.exibirAlunos();

        System.out.println("\nAlunos por nome:");
        for (Aluno aluno : gerenciador.exibirAlunosPorNome()) {
            System.out.println(aluno);
        }

        System.out.println("\nAlunos por nota:");
        for (Aluno aluno : gerenciador.exibirAlunosPorNota()) {
            System.out.println(aluno);
        }

        gerenciador.removerAluno(2L);
        System.out.println("\nAlunos após remover o aluno com matrícula 2:");
        gerenciador.exibirAlunos();

        System.out.println("Todos os alunos:");
        gerenciador.exibirAlunos();
    }
}
