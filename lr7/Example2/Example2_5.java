package lr7.Example2;

import java.io.*;
import java.util.Scanner;

public class Example2_5 {
    public static void main(String[] args) {
        String inputFileName  = "src/lr7/Example2/input.txt";
        String outputFileName = "src/lr7/Example2/output.txt";

        // 1) Читаем данные из консоли и записываем в input.txt
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
            System.out.println("Данные записаны в файл: " + inputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при инициализации input.txt: " + e.getMessage());
            return;
        }

        // 2) Чтение из input.txt, конвертация в верхний регистр и запись в output.txt
        try (
                // Байтовый входной поток из файла
                InputStream       inputStream       = new FileInputStream(inputFileName);
                // Адаптер для преобразования байтов в символы (UTF-8)
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                // Буферизированный символный входной поток
                BufferedReader    bufferedReader    = new BufferedReader(inputStreamReader);

                // Байтовый выходной поток в файл
                OutputStream       outputStream       = new FileOutputStream(outputFileName);
                // Адаптер для преобразования символов в байты (UTF-8)
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                // Буферизированный символный выходной поток
                BufferedWriter     bufferedWriter     = new BufferedWriter(outputStreamWriter)
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line.toUpperCase());
                bufferedWriter.newLine();
            }
            System.out.println("Преобразованные данные записаны в файл: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}
