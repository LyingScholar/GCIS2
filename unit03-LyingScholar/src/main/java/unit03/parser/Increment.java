package unit03.parser;

public class Increment implements Expression {
    private final Expression expression;

    public Increment(Expression expression){
        this.expression = expression;
    }

    @Override
    public double evaluate(){
        return expression.evaluate() + 1;
    }

    public static void main(String[] args) {
        Increment test = new Increment(new Constant(47.3));
        System.out.println(test.evaluate());
    }
}
