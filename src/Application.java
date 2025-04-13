import estructures.queue.Queue;
import utils.InputFileReader;

import java.util.Random;


public class Application {
    public static void main(String[] args) {
        
        // Tudo isso abaixo é só teste
        //InputFileReader.printInputFile();
        
        // Graph g = new Graph(5);
        // g.addEdge(0, 1);
        // g.addEdge(0, 2);
        // g.addEdge(2, 2);
        // g.addEdge(4, 3);

        // g.viewGraph();
        Queue<Integer> queue = new Queue<>();

        Random r = new Random();
        for(int i = 0; i < 10; i++){
            queue.add(r.nextInt(20));
        }

        queue.printQueue();
        
        System.out.println(queue.pop());

        queue.printQueue();

        InputFileReader.printInputFile();
        InputFileReader.readSampleFile("src/resource/sample.txt");
    }
}
