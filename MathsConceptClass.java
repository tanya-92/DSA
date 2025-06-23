import java.util.*;


class MathsConcept{
    public void swap(int[] arr, int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public int countDigits(int n){
        int count=0;
        while(n>0){
            n=n/10;
            count++;
        }
        return count;
    }

    public int reverseNo(int n){
        int revNo = 0;
        while(n>0){
            int last=n%10;
            n=n/10;
            revNo = (revNo*10)+last;
        }
        return revNo;
    }

    public boolean checkPalindorme(int n){
        int number = reverseNo(n);
        return number==n;
    }

    public boolean isArmstrong(int n){
        int temp = n;
        double sum = 0;            //int sum = 0;
        int digits = String.valueOf(n).length();
        while(n>0){
            int last = n%10;
            n=n/10;
            sum += Math.pow(last,digits);      //sum += (int)Math.pow(last,digits);          -Math.pow() returns double!!
        }
        return sum==temp;
    }

    public void printDivisors(int n){          //printed in Unsorted manner
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                System.out.print(i+" ");
                if(n/i != i){
                    System.out.print(n/i+" ");
                }
            }
        }
        System.out.println();
    }

    public void printDivisorsSorted(int n){
        List<Integer> ls = new ArrayList<>();
        for(int i=1; i*i<=n; i++){
            if(n%i==0){
                ls.add(i);
                if(n/i!=i){
                    ls.add(n/i);
                }
            }
        }
        Collections.sort(ls);
        System.out.print(ls);
        System.out.println();
    }

    public boolean isPrimeNo(int n){
        int count = 0;
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                count++;
                if(n/i != i){
                    count++;
                }
            }
        }
        return count==2;
    }

    public void GCD(int a,int b){
        while(a>0 && b>0){
            if(a>b) a=a%b;
            else b=b%a;
        }
        if(a==0) System.out.println(b);
        else System.out.println(a);
    }

    public void reverse(int[] arr, int l, int r){
        if(l>=r) return;
        swap(arr,l,r);
        reverse(arr,l+1,r-1);
    }

    public boolean isPalindrome(String str){    //case-sensitive; strict check
        int l = 0;
        int r = str.length()-1;
        while(l<r){
            if(str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public boolean isPalindrome2(String str){    //case-insensitive
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();       //to remove punctuation marks and nos etc.
        int l = 0;
        int r = str.length()-1;
        while(l<r){
            if(str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public void noHashing(int[] arr, int n){       //n-> no to be counted
        int size = arr.length;                     //this is for int-10^6 bool-10^7
        int hash[] = new int[size+1];
        for(int i=0; i<size;i++){
            hash[arr[i]] += 1;
        }
        System.out.println(hash[n]);
    }

    public void noHashing2(int[] arr, int n){      //for no.s greater than 10^6 etc. (use map, not arrays)
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            mpp.put(arr[i], mpp.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(mpp.getOrDefault(n, 0));
    }

    public int characterHashing(String s, char ch){    //to count frequency of any character present; case sensitive
        int count=0;
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==ch) count++;
        }
        return count;
    }

    public void characterHashing2(String s, char ch){    //to count frequency of any character present (lowercase)
        int[] hash = new int[26];                        //better
        for(int i = 0; i < s.length(); i++){
            hash[s.charAt(i)-'a']++;
        }
        System.out.println(hash[ch-'a']);
    }

    public void characterHashing3(String s, char ch){    //to count frequency of any character present (uppercase)
        int[] hash = new int[26];                        //better
        for(int i = 0; i < s.length(); i++){
            hash[s.charAt(i)-'A']++;
        }
        System.out.println(hash[ch-'A']);
    }

    public void characterHashing4(String s, char ch){    //to count frequency of any character present (both case)
        int[] hash = new int[256];                        //better
        for(int i = 0; i < s.length(); i++){
            hash[s.charAt(i)]++;
        }
        System.out.println(hash[ch]);
    }
}



public class MathsConceptClass {
    public static void main(String[] args) {
        MathsConcept obj = new MathsConcept();
        int[] array = {1,5,2,3,5,4,5};
        // int count = obj.countDigits(54666);
        // System.out.println(count);
        // System.out.println(obj.reverseNo(1234));
        // System.out.println(obj.checkPalindorme(1234321));
        // System.out.println(obj.isArmstrong(9474));
        // obj.printDivisors(48);
        // obj.printDivisorsSorted(48);
        // obj.GCD(10,15);
        // obj.reverse(array,0,array.length-1);
        // for(int i : arr){
        //     System.out.println(i+" ");
        // }
        // System.out.println(obj.isPalindrome("madam"));
        // System.out.println(obj.isPalindrome2("A man, a plan, a canal: Panama"));
        obj.noHashing(array,5);
        obj.noHashing2(array,5);
        // System.out.println(obj.characterHashing("aAabcaaghffseAa",'a'));
        // obj.characterHashing2("aaabcaaghffsea",'a');
        // obj.characterHashing3("ZEETVISONLYZEEZZZZTV",'Z');
        // obj.characterHashing4("ZEETVISONLYZEEZzzztv",'Z');
    }
}
