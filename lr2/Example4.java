package lr2;

public class Example4 {
    public static void main(String[] args) {
        // Создаём несколько объектов класса Person
        Person person1 = new Person("Иван", 25, 'M');
        Person person2 = new Person("Мария", 30, 'F');

        // Выводим информацию об объектах
        System.out.println("Имя: " + person1.getName()
                + ", Возраст: " + person1.getAge()
                + ", Пол: " + person1.getGender());

        System.out.println("Имя: " + person2.getName()
                + ", Возраст: " + person2.getAge()
                + ", Пол: " + person2.getGender());

        // Меняем некоторые значения
        person1.setAge(26);
        person2.setName("Мария Петровна");

        // Выводим изменённые данные
        System.out.println("\nПосле изменений:");
        System.out.println("Имя: " + person1.getName()
                + ", Возраст: " + person1.getAge()
                + ", Пол: " + person1.getGender());

        System.out.println("Имя: " + person2.getName()
                + ", Возраст: " + person2.getAge()
                + ", Пол: " + person2.getGender());
    }
}

// Класс Person
class Person {
    private String name;    // Имя
    private int age;        // Возраст
    private char gender;    // Пол ('M' или 'F')

    // Конструктор с параметрами
    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Геттеры (методы для получения значений)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    // Сеттеры (методы для установки значений)
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        // Можно добавить проверку на корректность возраста
        this.age = age;
    }

    public void setGender(char gender) {
        // Можно добавить проверку на корректность ('M' или 'F')
        this.gender = gender;
    }
}