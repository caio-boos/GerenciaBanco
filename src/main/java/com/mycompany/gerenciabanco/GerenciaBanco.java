/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.gerenciabanco;

import java.util.Scanner;

/**
 *
 * @author Caio Eduardo Avelino Alves Da Silva
 */
public class GerenciaBanco {

    public static void main(String[] args) {
        
        int escolha;
        
        Scanner scanner = new Scanner(System.in);
        
        ContaBanco contaBanco = new ContaBanco();
        
        contaBanco.pegaInformacoes();
        
        do{
            mostraMenu();
            
            escolha = scanner.nextInt();
            
            switch (escolha) {
                case 1: 
                    contaBanco.mostraSaldo();
                    break;                
                case 2: 
                    contaBanco.deposito();
                    break;                
                case 3: 
                    contaBanco.saque();
                    break;                
                case 4: 
                    contaBanco.dadosConta();
                    break;                
                default:
                    System.out.print("Opção inválida. Tente novamente!"); 
                    break; 
                    
            }
        } while(escolha != 0);
        
        System.out.println("Até mais !");
    }
    
    private static void mostraMenu(){
        System.out.println("\n+========|OPÇÕES|=========+");
        System.out.println("| 1 = Consultar Saldo        |");
        System.out.println("| 2 = Realizar depósito      |");
        System.out.println("| 3 = Realizar saque         |");
        System.out.println("| 4 = Informações da conta   |");
        System.out.println("| 0 = Encerrar               |");
        System.out.println("+===========|****|==========+");
        
    }
        
}

class ContaBanco {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo = 0.00;   
        
    public void pegaInformacoes(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite seu nome:");
        nome =  scanner.nextLine();
        
        System.out.println("Agora seu sobrenome:");
        sobrenome =  scanner.nextLine();
        
        System.out.println("Por fim seu CPF:");
        cpf =  scanner.nextLine();
    }
    
    public void deposito(){
        double valor_deposito;
        
        Scanner scanner = new Scanner(System.in);  
        
        System.out.println("Qual Valor do deposito?: ");
        
        valor_deposito = scanner.nextDouble();
        
        if(valor_deposito <= 0.00){
            System.out.println("Valor inválido , não pode ser negativo ou zero.");            
        }else{
            saldo += valor_deposito;
        }        
    }
    
    public void saque(){
        double valor_saque;
        
        Scanner scanner = new Scanner(System.in);  
        
        System.out.println("Quanto vai sacar?: ");
        
        valor_saque = scanner.nextDouble();
        
        if(valor_saque <= 0.00){
            System.out.println("Valor inválido , não pode ser negativo ou zero.");
        }
        
        if(saldo - valor_saque < 0){            
            System.out.println("Valor maior que saldo da conta.");   
        }else{
            saldo -= valor_saque;
        }        
        
    }
    
    public void mostraSaldo(){
        System.out.printf("Saldo atual é de: R$ %.2f \n",saldo);         
    }
    
    public void dadosConta(){
        System.out.println("Digite seu nome :"+nome);
        System.out.println("Agora seu Sobrenome:"+sobrenome);
        System.out.println("Por fim CPF:"+cpf);
    }
}