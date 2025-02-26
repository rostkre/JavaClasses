package timus;

import java.util.ArrayList;
import java.util.Scanner;

public class timus_1001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> numbers = new ArrayList<>();

        // Читаем входные числа
        while (scanner.hasNextLong()) {
            numbers.add(scanner.nextLong());
        }

        // Выводим квадратные корни в обратном порядке
        for (int i = numbers.size() - 1; i >= 0; i--) {
            System.out.printf("%.4f\n", Math.sqrt(numbers.get(i)));
        }
    }
}
