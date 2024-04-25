package com.mycompany.gerenciabanco;

import java.util.Scanner;

/**
 *
 * @author Rudney Junior
 */
public class GerenciaBanco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria();
        
        System.out.println("Bem-VIndo ao banco !");
        System.out.print("Digite seu nome ");
        String nome = scanner.nextLine();
        System.out.print("digite seu sobrenome ");
        String sobrenome = scanner.nextLine();
        System.out.print("Digite seu cpf ");
        String cpf = scanner.nextLine();
        
       conta.setNome(nome);
       conta.setSobrenome(sobrenome);
       conta.setCpf(cpf);
       
       int opcao = 0;
       do{
           System.out.println("Escolha a opção: ");
           System.out.println("1. Consultar saldo ");
           System.out.println("2. Realizar deposito ");
           System.out.println("3. Realizar Saque ");
           System.out.println("4. Encerrar ");
           System.out.print("Opção Escolhida ");
           opcao = scanner.nextInt();
          
           switch(opcao){
               case 1:
                   System.out.println("\nSeu Saldo atual é R$ "+ conta.getSaldo());
                   break;
               case 2:
                   System.out.print("\nDigire o valor do seu deposito: ");
                   double valorDeposito = scanner.nextDouble();
                   conta.depositar(valorDeposito);
                   System.out.println("\nDeposito realizado ");
                   break;

               case 3:
                   System.out.print("\nDigite o valor do saque");
                   double valorSaque = scanner.nextDouble();
                   if(conta.sacar(valorSaque)){
                       System.out.println("\nSaque realizado ");
                   } else{
                       System.out.println("\n Saldo insuficiente ");
                   }
                   break;
               case 4:
                   System.out.println("\n Obrifado por utilizar o banco");
                   break;
               default:
                   System.out.println("\n Opcao invalida, tente de novo");            
           }
       } while(opcao != 4);
    }

    private static String contaGetSaldo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class ContaBancaria {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void depositar(double valor) {
        saldo += valor;
    }
    
    public boolean sacar( double valor) {
        if (valor <= saldo) {
            saldo = valor;
            return true;
        } else {
            return false;
        }
    }
}
