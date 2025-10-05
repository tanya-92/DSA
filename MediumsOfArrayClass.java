import java.util.*;

class MediumsOfArray{
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverseArray(int[] arr, int start, int end) {
    while (start < end) {
        swap(arr, start, end);
            start++;
            end--;
        }
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
            mpp.put(arr[i], mpp.getOrDefault(arr[i], 0)+1);
        }
        for(Map.Entry<Integer, Integer> i : mpp.entrySet()){
            if(i.getValue() > n/2){
                return i.getKey();
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

    public int maximumSubarraySumBruteBetter(int[] arr, int n){
        int maximum = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += arr[j];
                maximum = Math.max(sum,maximum);
            }
        }
        return maximum;
    }

    public int maximumSubarraySumOptimal(int[] arr, int n){
        int maximum = Integer.MIN_VALUE;
        int sum = 0; int start = 0;
        int ansStart = -1; int ansEnd = -1;
        for(int i=0; i<n; i++){
            if(sum==0) start = i;
            sum += arr[i];
            if(sum>maximum) {
                maximum = sum;
                ansStart = start;
                ansEnd = i;
            }
            if(sum<0) sum = 0;
        }
        return maximum;
    }

    public void stocksProblem(int[] arr,int n){
        int minimum = arr[0];
        int profit = 0;
        for(int i=0; i<n; i++){
            int cost = arr[i] - minimum;
            profit = Math.max(profit, cost);
            minimum = Math.min(minimum,arr[i]);
        }
        System.out.println(profit);
    }

    public void reArrangeArrayElementBySignBrute(int[] arr, int n){
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(arr[i]>0) positives.add(arr[i]);
            else negatives.add(arr[i]);
        }
        for(int i=0; i<n/2; i++){
            arr[2*i]=positives.get(i);
            arr[2*i+1]=negatives.get(i);
        }
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public int[] reArrangeArrayElementBySignOptimal(int[] arr, int n){
        int[] ans = new int[n];
        int positiveIndex = 0, negativeIndex = 1;
        for(int i=0; i<n; i++){
            if(arr[i]<0){
                ans[negativeIndex] = arr[i];
                negativeIndex+=2;
            }
            else{
                ans[positiveIndex] = arr[i];
                positiveIndex+=2;
            }
        } 
        return ans;
    }

    public int[] reArrangeArrayElementBySignBruteVareity2(int[] arr, int n){     //when positives != negatives in the array
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(arr[i]>0) pos.add(arr[i]);
            else neg.add(arr[i]);
        }
        if(pos.size() > neg.size()){
            for(int i=0; i<neg.size(); i++){
                arr[2*i] = pos.get(i);
                arr[2*i+1] = neg.get(i);
            }
            int index = neg.size() * 2;
            for(int i=neg.size(); i<pos.size(); i++){
                arr[index] = pos.get(i);
                index++;
            }
        }
        else{
            for(int i=0; i<pos.size(); i++){
                arr[2*i] = pos.get(i);
                arr[2*i+1] = neg.get(i);
            }
            int index = pos.size() * 2;
            for(int i=pos.size(); i<neg.size(); i++){
                arr[index] = neg.get(i);
                index++;
            }
        }
        return arr;
    }

    public void nextPermutationOptimal(int[] arr, int n){
        int index = -1;
        for(int i=n-2; i>=0; i--){
            if(arr[i]<arr[i+1]){
                index=i;
                break;
            }
        }
        if(index == -1) {
            reverseArray(arr,0,n-1);
            return;
        }
        for(int i=n-1; i>index; i--){
            if(arr[i]>arr[index]) {
                swap(arr, i, index);
                break;
            }
        }
        reverseArray(arr,index+1,n-1);
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public ArrayList<Integer> LeadersInArrayBrute(int[] arr, int n){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            boolean leader = true;
            for(int j=i+1; j<n; j++){
                if(arr[j]>arr[i]){
                    leader = false;
                    break;
                }
            }
            if(leader==true) ans.add(arr[i]);
        }
        return ans;
    }

    public ArrayList<Integer> LeadersInArrayOptimal(int[] arr, int n){
        int maxi = Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=n-1; i>=0; i--){
            if(arr[i]>maxi) ans.add(arr[i]);
            maxi = Math.max(maxi,arr[i]);
        }
        // Collections.sort(ans);
        return ans;
    }
}

public class MediumsOfArrayClass {
    public static void main(String[] args){
        int arr[] = {10,22,12,3,0,6};
        int arr2[] = {3,-5,-7,1,-2,-5,2,-4};
        int n=arr.length;
        MediumsOfArray obj = new MediumsOfArray();
        // obj.twoSumOptimal(arr,n,14);
        // obj.sort0s1s2sBetter(arr,n);
        // obj.sort0s1s2sOptimal(arr,n);
        // System.out.println(obj.majorityElementBrute(arr2,n));
        // System.out.println(obj.majorityElementBetter(arr2,n));
        // System.out.println(obj.majorityElementOptimal(arr2,n));
        // System.out.println(obj.maximumSubarraySumBruteBetter(arr,n));
        // System.out.println(obj.maximumSubarraySumOptimal(arr,n));
        // obj.stocksProblem(arr2,n);
        // obj.reArrangeArrayElementBySignBrute(arr2,n);
        // int[] reArranged = obj.reArrangeArrayElementBySignOptimal(arr2,n);
        // System.out.println(Arrays.toString(reArranged));
        // int[] reArranged = obj.reArrangeArrayElementBySignBruteVareity2(arr2,n);
        // System.out.println(Arrays.toString(reArranged));
        // obj.nextPermutationOptimal(arr,n);
        // System.out.println(obj.LeadersInArrayBrute(arr,n));
        System.out.println(obj.LeadersInArrayOptimal(arr,n));
    }
}