package Concurrency;

public class View {

    public void acceptResult(Task task, int value) {
        println("Task "+task.getNumber()+ " finished result = "+value);
    }

    public void displayResults() {
    }

    public static void println (String s) {
        System.out.println(s);
    }
}
