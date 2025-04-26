import estruturas.grafo.Grafo;
import utils.GrafoConstrutor;

public class Main {
    public static void main(String[] args) {

        String caminhoArquivo = "src/recursos/entrada.txt";
        GrafoConstrutor grafoConstrutor = new GrafoConstrutor();

        grafoConstrutor.lerArquivo(caminhoArquivo);

        Grafo g = new Grafo(grafoConstrutor);

        g.mostrarGrafo();
//        g.buscarVizinhos("A");
//        g.verticeGrau("A");
//        g.ehAdjacente("A","B");
        g.buscaEmLargura("A");
//        g.visitarArestas();
    }
}
