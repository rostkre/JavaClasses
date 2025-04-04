package lr4.Exercise1;

public class Example6 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (ArithmeticException e) {
            // Узкий перехват
            System.out.println("1");
        } catch (RuntimeException e) {
            // Чуть более широкий
            System.out.println("3");
        } catch (Exception e) {
            // Самый широкий
            System.out.println("2");
        }
        System.out.println("4");
    }

}
