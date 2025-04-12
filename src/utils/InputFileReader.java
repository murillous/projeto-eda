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
}
