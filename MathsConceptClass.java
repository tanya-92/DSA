import java.util.*;


class MathsConcept{
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
        System.out.println;
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
        System.out.println;
    }
}

public class MathsConceptClass {
    public static void main(String[] args) {
        MathsConcept obj = new MathsConcept();
        // int count = obj.countDigits(54666);
        // System.out.println(count);
        // System.out.println(obj.reverseNo(1234));
        // System.out.println(obj.checkPalindorme(1234321));
        // System.out.println(obj.isArmstrong(9474));
        obj.printDivisors(48);
        obj.printDivisorsSorted(48);
    }
}
