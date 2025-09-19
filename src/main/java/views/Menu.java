package views;

import java.util.Scanner;

public class Menu {
    public  static  int escolherOpcao(){

        Scanner sc = new Scanner(System.in);

        int codigo;

        System.out.println("----------------------------------------------------------------------------");


        do {
            System.out.println("O que deseja fazer ?");
            System.out.println("Digite um codigo para o que deseja:");
            System.out.println("1 para consultar saldo. ");
            System.out.println("2 para realizar deposito. ");
            System.out.println("3 para realizar saque.");
            System.out.println("4 para consultar o uso do cheque especial.");
            System.out.println("5 para sair.");

            codigo = sc.nextInt();

            System.out.println("----------------------------------------------------------------------------");

            if(codigo < 1 || codigo > 5){
                System.out.println("---------------------------------------------");
                System.out.println("Codigo errado, digite novamente");
                System.out.println("---------------------------------------------");
            }

        } while (codigo < 1 || codigo > 5);

        return codigo;
    }
}
