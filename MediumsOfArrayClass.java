import java.util.*;

class MediumsOfArray{
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // public void twoSumBrute(int[] arr, int n, int target){
    //     for(int i=0; i<n; i++){
    //         for(int j=i+1; j<n; j++){
    //             if(arr[i]+arr[j]==target) System.out.println(i+" "+j);
    //         }
    //     }
    // }

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

    public void sort0s1s2sBetter(int[] arr, int n){
        int cnt0 = 0; int cnt1 = 0; int cnt2 = 0;
        for(int i=0; i<n; i++){
            if(arr[i]==0) cnt0++;
            if(arr[i]==1) cnt1++;
            if(arr[i]==2) cnt2++;
        }
        for(int i=0; i<cnt0; i++) arr[i]=0;
        for(int i=cnt0; i<cnt0+cnt1; i++) arr[i]=1;
        for(int i=cnt1+cnt0; i<n; i++) arr[i]=2;

        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public void sort0s1s2sOptimal(int[] arr, int n){
        int low = 0; int mid = 0; int high = n-1;
        while(mid<=high){
            if(arr[mid]==0){
                swap(arr,low,mid);
                low++; mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                swap(arr,mid,high);
                high--;
            }
        }
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public int majorityElementBrute(int[] arr, int n){
        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                if(arr[j]==arr[i]) cnt++;
            }
            if(cnt>n/2) return arr[i];
        }
        return -1;
    }
    public int majorityElementBetter(int[] arr, int n){
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i=0; i<n; i++){
            mpp.put(arr[i], getOrDefault(arr[i], 0)+1);
        }
        for(map.Entry<Integer, Integer> i : mpp.entrySet()){
            if(i.getValue() > n/2){
                return entry.getKey();
            }
        }
        return -1;
    }

    public int majorityElementOptimal(int[] arr, int n){
        int cnt = 0; int element = 0;
        for(int i=0; i<n; i++){
            if(cnt==0){
                cnt=1;
                element = arr[i];
            }
            else if(arr[i]==element) cnt++;
            else cnt--;
        }
        int cnt1 = 0;
        for(int i=0; i<n; i++){
            if(arr[i]==element) cnt1++;
        }
        if(cnt1 > n/2) return element;
        return -1;
    }
}

public class MediumsOfArrayClass {
    public static void main(String[] args){
        int arr[] = {0,0,1,2,0,2,2,2,1,0,1,0,0,1};
        int arr2[] = {2,2,3,3,1,2,2};
        int n=arr2.length;
        MediumsOfArray obj = new MediumsOfArray();
        // obj.twoSumOptimal(arr,n,14);
        // obj.sort0s1s2sBetter(arr,n);
        // obj.sort0s1s2sOptimal(arr,n);
        System.out.println(obj.majorityElementBrute(arr2,n));
    }
}