package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavraSet;

    public ConjuntoPalavrasUnicas() {
        this.palavraSet = new HashSet<>();
    }

    //Adiciona uma palavra ao conjunto.
    public void adicionarPalavra(String palavra) {
        palavraSet.add(palavra);
    }

    //Remove uma palavra do conjunto.
    public void removerPalavra(String palavra) {
        palavraSet.remove(palavra);
    }

    //Verifica se uma palavra está presente no conjunto.
    public boolean verificarPalavra(String palavra) {
        return palavraSet.contains(palavra);
    }

    //Exibe todas as palavras únicas do conjunto.
    public void exibirPalavrasUnicas() {
        for(String palavra : palavraSet)
            System.out.println(palavra);
    }
    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjunto = new ConjuntoPalavrasUnicas();
        conjunto.adicionarPalavra("Palavra1");
        conjunto.adicionarPalavra("Palavra2");
        conjunto.adicionarPalavra("Palavra3");
        conjunto.adicionarPalavra("Palavra4");
        conjunto.adicionarPalavra("Palavra5");
        conjunto.adicionarPalavra("Palavra2"); // Palavra duplicada

        System.out.println("Palavras no conjunto:");
        conjunto.exibirPalavrasUnicas();

        System.out.println("Verificando se 'Palavra1' está no conjunto: " + conjunto.verificarPalavra("Palavra1"));
        System.out.println("Verificando se 'Palavra' está no conjunto: " + conjunto.verificarPalavra("Palavra"));

        conjunto.removerPalavra("Palavra2");
        System.out.println("Palavras no conjunto após remover 'Palavra2':");
        conjunto.exibirPalavrasUnicas();
    }
}
