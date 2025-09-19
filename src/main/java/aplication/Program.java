package aplication;

import entities.ContaCorrente;
import views.Menu;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);



        ContaCorrente conta = new ContaCorrente("Lisa", 200, 1000, true);

        int opcao;
        double valor;

        do {
            opcao = Menu.escolherOpcao();

            switch (opcao) {
                case 1:
                    System.out.println(conta.consultar());
                    break;
                case 2:
                    System.out.print("Valor do deposito: ");
                    valor = sc.nextInt();
                    conta.depositar(valor);
                    break;

                case 3:
                    System.out.print("Valor do saque: ");
                    valor = sc.nextInt();
                    conta.sacar(valor);
                    break;

                case 4:
                    if (conta.verificarUsoEspecial()) {
                        System.out.println("Usou o cheque especial");
                    } else {
                        System.out.println("Nao usou o cheque especial");
                    }
                    break;

                case 5:
                    System.out.println("Operacao finalizada, obrigado por usar o nosso banco");

            }
        } while(opcao != 5);

        System.out.println("----------------------------------------------------------------------------");

        sc.close();
    }
}
