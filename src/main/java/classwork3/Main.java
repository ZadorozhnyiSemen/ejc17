package classwork3;

import java.io.IOException;

public class Main {
    /**
     * Amount of Russian kolbasa (or cash, doesn't matter really)
     */
    private static int kolbasaAmount = 50;

    /**
     * simple flag - true or false values
     */
    private volatile static boolean flag = true;

    public static void main(String[] args) {
        kolbasaEatExample(3);
        rabbitEatCarrot();
    }

    /**
     * Creates 2 threads one waiting for flag to equals false
     * Second switches flag to false when something entered in console
     */
    private static void rabbitEatCarrot() {
        new Thread(() -> {
            try {
                int k = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            flag = false;
            System.err.println("FLAG IS FALSE");
        }).start();
        new Thread(() -> {
            System.err.println("I'm waiting");
            while (flag) {

            }
            System.err.println("Completed");
        }).start();
    }

    /**
     * Creates threads to buy kolbasa or waste some cash(doesn't matter)
     * @param threadAmount anoun of threads
     */
    private static void kolbasaEatExample(int threadAmount) {
        for (int i = 0; i < threadAmount; i++) {
            new Thread(() -> {
                buyKolbasa(50);
            }).start();
        }
    }

    /**
     * If requested kolbasa is more than amount - buys it
     * @param requestedKolbasa kolbasa to buy
     */
    private synchronized static void buyKolbasa(int requestedKolbasa) {
        if (kolbasaAmount >= requestedKolbasa) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            kolbasaAmount -= requestedKolbasa;
            System.err.println("Kolbasa has been eaten: " + kolbasaAmount);
        } else {
            System.err.println("Not enough kolbasa: " + kolbasaAmount);
        }
    }
}
