package lr3;

public class Example8 {
    public static void main(String[] args) {
        // Простой пример использования
        SingleLinkedList list = new SingleLinkedList();

        // Итеративные методы

        list.createHead(new int[]{1, 2, 3});
        System.out.println("После createHead: " + list.toString()); // [3, 2, 1]

        list.createTail(new int[]{4, 5});
        System.out.println("После createTail: " + list.toString()); // [3, 2, 1, 4, 5]

        list.addFirst(100);
        list.addLast(999);
        System.out.println("После addFirst(100) и addLast(999): " + list.toString());

        list.insert(777, 2);
        System.out.println("После insert(777, 2): " + list.toString());

        list.removeFirst();
        list.removeLast();
        list.remove(2);
        System.out.println("После removeFirst, removeLast и remove(2): " + list.toString());

        // Рекурсивные методы: создадим новый список

        SingleLinkedList recList = new SingleLinkedList();

        recList.createHeadRec(new int[]{1, 2, 3}, 0);
        System.out.println("recList после createHeadRec: " + recList.toStringRec()); // [3, 2, 1]

        recList.createTailRec(new int[]{4, 5}, 0);
        System.out.println("recList после createTailRec: " + recList.toStringRec()); // [3, 2, 1, 4, 5]
    }
}

class Node2 {
    int value;
    Node next;
    Node2(int value) {
        this.value = value;
    }
}

class SingleLinkedList {
    private Node head; // голова списка
    private int size;  // размер списка (для удобства некоторых операций)

    // ---------------------------------------------------------------------
    //  МЕТОДЫ С ИСПОЛЬЗОВАНИЕМ ЦИКЛА

    public void createHead(int[] arr) {
        for (int value : arr) {
            addFirst(value);
        }
    }


    public void createTail(int[] arr) {
        for (int value : arr) {
            addLast(value);
        }
    }

    public String toString() {
        if (head == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head; // новый узел ссылается на старую голову
        head = newNode;      // голова теперь — новый узел
        size++;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void insert(int value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс " + index);
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }
        // Ищем узел перед позицией вставки
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public void removeFirst() {
        if (head == null) return; // список пуст
        head = head.next;
        size--;
    }

    public void removeLast() {
        if (head == null) return;    // список пуст
        if (head.next == null) {     // в списке только один элемент
            head = null;
            size--;
            return;
        }
        // Идём до предпоследнего узла
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null; // "отцепляем" последний
        size--;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некорректный индекс " + index);
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        // Ищем узел перед удаляемым
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next; // пропускаем удаляемый
        size--;
    }

    // ---------------------------------------------------------------------
    //  МЕТОДЫ С ИСПОЛЬЗОВАНИЕМ РЕКУРСИИ

    public void createHeadRec(int[] arr, int idx) {
        if (idx >= arr.length) return; // дошли до конца
        // Сначала вставляем текущий элемент в голову
        addFirst(arr[idx]);
        // Рекурсивно для следующего индекса
        createHeadRec(arr, idx + 1);
    }

    public void createTailRec(int[] arr, int idx) {
        if (idx >= arr.length) return; // дошли до конца
        // Добавляем текущий элемент в конец
        addLast(arr[idx]);
        // Рекурсивно вызываем для следующего
        createTailRec(arr, idx + 1);
    }

    public String toStringRec() {
        StringBuilder sb = new StringBuilder("[");
        buildStringRec(head, sb);
        sb.append("]");
        return sb.toString();
    }

    private void buildStringRec(Node node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.value);
        if (node.next != null) {
            sb.append(", ");
        }
        buildStringRec(node.next, sb);
    }
}
