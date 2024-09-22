package org.example.util;

import org.example.model.Livro;
import org.example.enums.CriterioOrdenacao;

public class AlgoritmoOrdenacao {
    public static void ordenar(Livro[] livros, int count, CriterioOrdenacao criterio) {
        switch (criterio) {
            case TITULO:
                bubbleSortPorTitulo(livros, count);
                break;
            case AUTOR:
                quickSortPorAutor(livros, 0, count - 1);
                break;
        }
    }

    private static void bubbleSortPorTitulo(Livro[] livros, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (livros[j].getTitulo().compareTo(livros[j + 1].getTitulo()) > 0) {
                    Livro temp = livros[j];
                    livros[j] = livros[j + 1];
                    livros[j + 1] = temp;
                }
            }
        }
    }

    private static void quickSortPorAutor(Livro[] livros, int inicio, int fim) {
        if (inicio < fim) {
            int pIndex = particionar(livros, inicio, fim);
            quickSortPorAutor(livros, inicio, pIndex - 1);
            quickSortPorAutor(livros, pIndex + 1, fim);
        }
    }

    private static int particionar(Livro[] livros, int inicio, int fim) {
        Livro pivot = livros[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (livros[j].getAutor().compareTo(pivot.getAutor()) < 0) {
                i++;
                Livro temp = livros[i];
                livros[i] = livros[j];
                livros[j] = temp;
            }
        }
        Livro temp = livros[i + 1];
        livros[i + 1] = livros[fim];
        livros[fim] = temp;
        return i + 1;
    }
}
