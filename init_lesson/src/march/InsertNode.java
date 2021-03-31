package march;

public class InsertNode {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.nextNode = node2;
        ListNode node3 = new ListNode(3);
        node2.nextNode = node3;

        ListNode node4 = new ListNode(4);
        node3.nextNode = node4;
        ListNode node5 = new ListNode(5);
        node4.nextNode = node5;

        insertValue(node1, 4);

        ListNode.print(node1);
    }

    private static void insertValue(ListNode head, int value) {

        ListNode previousNode = head;

        while (head != null) {

            if (value < head.value) {
                ListNode newNode = new ListNode(value);
                previousNode.nextNode = newNode;
                newNode.nextNode = head;
                break;
            }

            previousNode = head;
            head = head.nextNode;
        }
    }
}
