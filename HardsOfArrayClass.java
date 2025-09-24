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
        return ans;
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
            if (result.contains(arr[i])) continue;
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
            if(mpp.get(arr[i])==min){
                ls.add(arr[i]);
            }
            if(ls.size()==2) break;
        }
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
        int arr[] = {1,1,1,1,2,2,2};
        int arr2[] = {40,25,19,12,9,6,2};
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
        obj.majorityElementOptimal(arr,n);
    }
}