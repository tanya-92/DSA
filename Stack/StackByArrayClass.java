class Stack{
    int[] arr;
    int top;
    int size;

    Stack(int size){
        this.size = size;
        arr = new int[size];
        top = -1;
    }
}

class StackByArray{
    public void push(int data){
        if(top == size-1){           //like size=5 => top=4(index ke acc) => top == size-1=4 => stack is full; cant add more
            System.out.println("Stack Overflow");
            return;
        }
        arr[top++] = data;
    }

    public void pop(){
        if(top==-1){
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    public int peek(){
        if(top == -1){
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    boolean isEmpty(){
        return top == -1;
    }
}

class StackByArrayClass{
    public static void main(String[] args){
        StackByArray st = new StackByArray(5);
        
    }
}