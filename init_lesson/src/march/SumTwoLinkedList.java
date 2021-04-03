package march;

/**
 * Суммировать два связных списка, value которых либо 0, либо 1.
 * Вывести результирующий список.
 */
public class SumTwoLinkedList {

    public static void main(String[] args) {
        int[] f = {1, 1, 1, 1, 1};
        int[] s = {1, 1, 1, 1};

        ListNode node1 = new ListNode(f[0]);
        ListNode node2 = new ListNode(f[1]);
        node1.nextNode = node2;
        node1.previousNode = null;

        ListNode node3 = new ListNode(f[2]);
        node2.nextNode = node3;
        node2.previousNode = node1;

        ListNode node4 = new ListNode(f[3]);
        node3.nextNode = node4;
        node3.previousNode = node2;

        ListNode node5 = new ListNode(f[4]);
        node4.nextNode = node5;
        node4.previousNode = node3;
        node5.previousNode = node4;

        ListNode node11 = new ListNode(s[0]);
        ListNode node12 = new ListNode(s[1]);
        node11.nextNode = node12;
        node11.previousNode = null;

        ListNode node13 = new ListNode(s[2]);
        node12.nextNode = node13;
        node12.previousNode = node11;

        ListNode node14 = new ListNode(s[3]);
        node13.nextNode = node14;
        node13.previousNode = node12;

        //ListNode node15 = new ListNode(s[4]);
        node14.nextNode = node1;
        node14.previousNode = node13;
        //node15.previousNode = node14;

        ListNode.print(sumTwoLinkedList(node5, node14));
    }

    private static ListNode sumTwoLinkedList(ListNode first, ListNode second) {

        ListNode firstLast = first;
        ListNode secondLast = second;
        ListNode previousNode = null;
        int buffer = 0;

        while (firstLast != null || secondLast != null) {

            // Если у первого списка закончились элементы - заменяем узлами с value = 0
            if (firstLast == null) {
                firstLast = new ListNode(0);
            }

            // Если у второго списка закончились элементы - заменяем узлами с value = 0
            if (secondLast == null) {
                secondLast = new ListNode(0);
            }

            // Случай, когда оба значения 1 - увеличиваем буффер на 1
            if (firstLast.value == 1 && secondLast.value == 1) {
                ListNode node = new ListNode(0);
                node.nextNode = previousNode;
                previousNode = node;
                buffer++;

                // Случай, когда оба значения 0 - уменьшаем буффер на 1
            } else if (firstLast.value == 0 && secondLast.value == 0) {
                int sum = 0;
                if (buffer != 0) {
                    sum = 1;
                    buffer--;
                }
                ListNode node = new ListNode(sum);
                node.nextNode = previousNode;
                previousNode = node;

                // Случай, когда значения 0-1 или 1-0
            } else {
                int sum = 0;
                if (buffer == 0) {
                    sum = firstLast.value + secondLast.value;
                }
                ListNode node = new ListNode(sum);
                node.nextNode = previousNode;
                previousNode = node;
            }

            firstLast = firstLast.previousNode;
            secondLast = secondLast.previousNode;
        }

        // Добавляем единицы в начало, если буффер не пустой
        for (int i = 0; i < buffer; i++) {
            ListNode node = new ListNode(1);
            node.nextNode = previousNode;
            previousNode = node;
        }

        return previousNode;
    }
}
