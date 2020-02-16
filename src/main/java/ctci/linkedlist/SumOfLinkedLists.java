package ctci.linkedlist;/* @author Shambhuraj created on 2/13/2020*/

public class SumOfLinkedLists {

    public static void main(String[] args) {
        Node firstListHead = generateLinkedList();
        Node secondListHead = generateSecondLinkedList();
        LinkedListSum(firstListHead, secondListHead);
    }

    private static void LinkedListSum(Node firstListHead, Node secondListHead) {
        StringBuilder firstNumber = new StringBuilder();
        StringBuilder secondNumber = new StringBuilder();
        while (firstListHead != null) {
            firstNumber.append(firstListHead.data);
            firstListHead = firstListHead.next;
        }
        while (secondListHead != null) {
            secondNumber.append(secondListHead.data);
            secondListHead = secondListHead.next;
        }

        int sum = Integer.parseInt(firstNumber.toString()) + Integer.parseInt(secondNumber.toString());
        String addition = String.valueOf(sum);
        CustomLinkedList customLinkedList = new CustomLinkedList();

        for (int i = 0; i < addition.length(); i++) {
            customLinkedList.addElement(Integer.parseInt(String.valueOf(addition.charAt(i))));
        }
        printList(customLinkedList.getHead());
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
        customLinkedList.addElement(5);
        customLinkedList.addElement(2);
        // customLinkedList.addElement(1);
        return customLinkedList.getHead();
    }

    private static Node generateSecondLinkedList() {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addElement(1);
        customLinkedList.addElement(9);
        customLinkedList.addElement(7);
        customLinkedList.addElement(7);
        customLinkedList.addElement(7);
        // customLinkedList.addElement(1);
        return customLinkedList.getHead();
    }
}
