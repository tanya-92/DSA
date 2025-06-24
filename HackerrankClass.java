import java.util.*;

class Hackerrank{
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int a_count=0;int b_count=0;
        for(int i=0;i<3;i++){
            if(a.get(i)<b.get(i)){
                b_count++;
            }  
            else if(a.get(i)>b.get(i)){
                a_count++;
            }
        }
        return Arrays.asList(a_count,b_count);     //return arrayList
    }


    public static int diagonalDifference(List<List<Integer>> arr) {
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        int n = arr.size();  // Size of the matrix (assuming it's square)

        // Loop through each row of the matrix
        for (int i = 0; i < n; i++) {
            primaryDiagonalSum += arr.get(i).get(i);  // Add element from primary diagonal
            secondaryDiagonalSum += arr.get(i).get(n - i - 1);  // Add element from secondary diagonal
        }

        // Return the absolute difference between the two sums
        return Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
    }
}

public class HackerrankClass {
    public static void main(String[] args) {
    // List<Integer> ls = new ArrayList<>();
    // ls.add(10); 
    // ls.add(20); 
    // ls.add(30); 
    // ls.add(20); 
    // ls.add(10);
    // ls.add(10); 
    // System.out.println(ls);
    // ls.add(2,35);                     //ADD AT PARTICULAR INDEX
    // System.out.println(ls);
    // ls.set(0,11);                     //REPLACE
    // ls.remove(2);
    // System.out.println(ls.contains(10));          //TRUE
    // //ls.clear();
    // System.out.println(ls.indexOf(10));
    // System.out.println(ls.lastIndexOf(10));
    // System.out.println(ls);
    // System.out.println(ls.get(1));     //output: 20
    // Collections.sort(ls);
    // Collections.sort(ls, Collections.reverseOrder());    //Reverse Order 

    // for(int i : ls) {System.out.println(ls.get(i));}


    //2d list or a matrix(list of lists)
        List<List<Integer>> ls = new ArrayList<>();
        ls.add(Arrays.asList(1,2,3));
        ls.add(Arrays.asList(4,5,6));
        ls.add(Arrays.asList(7,8,9));

        System.out.println(ls.get(1).get(2));  //Output: 6
        ls.get(1).set(2,20);

        //Loop through 2d list:
        for(List<Integer> row : ls){
            for(Integer num : row){
                System.out.println(num+" ");
            }
            System.out.println();
        }
    }
}
