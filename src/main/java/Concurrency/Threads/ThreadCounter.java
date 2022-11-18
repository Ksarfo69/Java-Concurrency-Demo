package Concurrency.Threads;

public class ThreadCounter extends Thread{

    private int count;
    private String threadName;


    public ThreadCounter(String threadName)
    {
        this.threadName = threadName;
        this.count = 0;
    }


    @Override
    public void run() {
        try{
            System.out.println("Thread " + Thread.currentThread().getId() + " is running. Press any key to interrupt.");

            while(Thread.currentThread().isAlive())
            {
                count += 1;
                Thread.sleep(1000);

            }
        }catch (InterruptedException e)
        {
            System.out.println("Thread interrupted.");
        }
    }

    public int getCount() {
        return count;
    }
}
