package Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    protected abstract void calculatePerimeter();

    protected abstract void calculateArea();

    public Double getPerimeter() {
        return perimeter;
    }

    public Double getArea() {
        return area;
    }

    void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    void setArea(Double area) {
        this.area = area;
    }
}
