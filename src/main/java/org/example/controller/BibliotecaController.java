package org.example.controller;

import org.example.service.BibliotecaService;
import org.example.model.Livro;
import org.example.enums.CriterioOrdenacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaController {
    private BibliotecaService biblioteca;

    public BibliotecaController(int capacidade) {
        this.biblioteca = new BibliotecaService(capacidade);
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Ordenar por Título");
            System.out.println("4. Ordenar por Autor");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = -1;


            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Digite o ano de publicação: ");
                    int ano = -1;


                    try {
                        ano = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, insira um ano válido.");
                        scanner.nextLine();
                        continue;
                    }

                    Livro livro = new Livro(titulo, autor, ano);
                    biblioteca.adicionarLivro(livro);
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 3:
                    biblioteca.ordenar(CriterioOrdenacao.TITULO);
                    System.out.println("Livros ordenados por título.");
                    break;
                case 4:
                    biblioteca.ordenar(CriterioOrdenacao.AUTOR);
                    System.out.println("Livros ordenados por autor.");
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
