package unit03.parser;

public class Subtraction implements Expression {
    private final Expression expressionOne;
    private final Expression expressionTwo;

    public Subtraction(Expression expressionOne, Expression expressionTwo){
        this.expressionOne = expressionOne;
        this.expressionTwo = expressionTwo;
    }

    @Override
    public double evaluate(){
        double one = expressionOne.evaluate();
        double two = expressionTwo.evaluate();
        return one - two;

    }

    public static void main(String[] args) {
        Constant oper1 = new Constant(24);
        Constant oper2 = new Constant(23);
        Subtraction test = new Subtraction(oper1, oper2);
        System.out.println(test.evaluate());
    }
}
