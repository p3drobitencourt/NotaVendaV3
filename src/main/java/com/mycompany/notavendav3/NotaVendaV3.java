/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.notavendav3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pedro
 */

public class NotaVendaV3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Arroz", 5.50, 2));
        produtos.add(new Produto("Feijão", 7.80, 1));
        produtos.add(new Produto("Macarrão", 3.40, 3));
        produtos.add(new Produto("Óleo", 9.20, 1));

    
        System.out.println("=== Nota de Venda ===");
        double total = 0;
        for (Produto produto : produtos) {
            double precoProduto = produto.calcularPrecoTotal();
            System.out.printf("%-10s | Qtd: %d | Preço: R$ %.2f%n",
                    produto.getNome(), produto.getQuantidade(), precoProduto);
            total += precoProduto;
        }
        System.out.printf("\nValor total: R$ %.2f%n", total);

        
        System.out.println("\nEscolha a forma de pagamento:");
        System.out.println("1 - Cartão de Crédito (5% de juros)");
        System.out.println("2 - Cartão de Débito (sem juros)");
        System.out.println("3 - Dinheiro/Pix (5% de desconto)");
        System.out.print("Digite a opção: ");
        int opcao = scanner.nextInt();

      
        double valorFinal = total;
        String formaPagamento = "";
        switch (opcao) {
            case 1:
                formaPagamento = "Cartão de Crédito";
                valorFinal += total * 0.05; 
                break;
            case 2:
                formaPagamento = "Cartão de Débito";
                break; 
            case 3:
                formaPagamento = "Dinheiro/Pix";
                valorFinal -= total * 0.05; 
                break;
            default:
                System.out.println("Opção inválida. Pagamento em Cartão de Débito será considerado.");
                formaPagamento = "Cartão de Débito";
        }

        
        System.out.println("\n=== Nota de Venda Final ===");
        System.out.printf("Forma de pagamento: %s%n", formaPagamento);
        System.out.printf("Valor total: R$ %.2f%n", total);
        System.out.printf("Valor a ser pago: R$ %.2f%n", valorFinal);

        scanner.close();
    }
}