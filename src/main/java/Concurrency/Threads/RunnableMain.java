package Concurrency.Threads;

import java.util.Objects;
import java.util.Scanner;

public class RunnableMain {
    public static void main(String[] args) {
        //Print out the main thread id.
        System.out.println("Main thread id: " + Thread.currentThread().getId());

        //instantiate runneable task
        Runnable runnable = new RunnableCounter();


        //pass task to the thread.
        Thread T1 = new Thread(runnable, "Runnable Thread");


        //start the tread
        T1.start();

        //Scan for user input as a sign to interrupt thread.
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();


        //if there's a user input then interrupt the thread.
        if(Objects.nonNull(userInput))
        {
            T1.interrupt();
            System.out.println("Interrupting thread.");
        }
    }
}
