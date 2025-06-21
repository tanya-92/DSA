//Patterns
class Patterns{
    int n;
    public void Pattern1(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            for(int j=0;j<2*i+1;j++){
                System.out.print("*");
            }
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }


    public void Pattern2(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<2*n-(2*i+1);j++){
                System.out.print("*");
            }
            for(int j=0;j<=i;j++){
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }


    public void Pattern3(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
        for(int i=0;i<n;i++){
            for(int j=n-(i+1);j>0;j--){
                System.out.print("*");
            }
        }
    }


    public void Pattern4(int n){
        for(int i=0;i<n;i++){
            int start=0;
            if(i%2==0){
                start=1;
            }
            else{
                start=0;
            }
            for(int j=0;j<=i;j++){
               System.out.print(start);
               start=1-start; 
            }
            System.out.print("\n");
        }
    }


    public void Pattern5(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            for(int j=1;j<=2*n-2*i;j++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            System.out.print("\n");
        }
    }


    public void Pattern6(int n){
        int start=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(start);
                start++;
            }
            System.out.println();
        }
    }


    public void Pattern7(int n){
        for(int i=0;i<n;i++){
            for(int j=n-i;j>0;j--){
                System.out.print("*");
            }
            for(int j=0;j<=2*i;j++){
                System.out.print(" ");
            }
            for(int j=n-i;j>0;j--){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<2*n-2*i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public void Pattern8(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0||i==n-1||j==n-1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public void Pattern9(int n){
        for(int i=0;i<2*n-1;i++){
            for(int j=0;j<2*n-1;j++){
                int top=i;
                int left=j;
                int right=(2*n-2)-j;
                int down=(2*n-2)-i;
                System.out.print(n-Math.min(Math.min(top, down),Math.min(left,right)));
            }
            System.out.println();
        }
    }
}



public class PatternsClass{
    public static void main(String[] args) {
        Patterns p = new Patterns();
        // p.Pattern1(5);
        // p.Pattern2(5);
        // p.Pattern3(5);
        // p.Pattern4(5);
        // p.Pattern5(5);
        // p.Pattern6(5);
        // p.Pattern7(5);
        // p.Pattern8(5);
        p.Pattern9(5);
    }
}