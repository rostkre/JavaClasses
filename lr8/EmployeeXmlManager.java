package lr8.Example2;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class EmployeeXmlManager {
    private static final String XML_FILE = "src/lr8/Example2/employees.xml";
    private Document doc;
    private Element root;

    public static void main(String[] args) {
        EmployeeXmlManager manager = new EmployeeXmlManager();
        manager.run();
    }

    private void run() {
        try {
            loadDocument();  // загрузка только существующего файла
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\n--- Менеджер сотрудников XML ---");
                System.out.println("1. Добавить сотрудника");
                System.out.println("2. Поиск по имени");
                System.out.println("3. Поиск по дате рождения");
                System.out.println("4. Удалить по имени");
                System.out.println("5. Показать всех сотрудников");
                System.out.println("0. Выход");
                System.out.print("Выберите пункт: ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1": addEmployee(scanner); break;
                    case "2": searchByName(scanner); break;
                    case "3": searchByDOB(scanner); break;
                    case "4": deleteByName(scanner); break;
                    case "5": listAll(); break;
                    case "0": saveDocument(); System.out.println("До свидания!"); return;
                    default: System.out.println("Неверный выбор.");
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private void loadDocument() throws Exception {
        File file = new File(XML_FILE);
        if (!file.exists()) {
            throw new Exception("Файл XML не найден: " + XML_FILE);
        }
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc = db.parse(file);
        doc.getDocumentElement().normalize();
        root = doc.getDocumentElement();
    }

    private void addEmployee(Scanner scanner) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (ГГГГ-ММ-ДД): ");
        String dob = scanner.nextLine();
        System.out.print("Введите должность: ");
        String position = scanner.nextLine();

        Element emp = doc.createElement("employee");
        emp.setAttribute("name", name);
        emp.setAttribute("dob", dob);

        Element posElem = doc.createElement("position");
        posElem.setTextContent(position);
        emp.appendChild(posElem);
        root.appendChild(emp);

        System.out.println("Сотрудник добавлен.");
    }

    private void searchByName(Scanner scanner) {
        System.out.print("Введите имя для поиска: ");
        String name = scanner.nextLine().toLowerCase();
        NodeList list = root.getElementsByTagName("employee");
        boolean found = false;
        for (int i = 0; i < list.getLength(); i++) {
            Element emp = (Element) list.item(i);
            if (emp.getAttribute("name").toLowerCase().contains(name)) {
                printEmployee(emp);
                found = true;
            }
        }
        if (!found) System.out.println("Сотрудники не найдены.");
    }

    private void searchByDOB(Scanner scanner) {
        System.out.print("Введите дату рождения для поиска (ГГГГ-ММ-ДД): ");
        String dob = scanner.nextLine();
        NodeList list = root.getElementsByTagName("employee");
        boolean found = false;
        for (int i = 0; i < list.getLength(); i++) {
            Element emp = (Element) list.item(i);
            if (emp.getAttribute("dob").equals(dob)) {
                printEmployee(emp);
                found = true;
            }
        }
        if (!found) System.out.println("Сотрудники не найдены.");
    }

    private void deleteByName(Scanner scanner) {
        System.out.print("Введите имя для удаления: ");
        String name = scanner.nextLine().toLowerCase();
        NodeList list = root.getElementsByTagName("employee");
        for (int i = 0; i < list.getLength(); i++) {
            Element emp = (Element) list.item(i);
            if (emp.getAttribute("name").toLowerCase().contains(name)) {
                root.removeChild(emp);
                System.out.println("Сотрудник удалён.");
                return;
            }
        }
        System.out.println("Соответствий не найдено.");
    }

    private void listAll() {
        NodeList list = root.getElementsByTagName("employee");
        for (int i = 0; i < list.getLength(); i++) {
            printEmployee((Element) list.item(i));
        }
    }

    private void printEmployee(Element emp) {
        System.out.printf("Имя: %s, Дата рождения: %s, Должность: %s\n",
                emp.getAttribute("name"),
                emp.getAttribute("dob"),
                emp.getElementsByTagName("position").item(0).getTextContent()
        );
    }

    private void saveDocument() throws TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(XML_FILE));
        transformer.transform(source, result);
        System.out.println("Изменения сохранены в XML-файл.");
    }
}
