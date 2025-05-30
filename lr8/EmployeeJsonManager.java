package lr8.Example3;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class EmployeeJsonManager {
    private static final String JSON_FILE = "src/lr8/Example3/employees.json";
    private JSONArray employees;

    public static void main(String[] args) {
        EmployeeJsonManager manager = new EmployeeJsonManager();
        manager.run();
    }

    private void run() {
        try {
            loadEmployees();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\n--- Менеджер сотрудников JSON ---");
                System.out.println("1. Добавить сотрудника");
                System.out.println("2. Поиск по имени");
                System.out.println("3. Удалить по имени");
                System.out.println("4. Показать всех сотрудников");
                System.out.println("0. Выход");
                System.out.print("Выберите пункт: ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1": addEmployee(scanner); break;
                    case "2": searchByName(scanner); break;
                    case "3": deleteByName(scanner); break;
                    case "4": listAll(); break;
                    case "0": saveEmployees(); System.out.println("До свидания!"); return;
                    default: System.out.println("Неверный выбор.");
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    // загрузка массива сотрудников из JSON-файла
    private void loadEmployees() throws Exception {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(JSON_FILE));
        JSONObject root = (JSONObject) obj;
        employees = (JSONArray) root.get("employees");
    }

    // сохранение массива обратно в файл
    private void saveEmployees() throws Exception {
        JSONObject root = new JSONObject();
        root.put("employees", employees);
        try (FileWriter writer = new FileWriter(JSON_FILE)) {
            writer.write(root.toJSONString());
        }
        System.out.println("Изменения сохранены в JSON-файл.");
    }

    private void addEmployee(Scanner scanner) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (ГГГГ-ММ-ДД): ");
        String dob = scanner.nextLine();
        System.out.print("Введите должность: ");
        String position = scanner.nextLine();

        JSONObject emp = new JSONObject();
        emp.put("name", name);
        emp.put("dob", dob);
        emp.put("position", position);

        employees.add(emp);
        System.out.println("Сотрудник добавлен.");
    }

    private void searchByName(Scanner scanner) {
        System.out.print("Введите имя для поиска: ");
        String query = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Object o : employees) {
            JSONObject emp = (JSONObject) o;
            String name = ((String) emp.get("name")).toLowerCase();
            if (name.contains(query)) {
                printEmployee(emp);
                found = true;
            }
        }
        if (!found) System.out.println("Сотрудники не найдены.");
    }

    private void deleteByName(Scanner scanner) {
        System.out.print("Введите имя для удаления: ");
        String query = scanner.nextLine().toLowerCase();
        Iterator<?> iter = employees.iterator();
        while (iter.hasNext()) {
            JSONObject emp = (JSONObject) iter.next();
            String name = ((String) emp.get("name")).toLowerCase();
            if (name.contains(query)) {
                iter.remove();
                System.out.println("Сотрудник удалён.");
                return;
            }
        }
        System.out.println("Соответствий не найдено.");
    }

    private void listAll() {
        for (Object o : employees) {
            printEmployee((JSONObject) o);
        }
    }

    private void printEmployee(JSONObject emp) {
        System.out.printf("Имя: %s, Дата рождения: %s, Должность: %s\n",
                emp.get("name"), emp.get("dob"), emp.get("position")
        );
    }
}
