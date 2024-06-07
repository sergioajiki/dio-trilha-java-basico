package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    //Adiciona um produto ao estoque, juntamente com a quantidade disponível e o preço.
    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        estoqueProdutosMap.put(cod, new Produto(nome, quantidade, preco));
    }

    //Exibe todos os produtos, suas quantidades em estoque e preços.
    public void exibirProdutos() {
        System.out.println(estoqueProdutosMap);
    }

    //Calcula e retorna o valor total do estoque, considerando a quantidade e o preço de cada produto.
    public double calcularValorTotalEstoque() {
        double valorTotalEstoque = 0;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
                valorTotalEstoque += p.getQuantidade() * p.getQuantidade();
            }
        }
        return valorTotalEstoque;
    }

    //Retorna o produto mais caro do estoque, ou seja, aquele com o maior preço.
    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
                if (p.getPreco() > maiorPreco) {
                    produtoMaisCaro = p;
                    maiorPreco = p.getPreco();
                }
            }
        }
        return produtoMaisCaro;
    }

    //Retorna o produto mais barato do estoque, ou seja, aquele com o menor preço.
    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
                if (p.getPreco() < menorPreco) {
                    produtoMaisBarato = p;
                    menorPreco = p.getPreco();
                }
            }
        }
        return produtoMaisBarato;
    }

    //Retorna o produto de maior valor, considerando a quantidade no estoque e o preço(quantidade * preço).
    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto produtoMaiorValorEstoque = null;
        double maiorValor = 0;
        for(Produto produto : estoqueProdutosMap.values()){
            double valorProdutoEstoque = produto.getQuantidade() * produto.getPreco();
            if(produtoMaiorValorEstoque == null || valorProdutoEstoque > maiorValor) {
                produtoMaiorValorEstoque = produto;
                maiorValor = valorProdutoEstoque;
            }
        }
        return produtoMaiorValorEstoque;
    }
}
