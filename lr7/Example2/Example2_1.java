package lr7.Example2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Example2_1 {
    public static void main(String[] args) {
        // Создание папки
        File folder = new File("src/lr7/Example2/example_folder");
        if (!folder.exists()) {
            if (folder.mkdir()) {
                System.out.println("Папка создана: " + folder.getAbsolutePath());
            } else {
                System.out.println("Не удалось создать папку: " + folder.getAbsolutePath());
                return;
            }
        } else {
            System.out.println("Папка уже существует: " + folder.getAbsolutePath());
        }

        // Создание файла внутри папки
        File file = new File(folder, "example_file.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан: " + file.getAbsolutePath());
            } else {
                System.out.println("Файл уже существует: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
            return;
        }

        // Чтение текста из консоли и запись в файл
        try (Scanner scanner = new Scanner(System.in);
             FileWriter writer = new FileWriter(file)) {

            System.out.println("Введите текст для записи в файл (пустая строка — завершить):");
            String line;
            while (true) {
                line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                writer.write(line);
                writer.write(System.lineSeparator());
            }
            System.out.println("Текст успешно записан в файл.");

        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        // Удаление файла и папки (необязательно, можете закомментировать)
        if (file.delete()) {
            System.out.println("Файл удален: " + file.getAbsolutePath());
        } else {
            System.out.println("Не удалось удалить файл: " + file.getAbsolutePath());
        }

        if (folder.delete()) {
            System.out.println("Папка удалена: " + folder.getAbsolutePath());
        } else {
            System.out.println("Не удалось удалить папку: " + folder.getAbsolutePath());
        }
    }
}
