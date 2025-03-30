package lr3;

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Example4 {
    public static void main(String[] args) {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        // Установите точки останова в отладчике на следующих строках
        System.out.println("Node0 value: " + node0.value); // Первая точка
        System.out.println("Node1 value: " + node1.value); // Вторая точка
        System.out.println("Node2 value: " + node2.value); // Третья точка
        System.out.println("Node3 value: " + node3.value); // Конец списка
    }
}
