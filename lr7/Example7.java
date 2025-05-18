package lr7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Example7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос имени файла
        System.out.print("Введите имя файла (из папки src/lr7/): ");
        String fileName = scanner.nextLine().trim();
        String filePath = "src/lr7/" + fileName;

        // Запрос текста для записи
        System.out.println("Введите текст для записи в файл (пустая строка — завершить ввод):");
        StringBuilder sb = new StringBuilder();
        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            sb.append(line).append(System.lineSeparator());
        }
        scanner.close();

        String content = sb.toString();
        int charCount = content.length();

        // Запись текста в файл
        File file = new File(filePath);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
            System.out.println("Текст записан в файл: " + filePath);
            System.out.println("Количество записанных символов: " + charCount);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
