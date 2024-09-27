package org.example.structures;

import org.example.model.Livro;

public class No {
    Livro livro;
    No esquerda, direita;

    public No(Livro livro) {
        this.livro = livro;
        this.esquerda = null;
        this.direita = null;
    }
}



