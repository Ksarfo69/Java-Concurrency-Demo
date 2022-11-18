package Concurrency.ThreadSynchronization;

public class ThreadPrinterMain {



    public static void main(String[] args) {
        ThreadNamePrinter threadNamePrinter = new ThreadNamePrinter();

        Thread T1 = new Thread(threadNamePrinter);
        Thread T2 = new Thread(threadNamePrinter);

        T1.start();
        T2.start();
    }
}
