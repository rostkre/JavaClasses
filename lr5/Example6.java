package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Пример списка целых чисел
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(3);
        numbers.add(25);
        numbers.add(30);
        numbers.add(45);
        numbers.add(50);
        numbers.add(75);

        // Ввод делителя
        System.out.print("Введите делитель: ");
        int divisor = scanner.nextInt();

        // Фильтрация списка
        List<Integer> result = filterDivisibleBy(numbers, divisor);

        System.out.println("\nИсходный список:");
        for (Integer num : numbers) {
            System.out.println(num);
        }

        System.out.println("\nОтфильтрованные числа (делятся на " + divisor + " без остатка):");
        for (Integer num : result) {
            System.out.println(num);
        }
    }


    public static List<Integer> filterDivisibleBy(List<Integer> list, int divisor) {
        return list.stream()
                .filter(num -> num % divisor == 0)
                .collect(Collectors.toList());
    }
}
