package ctci.linkedlist;
/*
@author Shambhuraj Bhande
* */
public class CustomLinkedList {
private  Node head;
private  Node node;


    public Node getHead() {
        return head;
    }

    public void addElement(int data){
        if (head==null){
            head=new Node(data);
            node=head;
        }else{
            node.next=new Node(data);
            node=node.next;
        }
    }

    public static void printCustomLinkedList(Node node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        CustomLinkedList customLinkedList=new CustomLinkedList();
        customLinkedList.addElement(1);
        customLinkedList.addElement(2);
        customLinkedList.addElement(3);
        printCustomLinkedList(customLinkedList.getHead());
    }
}
