package utils;

import estruturas.grafo.Grafo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public Grafo grafo;

    public Menu(Grafo grafo) {
        this.grafo = grafo;
    }

    public void mostrar_menu() {
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;

        // variáveis utilitárias
        String vertice1, vertice2, vertice;

        while (true) {
            System.out.println("Escolha uma opção:\n");
            System.out.println("1) - Verificar adjacência entre vértices");
            System.out.println("2) - Calcular grau do vértice");
            System.out.println("3) - Buscar vizinhos do vértice");
            System.out.println("4) - Visitar todas as arestas do grafo");
            System.out.println("5) - Fazer busca em largura");
            System.out.println("6) - Verifcar se é bipartido");
            System.out.println("7) - Exibir matriz de adjacência");
            System.out.println("0) - Sair");

            try {
                System.out.print("\n--> ");
                escolha = scanner.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("A escolha precisa ser um dos números apresentados no menu no formato: n) - opção");
                System.exit(1);
            }

           switch (escolha) {
               case 0:
                   System.exit(0);
                   break;
               case 1:
                   System.out.print("Informe o primeiro vértice: ");
                   vertice1 = scanner.next();

                   System.out.print("Informe o segundo vértice: ");
                   vertice2 = scanner.next();

                   grafo.ehAdjacente(vertice1, vertice2);
                   System.out.println();
                   break;
               case 2:
                   System.out.print("Informe o vértice cujo o grau você deseja calcular: ");
                   vertice = scanner.next();

                   grafo.verticeGrau(vertice);
                   System.out.println();
                   break;
               case 3:
                   System.out.print("Informe o vértice cujo os vizinhos você deseja buscar: ");
                   vertice = scanner.next();

                   grafo.buscarVizinhos(vertice);
                   System.out.println();
                   break;
               case 4:
                   grafo.visitarArestas();
                   System.out.println();
                   break;
               case 5:
                   System.out.print("Informe o vértice inicial: ");
                   vertice = scanner.next();

                   grafo.buscaEmLargura(vertice);
                   System.out.println();
                   break;
               case 6:
                   grafo.grafoDuasCores();
                   System.out.println();
                   break;
               case 7:
                   grafo.mostrarGrafo();
                   System.out.println();
                   break;
               default:
                   System.out.println("\nOpção inválida! Tente novamente.\n");
           }
        }
    }
}
