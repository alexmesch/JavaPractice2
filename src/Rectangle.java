public class Rectangle implements Shape {
    int height;
    int length;

    Rectangle(int height, int length) {
        this.height = height;
        this.length = length;
    }

    public double area() {
        return height*length;
    }

    public double perimeter() {
        return (height+length)*2;
    }
}
