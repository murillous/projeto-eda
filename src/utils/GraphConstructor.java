package utils;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphConstructor {

    private boolean isDirected;
    private final Set<String> vertices = new HashSet<>();
    private final List<String[]> edges = new ArrayList<>();

    public void readFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if(line.trim().equalsIgnoreCase("D")) isDirected = true;
                if (!line.contains(",")) continue;

                String[] fields = line.split(",");
                String firstVertex = fields[0];
                String secondVertex = fields[1];

                edges.add(new String[]{firstVertex, secondVertex});

                vertices.add(firstVertex);
                vertices.add(secondVertex);

                //System.out.println(firstVertex + "\t" + secondVertex);
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
}
