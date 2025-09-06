import java.util.*;

class MediumsOfArray{
    public void twoSumBrute(int[] arr, int n, int target){
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]+arr[j]==target) System.out.println(i+" "+j);
            }
        }
    }

    public void twoSumBetter(int[] arr, int n, int target){
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i=0; i<n; i++){
            int a = arr[i];
            int more = target-a;
            if(mpp.containsKey(more)){
                System.out.println(mpp.get(more)+" "+i);
            } else{
                mpp.put(a,i);
            }
        }
        System.out.println("No pair found");
    }

    public void twoSumOptimal(int[] arr, int n, int target){
        Arrays.sort(arr);
        int left = 0; int right = n-1; boolean found = false;
        while(left<right){
            int sum = arr[left] + arr[right];
            if(sum == target) {
                System.out.println("YES: "+arr[left]+", "+arr[right]);
                found = true;
                break;
            }
            else if(sum<target) left++;
            else right--;
        }
        if(!found) System.out.println("NO");
    }
}

public class MediumsOfArrayClass {
    public static void main(String[] args){
        int arr[] = {2,5,6,8,10};
        int arr2[] = {2,4,5,7,9};
        int n=arr.length;
        MediumsOfArray obj = new MediumsOfArray();
        obj.twoSumOptimal(arr,n,14);
    }
}