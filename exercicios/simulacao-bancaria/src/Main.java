import java.util.Scanner;

public class SimulacaoBancaria {
    private double saldo;

    public SimulacaoBancaria() {
        saldo = 0.0;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Saldo atual: " + saldo);
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saldo atual: " + valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: " + saldo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimulacaoBancaria conta= new SimulacaoBancaria();

        //  System.out.println("Menu");
        //  System.out.println("1 - Depositar");
        //  System.out.println("2 - Sacar");
        //  System.out.println("3 - Consultar Saldo");
        //  System.out.println("0 - Encerrar");
        // Loop infinito para manter o programa em execução até que o usuário decida sair
        int opcao = 4;
        while (opcao != 0) {
            //  System.out.println("Selecione uma opção: ");
            opcao = scanner.nextInt();
            // TODO: Implemente as condições necessárias para avaliaa a opção escolhida:
            // Dica: Utilze o switch/case para o programa realizar as operações escolhidas pelo usuário.
            switch (opcao) {
                case 1:
                    //  System.out.print("Digite o valor a depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    //  System.out.print("Digite o valor a sacar: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    conta.consultarSaldo();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                // Exibe mensagem de opção inválida se o usuário escolher uma opção inválida:
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }