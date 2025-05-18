package lr7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Example3 {
    public static void main(String[] args) throws IOException {
        // Открываем файл для построчного чтения
        BufferedReader reader = new BufferedReader(
                new FileReader("src/lr7/input.txt")
        );

        int lineCount = 0;
        // Считаем строки до конца файла
        while (reader.readLine() != null) {
            lineCount++;
        }

        reader.close();
        // Выводим результат
        System.out.println("Количество строк в файле: " + lineCount);
    }
}