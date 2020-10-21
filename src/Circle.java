public class Circle implements Shape {
    int diameter;

    Circle(int diameter) {
        this.diameter = diameter;
    }

    public double area() {
        return (3.1415*diameter*diameter)/4;
    }

    public double perimeter() {
        return 3.1415*diameter;
    }
}
