import estruturas.grafo.Grafo;
import utils.GrafoConstrutor;

public class Main {
    public static void main(String[] args) {

        String caminhoArquivo = "src/recursos/amostra.txt";
        GrafoConstrutor grafoConstrutor = new GrafoConstrutor();

        grafoConstrutor.lerArquivo(caminhoArquivo);

        System.out.println(grafoConstrutor.obterVertices());

        Grafo g = new Grafo(grafoConstrutor);

        g.mostrarGrafo();
        g.verticeGrau("Z");

    }
}
