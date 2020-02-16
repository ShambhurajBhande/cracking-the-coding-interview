package ctci.linkedlist;
/* @author Shambhuraj created on 2/13/2020*/
/*
* Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
that node.
* */

public class DeleteMiddleElement {
    public static void main(String[] args) {
        Node head = generateLinkedList();
        printList(head);
        deleteMiddleNode(head);
        printList(head);
    }

    private static void deleteMiddleNode(Node head) {
        if (head == null &&head.next!=null) {
            return;
        }
        Node previousNode = null;
        Node slowRunner = head;
        Node fastRunner = head;
        while (fastRunner != null&& fastRunner.next != null) {
            fastRunner = fastRunner.next.next;
            previousNode=slowRunner;
            slowRunner = slowRunner.next;
        }
        previousNode.next=slowRunner.next;
    }
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println();
    }

    private static Node generateLinkedList() {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addElement(1);
        customLinkedList.addElement(2);
        customLinkedList.addElement(3);
        customLinkedList.addElement(9);
        customLinkedList.addElement(7);
       // customLinkedList.addElement(1);
        return customLinkedList.getHead();
    }
}
