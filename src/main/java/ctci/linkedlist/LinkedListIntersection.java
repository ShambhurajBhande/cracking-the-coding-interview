package ctci.linkedlist;
/* @author Shambhuraj created on 2/15/2020*/

/*Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. Note that the intersection is defined based on reference, not value. That is, if the kth
node of the first linked list is the exact same node (by reference) as the jth node of the second
linked list, then they are intersecting. */

public class LinkedListIntersection {

    public static void main(String[] args) {
        Node firstList = generateLinkedList();
        Node secondList = generateSecondLinkedList();
        printList(firstList);
        printList(secondList);
        boolean isIntersect = isIntersect(firstList, secondList);
        System.out.println(isIntersect);
    }

    private static boolean isIntersect(Node firstList, Node secondList) {
        boolean intesect = false;
        if (firstList == null || secondList == null) {
            return false;
        }
        int firstLenth = findLength(firstList);
        int secondLenth = findLength(secondList);
        if (firstLenth > secondLenth) {
            intesect = checkIntersection(firstList, secondList, firstLenth - secondLenth);
        } else {
            intesect = checkIntersection(secondList, firstList, secondLenth - firstLenth);
        }
        return intesect;
    }

    private static boolean checkIntersection(Node bigList, Node smallList, int difference) {
        boolean isIntersect = false;
        while (bigList.next != null) {
            if (difference == 0) {
                if (bigList == smallList) {
                    isIntersect = true;
                }
                smallList = smallList.next;
                bigList = bigList.next;
            } else {
                difference--;
                bigList = bigList.next;
            }
        }
        return isIntersect;
    }

    private static int findLength(Node list) {
        int length = 0;
        while (list.next != null) {
            length++;
            list=list.next;
        }
        return length;
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
         customLinkedList.addElement(1);
        return customLinkedList.getHead();
    }

    private static Node generateSecondLinkedList() {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addElement(1);
        customLinkedList.addElement(9);
        customLinkedList.addElement(5);
        customLinkedList.addElement(2);
        customLinkedList.addElement(1);
        return customLinkedList.getHead();
    }
}
