package lr8.Example1.Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class Excel2 {
    public static void main(String[] args) throws IOException {
        // Открываем файл Excel для чтения
        String filePath = "src/lr8/Example1/Excel/example3.xlsx";
        FileInputStream inputStream = new FileInputStream(filePath);

        // Создаем экземпляр книги Excel из файла
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        // Получаем лист из книги по его имени
        XSSFSheet sheet = workbook.getSheet("Товары");

        // Перебираем строки и ячейки листа
        for (Row row : sheet) {
            for (Cell cell : row) {
                // Выводим значение ячейки на экран
                System.out.print(cell.toString() + "\t");
            }
            System.out.println();
        }

        // Закрываем файл и освобождаем ресурсы
        workbook.close();
        inputStream.close();
    }
}