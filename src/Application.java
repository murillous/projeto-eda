import estructures.graph.Graph;
import utils.FileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Application {
    public static void main(String[] args) throws IOException {

        String filepath = "src/resource/sample.txt";
        //InputFileReader.printInputFile();
        FileReader.readSampleFile(filepath);

        List<String> lines = Files.readAllLines(Paths.get(filepath));

        String type = lines.getFirst().trim();
        System.out.println(type);
        System.out.println(type.equalsIgnoreCase(" ND   "));


         Graph g = new Graph(5);
         g.addEdge(0, 1);
         g.addEdge(0, 2);
         g.addEdge(2, 2);
         g.addEdge(4, 3);

         g.viewGraph();
    }
}
