package org.example.controller;

import org.example.model.Livro;
import org.example.service.BibliotecaService;
import org.example.service.RecomendacaoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaController {
    private BibliotecaService biblioteca;
    private RecomendacaoService recomendacaoService;
    private List<Livro> livros;

    public BibliotecaController(int capacidade) {
        this.livros = new ArrayList<>();
        this.biblioteca = new BibliotecaService(capacidade);
        this.recomendacaoService = new RecomendacaoService(livros);
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Recomendação de Livros por Autor");
            System.out.println("4. Recomendação de Livros por Autor ou Tema");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Digite o ano de publicação: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o tema do livro: ");
                    String tema = scanner.nextLine();

                    Livro livro = new Livro(titulo, autor, ano, tema);
                    biblioteca.adicionarLivro(livro);
                    livros.add(livro);
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 3:
                    System.out.print("Digite o autor para recomendações: ");
                    String autorBusca = scanner.nextLine();
                    List<Livro> recomendadosAutor = biblioteca.recomendarLivrosPorAutor(autorBusca);
                    for (Livro l : recomendadosAutor) {
                        System.out.println("Livro: " + l.getTitulo() + " - Autor: " + l.getAutor());
                    }
                    break;
                case 4:
                    System.out.print("Digite o autor ou tema para recomendações: ");
                    String autorOuTema = scanner.nextLine();
                    List<Livro> recomendados = recomendacaoService.recomendarLivros(autorOuTema);
                    System.out.println("Livros recomendados:");
                    for (Livro l : recomendados) {
                        System.out.println(l.getTitulo() + " - " + l.getAutor());
                    }
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
