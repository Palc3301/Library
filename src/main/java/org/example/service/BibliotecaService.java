package org.example.service;

import org.example.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {
    private List<Livro> livros;
    private int capacidade;

    public BibliotecaService(int capacidade) {
        this.livros = new ArrayList<>();
        this.capacidade = capacidade;
    }

    public void adicionarLivro(Livro livro) {
        if (livros.size() < capacidade) {
            livros.add(livro);
            System.out.println("Livro adicionado com sucesso!");
        } else {
            System.out.println("Capacidade máxima atingida. Não é possível adicionar mais livros.");
        }
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro disponível.");
        } else {
            System.out.println("Lista de Livros:");
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    public List<Livro> recomendarLivrosPorAutor(String autor) {
        List<Livro> recomendados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                recomendados.add(livro);
            }
        }
        if (recomendados.isEmpty()) {
            System.out.println("Nenhum livro encontrado para o autor: " + autor);
        }
        return recomendados;
    }
}
