class MathsConcept{
    public int countDigits(int n){
        int count=0;
        while(n>0){
            n=n/10;
            count++;
        }
        return count;
    }
}

public class MathsConceptClass {
    public static void main(String[] args) {
        MathsConcept obj = new MathsConcept();
        int count = obj.countDigits(54666);
        System.out.println(count);
    }
}
