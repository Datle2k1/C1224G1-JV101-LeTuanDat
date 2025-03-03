import java.io.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader bf = new BufferedReader(new FileReader("src/country.csv"))) {
            String data;
            while ((data = bf.readLine()) != null) {
                System.out.println(data);
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}