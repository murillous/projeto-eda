package utils;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class GraphConstructor {

    private static boolean isDirected;
    private static final Set<String> vertices = new HashSet<>();

    public void readFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if(line.trim().equalsIgnoreCase("D")) isDirected = true;
                if (!line.contains(",")) continue;

                String[] fields = line.split(",");
                String firstVertex = fields[0];
                String secondVertex = fields[1];
                vertices.add(firstVertex);
                vertices.add(secondVertex);

                System.out.println(firstVertex + "\t" + secondVertex);
            }
        } catch (IOException e) {
            System.out.println("ERROR while trying to read the file: \n" + e.getMessage());
        }
    }

    public static boolean getIsDirected() {
        return isDirected;
    }

    public static Set<String> getVertices() {
        return vertices;
    }
}
