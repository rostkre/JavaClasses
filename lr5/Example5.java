package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example5 {
    public static void main(String[] args) {
        // Пример использования
        Scanner scanner = new Scanner(System.in);

        // Ввод подстроки для фильтрации
        System.out.println("Введите подстроку для поиска: ");
        String substring = scanner.nextLine();

        // Создаём тестовый список строк
        List<String> strings = new ArrayList<>();
        strings.add("Hello world");
        strings.add("Java programming");
        strings.add("Подстрока здесь");
        strings.add("Test string");
        strings.add("Ещё одна строка");

        // Вызываем функцию фильтрации
        List<String> result = filterStringsContainingSubstring(strings, substring);

        // Выводим результат
        System.out.println("\nИсходный список:");
        for (String s : strings) {
            System.out.println(s);
        }

        System.out.println("\nОтфильтрованные строки (содержат подстроку \"" + substring + "\"):");
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String substring) {
        return list.stream()
                .filter(str -> str.contains(substring))
                .collect(Collectors.toList());
    }
}