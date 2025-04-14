package utils;
import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileReader {

    private boolean isDirected;
    private Set<String> vertices;

    public FileReader(){
        vertices = new HashSet<>();
    }

    public static void readSampleFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(filePath))) {
            String line;

            while((line = bufferedReader.readLine()) != null){
                // Will just skip invalid lines
                if (!line.contains(",")) continue;

                String[] fields = line.split(",");
                String firstVertex = fields[0];
                String secondVertex = fields[1];

                System.out.println(firstVertex + "\t" + secondVertex + "\t");

            }
        } catch (IOException e) {
            System.out.println("ERROR while trying to read the file: \n" + e.getMessage());
        }
    }
}
