package Concurrency;

public class Task
{
    public static final int LIMIT = 10;
    private static final int TIME_MIN = 250;
    private static final int TIME_SCALE = 100;

    private int number;
    private int complexity;
    private final View view;

    public Task (int number_, int complexity_, View view_) {
        number = number_;
        complexity = complexity_%LIMIT;
        view = view_;
    }

    public void execute(int param) {
        int result = complexity * (param%LIMIT);
        try {
            Thread.sleep(TIME_MIN+complexity*TIME_SCALE);
        }
        catch (InterruptedException ignore) {}
        view.acceptResult(this,result);
    }

    public int getNumber() {
        return number;
    }
}
