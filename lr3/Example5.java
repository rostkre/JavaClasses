package lr3;

import java.util.HashMap;
import java.util.Map;

public class Example5 {
    public static void main(String[] args) {
        // 1. Заполняем HashMap 10 объектами
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "sixxxxxx");
        map.put(7, "seven");
        map.put(8, "eighttt");
        map.put(9, "nineeee");

        // 2. Находим строки, у которых ключ > 5
        System.out.println("Строки с ключами > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println("Ключ " + entry.getKey() + ": " + entry.getValue());
            }
        }

        // 3. Если ключ = 0, выводим строку(и) через запятую
        if (map.containsKey(0)) {
            System.out.println("Строка для ключа 0: " + map.get(0));
        }

        // 4. Перемножаем все ключи, где длина строки > 5
        long product = 1; // используем long, чтобы избежать возможного переполнения
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
            }
        }
        System.out.println("Произведение ключей (длина строки > 5): " + product);
    }
}