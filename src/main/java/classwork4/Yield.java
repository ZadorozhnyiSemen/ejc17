package classwork4;

public class Yield {

    /**
     * Example of use yield() method for threads
     * @param args
     */
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                System.err.println(Thread.currentThread().getName() + " " + i);
                Thread.yield();
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
