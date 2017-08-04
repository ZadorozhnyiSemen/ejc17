package classwork4;

public class ThreadsWithWait {
    private static final Object key = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.err.println(i);
                if (i == 3) {
                    synchronized (key) {
                        key.notifyAll();
                    }
                }
                try {
                    Thread.sleep(99);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.err.println("start...");
        thread.start();
        synchronized (key) {
            key.wait();
        }
        System.err.println("finish");
    }
}
