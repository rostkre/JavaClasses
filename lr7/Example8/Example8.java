package lr7.Example8;

import java.io.*;

public class Example8 {
    public static void main(String[] args) {
        String serFile = "src/lr7/Example8/person.ser";

        // Создаём объект для сохранения
        Person person = new Person("Иван Иванов", 28, "ivan.ivanov@example.com");

        // Сериализация объекта в файл
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(serFile))) {
            oos.writeObject(person);
            System.out.println("Объект сохранён в файл: " + serFile);
        } catch (IOException e) {
            System.err.println("Ошибка при сериализации: " + e.getMessage());
            return;
        }

        // Десериализация объекта из файла
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(serFile))) {
            Person restored = (Person) ois.readObject();
            System.out.println("Объект восстановлен из файла:");
            System.out.println("  Имя:  " + restored.getName());
            System.out.println("  Возраст: " + restored.getAge());
            System.out.println("  Email: " + restored.getEmail());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при десериализации: " + e.getMessage());
        }
    }
}
