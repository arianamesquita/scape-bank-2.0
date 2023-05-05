package testesPedro;

import java.io.*;
import java.util.logging.LogRecord;

public class repasse {
    static String caminho1 = "C:\\Users\\pedro\\Downloads\\CEP-dados-2018-UTF8\\ceps.txt";
    static String caminho2 = "C:\\Users\\pedro\\Downloads\\CEP-dados-2018-UTF8\\cepsatualizado.txt";
  
  
    public static String ler(String url){
    BufferedReader reader;
    StringBuilder content = new StringBuilder();
    try {
        reader = new BufferedReader(new FileReader(url));
        String line;
        while ((line = reader.readLine()) != null) {
            line="('"+line.replace("\t", "','").replaceFirst("/", "','")+"'),";
            content.append(line);
        }
        reader.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
        String str = String.valueOf(content);
        int lastIndex = str.lastIndexOf(",");
        str = str.substring(0, lastIndex) + str.substring(lastIndex + 1);
    return str;
}
 public static void gravar(String content){
     try {

         BufferedWriter writer = new BufferedWriter(new FileWriter(caminho2, true));
         writer.write(content);
         writer.newLine();
         writer.close();
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
public static void main(String[] args) {

    System.out.println(ler(caminho1));
}
}

