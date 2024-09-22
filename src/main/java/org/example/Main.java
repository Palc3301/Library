package org.example;

import org.example.controller.BibliotecaController;

public class Main {
    public static void main(String[] args) {
        BibliotecaController controller = new BibliotecaController(100);
        controller.iniciar();
    }
}
