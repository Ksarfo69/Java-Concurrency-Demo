package Concurrency.Threads;

public class RunnableCounter implements Runnable{

    private int count;

    public RunnableCounter()
    {
        this.count = 0;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getId() + " is running. Press any key to interrupt.");
        try{
            while(Thread.currentThread().isAlive())
            {
                count += 1;
                Thread.sleep(2000);
            }
        }catch (InterruptedException e)
        {
            System.out.println("Thread: " + Thread.currentThread().getId() + " was interrupted.");
        }
    }
}
