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
        produtoPorPreco.addAll(produtoSet);
        return produtoPorPreco;
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto(1L, "Produto1", 150d, 50);
        cadastroProdutos.adicionarProduto(2L, "Produto2", 20d, 10);
        cadastroProdutos.adicionarProduto(3L, "Produto3", 100d, 12);
        cadastroProdutos.adicionarProduto(3L, "Produto6", 50d, 14);
        cadastroProdutos.adicionarProduto(4L, "Produto4", 33d, 33);

        System.out.println(cadastroProdutos.produtoSet);

        System.out.println("Produtor por nome: " + cadastroProdutos.exibirProdutosPorNome());

        System.out.println("Produtos por preço: " + cadastroProdutos.exibirProdutosPorPreco());
    }
}
