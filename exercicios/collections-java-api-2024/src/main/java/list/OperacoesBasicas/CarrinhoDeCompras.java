package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    //Adiciona um item ao carrinho com o nome, preço e quantidade especificados.
    public void adicionarItem(String nome, double preco, int quantidade){
        Item item = new Item(nome, preco, quantidade);
        this.itemList.add(item);
    }

    //Remove um item do carrinho com base no seu nome.
    public void removerItem(String nome) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getNome().equals(nome)) {
                itemList.remove(i);
                break;
            }
        }
    }

    //Calcula e retorna o valor total do carrinho, levando em consideração o preço e a quantidade de cada item.
    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Item item : itemList) {
            valorTotal += item.getPreco() * item.getQuantidade();
        }
        return valorTotal;
    }

    // Exibe todos os itens presentes no carrinho, mostrando seus nomes, preços e quantidades.
    public void exibirItens() {
        for (Item item : itemList) {
            System.out.println("Nome: " + item.getNome()
            + ", Preço: " + item.getPreco()
            + ", Quantidade: " + item.getQuantidade());
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adicionarItem("Banana", 1.50, 3);
        carrinho.adicionarItem("Maçã", 2.00, 2);
        carrinho.exibirItens();
        System.out.println("Valor Total: " + carrinho.calcularValorTotal());
        carrinho.removerItem("Banana");
        carrinho.exibirItens();
        System.out.println("Valor Total: " + carrinho.calcularValorTotal());
    }

}
