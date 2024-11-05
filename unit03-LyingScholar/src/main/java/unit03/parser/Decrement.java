package unit03.parser;

public class Decrement implements Expression {
    private final Expression expression;

    public Decrement(Expression expression){
        this.expression = expression;
    }

    @Override
    public double evaluate(){
        return expression.evaluate() - 1;
    }

    public static void main(String[] args) {
        Decrement test = new Decrement(new Constant(47.3));
        System.out.println(test.evaluate());
    }
}
