package utils;
import java.io.*;
import java.util.*;

public class GraphConstructor {

    private boolean isDirected;
    private final Set<String> vertices = new HashSet<>();
    private final List<String[]> edges = new ArrayList<>();
    private Map<String,Integer> vertexIndex = new HashMap<>();

    public void readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                if(line.trim().equalsIgnoreCase("D")) isDirected = true;
                if (!line.contains(",")) continue;

                String[] fields = line.split(",");
                String firstVertex = fields[0];
                String secondVertex = fields[1];

                edges.add(new String[]{firstVertex, secondVertex});

                vertices.add(firstVertex);
                vertices.add(secondVertex);

            }
            int index = 0;
            for(String vertex: vertices){
                vertexIndex.put(vertex,index++);
            }
        } catch (IOException e) {
            System.out.println("ERROR while trying to read the file: \n" + e.getMessage());
        }
    }

    public boolean getIsDirected() {
        return isDirected;
    }

    public Set<String> getVertices() {
        return vertices;
    }

    public List<String[]> getEdges(){
        return edges;
    }

    public Map<String, Integer> getVertexIndex() {
        return vertexIndex;
    }
}
