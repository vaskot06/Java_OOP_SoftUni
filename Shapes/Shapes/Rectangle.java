package Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    private Double getHeight() {
        return height;
    }

    private Double getWidth() {
        return width;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * (getHeight()+ getWidth()));
    }

    @Override
    protected void calculateArea() {
        setArea(getHeight() * getWidth());
    }
}
