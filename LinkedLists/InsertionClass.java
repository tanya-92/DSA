class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class Insertion{
    Node head;   //started a linked list

    public void insertionAtBeginning(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {   // reach last node
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void traversal(){
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class InsertionClass{
    public static void main(String[] args){
        Insertion list = new Insertion();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        System.out.println("Linked List:");
        list.traversal();
    }
}