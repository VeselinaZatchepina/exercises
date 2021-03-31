package march;

/**
 * Отобразить перевернутый связный список с индекса startIndex, до индекса endIndex включительно.
 */
public class GetNodesByIndexAndReverse {

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

        ListNode.print(getReversedList(node1, 1, 5));
    }

    private static ListNode getReversedList(ListNode head, int startIndex, int endIndex) {

        ListNode previousNode = head;
        ListNode startNode = null;
        ListNode endNode = null;
        int currentIndex = 1;

        while (currentIndex != endIndex + 1) {

            // Если индекс равен startIndex - создаем узел с текущим value и предыдущим назначаем его
            if (currentIndex == startIndex) {
                startNode = new ListNode(head.value);
                previousNode = startNode;

                // Если индекс больше startIndex, но меньше endIndex - создаем узел с текущим value
                // предыдущим назначаем его + записываем предварительный tail + назначаем nextNode как previousNode
            } else if (currentIndex > startIndex && currentIndex < endIndex + 1) {
                ListNode newNode = new ListNode(head.value);
                newNode.nextNode = previousNode;
                endNode = newNode;
                previousNode = newNode;

                // Если индекс == startIndex, то возвращаем tail
            } else if (currentIndex == endIndex + 1) {
                return endNode;

                // иначе продолжаем идти по списку
            } else {
                previousNode = head;
            }

            head = head.nextNode;
            currentIndex++;
        }

        return endNode;
    }
}
