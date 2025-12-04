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
        newNode.next = head;
        head = newNode;
    }

    public void insertionAtIndex(int data, int index){
        Node newNode = new Node(data);

        // Case 1: insert at beginning (index = 0)
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        
        Node temp = head; int i=0;
        while(i != index-1){
            temp = temp.next;        //index se ek step phle aake rokdia!
            i++; 
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void insertionAtEnd(int data){
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
        newNode.next = null;
    }

    public void insertionAfterNode(int data, Node prevNode){
        Node newNode = new Node(data);
        newNode.next = prevNode.next;  
        prevNode.next = newNode;
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
        list.insertionAtEnd(10);
        list.insertionAtEnd(20);
        list.insertionAtEnd(30);
        list.insertionAtEnd(40);
        list.insertionAtBeginning(50);
        list.insertionAtIndex(60,2);
        list.insertionAfterNode(50, head.next);          // insert after 2nd node
        list.insertionAfterNode(50, head.next.next);     // insert after 3rd node


        System.out.println("Linked List:");
        list.traversal();
    }
}