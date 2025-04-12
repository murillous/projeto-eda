import java.io.*;

public class ConfigFileReader {

    public static void printConfigFile(){
        File filepath = new File("src/resource/config.txt");

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
