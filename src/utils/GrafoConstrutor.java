package utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GrafoConstrutor {

    private boolean ehDirecionado;
    private final Set<String> vertices = new HashSet<>();
    private final List<String[]> arestas = new ArrayList<>();
    private final Map<String,Integer> verticeParaIndice = new HashMap<>();

    public void lerArquivo(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                if(linha.trim().equalsIgnoreCase("D")) ehDirecionado = true;
                if (!linha.contains(",")) continue;

                String[] campos = linha.split(",");
                String primeiroVertice = campos[0];
                String segundoVertice = campos[1];

                arestas.add(new String[]{primeiroVertice, segundoVertice});

                vertices.add(primeiroVertice);
                vertices.add(segundoVertice);

            }
            int indice = 0;
            for(String vertice: vertices){
                verticeParaIndice.put(vertice,indice++);
            }
        } catch (IOException e) {
            System.out.println("Erro ao tentar ler o arquivo: \n" + e.getMessage());
        }
    }

    public boolean obterEhDirecionado() {
        return ehDirecionado;
    }

    public List<String[]> obterArestas(){
        return arestas;
    }

    public Map<String, Integer> obterVerticeParaIndice() {
        return verticeParaIndice;
    }
}
