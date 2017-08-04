package classwork4;

public class ThreadsWithJoin {

    /**
     * Main thread creates additional thread and join in when it ends
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.err.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.err.println("Start...");
        thread.start();
        thread.join();
        System.err.println("End.");
    }
}
