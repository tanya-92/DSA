import java.util.*;

class HardsOfArray{

    public int maximumProductSubarrayBrute(int[] arr, int n){
        int maximum = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int product = 1;
            for(int j=i; j<n; j++){
                product = product * arr[j];
                maximum = Math.max(maximum,product);
            }
        }
        return maximum;
    }

    public int maximumProductSubarrayOptimal(int[] arr, int n){
        int pre = 1; int suf = 1;
        int maximum = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(pre==0) pre=1;
            if(suf==0) suf=1;
            pre = pre*arr[i];
            suf = suf*arr[n-i-1];
            maximum = Math.max(maximum,Math.max(pre,suf));
        }
        return maximum;
    }

    public int CountInversionsBrute(int[] arr,int n){
        int count = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]>arr[j]) count++;
            }
        }
        return count;
    }

    public int CountInversionsAndMergeSortOptimal(int[] arr, int low,int high){
        int mid = (low+high)/2;
        int count = 0;

        if(low>=high) return count;
        count += CountInversionsAndMergeSortOptimal(arr,low,mid);
        count += CountInversionsAndMergeSortOptimal(arr,mid+1,high);
        count += merge1(arr,low,mid,high);
        return count;
    }

    public int merge1(int[] arr, int low, int mid, int high){
        int[] temp = new int[high-low+1];
        int count = 0;
        int left = low;
        int right = mid+1;
        int k = 0;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp[k++] = arr[left++];
            }
            else{
                temp[k++] = arr[right++];
                count += (mid-left+1);
            }
        }
        while(left<=mid){
            temp[k++] = arr[left++];
        }
        while(right<=high){
            temp[k++] = arr[right++];
        }
        for(int i=low; i<=high; i++){
            arr[i] = temp[i-low];
        }
        return count;
    }

    public int reversePairsBrute(int[] arr, int n){
        int count = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i] > 2*arr[j]) count++;
            }
        }
        return count;
    }

    public int reversePairsAndMergeSortOptimal(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += reversePairsAndMergeSortOptimal(arr, low, mid);  
        cnt += reversePairsAndMergeSortOptimal(arr, mid + 1, high);
        cnt += reversePairsOptimal(arr, low, mid, high); //Modification
        merge2(arr, low, mid, high);  
        return cnt;
    }

    public int team(int[] arr, int n) {
        return reversePairsAndMergeSortOptimal(arr, 0, n - 1);
    }

    public int reversePairsOptimal(int[] arr, int low, int mid, int high){
        int right = mid + 1;
        int cnt = 0;
        for(int i = low; i <= mid; i++) {
            while(right <= high && arr[i] > 2 * arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    public void merge2(int[] arr, int low, int mid, int high){
        int[] temp = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int k = 0;
        while(left<=mid && right<=high){
            if(arr[left]<arr[right]){
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
        for(int i=low; i<=high; i++){
            arr[i] = temp[i-low];
        }
    }
}

public class HardsOfArrayClass {
    public static void main(String[] args){
        int arr[] = {5,3,0,4,1};
        int arr2[] = {40,25,19,12,9,6,2};
        int n=arr.length;
        HardsOfArray obj = new HardsOfArray();
        // System.out.println(obj.CountInversionsBrute(arr,n));
        // System.out.println(obj.CountInversionsAndMergeSortOptimal(arr,0,4));
        // System.out.println(obj.team(arr2,n));
        // System.out.println(obj.maximumProductSubarrayBrute(arr,n));
        System.out.println(obj.maximumProductSubarrayOptimal(arr,n));
    }
}