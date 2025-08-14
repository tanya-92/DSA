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

    public void zerosToEndOptimal(int[] arr, int n){
        int j = -1;
        for(int i=0; i<n; i++){
            if(arr[i]==0) {
                j=i;
                break;
            }
        }
        for(int i=j+1; i<n; i++){
            if(arr[i]!=0){
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
    }

    public int linearSearch(int[] arr, int n,int key){
        for(int i=0; i<n; i++){
            if(arr[i]==key) return i;
        }
        return -1;
    }

    public void unionOfSortedArraysBrute(int[] arr1, int[] arr2){
        int n1=arr1.length; int n2=arr2.length;
        Set<Integer> st = new TreeSet<>();  //ordered              :-for unordered(HashSet)    :-for Insertion order(LinkedHashSet)
        for(int i=0; i<n1; i++){
            st.add(arr1[i]);
        }
        for(int i=0; i<n2; i++){
            st.add(arr2[i]);
        }
        int[] unionArr = new int[st.size()];
        int index = 0;
        for (int num : st) {
            unionArr[index++] = num;
        }
        for (int num : unionArr) {
            System.out.print(num + " ");
        }
    }

    public int[] unionOfSortedArraysOptimal(int[] arr1, int[] arr2){       //2 pointer approach
        int i=0; int j=0;
        int n1=arr1.length; int n2=arr2.length;
        ArrayList<Integer> unionList = new ArrayList<>();
        while(i<n1 && j<n2){
            if(arr1[i]<=arr2[j]){
                if(unionList.isEmpty() || !unionList.get(unionList.size()-1).equals(arr1[i])){
                    unionList.add(arr1[i]);
                }
                i++;
            }
            else{
                if(unionList.isEmpty() || !unionList.get(unionList.size()-1).equals(arr2[j])){
                    unionList.add(arr2[j]);
                }
                j++;
            }
        }
        while(i<n1){
            if (unionList.isEmpty() || !unionList.get(unionList.size() - 1).equals(arr1[i])) {
                unionList.add(arr1[i]);
            }
            i++;
        }
        while(j<n2){
            if(unionList.isEmpty() || !unionList.get(unionList.size()-1).equals(arr2[j])){
                    unionList.add(arr2[j]);
                }
                j++;
        }
        int[] result = new int[unionList.size()];
        for (int k = 0; k < unionList.size(); k++) {
            result[k] = unionList.get(k);
        }
        return unionList.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersectionOfSortedArraysBrute(int[] arr1, int[] arr2){
        int n1=arr1.length; int n2=arr2.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(arr1[i]==arr2[j]){
                    ans.add(arr1[i]);
                    break;
                }
                if(arr2[j]>arr1[i]) break;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersectionOfSortedArraysOptimal(int[] arr1, int[] arr2){
        int n1=arr1.length; int n2=arr2.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0;int j=0;
        while(i<n1 && j<n2){
            if(arr1[i]<arr2[j]){i++;}
            else if(arr1[i]>arr2[j]){j++;}
            else{
                ans.add(arr1[i]);
                i++; j++;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public void missingNoBrute(int[] arr,int n){  
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }   
        int i = 0;
        for(i=1; i<=max; i++){
            int flag = 0;
            for(int j=0;j<n;j++){
                if(arr[j]==i){
                    flag = 1;
                    break;
                }
            }
            if(flag==0) System.out.println(i);
        }
    }

    public void missingNoBetter(int[] arr,int n){
        int[] hash = new int[n+1];
        for(int i=0; i<n; i++){
            hash[arr[i]] = 1;
        }
        for(int i=1; i<=n; i++){
            if(hash[i]==0) System.out.println(i);
        }
    }

    public void missingNoOptimal1(int[] arr,int n){
        int sum = (n*(n+1))/2;
        int len = arr.length;
        int sum2=0;
        for(int i=0; i<len;i++){
            sum2 = sum2 + arr[i];
        }
        System.out.println(sum-sum2);
    }

    public void missingNoOptimal2(int[] arr,int n){
        int xor1 = 0; int xor2 = 0;
        for(int i=0; i<n-1; i++){
            xor2 = xor2 ^ arr[i];
            xor1 = xor1 ^ (i+1);
        }
        xor1 = xor1 ^ n;
        System.out.println(xor1 ^ xor2);
    }
}


public class BasicsOfArrayClass {
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,6};
        int arr2[] = {2,4,5,7,9};
        int n=arr.length;
        BasicsOfArray obj = new BasicsOfArray();
        // obj.secondSmallest(arr,n);
        // obj.leftRotateBrute(arr,n,3);
        // obj.leftRotateOptimal(arr,n,3);
        // obj.zerosToEndBrute(arr,n);
        // obj.display(arr,n);
        // obj.zerosToEndOptimal(arr,n);
        // obj.unionOfSortedArraysBrute(arr,arr2);
        // int[] ans = obj.unionOfSortedArraysOptimal(arr,arr2);
        // System.out.println(Arrays.toString(ans));
        // int[] ans = obj.intersectionOfSortedArraysBrute(arr,arr2);
        // System.out.println(Arrays.toString(ans));
        // int[] ans = obj.intersectionOfSortedArraysOptimal(arr,arr2);
        // System.out.println(Arrays.toString(ans));
        // obj.missingNoBrute(arr,n);
        // obj.missingNoBetter(arr,n+1);            //total length+missing one
        // obj.missingNoOptimal1(arr,n+1);
        obj.missingNoOptimal2(arr,n+1);
    }

}
