import java.util.Scanner;

public class timus_1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cipher = sc.nextLine();   // Считываем зашифрованную строку

        StringBuilder sb = new StringBuilder();

        for (char c : cipher.toCharArray()) {
            // Если StringBuilder не пуст и последний символ совпадает с текущим
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                // Удаляем последний символ, тем самым убирая пару
                sb.deleteCharAt(sb.length() - 1);
            } else {
                // Иначе добавляем текущий символ
                sb.append(c);
            }
        }

        // Выводим итоговую строку — восстановленный текст
        System.out.println(sb.toString());
    }
}
