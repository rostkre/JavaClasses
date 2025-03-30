package lr3.Example7;

public class Example7_1 {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(0, null); // 0-й узел - будет головой в списке
        ListNode node1 = new ListNode(1, null);
        ListNode node2 = new ListNode(2, null);
        ListNode node3 = new ListNode(3, null); // последний узел - будет хвостом в списке

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode ref = node0;
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }
}

class ListNode {
    int value;
    ListNode next;

    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}
