package unit10.activities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public interface Operation {
        public double execute(double left, double right);
    
        
    }

    public static Operation getOperation(String op){
        if(op.equals("+")){
            return new Operation(){
                @Override
                public double execute(double left, double right){
                    return left+ right;
                }
            };
        }else if(op.equals("-")){
            return (left, right) -> left-right;
        }else if(op.equals("*")){
            return (left, right) -> left*right;
        }else if(op.equals("/")){
            return (left, right) -> left/right;
        }else if(op.equals("^") || op.equals("**")){
            return (left, right) -> Math.pow(left,right);
        }
        throw new UnsupportedOperationException("'"+op+"'" + "not a supported operator!");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double left = 0.0;
        double right = 0.0;
        String oper = "";
        System.out.println("\n welcome to my little calculator!");


        while (true) {
            try{
                System.out.println("\n Enter a double: ");
                left = scan.nextDouble();
                System.out.println("\nEnter an operation: ");
                oper = scan.next();
                System.out.println("\n Enter a double: ");
                right = scan.nextDouble();
                Operation operation = getOperation(oper);
                System.out.println(left + " "+ oper + " "+ right + " = " + operation.execute(left, right));
            }catch(InputMismatchException ime){
                break;
            }
        }
        scan.close();
        System.out.println("\nThanks for using my little calculator!");
        System.out.println();
    }
}

