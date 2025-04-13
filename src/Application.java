import estructures.graph.Graph;
import estructures.queue.Queue;
import utils.InputFileReader;

import java.util.Random;


public class Application {
    public static void main(String[] args) {
        
        //InputFileReader.printInputFile();
        InputFileReader.readSampleFile("src/resource/sample.txt");

         Graph g = new Graph(5);
         g.addEdge(0, 1);
         g.addEdge(0, 2);
         g.addEdge(2, 2);
         g.addEdge(4, 3);

         g.viewGraph();
    }
}
