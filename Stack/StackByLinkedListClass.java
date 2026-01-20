class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class StackByLinkedList{
    Node top;

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public void pop(){
    int pop(){
        if(top == null){
            System.out.println("Stack Underflow");
            return -1;
        }
        int val = top.data;
        top = top.next;
        return val;
    }

    int peek(){
        if(top == null){
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }
}

class StackByLinkedListClass{
    public static void main(String[] args){
        StackByLinkedList st = new StackByLinkedList(5);
        
    }
}