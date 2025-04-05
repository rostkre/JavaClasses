package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Пример списка строк
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("World123");
        strings.add("ABC");
        strings.add("Test!");
        strings.add("Привет");
        strings.add("12345");
        strings.add("НаРусском");

        // Вызываем функцию фильтрации
        List<String> result = filterAlphabeticOnly(strings);

        System.out.println("\nИсходный список строк:");
        for (String s : strings) {
            System.out.println(s);
        }

        System.out.println("\nСтроки, содержащие только буквы (без цифр и других символов):");
        for (String s : result) {
            System.out.println(s);
        }
    }


    public static List<String> filterAlphabeticOnly(List<String> list) {
        return list.stream()
                // Проверяем, что вся строка состоит только из букв (латиница и кириллица)
                .filter(s -> s.matches("[a-zA-Zа-яА-Я]+"))
                .collect(Collectors.toList());
    }
}
