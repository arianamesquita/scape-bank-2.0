package testesPedro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.LogRecord;

public class repasse {
    static String caminho1 = "C:\\Users\\pedro\\Downloads\\CEP-dados-2018-UTF8\\ceps.txt";
    String caminho2 = "C:\\Users\\pedro\\Downloads\\CEP-dados-2018-UTF8\\cepsatualizado.txt";
  
  
    public static void ler(String url){
    BufferedReader reader;
    try {
        reader = new BufferedReader(new FileReader(url));
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
} 
public static void main(String[] args) {
    
    ler(caminho1);
}
}

