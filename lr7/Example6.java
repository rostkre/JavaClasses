package lr7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос имени файла
        System.out.print("Введите имя файла (из папки src/lr7/): ");
        String fileName = scanner.nextLine().trim();
        String filePath = "src/lr7/" + fileName;
        File file = new File(filePath);

        if (!file.exists() || !file.isFile()) {
            System.out.println("Файл не найден: " + filePath);
            scanner.close();
            return;
        }

        // Запрос слова для поиска
        System.out.print("Введите слово для поиска: ");
        String searchWord = scanner.nextLine();
        scanner.close();

        System.out.println("Строки, содержащие слово \"" + searchWord + "\":");

        // Чтение файла и поиск строк
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 1;
            boolean foundAny = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains(searchWord)) {
                    System.out.printf("%d: %s%n", lineNumber, line);
                    foundAny = true;
                }
                lineNumber++;
            }
            if (!foundAny) {
                System.out.println("Совпадений не найдено.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
