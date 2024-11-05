package practicum1.shape;

public abstract class Shape {
    protected String name;
    protected double perimeter;


    public Shape(String name) {
        this.name = name;
    }

    public abstract double calculatePerimeter();

    public String getName() {
        return name;
    }

    public double getPerimeter() {
        if (perimeter == 0) {
            perimeter = calculatePerimeter();
        }
        return perimeter;
    }
    @Override
    public String toString() {
        return "Shape:- name:" + name + ", perimeter:" + getPerimeter();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        } else{
            Shape other = (Shape) obj;
            return this.name.equals(other.name) && this.getPerimeter() == other.getPerimeter();
    }
}
}