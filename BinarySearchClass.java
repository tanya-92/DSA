import java.util.*;

class BinarySearch{
    public int search(int[] arr, int target){
        int low=0; int high=arr.length-1;
        while(low<=high){
            int mid = (high+low)/2;
            if(arr[mid]==target) return mid;
            else if(target>arr[mid]) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }

    public int searchRecursive(int[] arr, int low, int high, int target){
        int mid = (high+low)/2;
        if(low>high) return -1;
        if(arr[mid]==target) return mid;
        else if(target>arr[mid]) return searchRecursive(arr,mid+1,high,target);
        else return searchRecursive(arr,low,mid-1,target);
    }

    public int lowerBound(int[] arr, int target){      //smallest idx s-t arr[idx]>=x
        int n = arr.length;
        int low=0; int high=n-1; int ans = n;
        while(low<=high){
            int mid = (high+low)/2;
            if(arr[mid]>=target){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }

    public int upperBound(int[] arr, int target){      //smallest idx s-t arr[idx]>x
        int n = arr.length;
        int low=0; int high=n-1; int ans = n;
        while(low<=high){
            int mid = (high+low)/2;
            if(arr[mid]>target){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }

    public int floor(int[] arr, int target){
        int n = arr.length;
        int low=0; int high=n-1; int ans = -1;
        while(low<=high){
            int mid = (high+low)/2;
            if(arr[mid]<=target){
                ans = mid;
                low = mid+1;
            }
            else high = mid - 1;
        }
        return arr[ans];
    }

    public int[] firstAndLastOccurenceBrute(int[] arr, int x){
        int first = -1, last = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                if(first==-1) first = i;
                last = i;
            }
        }
        return new int[]{first,last};
    }

    public int[] firstAndLastOccurenceOptimal(int[] arr, int x){
        int n = arr.length;
        int lb = lowerBound(arr,x);
        if(lb==n || arr[lb] != x) return new int[]{-1,-1};
        return new int[]{lb,upperBound(arr,x)-1};
    }

    public int[] firstAndLastOccurence(int[] arr, int x){
        int n = arr.length;
        //FIRST
        int low=0; int high=n-1; int first = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==x){
                first = mid;
                high = mid-1;
            }
            else if(arr[mid]<x) low = mid+1;
            else high = mid - 1;
        }

        //LAST
        low=0; high=n-1; int last = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==x){
                last = mid;
                low = mid+1;
            }
            else if(arr[mid]<x) low = mid+1;
            else high = mid-1;
        }
        return new int[]{first,last};
    }

    public int searchInRotatedSortedArray(int[] arr, int target){    //unique elements in array
        int low=0; int high=arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==target) return mid;
            if(arr[mid]>=arr[low]){              //left sorted
                if(arr[mid]>=target && target>=arr[low]) high = mid-1;
                else low=mid+1;
            }
            else{                               //right sorted
                if(arr[mid]<=target && target<=arr[high]) low = mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }

    public int searchInRotatedSortedArray2(int[] arr, int target){    //duplicate elements in array
        int low=0; int high=arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==target) return mid;
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                low++; high--; continue;
            }
            
            if(arr[mid]>=arr[low]){              //left sorted
                if(arr[mid]>=target && target>=arr[low]) high = mid-1;
                else low=mid+1;
            }
            else{                               //right sorted
                if(arr[mid]<=target && target<=arr[high]) low = mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }

    public int findMinimumInRotatedSortedArray(int[] arr){
        int low=0; int high=arr.length-1;
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[low]<=arr[high]){               //already sorted
                ans = Math.min(ans,arr[low]);
                break;
            }
            if(arr[mid]>=arr[low]){              //left sorted
                ans = Math.min(arr[low],ans);
                low=mid+1;
            }
            else{                               //right sorted
                ans = Math.min(arr[mid],ans);
                high = mid-1;
            }
        }
        return ans;
    }

    public int noOfTimesArrayRotated(int[] arr){
        int low=0; int high=arr.length-1;
        int index = -1;
        int min = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[low]<=arr[high]){             //already sorted
                if(arr[low] < min){
                    min = arr[low];
                    index = low;
                }
                break;
            }
            if(arr[mid]>=arr[low]){              //left sorted
                if(arr[low] < min){
                    min = arr[low];
                    index = low;
                }
                low = mid + 1;
            }
            else{                               //right sorted
                if(arr[mid] < min){
                    min = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }

    public int singleElementInSortedArrayBrute(int[] arr, int n){
        if(n==1) return arr[0];
        for(int i=0; i<n; i++){
             if(i==0){
                if(arr[i] != arr[i+1]) return arr[i];
             }
             else if(i==n-1){
                if(arr[i] != arr[i-1]) return arr[i];
             }
             else{
                if(arr[i] != arr[i+1] && arr[i] != arr[i-1]) return arr[i];
             }
        }
        return -1;
    }

    public int singleElementInSortedArrayOptimal(int[] arr, int n){
        if(n==1) return arr[0];
        if(arr[0] != arr[1]) return arr[0];
        if(arr[n-1] != arr[n-2]) return arr[n-1];
        int low=1; int high=n-2;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]) return arr[mid];
            if((mid%2==1 && arr[mid]==arr[mid-1]) || (mid%2==0 && arr[mid]==arr[mid+1])) low= mid+1;
            else high = mid-1;
        }
        return -1;
    }

    public int peakElementBrute(int[] arr){
        return -1;
    }

    public int NthRootOfMlinearSearch(int n, int m){
        for(int i=1; i<=m; i++){
            if(FunctionNthRootOfMlinearSearch(i,n) == m){         //function to multiply i, n times
                return i;
            }
            else if(FunctionNthRootOfMlinearSearch(i,n) > m) break;
        }
        return -1;
    }
    public int FunctionNthRootOfMlinearSearch(int i, int n){
        int result = 1;
        for(int j=1; j<=n; j++){
            result *= i;
        }
        return result;
    }

    public int NthRootOfMbinarySearch(int n, int m){
        int low=1; int high=m;
        while(low<=high){
            int mid = (low+high)/2;
            if(FunctionNthRootOfMbinarySearch(mid,n,m)==1){
                return mid;
            }
            else if(FunctionNthRootOfMbinarySearch(mid,n,m)==0){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
    public int FunctionNthRootOfMbinarySearch(int mid, int n, int m){
        long ans = 1;
        for(int i=1; i<=n; i++){
            ans = ans*mid;
            if(ans>m) return 2;
        }
        if(ans == m) return 1;
        return 0;
    }

    public int maxInArray(int[] arr){
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>maxi) maxi=arr[i];
        }
        return maxi;
    }
    public int minInArray(int[] arr){
        int mini = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<mini) mini=arr[i];
        }
        return mini;
    }
    public int kokoEatingBananasLinearSearch(int[] piles, int hours){           //time limit exceed
        int max = maxInArray(piles);
        for(int i=1; i<max; i++){
            int requiredTime = FunctionKokoEatingBananas(piles,i);
            if(requiredTime <= hours) return i;
        }
        return -1;
    }
    public int FunctionKokoEatingBananas(int[] piles, int hourly){
        int totalHours = 0;
        for(int i=0; i<piles.length; i++){
            totalHours += Math.ceil((double)piles[i] / hourly);
        }
        return totalHours;
    }

    public int kokoEatingBananasBinarySearch(int[] piles, int hours){
        int low = 1; int high = maxInArray(piles);
        int ans = 0;
        while(low<=high){
            int mid = (low+high)/2;
            int requiredTime = FunctionKokoEatingBananas(piles,mid);
            if(requiredTime <= hours){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        } 
        return ans;
    }

    public boolean FunctionMinimumDaysToMakeMbouquets(int[] bloomDays, int day, int m, int k){
        int count = 0; int noOfBouquets = 0;
        for(int i=0; i<bloomDays.length; i++){
            if(bloomDays[i] <= day) count++;               //bloom hogya usdin ya usdin se phle
            else{
                noOfBouquets += (count/k);
                count=0;
            }
        }
        noOfBouquets += (count/k);
        if(noOfBouquets >= m) return true;
        else return false;
    }
    public int minimumDaysToMakeMbouquetsLinearSearch(int[] bloomDays, int m, int k){
        int maxi = maxInArray(bloomDays);
        int mini = minInArray(bloomDays);
        if(bloomDays.length < m*k) return -1;
        for(int i=mini; i<=maxi; i++){
            if (FunctionMinimumDaysToMakeMbouquets(bloomDays,i,m,k)==true) return i;
        }
        return -1;
    }

    public int minimumDaysToMakeMbouquetsBinarySearch(int[] bloomDays, int m, int k){
        int high = maxInArray(bloomDays);
        int low = minInArray(bloomDays);
        int ans = 0;
        if(bloomDays.length < m*k) return -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(FunctionMinimumDaysToMakeMbouquets(bloomDays,mid,m,k)==true){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
}

public class BinarySearchClass {
    public static void main(String[] args){
        int[] arr = {1,1,2,2,3,4,4};
        int n=arr.length;
        int[] piles = {3,6,11,7};
        int[] bloomDays = {7,7,7,7,13,11,12,7};
        BinarySearch obj = new BinarySearch();
        // System.out.println(obj.search(arr,9));
        // System.out.println(obj.searchRecursive(arr,0,7,9));
        // System.out.println(obj.floor(arr,25));
        // int[] result = obj.firstAndLastOccurence(arr, 8);
        // System.out.println(Arrays.toString(result));
        // System.out.println(obj.NthRootOfMbinarySearch(3,64));
        // System.out.println(obj.kokoEatingBananasLinearSearch(piles,8));
        // System.out.println(obj.kokoEatingBananasBinarySearch(piles,8));
        // System.out.println(obj.minimumDaysToMakeMbouquetsBinarySearch(bloomDays,2,3));
        System.out.println(obj.singleElementInSortedArrayBrute(arr,n));
        System.out.println(obj.singleElementInSortedArrayOptimal(arr,n));
    }
}