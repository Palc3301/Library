package org.example.util;

import org.example.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class ArvoreBinariaLivros {
    private No raiz;

    public ArvoreBinariaLivros() {
        this.raiz = null;
    }

    public void inserir(Livro livro) {
        this.raiz = inserirRecursivo(this.raiz, livro);
    }

    private No inserirRecursivo(No raiz, Livro livro) {
        if (raiz == null) {
            raiz = new No(livro);
            return raiz;
        }

        if (livro.getAutor().compareTo(raiz.livro.getAutor()) < 0) {
            raiz.esquerda = inserirRecursivo(raiz.esquerda, livro);
        } else if (livro.getAutor().compareTo(raiz.livro.getAutor()) > 0) {
            raiz.direita = inserirRecursivo(raiz.direita, livro);
        }
        return raiz;
    }

    public List<Livro> buscarLivrosPorAutor(String autor) {
        List<Livro> encontrados = new ArrayList<>();
        buscarLivrosRecursivo(this.raiz, autor, encontrados);
        return encontrados;
    }

    private void buscarLivrosRecursivo(No raiz, String autor, List<Livro> encontrados) {
        if (raiz != null) {
            buscarLivrosRecursivo(raiz.esquerda, autor, encontrados);
            if (raiz.livro.getAutor().equalsIgnoreCase(autor)) {
                encontrados.add(raiz.livro);
            }
            buscarLivrosRecursivo(raiz.direita, autor, encontrados);
        }
    }

    public void exibirLivrosEmOrdem() {
        exibirEmOrdemRecursivo(this.raiz);
    }

    private void exibirEmOrdemRecursivo(No raiz) {
        if (raiz != null) {
            exibirEmOrdemRecursivo(raiz.esquerda);
            System.out.println("Livro: " + raiz.livro.getTitulo() + " - Autor: " + raiz.livro.getAutor());
            exibirEmOrdemRecursivo(raiz.direita);
        }
    }

    private static class No {
        Livro livro;
        No esquerda, direita;

        public No(Livro livro) {
            this.livro = livro;
            this.esquerda = null;
            this.direita = null;
        }
    }
}
