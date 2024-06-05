package main.java.list.OperacoesBasicas;

public class Tarefa {
    //Cada tarefa é representada por uma classe chamada "Tarefa" que possui um atributo de descrição
    private String descricao;

    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
