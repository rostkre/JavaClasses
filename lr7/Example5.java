package lr7;

import java.io.File;
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла (расположенного в папке src/lr7/): ");
        String fileName = scanner.nextLine().trim();

        // Путь к файлу в папке src/lr7/
        String filePath = "src/lr7/" + fileName;
        File file = new File(filePath);

        if (file.exists() && file.isFile()) {
            long sizeInBytes = file.length();
            System.out.println("Размер файла \"" + file.getName() + "\": " + sizeInBytes + " байт");
        } else if (!file.exists()) {
            System.out.println("Файл не найден в папке src/lr7/: " + fileName);
        } else {
            System.out.println("Указанный путь не является файлом: " + filePath);
        }

        scanner.close();
    }
}
