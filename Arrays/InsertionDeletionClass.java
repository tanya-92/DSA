class InsertionDeletion{
    public void display(int[] arr, int n){
        for(int i=0; i<n; i++){
            System.out.println(arr[i]);    //traversal
        }
    }

    public int indexInsertion(int[] arr, int n, int element, int index){
        if(n>100) return -1;
        for(int i=n-1; i>=index; i--){
            arr[i+1] = arr[i];
        }
        arr[index] = element;
        return 1;
    }

    public int indexDeletion(int[] arr, int n, int index){
        if(index>n) return -1;
        for(int i=index; i<n; i++){
            arr[i] = arr[i+1];
        }
        return 1;
    }
}

public class InsertionDeletionClass{
    public static void main(String[] args) {
        int[] arr = new int[100];  // size = 100
        arr[0] = 7;
        arr[1] = 8;
        arr[2] = 12;
        arr[3] = 27;
        arr[4] = 88;
        InsertionDeletion obj = new InsertionDeletion();
        // obj.display(arr, 5);
        // obj.indexInsertion(arr,5,45,2);
        System.out.println(obj.indexDeletion(arr,5,6));
        // obj.display(arr,6);
    }
}