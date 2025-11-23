class LinearBinarySearch{
    public void display(int[] arr, int n){
        for(int i=0; i<n; i++){
            System.out.println(arr[i]);    //traversal
        }
    }

    public int linerSearch(int[] arr, int n, int element){
        for(int i=0; i<n; i++){
            if(arr[i]==element) return i;
        }
        return -1;
    }

    public int binarySearch(int[] arr, int n, int element){
        int low, mid, high;
        low=0; high=n-1;
        while(low<=high){
            mid = (low+high)/2;
            if(arr[mid]==element) return mid;
            if(arr[mid]<element) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}

public class LinearBinarySearchClass{
    public static void main(String[] args) {
        int[] arr = new int[100];  // size = 100
        arr[0] = 7;
        arr[1] = 8;
        arr[2] = 12;
        arr[3] = 27;
        arr[4] = 88;
        LinearBinarySearch obj = new LinearBinarySearch();
        // System.out.println(obj.linerSearch(arr,5,27));
        System.out.println(obj.binarySearch(arr,5,88));
    }
}