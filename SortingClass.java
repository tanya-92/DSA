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
}

public class SortingClass {
    public static void main(String[] args){
        int[] arr = {1,34,45,56,23,1,23,0};
        Sorting obj = new Sorting();
        System.out.println(Arrays.toString(obj.SelectionSort(arr)));
    }
}