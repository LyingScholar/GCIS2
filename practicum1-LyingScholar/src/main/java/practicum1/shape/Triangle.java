package practicum1.shape;

public class Triangle extends Shape {
    private double sideLength;

    public Triangle(String name, double sideLength) {
        super(name);
        this.sideLength = sideLength;
    }

    
    @Override
    public double calculatePerimeter() {
        return 5 * sideLength;
    }
}