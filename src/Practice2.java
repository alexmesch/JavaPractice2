import java.util.ArrayList;

public class Practice2 {

    /*
     * Задание 1
     */

    interface Printable {
        String print(String text);
    }

    interface Runnable {
        String repeatPrint(String text);
    }

    static void repeatTask(int times, Runnable task) {
        for(int i = 0; i < times; i++) {
            System.out.println(task.repeatPrint("I love Java more"));
        }
    }

    /*
     * Условия: есть начальная позиция на двумерной плоскости, можно осуществлять последовательность шагов по четырем направлениям Up, Down, Left, Right. Размерность каждого шага равна 1. Задание:
     * Создать enum Directions с возможными направлениями движения
     * Создать метод, принимающий координаты и одно из направлений и возвращающий координату после перехода по направлению
     */
    enum Directions {
        LEFT  {
            public int move (int x) {
                return (x-1);
            }
        },
        RIGHT {
            public int move (int x) {
                return (x+1);
            }
        },
        UP {
            public int move(int y) {
                return (y+1);
            }
        },
        DOWN {
            public int move (int y) {
                return (y-1);
            }
        };
        public abstract int move (int coord);
    }

    static void changeCoordinates(Coordinates coordinates, Directions directions) {
        String operation = directions.name();
        switch (operation) {
            case "LEFT":
                coordinates.setX(Directions.LEFT.move(coordinates.getX()));
                break;
            case "RIGHT":
                coordinates.setX(Directions.RIGHT.move(coordinates.getX()));
                break;
            case "UP":
                coordinates.setY(Directions.UP.move(coordinates.getY()));
                break;
            case "DOWN":
                coordinates.setY(Directions.DOWN.move(coordinates.getY()));
                break;
        }
        System.out.println("(" + coordinates.getX()  + ";" + coordinates.getY() + ")");
    }

    /*
     * Создать метод, осуществлящий несколько переходов от первоначальной
     * координаты и выводящий координату после каждого перехода.
     * Для этого внутри метода следует определить переменную location с
     * начальными координатами (0,0) и массив направлений, содержащий
     * элементы [up, up, left, down, left, down, down, right, right, down, right],
     * и програмно вычислить какие будут координаты у
     * переменной location после выполнения этой последовательности шагов.
     * Для вычисленеия результата каждого перемещения следует
     * использовать созданный ранее метод перемещения на один шаг.
     */
    static void multipleMoves(Coordinates coordinates, ArrayList<Directions> directionsArray) {
        System.out.println("MultipleMoves: ");
        for (int i = 0; i < directionsArray.size(); i++) {
            System.out.println("// " + directionsArray.get(i));
            changeCoordinates(coordinates,directionsArray.get(i));
        }
    }


    public static void main(String[] args) {

        Printable myClosure;
        myClosure = (text) -> text;
        System.out.println(myClosure.print("I love Java"));
        System.out.println("repeatTask: ");

        Runnable task;
        task = text -> text;
        repeatTask(10,task);

        Coordinates coordinates = new Coordinates(10,5);

        System.out.println();
        System.out.println("Change coordinates: ");
        changeCoordinates(coordinates, Directions.LEFT);

        Coordinates location = new Coordinates(0,0);

        ArrayList<Directions> directionsArray = new ArrayList<>();
        directionsArray.add(Directions.UP);
        directionsArray.add(Directions.UP);
        directionsArray.add(Directions.LEFT);
        directionsArray.add(Directions.DOWN);
        directionsArray.add(Directions.LEFT);
        directionsArray.add(Directions.DOWN);
        directionsArray.add(Directions.DOWN);
        directionsArray.add(Directions.RIGHT);
        directionsArray.add(Directions.RIGHT);
        directionsArray.add(Directions.DOWN);
        directionsArray.add(Directions.RIGHT);

        multipleMoves(location, directionsArray);

        Shape shape  = new Rectangle(5,4);
        System.out.println("Rectangle Area: " + shape.area());
        System.out.println("Rectangle Perimeter: " + shape.perimeter());

        shape = new Square(3);
        System.out.println("Square Area: " + shape.area());
        System.out.println("Square Perimeter: " + shape.perimeter());

        shape = new Circle(3);
        System.out.println("Circle Area: " + shape.area());
        System.out.println("Circle Perimeter: " + shape.perimeter());
    }
}
