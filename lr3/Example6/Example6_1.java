package lr3.Example6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example6_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество человек (N): ");
        int N = scanner.nextInt();

        // Заполняем ArrayList числами от 1 до N
        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }

        long startTime = System.nanoTime();  // Начало отсчёта времени

        int index = 0;
        // Пока не останется один человек, вычеркиваем каждого второго
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);

        }

        long endTime = System.nanoTime();  // Окончание отсчёта времени

        System.out.println("Остался человек с номером: " + people.get(0));
        System.out.println("Время выполнения (ArrayList): " + (endTime - startTime) + " нс");
    }
}
