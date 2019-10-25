package Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    private final Double getRadius() {
        return radius;
    }

    @Override
    protected void calculatePerimeter() {
    setPerimeter(2 * Math.PI * getRadius());
    }

    @Override
    protected void calculateArea() {
        setArea(Math.PI * Math.pow(getRadius(), 2));
    }
}
