package Concurrency.Threads;

import java.util.Objects;
import java.util.Scanner;

public class ThreadMain {

    public static void main(String[] args) {

        // print out main thread id.
        System.out.println("Main thread id: " + Thread.currentThread().getId());


        //create thread and start.
        ThreadCounter T1 = new ThreadCounter("Counter Thread");
        T1.start();


        //Scan for user input as a sign to interrupt thread.
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();


        //if there's a user input then interrupt the thread.
        if(Objects.nonNull(userInput))
        {
            System.out.println("Interrupting thread.");
            T1.interrupt();

            try{
                // wait till T1 dies and get the count of seconds it ran for.
                T1.join();
                System.out.println("Thread "
                        + T1.getId()
                        + " run for "
                        + T1.getCount()
                        + " seconds.");
            }
            catch(InterruptedException e)
            {
                System.out.println("Main thread was interrupted.");
            }
        }

    }
}
