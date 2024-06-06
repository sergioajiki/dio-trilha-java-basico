package main.java.list.Ordenacao;

public class Pessoa {
    private String nome;
    private int Idade;
    private double altura;

    public Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        Idade = idade;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return Idade;
    }

    public double getAltura() {
        return altura;
    }
}
