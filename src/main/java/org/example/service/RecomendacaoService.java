package org.example.service;

import org.example.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class RecomendacaoService {

    private List<Livro> livrosDisponiveis;

    public RecomendacaoService(List<Livro> livros) {
        this.livrosDisponiveis = livros;
    }

    public List<Livro> recomendarLivros(String autorOuTema) {
        List<Livro> recomendacoes = new ArrayList<>();
        List<Livro> caminhoAtual = new ArrayList<>();
        boolean[] visitado = new boolean[livrosDisponiveis.size()];
        backtrack(autorOuTema, recomendacoes, caminhoAtual, visitado, 0);
        return recomendacoes;
    }

    private void backtrack(String autorOuTema, List<Livro> recomendacoes, List<Livro> caminhoAtual, boolean[] visitado, int index) {
        if (index >= livrosDisponiveis.size()) return;

        for (int i = index; i < livrosDisponiveis.size(); i++) {
            Livro livro = livrosDisponiveis.get(i);

            if (!visitado[i] && (livro.getAutor().equalsIgnoreCase(autorOuTema) || livro.getTema().equalsIgnoreCase(autorOuTema))) {
                caminhoAtual.add(livro);
                recomendacoes.addAll(caminhoAtual);
                visitado[i] = true;
                backtrack(autorOuTema, recomendacoes, caminhoAtual, visitado, i + 1);
                visitado[i] = false;
                caminhoAtual.remove(caminhoAtual.size() - 1);  // Backtrack
            }
        }
    }
}
