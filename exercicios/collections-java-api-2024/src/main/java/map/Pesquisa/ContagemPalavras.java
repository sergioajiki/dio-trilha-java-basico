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

    // Adiciona palavras de um texto à contagem.
    public void adicionarPalavrasDoTexto(String texto) {
        // separa as palavras por espaços e pontuações
        String[] palavras = texto.split("\\W+");
        for (String palavra : palavras) {
            // converte a palavra para minúsculas
            palavra = palavra.toLowerCase();
            palavrasMap.put(palavra, palavrasMap.getOrDefault(palavra, 0) + 1);
        }
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        ContagemPalavras contagem = new ContagemPalavras();
        String texto = "HashMap é uma implementação da interface Map que não mantém uma ordem específica dos elementos. Ele armazena os elementos internamente usando uma função de hash para melhorar a eficiência das operações de pesquisa e acesso. O HashMap também permite chaves ou valores nulos.";
        contagem.adicionarPalavrasDoTexto(texto);

        System.out.println("Contagem de palavras:");
        contagem.exibirContagemPalavras();

        System.out.println("\nPalavra mais frequente:");
        System.out.println(contagem.encontrarPalavraMaisFrequente());
    }
}
