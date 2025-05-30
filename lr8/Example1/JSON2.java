package lr8.Example1.JSON;

import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSON2 {
    public static void main(String[] args) {
        try {
            // Создаем парсер JSON
            JSONParser parser = new JSONParser();
            // Читаем и парсим файл
            Object obj = parser.parse(
                    new FileReader("src/lr8/Example1/JSON/example-json.json")
            );
            // Приводим к JSONObject
            JSONObject jsonObject = (JSONObject) obj;

            // Выводим корневой элемент
            System.out.println("Корневой элемент: "
                    + jsonObject.keySet().iterator().next());

            // Получаем массив книг
            JSONArray jsonArray = (JSONArray) jsonObject.get("books");

            // Проходим по каждому элементу массива
            for (Object o : jsonArray) {
                JSONObject book = (JSONObject) o;
                System.out.println("\nТекущий элемент: book");

                System.out.println("Название книги: "
                        + book.get("title"));
                System.out.println("Автор: "
                        + book.get("author"));
                System.out.println("Год издания: "
                        + book.get("year"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}