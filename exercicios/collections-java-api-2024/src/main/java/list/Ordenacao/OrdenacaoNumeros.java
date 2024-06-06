package main.java.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> numeros;

    public OrdenacaoNumeros() {
        this.numeros = new ArrayList<>();
    }

    //Adiciona um número à lista.
    public void adicionarNumero(int numero) {
        this.numeros.add(numero);
    }

    //Ordena os números da lista em ordem ascendente usando a interface Comparable e a class Collections.
    public List<Integer> ordenarAscendente() {
        List<Integer> numAscendente = new ArrayList<>(numeros);
        Collections.sort(numAscendente);
        return numAscendente;
    }

    //Ordena os números da lista em ordem descendente usando um Comparable e a class Collections.
    public List<Integer> ordenarDescendente() {
        List<Integer> numDescendente = new ArrayList<>(numeros);
        Collections.sort(numDescendente, Collections.reverseOrder());
        return numDescendente;
    }

    @Override
    public String toString() {
        return "Numeros: " + numeros;
    }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();
        ordenacaoNumeros.adicionarNumero(2);
        ordenacaoNumeros.adicionarNumero(5);
        ordenacaoNumeros.adicionarNumero(20);
        ordenacaoNumeros.adicionarNumero(1);
        ordenacaoNumeros.adicionarNumero(7);
        ordenacaoNumeros.adicionarNumero(-7);
        System.out.println(ordenacaoNumeros);
        System.out.println("Números em ordem ascendente: " + ordenacaoNumeros.ordenarAscendente());
        System.out.println("Números em ordem descendente: " + ordenacaoNumeros.ordenarDescendente());
    }
}
