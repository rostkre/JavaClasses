package lr7.Example1;


import java.io.*;

public class Example1_5 {
    public static void main(String[] args) {
        String inputFileName  = "src/lr7/Example1/input.txt";
        String outputFileName = "src/lr7/Example1/output.txt";

        try (
                // Байтовый входной поток из файла
                InputStream       inputStream       = new FileInputStream(inputFileName);
                // Адаптер для преобразования байтов в символы с указанием кодировки
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                // Буферизированный символный входной поток
                BufferedReader    bufferedReader    = new BufferedReader(inputStreamReader);

                // Байтовый выходной поток в файл
                OutputStream       outputStream       = new FileOutputStream(outputFileName);
                // Адаптер для преобразования символов в байты с указанием кодировки
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                // Буферизированный символный выходной поток
                BufferedWriter     bufferedWriter     = new BufferedWriter(outputStreamWriter)
        ) {
            String line;
            // Читаем построчно, конвертируем в верхний регистр и записываем в выходной файл
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line.toUpperCase());
                bufferedWriter.newLine();
            }
            System.out.println("Данные записаны в файл: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}