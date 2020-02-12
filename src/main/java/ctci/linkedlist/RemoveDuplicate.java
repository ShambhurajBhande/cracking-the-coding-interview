package ctci.linkedlist;

import java.util.LinkedList;

/*
@author Shambhuraj Bhande
* Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * */
public class RemoveDuplicate {
    static Node head;



    public static void main(String[] args) {

        Node head = generateLinkedList();
        System.out.print("Input:::");
        printList(head);
        removeDuplicate(head);
        System.out.println("Output:::");
        printList(head);
    }

    private static void removeDuplicate(Node head) {
        while (head != null) {
            Node runner=head;
            while (runner.next != null) {
                if (runner.next.data == head.data) {
                    runner.next=runner.next.next;
                }else {
                    runner=runner.next;
                }
            }
            head=head.next;
        }

    }


    private static Node generateLinkedList() {
        CustomLinkedList customLinkedList=new CustomLinkedList();
        customLinkedList.addElement(1);
        customLinkedList.addElement(2);
        customLinkedList.addElement(3);
        customLinkedList.addElement(3);
        customLinkedList.addElement(7);
        customLinkedList.addElement(1);
        return customLinkedList.getHead();
    }
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println();
    }

}
