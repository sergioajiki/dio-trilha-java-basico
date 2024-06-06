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

}
