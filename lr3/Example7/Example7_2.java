package lr3.Example7;

public class Example7_2 {
    public static void main(String[] args) {
        ListNode head = null;
        for (int i = 9; i >= 0; i--) {
            head = new ListNode(i, head);
        }

        ListNode ref = head;
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }
}

class List2Node {
    int value;
    ListNode next;

    List2Node(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}
