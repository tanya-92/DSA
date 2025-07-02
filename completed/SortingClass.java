import java.util.*;

class Sorting{
    public void swap(int[] arr, int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public int[] SelectionSort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1;i++){
            int min = i;
            for(int j=i; j<=n-1; j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            swap(arr,min,i);
        }
        return arr;
    }

    public int[] BubbleSort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1;i++){
            boolean isSorted = false;
            for(int j=0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    isSorted = true;
                }
            }
            if(!isSorted) break;
        }
        return arr;
    }

    public int[] InsertionSort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            int j = i;
            while(j>0 && arr[j-1]>arr[j]){
                swap(arr,j,j-1);
                j--;
            }
        }
        return arr;
    }

    public int[] MergeSort(int[] arr, int low, int high){
        int mid = (low+high)/2;
        if (low >= high) {
            return arr;
        }
        MergeSort(arr,low,mid);
        MergeSort(arr,mid+1,high);
        Merge(arr,low,mid,high);
        return arr;
    }
    public void Merge(int[] arr,int low,int mid,int high){
        int temp[] = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int k = 0;
        while(left<=mid && right <=high){
            if(arr[left]<=arr[right]){
                temp[k++] = arr[left++];
            }
            else{
                temp[k++] = arr[right++];
            }
        }

        while(left<=mid){
            temp[k++] = arr[left++];
        }
        while(right<=high){
            temp[k++] = arr[right++];
        }
        for(int i = low; i<=high; i++){
            arr[i] = temp[i-low];
        }
    }

    public int[] QuickSort(int[] arr, int low, int high){
        if(low<high){
            int partitionIndex = f(arr, low, high);
            QuickSort(arr,low,partitionIndex-1);
            QuickSort(arr,partitionIndex+1,high);
        }
        return arr;
    }
    public int f(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low; int j = high;
        while(i<=j){
            while(arr[i]<=pivot && i<=high-1) i++;
            while(arr[j]>pivot && j>=low+1) j--;
            if(i<j) swap(arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }
}

public class SortingClass {
    public static void main(String[] args){
        int[] arr = {1,34,45,56,23,1,23,0};
        Sorting obj = new Sorting();
        // System.out.println(Arrays.toString(obj.SelectionSort(arr)));
        // System.out.println(Arrays.toString(obj.BubbleSort(arr)));
        // System.out.println(Arrays.toString(obj.InsertionSort(arr)));
        System.out.println(Arrays.toString(obj.MergeSort(arr,0,7)));
        System.out.println(Arrays.toString(obj.QuickSort(arr,0,7)));
    }
}