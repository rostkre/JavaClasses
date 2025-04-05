package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Пример списка строк
        List<String> words = new ArrayList<>();
        words.add("Short");
        words.add("VeryLongWord");
        words.add("Medium");
        words.add("AnotherLongString");

        System.out.print("Введите минимальную длину строки: ");
        int minLength = scanner.nextInt();

        // Фильтрация списка
        List<String> filtered = filterStringsLongerThan(words, minLength);

        System.out.println("\nИсходный список строк:");
        for (String s : words) {
            System.out.println(s);
        }

        System.out.println("\nСтроки, длина которых больше " + minLength + ":");
        for (String s : filtered) {
            System.out.println(s);
        }
    }


    public static List<String> filterStringsLongerThan(List<String> list, int minLength) {
        return list.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }
}
