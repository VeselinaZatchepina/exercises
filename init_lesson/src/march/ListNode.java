package march;

public class ListNode {

    int value;
    ListNode nextNode = null;
    ListNode previousNode = null;

    public ListNode(int value) {
        this.value = value;
    }

    public static void print(ListNode head) {

        while (head != null) {
            System.out.println(head.value);
            head = head.nextNode;
        }
    }
}
