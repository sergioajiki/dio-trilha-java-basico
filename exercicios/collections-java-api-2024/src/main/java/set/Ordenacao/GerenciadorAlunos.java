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
        for(Aluno aluno : alunoSet) {
            System.out.println(aluno);
        }
    }
}
