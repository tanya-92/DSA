import java.util.Arrays;
import java.util.*;

class BasicsOfArray{
    public void sortArray(int arr[], int n){
        Arrays.sort(arr);
        }

    public void display(int arr[],int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public void reverseArray(int arr[], int start, int end){
        while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;end--;
        }
    }

    public int largestElement(int arr[],int n){
        int largest = arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        return largest;
    }

    public void secondLargestBrute(int[] arr, int n){
        Arrays.sort(arr);
        int secondLargest;
        int largest = arr[n-1];
        for(int i=n-2; i>=0; i--){
            if(arr[i]!=largest){
                secondLargest = arr[i];
                break;
            }
        }
    }

    public void secondLargestBetter(int[] arr, int n){
        int largest = largestElement(arr,n);
        int secondLargest = -1;
        for(int i=0; i<n; i++){
            if(arr[i]!=largest && arr[i]>secondLargest){
                secondLargest = arr[i];
            }
        }
        System.out.println(secondLargest);
    }

    public void secondLargestOptimal(int[] arr, int n){
        int largest = arr[0];
        int secondLargest = -1;
        for(int i = 0; i<n; i++){
            if(arr[i]>largest){
                secondLargest = largest;
                largest = arr[i];
            }
            else if(arr[i]<largest && arr[i]>secondLargest){
                secondLargest = arr[i];
            }
        }
        System.out.println(secondLargest);
    }

    public void secondSmallest(int[] arr,int n){
        int smallest = arr[0];
        int secondSmallest = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            if(arr[i]<smallest){
                secondSmallest = smallest;
                smallest = arr[i];
            }
            else if(arr[i]>smallest && arr[i]<secondSmallest){
                secondSmallest = arr[i];
            }
        }
        System.out.println(secondSmallest);
    }

    public boolean isSorted(int[] arr, int n){
        for(int i=1; i<n; i++){
            if(arr[i]>arr[i-1]){}
            else return false;
        }
        return true;
    }

    public void removeDuplicatesBrute(int[] arr, int n){
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(arr[i]);                   //to insert-> nlogn   and to  iterate->n  => O(n+nlogn)      SC->O(n)
        }
    }

    public void removeDuplicatesOptimal(int[] arr, int n){
        int i = 0;
        for(int j = 1;j<n;j++){
            if(arr[j]!=arr[i]){
                arr[i+1]=arr[j];
                i++;
            }
        }
    }

    public void leftRotateByOnePlace(int[] arr, int n){
        int temp = arr[0];
        for(int i=1; i<n; i++){
            arr[i-1]=arr[i];
        }
        arr[n-1]=temp;
    }

    public void leftRotateBrute(int[] arr, int n, int d){
        d = d%n;
        int[] temp = new int[d];
        for(int i=0; i<d; i++){
            temp[i] = arr[i];
        }
        for(int i=d; i<n; i++){
            arr[i-d]=arr[i];
        }
        int j=0;
        for(int i=n-d; i<n; i++){
            arr[i]=temp[j];
            j++;
        }
    }

    public void leftRotateOptimal(int[] arr, int n, int d){
        reverseArray(arr,0,d-1);
        reverseArray(arr,d,n-1);
        reverseArray(arr,0,n-1);
    }

    public void rightRotateOptimal(int[] arr, int n, int d){
        reverseArray(arr,0,d);
        reverseArray(arr,d+1,n-1);
        reverseArray(arr,0,n-1);
    }

    public void zerosToEndBrute(int[] arr, int n){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(arr[i]!=0) temp.add(arr[i]);
        }
        for(int i=0; i<temp.size(); i++){
            arr[i]=temp.get(i);
        }
        for(int i=temp.size(); i<n; i++){
            arr[i]=0;
        }
    }

    public void zerosToEndOptimal()
}


public class BasicsOfArrayClass {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,0,6,0,7,8,9};
        int n=arr.length;
        BasicsOfArray obj = new BasicsOfArray();
        // obj.secondSmallest(arr,n);
        // obj.leftRotateBrute(arr,n,3);
        // obj.leftRotateOptimal(arr,n,3);
        obj.zerosToEndBrute(arr,n);
        obj.display(arr,n);
    }

}
