package lr8.Example5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFileExample {
    private static final String FILE_PATH = "src/lr8/Example1/Excel/example3.xlsx";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        XSSFWorkbook workbook = null;

        // Загрузка книги Excel
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            workbook = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: файл не найден: " + FILE_PATH);
            System.err.println("Проверьте путь и повторите запуск.");
            return;
        } catch (EncryptedDocumentException e) {
            System.err.println("Ошибка: файл защищён паролем и не может быть открыт.");
            System.err.println("Убедитесь, что файл не зашифрован, или используйте незашифрованную версию.");
            return;
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода при чтении файла: " + e.getMessage());
            return;
        }

        // Выбор листа для чтения
        Sheet sheet = null;
        while (sheet == null) {
            System.out.print("Введите имя листа для чтения: ");
            String sheetName = scanner.nextLine();
            sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.err.println("Лист с именем '" + sheetName + "' не найден.");
                System.err.println("Доступные листы:");
                Iterator<Sheet> it = workbook.iterator();
                while (it.hasNext()) {
                    System.err.println(" - " + it.next().getSheetName());
                }
                System.err.println("Проверьте название и попробуйте снова.");
            }
        }

        // Чтение и вывод содержимого листа
        System.out.println("Чтение листа: " + sheet.getSheetName());
        for (Row row : sheet) {
            for (Cell cell : row) {
                try {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                            System.out.print("\t");
                    }
                } catch (Exception e) {
                    System.err.print("[Ошибка чтения ячейки] " + e.getMessage() + "\t");
                }
            }
            System.out.println();
        }

        // Закрытие ресурсов
        try {
            workbook.close();
        } catch (IOException e) {
            System.err.println("Ошибка при закрытии книги: " + e.getMessage());
        }
    }
}