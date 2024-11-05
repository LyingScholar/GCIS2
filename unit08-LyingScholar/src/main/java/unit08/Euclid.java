package unit08;

public class Euclid {
    public static int gcd(int a,int b){
        //as long asa is not euual to be
        while(a!=b){
            //if a is greater than b
            if(a>b){
                //let a = a-b
                a= a-b;
            //otherwise
        }else{
            //let b=b-a
            b=b-a;
        }
    }
        //return a
        return a;
    }

    public static void main(String[] args) {
        
        int a = 1071;
        int b = 462;
        System.out.println("\nGreatest common divisor of " + a+ " and "
                + b + ": " + gcd(a,b));
        System.out.println();
    }
}
