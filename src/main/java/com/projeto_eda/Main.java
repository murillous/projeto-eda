package com.projeto_eda;

import com.projeto_eda.estruturas.grafo.Grafo;
import com.projeto_eda.utils.GrafoConstrutor;
import com.projeto_eda.utils.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o caminho do arquivo ");
        System.out.printf("%n--> ");
        String caminhoArquivo = scanner.nextLine();
        System.out.println();

        GrafoConstrutor grafoConstrutor = new GrafoConstrutor();

        grafoConstrutor.lerArquivo(caminhoArquivo);

        Grafo grafo = new Grafo(grafoConstrutor);

        Menu menu = new Menu(grafo);
        menu.mostrar_menu();
    }
}
