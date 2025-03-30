package lr3.Example1;

public class Example1_5 {
    public static void main(String[] args) {
        System.out.println(fact(5));
    }

    public static int fact(int n) {
        // Сообщения для вывода последовательности вызовов
        System.out.println("Call: fact(" + n + ")");

        if (n == 0) {
            System.out.println("Return from fact(0): 0");
            return 0;
        } else if (n == 1) {
            System.out.println("Return from fact(1): 1");
            return 1;
        } else {
            int result = fact(n - 2) + fact(n - 1);
            System.out.println("Return from fact(" + n + "): " + result);
            return result;
        }
    }
}