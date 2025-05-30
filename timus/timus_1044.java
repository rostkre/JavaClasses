import java.util.Scanner;

public class timus_1044 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int half = N / 2;
        // Максимальная возможная сумма на одной половине
        int maxSum = 9 * half;
        // counts[s] = число способов набрать сумму s в half цифрах (0–9)
        long[] counts = new long[maxSum + 1];

        // Простейший перебор всех комбинаций half цифр (10^half, при half<=4 это <=10000)
        int limit = (int) Math.pow(10, half);
        for (int x = 0; x < limit; x++) {
            int tmp = x;
            int s = 0;
            // Суммируем ровно half цифр, включая ведущие нули
            for (int i = 0; i < half; i++) {
                s += tmp % 10;
                tmp /= 10;
            }
            counts[s]++;
        }

        // Теперь для каждой возможной суммы s пары половин дают counts[s] * counts[s] счастливых билетов
        long result = 0;
        for (int s = 0; s <= maxSum; s++) {
            result += counts[s] * counts[s];
        }

        System.out.println(result);
    }
}
