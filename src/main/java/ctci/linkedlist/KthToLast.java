package ctci.linkedlist;

/* @author Shambhuraj */
/*
Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
* */
public class KthToLast {

    public static void main(String[] args) {
        Node head = generateLinkedList();
        printKthToLast(head, 3);
        //int index=printKthToLastRecurssion(head,2);
    }


    static int printKthToLastRecurssion(Node head, int k) {
        if (head == null) {
            return 0;
        }
        int index = printKthToLastRecurssion(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is " + head.data);
        }
        return index;
    }

    private static void printKthToLast(Node head, int k) {
        if (head == null) {
            return;
        }
        Node kthNode=head;
        Node kthFromStart = findKthFromStart(head, k);
        while (kthFromStart != null) {
            kthFromStart = kthFromStart.next;
            kthNode=kthNode.next;
        }
        System.out.print("Kth Node is::: "+kthNode.data);
    }

    private static Node findKthFromStart(Node kthFromStart, int k) {
        for (int i = 0; i < k; i++) {
            kthFromStart = kthFromStart.next;
        }
        return kthFromStart;
    }

    private static Node generateLinkedList() {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addElement(1);
        customLinkedList.addElement(2);
        customLinkedList.addElement(3);
        customLinkedList.addElement(9);
        customLinkedList.addElement(7);
        customLinkedList.addElement(1);
        return customLinkedList.getHead();
    }
}
