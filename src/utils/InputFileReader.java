package utils;
import java.io.*;

public class InputFileReader {

    public static void printInputFile(){
        File filepath = new File("src/resource/input.txt");

            try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
                
                String line;
                while((line = reader.readLine()) != null){
                    System.out.println(line);
                }     
            }
            catch(FileNotFoundException e){
                System.out.println("O arquivo não foi encontrado");
            }
            catch(IOException e){
                System.out.println("Algo deu errado");
            }
        }

    public static void readSampleFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
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
