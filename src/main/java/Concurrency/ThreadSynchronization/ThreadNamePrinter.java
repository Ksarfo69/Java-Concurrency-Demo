package Concurrency.ThreadSynchronization;

public class ThreadNamePrinter implements Runnable{

    public synchronized void printThreadName()
    {
        try{
            for(int i = 0; i<=10; i++)
            {
                System.out.println(Thread.currentThread().getName() + " printing.");
                Thread.sleep(1000);
            }
        }catch(InterruptedException e)
        {
            System.out.println("Thread "+ Thread.currentThread().getName() + " interrupted.");
        }

    }

    @Override
    public void run() {
        printThreadName();
    }
}
