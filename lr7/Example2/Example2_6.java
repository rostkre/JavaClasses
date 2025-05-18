package lr7.Example2;

import java.io.*;
import java.util.Scanner;

public class Example2_6 {
    public static void main(String[] args) {
        String inputFileName  = "src/lr7/Example2/input.txt";
        String outputFileName = "src/lr7/Example2/output.txt";

        // 1) Чтение данных из консоли и запись в input.txt
        System.out.println("Введите текст для записи в input.txt (пустая строка — завершить):");
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(System.in)) {
            String line;
            while (true) {
                line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                sb.append(line).append(System.lineSeparator());
            }
        }

        try (BufferedWriter initWriter = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(inputFileName), "UTF-8"
        ))) {
            initWriter.write(sb.toString());
            System.out.println("Исходные данные записаны в файл: " + inputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при инициализации input.txt: " + e.getMessage());
            return;
        }

        // 2) Чтение из input.txt, конвертация в верхний регистр и запись в output.txt
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName));
                PrintWriter    printWriter    = new PrintWriter(outputFileName, "UTF-8")
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                printWriter.println(line.toUpperCase());
            }
            System.out.println("Преобразованные данные записаны в файл: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}
