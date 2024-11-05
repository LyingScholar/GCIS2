package practicum1.shape;

public class Pentagon extends Shape {
    private double sideLength;

    public Pentagon(String name, double sideLength) {
        super(name);
        this.sideLength = sideLength;
    }

    
    @Override
    public double calculatePerimeter() {
        return 5 * sideLength;
    }
}