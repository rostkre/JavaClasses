package lr2;

public class Example3 {
    public static String getExample3String(String Example3String, int shift) {
        // Преобразуем переданную в метод строку в символьный массив
        char[] arrayChar = Example3String.toCharArray();

        // Создаем массив с типом данных long, размер которого равен размеру символьного массива
        long[] arrayInt = new long[arrayChar.length];

        // Создаем символьный массив, в который будем записывать преобразованные символы
        char[] arrayCharNew = new char[arrayChar.length];

        // В цикле перебираем все символы, из которых состоит переданная строка,
        // прибавляем к каждому символу число-ключ (сдвиг)
        for (int i = 0; i < arrayChar.length; i++) {
            // Прибавляем к символу с индексом i сдвиг
            arrayInt[i] = arrayChar[i] + shift;
            // Преобразуем число в символ char и записываем в новый массив
            arrayCharNew[i] = (char) arrayInt[i];
        }

        // Преобразуем новый массив символов обратно в строку
        Example3String = new String(arrayCharNew);

        // Возвращаем строку в метод, из которого был вызван текущий метод
        return Example3String;
    }


    // Метод main, с которого запускается программа
    public static void main(String[] args) {
        // Пример входной строки
        String input = "Hello World!";
        int shift = 3;

        // Вызываем метод шифрования
        String encrypted = getExample3String(input, shift);

        // Выводим результат
        System.out.println("Исходная строка: " + input);
        System.out.println("Зашифрованная строка: " + encrypted);
    }
}


