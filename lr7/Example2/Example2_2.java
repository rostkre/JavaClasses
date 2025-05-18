package lr7.Example2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Example2_2 {
    public static void main(String[] args) {
        String fileName = "src/lr7/Example2/example_file.txt";

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
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            byte[] dataBytes = sb.toString().getBytes("UTF-8");
            outputStream.write(dataBytes);
            System.out.println("Данные записаны в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            return;
        }

        // Чтение данных из файла
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            StringBuilder readSb = new StringBuilder();
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                readSb.append(new String(buffer, 0, bytesRead, "UTF-8"));
            }
            System.out.println("Прочитанные данные:\n" + readSb);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        // Удаление файла
        File f = new File(fileName);
        if (f.delete()) {
            System.out.println("Файл удален: " + fileName);
        } else {
            System.out.println("Не удалось удалить файл: " + fileName);
        }
    }
}
