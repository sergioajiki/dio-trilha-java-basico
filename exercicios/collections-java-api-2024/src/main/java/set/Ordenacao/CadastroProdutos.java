package main.java.set.Ordenacao;

import com.sun.source.tree.SwitchExpressionTree;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    //Adiciona um produto ao cadastro.
    public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        produtoSet.add(new Produto(cod, nome, preco, quantidade));
    }

    //Exibe todos os produtos do cadastro em ordem alfabética pelo nome.
    public Set<Produto> exibirProdutosPorNome() {
        //HashSet não deixa organizado, por isso usar TreeSet
        Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);
        return produtosPorNome;
    }

    //Exibe todos os produtos do cadastro em ordem crescente de preço.
    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtoPorPreco = new TreeSet<>(new Produto.ComparatorPorPreco());
        produtoSet.addAll(produtoSet);
        return produtoPorPreco;
    }
}
