package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> numeros;

    public SomaNumeros() {
        this.numeros = new ArrayList<>();
    }

    //Adiciona um número à lista de números.
    public void adicionarNumero(int numero) {
        this.numeros.add(numero);
    }

    //Calcula a soma de todos os números na lista e retorna o resultado.
    public int calcularSoma() {
        int somaTotal = 0;
        for (Integer num : numeros)
            somaTotal += num;
        return somaTotal;
    }

    //Encontra o maior número na lista e retorna o valor.
    public int encontrarMaiorNumero() {
        int numMaior = numeros.get(0);
        if (!numeros.isEmpty()) {
            for (Integer num : numeros) {
                if (num > numMaior) {
                    numMaior = num;
                }
            }
        }
        return numMaior;
    }

    //Encontra o menor número na lista e retorna o valor.
    public int encontrarMenorNumero() {
        int numMenor = numeros.get(0);
        if (!numeros.isEmpty()) {
            for (Integer num : numeros) {
                if (num < numMenor) {
                    numMenor = num;
                }
            }
        }
        return numMenor;
    }

    //Retorna uma lista contendo todos os números presentes na lista.
    public void exibirNumeros() {
        System.out.println(this.numeros);
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();
        somaNumeros.adicionarNumero(1);
        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(5);
        somaNumeros.adicionarNumero(3);
        somaNumeros.adicionarNumero(6);
        somaNumeros.adicionarNumero(7);
        somaNumeros.adicionarNumero(-10);
        somaNumeros.exibirNumeros();
        System.out.println("Soma dos números = " + somaNumeros.calcularSoma());
        System.out.println("Maior número = " + somaNumeros.encontrarMaiorNumero());
        System.out.println("Menor número = " + somaNumeros.encontrarMenorNumero());
    }
}
