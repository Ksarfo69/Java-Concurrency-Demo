package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Engine {
    private ExecutorService executor;

    //initializes a fixe thread pool
    public Engine()
    {
        this.executor = Executors.newFixedThreadPool(5);
    }

    // dispatches the work to the executor
    void dispatch (Task task, int param) {
        Runnable work = () -> {
            task.execute(param);
        };

        executor.execute(work);
    }


    // waits for the thread pool to be shut down or forcefully shuts it down after 3500ms
    public void shutdown() {
        executor.shutdown();
        try{
            if(!executor.awaitTermination(3500, TimeUnit.MILLISECONDS))
            {
                executor.shutdownNow();
            }

        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }
}