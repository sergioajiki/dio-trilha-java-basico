package org.example;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Por favor, digite o número da conta");
        Integer numero = scanner.nextInt();

        System.out.println("Por favor, digite o número da agência");
        String agencia = scanner.next();

        System.out.println("Digite o nome do Cliente");
        String nomeCliente = scanner.next();

        System.out.println("Digite o valor do depósito inicial");
        Double saldo = scanner.nextDouble();

        System.out.println("Olá "
                + nomeCliente
                + ", obrigado por criar uma conta em nosso banco,"
                + " sua agência é "
                + agencia
                + ", conta "
                + numero
                + " e seu saldo "
                + saldo
                + " já está disponível para saque"
        );
    }
}