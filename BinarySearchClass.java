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
}

public class BinarySearchClass {
    public static void main(String[] args){
        int[] arr = {10,20,30,40,50};
        int n=arr.length;
        BinarySearch obj = new BinarySearch();
        // System.out.println(obj.search(arr,9));
        // System.out.println(obj.searchRecursive(arr,0,7,9));
        System.out.println(obj.floor(arr,25));
    }
}