package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Пример списка целых чисел
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(10);
        numbers.add(20);
        numbers.add(5);
        numbers.add(30);
        numbers.add(25);
        numbers.add(15);

        // Ввод порогового значения
        System.out.print("Введите число, с которым будут сравниваться элементы списка: ");
        int threshold = scanner.nextInt();

        // Фильтрация списка
        List<Integer> result = filterNumbersGreaterThan(numbers, threshold);

        System.out.println("\nИсходный список целых чисел:");
        for (Integer num : numbers) {
            System.out.println(num);
        }

        System.out.println("\nЧисла, которые больше " + threshold + ":");
        for (Integer num : result) {
            System.out.println(num);
        }
    }


    public static List<Integer> filterNumbersGreaterThan(List<Integer> list, int threshold) {
        return list.stream()
                .filter(num -> num > threshold)
                .collect(Collectors.toList());
    }
}
