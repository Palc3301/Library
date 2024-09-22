package org.example.service;

import org.example.enums.CriterioOrdenacao;
import org.example.model.Livro;
import org.example.util.AlgoritmoOrdenacao;

public class BibliotecaService {
    private Livro[] livros;
    private int count;

    public BibliotecaService(int capacidade) {
        livros = new Livro[capacidade];
        count = 0;
    }

    public void adicionarLivro(Livro livro) {
        if (count < livros.length) {
            livros[count++] = livro;
        } else {
            System.out.println("Biblioteca cheia. Não é possível adicionar mais livros.");
        }
    }

    public void listarLivros() {
        for (int i = 0; i < count; i++) {
            System.out.println(livros[i]);
        }
    }

    public void ordenar(CriterioOrdenacao criterio) {
        AlgoritmoOrdenacao.ordenar(livros, count, criterio);
    }
}
