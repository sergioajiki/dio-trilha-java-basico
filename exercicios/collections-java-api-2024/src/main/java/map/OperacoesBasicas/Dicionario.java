package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    //Adiciona uma palavra e sua definição ao dicionário, associando a palavra à sua definição correspondente.
    public void adicionarPalavra(String palavra, String definicao) {
        dicionarioMap.put(palavra, definicao);
    }

    //Remove uma palavra do dicionário, dado o termo a ser removido.
    public void removerPalavra(String palavra) {
        if (!dicionarioMap.isEmpty()) {
            dicionarioMap.remove(palavra);
        }
    }

    //Exibe todas as palavras e suas definições do dicionário, mostrando cada palavra seguida de sua respectiva definição.
    public void exibirPalavras() {
        System.out.println(dicionarioMap);
    }

    //Pesquisa uma palavra no dicionário e retorna sua definição correspondente.
    public String pesquisarPorPalavra(String palavra) {
        String definicaoPorPalavra = null;
        if (!dicionarioMap.isEmpty()) {
            definicaoPorPalavra = dicionarioMap.get(palavra);
        }
        return definicaoPorPalavra;
    }
    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("casa", "Construção destinada a servir de moradia.");
        dicionario.adicionarPalavra("carro", "Veículo automotor com quatro rodas usado para transporte.");
        dicionario.adicionarPalavra("java", "Linguagem de programação orientada a objetos.");

        System.out.println("Exibindo todas as palavras do dicionário:");
        dicionario.exibirPalavras();

        System.out.println("\nDefinição da palavra 'carro': " + dicionario.pesquisarPorPalavra("carro"));

        dicionario.removerPalavra("casa");
        System.out.println("\nDicionário após remover a palavra 'casa':");
        dicionario.exibirPalavras();
    }
}
