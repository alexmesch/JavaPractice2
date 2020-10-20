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
     * Условия: есть начальная позиция на двумерной плоскости, можно осуществлять последовательность шагов по четырем направлениям up, down, left, right. Размерность каждого шага равна 1. Задание:
     * Создать enum Directions с возможными направлениями движения
     * Создать метод, принимающий координаты и одно из направлений и возвращающий координату после перехода по направлению
     */
    enum Directions {
        Left {
            public int move (int x) {
                return (x-1);
            }
        },
        Right {
            public int move (int x) {
                return (x+1);
            }
        },
        Up {
            public int move(int y) {
                return (y+1);
            }
        },
        Down {
            public int move (int y) {
                return (y-1);
            }
        };
        public abstract int move (int coord);
    }

    static void changeCoordinates(Coordinates coordinates, Directions directions) {
        String operation = directions.name();
        switch(operation) {
            case "Left":
                coordinates.setX(Directions.Left.move(coordinates.getX()));
                break;
            case "Right":
                coordinates.setX(Directions.Right.move(coordinates.getX()));
                break;
            case "Up":
                coordinates.setY(Directions.Up.move(coordinates.getY()));
                break;
            case "Down":
                coordinates.setY(Directions.Down.move(coordinates.getY()));
        }
        System.out.println("X: " + coordinates.getX()  + " Y: " + coordinates.getY());
    }


    public static void main(String[] args) {

        Printable myClosure;
        myClosure = (text) -> text;
        System.out.println(myClosure.print("I love Java"));
        System.out.println("repeatTask: ");

        Runnable task;
        task = text -> text;
        repeatTask(10,task);

        Coordinates coordinates = new Coordinates(0,0);

        System.out.println();
        System.out.println("Change coordinates: ");
        changeCoordinates(coordinates, Directions.Left);
    }
}
