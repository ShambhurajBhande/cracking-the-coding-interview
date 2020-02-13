package ctci.linkedlist;

/* @author Shambhuraj */
/*
Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
* */
public class KthToLast {

    public static void main(String[] args) {
        Node head = generateLinkedList();
        printKthToLast(head, 3);
    }

    private static void printKthToLast(Node head, int k) {
        Node kthNode = findKthElement(head, k);
        while (kthNode != null) {
            System.out.print(kthNode.data + "->");
            kthNode = kthNode.next;
        }
    }

    private static Node findKthElement(Node head, int k) {
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        return head;
    }

    private static Node generateLinkedList() {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addElement(1);
        customLinkedList.addElement(2);
        customLinkedList.addElement(3);
        customLinkedList.addElement(3);
        customLinkedList.addElement(7);
        customLinkedList.addElement(1);
        return customLinkedList.getHead();
    }
}
