import estruturas.grafo.Grafo;
import utils.GrafoConstrutor;
import utils.Menu;

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
