class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class queueByLinkedList{
    Node front;
    Node rear;

    public void enqueue(int data){
        Node newNode = new Node(data);
        if(rear == null){
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue(){
        if(front == null){
            System.out.println("Queue Underflow");
            return -1;
        }
        int val = front.data;
        front = front.next;

        if(front == null) {rear = null;}

        return val;
    }

    void display() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class queueByLinkedListClass{
    public static void main(String[] args){
        queueByLinkedList q = new queueByLinkedList();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        q.dequeue();
        q.display();  
    }
}