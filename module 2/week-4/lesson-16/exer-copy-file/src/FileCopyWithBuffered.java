import java.io.*;
import java.util.Scanner;

public class FileCopyWithBuffered {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập đường dẫn tệp nguồn: ");
        String sourcePath = scanner.nextLine();

        System.out.print("Nhập đường dẫn tệp đích: ");
        String targetPath = scanner.nextLine();

        File sourceFile = new File("src/source-file.txt");
        File targetFile = new File("src/target-file.txt");

        if (!sourceFile.exists()) {
            System.out.println("Lỗi: Tệp nguồn không tồn tại!");
            return;
        }

        if (targetFile.exists()) {
            System.out.println("Cảnh báo: Tệp đích đã tồn tại. Ghi đè? (y/n)");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("y")) {
                System.out.println("Hủy thao tác sao chép.");
                return;
            }
        }

        int charCount = copyFile(sourceFile, targetFile);
        if (charCount != -1) {
            System.out.println("Sao chép thành công! Số ký tự trong tệp: " + charCount);
        } else {
            System.out.println("Có lỗi xảy ra khi sao chép.");
        }
    }

    public static int copyFile(File source, File target) {
        int charCount = 0;

        try (
                BufferedReader reader = new BufferedReader(new FileReader(source));
                BufferedWriter writer = new BufferedWriter(new FileWriter(target))
        ) {
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
                charCount++;
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi sao chép: " + e.getMessage());
            return -1;
        }

        return charCount;
    }
}
