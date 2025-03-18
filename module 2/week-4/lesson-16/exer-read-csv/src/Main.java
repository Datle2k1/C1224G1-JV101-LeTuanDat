import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
//    public static void main(String[] args) {
//        try(BufferedReader bf = new BufferedReader(new FileReader("src/country.csv"))) {
//            String data;
//            while ((data = bf.readLine()) != null) {
//                System.out.println(data);
//            }
//        } catch (IOException ex) {
//            System.err.println(ex.getMessage());
//        }
//    }

    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("src/CodeGym.txt");

        byte[] bytes = new byte[10];
        int i = -1;

        while ((i = in.read(bytes)) != -1) {
            String s = new String(bytes, 0, i);
            System.out.println(s);
        }
        in.close();
    }
}