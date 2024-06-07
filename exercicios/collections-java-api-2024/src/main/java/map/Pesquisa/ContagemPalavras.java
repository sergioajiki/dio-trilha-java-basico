package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> palavrasMap;

    public ContagemPalavras() {
        this.palavrasMap = new HashMap<>();
    }

    //Adiciona uma palavra à contagem.
    public void adicionarPalavra(String palavra, Integer contagem) {
        palavrasMap.put(palavra, contagem);
    }

    //Remove uma palavra da contagem, se estiver presente.
    public void removerPalavra(String palavra) {
        palavrasMap.remove(palavra);
    }

    //Exibe todas as palavras e suas respectivas contagens.
    public void exibirContagemPalavras() {
        System.out.println(palavrasMap);
    }

    //Encontra a palavra mais frequente no texto e retorna a palavra e sua contagem.
    public String encontrarPalavraMaisFrequente() {
        String palavraMaisFrequente = null;
        int maiorContagem = 0;
        for (Map.Entry<String, Integer> palavra : palavrasMap.entrySet()) {
            if (palavraMaisFrequente == null || palavra.getValue() > maiorContagem) {
                palavraMaisFrequente = palavra.getKey();
                maiorContagem = palavra.getValue();
            }
        }
        return palavraMaisFrequente;
    }

}
