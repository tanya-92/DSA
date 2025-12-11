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
}

public class BinarySearchClass {
    public static void main(String[] args){
        int[] arr = {2,4,6,8,8,8,11,13};
        int n=arr.length;
        BinarySearch obj = new BinarySearch();
        // System.out.println(obj.search(arr,9));
        // System.out.println(obj.searchRecursive(arr,0,7,9));
        // System.out.println(obj.floor(arr,25));
        int[] result = obj.firstAndLastOccurence(arr, 8);
        System.out.println(Arrays.toString(result));

    }
}