import java.util.HashSet;
import java.util.Scanner;

public class timus_1563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());  // Читаем количество магазинов

        HashSet<String> visited = new HashSet<>();
        int bayanCount = 0; // Счётчик «БАЯН»

        for (int i = 0; i < n; i++) {
            // Считываем название магазина (возможно с пробелами)
            String shopName = sc.nextLine();

            // Проверяем, встречалось ли оно ранее
            if (visited.contains(shopName)) {
                // Магазин уже посещался -> говорим «БАЯН»
                bayanCount++;
            } else {
                // Добавляем в множество посещённых
                visited.add(shopName);
            }
        }

        // Выводим количество раз, когда прозвучало «БАЯН»
        System.out.println(bayanCount);
    }
}
