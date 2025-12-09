import java.util.*;

class HardsOfArray{
    public long nCr(int r, int c){
        long result = 1;
        for(int i=0; i<c; i++){
            result = result * (r-i);
            result = result / (i+1);
        }
        return result;
    }

    public int pascalTrianglePrintElementOptimal(int r, int c){
        int element = (int) nCr(r - 1, c - 1);
        return element;
    }

    public void pascalTrianglePrintRowBrute(int r){
        for (int i = 1; i <= r; i++) {
            System.out.print(nCr(r - 1, i - 1) + " ");
        }
        System.out.println();
    }

    public void pascalTrianglePrintRowOptimal(int r){
        int result = 1;
        System.out.print(result+" ");
        for(int i=1; i<r; i++){
            result = result * (r-i);
            result = result / i;
            System.out.print(result+" ");
        }
    }

    public void pascalTrianglePrintTriangleBrute(int r){
        ArrayList<ArrayList<Long>> result = new ArrayList<>();
        for(int i=0; i<r; i++){
            ArrayList<Long> temp = new ArrayList<>();
            for(int j=0; j<=i; j++){
                temp.add(nCr(i,j));
            }
            result.add(temp);
        }
        for (ArrayList<Long> i : result) {
            for (Long val : i) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public List<Integer> pascalTriangleGenerateRowsOptimal(int r){
        int ans = 1;
        ArrayList<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for(int i=1; i<r; i++){
            ans = ans * (r-i);
            ans = ans / i;
            ansRow.add(ans);
        }
        return ansRow;
    }

    public List<List<Integer>> pascalTrianglePrintTriangleOptimal(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        //store the entire pascal's triangle:
        for (int row = 1; row <= n; row++) {
            ans.add(pascalTriangleGenerateRowsOptimal(row));
        }
        return ans;
    }

    
    public List<Integer> majorityElementBrute(int[] arr, int n){
        ArrayList<Integer> ls = new ArrayList<>();
        for(int i=0; i<n; i++){
            if (ls.contains(arr[i])) continue;
            int count = 0;
            for(int j=0; j<n; j++){
                if(arr[j] == arr[i]) count++;
            }
            if(count > n/3) ls.add(arr[i]);
        }
        return ls;
    }

    public List<Integer> majorityElementBetter(int[] arr, int n){
        ArrayList<Integer> ls = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int min = (n/3)+1;
        for(int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if(map.get(arr[i])==min){
                ls.add(arr[i]);
            }
            if(ls.size()==2) break;
        }
        return ls;
    }

    public List<Integer> majorityElementOptimal(int[] arr, int n){
        int cnt1 = 0; int cnt2 = 0;
        int ele1 = Integer.MIN_VALUE; int ele2 = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(cnt1 == 0 && arr[i] != ele2){
                cnt1 = 1;
                ele1 = arr[i];
            }
            else if(cnt2 == 0 && arr[i] != ele1){
                cnt2 = 1;
                ele2 = arr[i];
            }
            else if(ele1 == arr[i]) cnt1++;
            else if(ele2 == arr[i]) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }

        ArrayList<Integer> ls = new ArrayList<>();
        cnt1 = 0; cnt2 = 0;
        for(int i=0; i<n; i++){
            if(ele1 == arr[i]) cnt1++;
            if(ele2 == arr[i]) cnt2++;
        }
        int minimum = (int)(n/3)+1;
        if(cnt1>=minimum) ls.add(ele1);
        if(cnt2>=minimum) ls.add(ele2);
        return ls;
    }

    public ArrayList<List<Integer>> threeSumBrute(int[] arr){
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    if(arr[i]+arr[j]+arr[k]==0){
                        List<Integer> triplet = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(triplet);
                        set.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public ArrayList<List<Integer>> threeSumBetter(int[] arr){
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<n; i++){
            Set<Integer> hashset = new HashSet<>();
            for(int j=i+1; j<n; j++){
                int third = -(arr[i] + arr[j]);
                if(hashset.contains(third)){
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    temp.sort(null);
                    set.add(temp);
                }
                hashset.add(arr[j]);
            }
        }
        return new ArrayList<>(set);
    } 

    public ArrayList<List<Integer>> threeSumOptimal(int[] arr){
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(arr);
        for(int i=0; i<n; i++){
            if(i>0 && arr[i] == arr[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum<0) j++;
                else if(sum>0) k--;
                else{
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    set.add(temp);
                    j++;
                    k--;
                    //skip the duplicates:
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }
        return new ArrayList<>(set); 
    }

    public ArrayList<List<Integer>> fourSumBrute(int[] arr){
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    for(int l=k+1; l<n; l++){
                        if(arr[i]+arr[j]+arr[k]+arr[l]==0){
                        List<Integer> result = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                        Collections.sort(result);
                        set.add(result);
                    }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public ArrayList<List<Integer>> fourSumBetter(int[] arr){
        int n = arr.length;
        int target = 0;
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Integer> hashSet = new HashSet<>();
                for(int k=j+1;k<n;k++){
                    long sum = (long) arr[i]+arr[j]+arr[k];
                    long fourth = target-sum;
                    if(hashSet.contains((int)fourth)){
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],(int)fourth);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    hashSet.add(arr[k]);
                }
            }
        }
        return new ArrayList<>(set);
    }

    public ArrayList<List<Integer>> fourSumOptimal(int[] arr, int target){
        int n = arr.length;
        Arrays.sort(arr);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && arr[j]==arr[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while(k<l){
                    long sum = (long) arr[i]+arr[j]+arr[k]+arr[l];
                    if(sum<target) k++;
                    else if(sum>target) l--;
                    else{
                        ans.add(Arrays.asList(arr[i],arr[j],arr[k],arr[l]));
                        k++; l--;

                        while(k<l && arr[k]==arr[k-1]) k++;
                        while(k<l && arr[l]==arr[l+1]) l--;
                    }
                }
            }
        }
        return ans;
    }

    public int countSubArraysWithXORasKbetter(int[] arr, int k){                //Brute: O(n^3)
        int n = arr.length;
        int count=0;
        for(int i=0;i<n;i++){
            int xor = 0;
            for(int j=i;j<n;j++){
                xor = xor ^ arr[j];
                if(xor==k) count++;
            }
        }
        return count;
    }

    public int countSubArraysWithXORasKoptimal(int[] arr, int k){
        int xor=0;
        Map<Integer,Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        int n = arr.length;
        int count = 0;
        for(int i=0;i<n;i++){
            xor = xor^arr[i];
            int target = xor ^ k;
            // Add the number of times target has appeared before
            count += mpp.getOrDefault(target, 0);
            // Store current prefix xor
            mpp.put(xor, mpp.getOrDefault(xor, 0) + 1);
        }
        return count;
    }

    public long[] mergeTwoSortedArraysBrute(int[] arr1, int[] arr2){
        int m = arr1.length; int n = arr2.length;
        long[] arr = new long[m+n];
        int left=0,right=0,index=0;
        while(left<m && right<n){
            if(arr1[left]<arr2[right]){
                arr[index] = arr1[left];
                index++; left++;
            }
            else{
                arr[index] = arr2[right];
                index++; right++;
            }
        }
        while(left<m) arr[index++] = arr1[left++];
        while(right<n) arr[index++] = arr2[right++];
        return arr;

        // for(int i=0;i<m+n;i++){            //putting back into original array and not using extra space
        //     if(i<m) arr1[i] = arr[i];
        //     else arr2[i-n] = arr[i];
        // }
    }

    public void mergeTwoSortedArraysOptimal1(int[] arr1, int[] arr2){
        int m = arr1.length; int n = arr2.length;
        int left = n-1;
        int right = 0;
        while(left>=0 && right<n){
            if(arr1[left]>arr2[right]){
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--; right++;
            }
            else break;
        }
        Arrays.sort(arr1); Arrays.sort(arr2);

    }

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

    // public void mergeTwoSortedArraysOptimal2(int[] arr1, int[] arr2){
    //     int m = arr1.length; int n = arr2.length;
    //     int len = m+n;
    //     int gap = (len/2)+(len%2);
    //     while(gap>0){
    //         int left=0; int right=gap+left;
    //         while(right<len){
    //             if(left<n && right>=n){
    //                 swapIfGreater(arr1,arr2,left,right-n);
    //             }
    //             else if(left>=n){
    //                 swapIfGreater()
    //             }
    //         }
    //     }
    // }

    public int[] missingAndRepeatingBrute(int[] arr){
        int repeating = -1, missing = -1;
        int n = arr.length;
        for(int i=1;i<=n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(arr[j]==i) cnt++;
            }
            if(cnt==2) repeating = i;
            else if(cnt==0) missing = i;
            if(missing!=-1 && repeating!=-1) break;
        }
        return new int[]{missing, repeating};
    }

    public int[] missingAndRepeatingBetter(int[] arr){
        int n=arr.length;
        int repeating = -1, missing = -1;
        int[] hash = new int[n+1];
        for(int i=0;i<n;i++){
            hash[arr[i]]++;
        }
        for(int i=1;i<=n;i++){
            if(hash[i]==2) repeating = i;
            else if(hash[i]==0) missing = i;
            if(missing!=-1 && repeating!=-1) break;
        }
        return new int[]{missing, repeating};
    }

    public int[] missingAndRepeatingOptimal1(int[] arr){
        int n=arr.length;
        
        return new int[]{missing, repeating};
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
        int arr[] = {1,3,4,5,4};
        int arr2[] = {2,4,6,8,10};
        int n=arr.length;
        HardsOfArray obj = new HardsOfArray();
        // System.out.println(obj.CountInversionsBrute(arr,n));
        // System.out.println(obj.CountInversionsAndMergeSortOptimal(arr,0,4));
        // System.out.println(obj.team(arr2,n));
        // System.out.println(obj.maximumProductSubarrayBrute(arr,n));
        // System.out.println(obj.maximumProductSubarrayOptimal(arr,n));
        // System.out.println(obj.pascalTrianglePrintElementOptimal(5,3));
        // obj.pascalTrianglePrintRowBrute(5);
        // obj.pascalTrianglePrintRowOptimal(5);
        // obj.pascalTrianglePrintTriangleBrute(6);
        // List<List<Integer>> ans = pascalTrianglePrintTriangleOptimal(6);
        // for (List<Integer> it : ans) {
        //     for (int ele : it) {
        //         System.out.print(ele + " ");
        //     }
        //     System.out.println();
        // }
        // obj.majorityElementOptimal(arr,n);
        // System.out.println(obj.threeSumBrute(arr));
        // System.out.println(obj.threeSumBetter(arr));
        // System.out.println(obj.threeSumOptimal(arr));
        // System.out.println(obj.fourSumBrute(arr));
        // System.out.println(obj.fourSumBetter(arr));
        // System.out.println(obj.fourSumOptimal(arr,0));
        // System.out.println(Arrays.toString(obj.mergeTwoSortedArraysBrute(arr,arr2)));
        // System.out.println(obj.mergeTwoSortedArraysOptimal1(arr,arr2));             //will just sort but won't print
        // System.out.println(Arrays.toString(obj.missingAndRepeatingBrute(arr)));
        // System.out.println(Arrays.toString(obj.missingAndRepeatingBetter(arr)));
    }
}