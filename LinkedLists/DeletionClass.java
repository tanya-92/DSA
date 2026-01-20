class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class Deletion{
    Node head;

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

    public void deletionFromBeginning(){
        if(head == null){System.out.println("list is empty"); return;}
        head = head.next;
    }

    public void deletionFromEnd(){
        if(head == null){System.out.println("list is empty"); return;}
        if(head.next == null) {head = null; return;} //only one node
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }

    public void deletionAtIndex(int index){
        if(head == null){System.out.println("list is empty"); return;}
        if(index == 0){
            head = head.next;
            return;
        }
        Node temp = head;
        for(int i=0; i<index-1; i++){
            if(temp.next==null) { System.out.println("Index out of bounds"); return;}
            temp = temp.next;
        }
        if(temp.next==null) { System.out.println("Index out of bounds"); return;}
        temp.next = temp.next.next;
    }
}

public class DeletionClass{
    public static void main(String[] args){
        Deltion list = new Deletion();
        list.insertionAtEnd(10);
        list.insertionAtEnd(20);
        list.insertionAtEnd(30);
        list.insertionAtEnd(40);
        
        list.deletionFromBeginning();
        list.deletionFromEnd();
        list.deletionAtIndex(1);
    }
}