package lr7.Example2;

import java.io.*;
import java.util.Scanner;

public class Example2_4 {
    public static void main(String[] args) {
        String fileName = "example_file.txt";

        // Чтение данных из консоли
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите текст для записи в файл (пустая строка — завершить):");
            String line;
            while (true) {
                line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                sb.append(line).append(System.lineSeparator());
            }
        }

        // Запись данных в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(sb.toString());
            System.out.println("Данные записаны в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            return;
        }

        // Чтение данных из файла
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            char[] buffer = new char[1024];
            int charsRead = reader.read(buffer);
            String readData = new String(buffer, 0, charsRead);
            System.out.println("Прочитанные данные:\n" + readData);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        // Удаление файла (опционально)
        File f = new File(fileName);
        if (f.delete()) {
            System.out.println("Файл удален: " + fileName);
        } else {
            System.out.println("Не удалось удалить файл: " + fileName);
        }
    }
}
