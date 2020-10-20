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

    public static void main(String[] args) {

        Printable myClosure;
        myClosure = (text) -> text;
        System.out.println(myClosure.print("I love Java"));
        System.out.println("repeatTask: ");

        Runnable task;
        task = text -> text;
        repeatTask(10,task);
    }
}
