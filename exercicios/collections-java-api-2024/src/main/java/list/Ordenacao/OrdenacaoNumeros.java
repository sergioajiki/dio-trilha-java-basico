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
        List<Integer> numAscendente = new ArrayList<>();
        Collections.sort(numAscendente);
        return numAscendente;
    }

    //Ordena os números da lista em ordem descendente usando um Comparable e a class Collections.
    public List<Integer> ordenarDescendente() {
        List<Integer> numDescendente = new ArrayList<>();
        Collections.sort(numDescendente, Collections.reverseOrder());
        return numDescendente;
    }
}
