import java.util.Arrays;

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

    public void largestElement(int arr[],int n){
        int largest = arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        System.out.println(largest);
    }

    public void SecondLargestElement(int arr[],int n){
        int largest = arr[0];
        int secLargest = -1;
        for(int i=0;i<n;i++){
            if(arr[i]>largest){
                secLargest=largest;
                largest=arr[i];
            }
            else if(arr[i]<largest && arr[i]>secLargest){
                secLargest=arr[i];
            }
        }
        System.out.println(secLargest);
    }

    public void SecondSmallestElement(int arr[],int n){
        int smallest = arr[0];
        int secondSmallest = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]<smallest){
                secondSmallest=smallest;
                smallest=arr[i];
            }
            else if(arr[i]>smallest && arr[i]<secondSmallest){
                secondSmallest=arr[i];
            }
        }
        System.out.println(secondSmallest);
    }

    public boolean isSorted(int arr[]){
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]) {
                return false;
            }
        }
        return true;
    }

    public void removeDuplicates(int arr[],int n){
        int i=0;
        for(int j=1;j<n;j++){
            if(arr[j]!=arr[i]){
                arr[i+1]=arr[j];
                i++;
            }
        }
        System.out.println(i+1);
    }

    public void leftRotateByOne(int arr[],int n){
        int temp=arr[0];
        for(int i=0;i<n-1;i++){
            arr[i]=arr[i+1];
        }
        arr[n-1]=temp;
        display(arr, n);
    }

    public void leftRotateByD(int arr[], int n, int d){   
        d=d%n;
        reverseArray(arr, 0, d-1);
        reverseArray(arr, d, n-1);
        reverseArray(arr, 0, n-1);
        display(arr, n);
        System.out.println();
    }

    public void rightRotateByD(int arr[], int n, int d){   
        d=d%n;
        reverseArray(arr, 0, d);
        reverseArray(arr, d+1, n-1);
        reverseArray(arr, 0, n-1);
        display(arr, n);

        // reverseArray(arr, n - d, n - 1);  // reverse last d elements
        // reverseArray(arr, 0, n - d - 1);  // reverse first n - d elements
        // reverseArray(arr, 0, n - 1);
    }

    public void ZerosToEnd(int arr[], int n){
        int j=-1;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                j=i; break;
            }
        }
        for(int i=j+1;i<n;i++){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
        display(arr, n);
    }

    public void linearSearch(int[] arr, int key, int n){
        for(int i=0;i<n;i++){
            if(arr[i] == key) {         //first occurence
                System.out.println(i);
                break;
            }  
        }
        for(int i=n-1;i>=0;i--){
            if(arr[i] == key) {
                System.out.println(i);  //Last occurence
                break;
            }  
        }
    }
}


public class BasicsOfArrayClass {
    public static void main(String[] args) {
        int arr[] = {1,0,0,2,3,4,0,5,6,0,7};
        int n=arr.length;
        BasicsOfArray Element = new BasicsOfArray();
        // Element.largestElement(arr, n);
        // Element.SecondLargestElement(arr, n);
        // Element.SecondSmallestElement(arr,n);
        // System.out.println(Element.isSorted(arr));
        // Element.removeDuplicates(arr, n);
        // Element.leftRotateByOne(arr, n);
        // Element.leftRotateByD(arr, n, 3);
        // Element.rightRotateByD(arr, n, 3);
        // Element.ZerosToEnd(arr,n);
        Element.linearSearch(arr, 0, n);
    }
}
