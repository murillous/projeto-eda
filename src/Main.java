import estruturas.grafo.Grafo;
import utils.GrafoConstrutor;
import utils.Menu;

public class Main {
    public static void main(String[] args) {

        String caminhoArquivo = "src/recursos/entrada.txt";
        GrafoConstrutor grafoConstrutor = new GrafoConstrutor();

        grafoConstrutor.lerArquivo(caminhoArquivo);

        Grafo grafo = new Grafo(grafoConstrutor);

        Menu menu = new Menu(grafo);
        menu.mostrar_menu();
    }
}
