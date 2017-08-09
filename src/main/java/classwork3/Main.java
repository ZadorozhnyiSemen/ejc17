package classwork3;

import java.io.IOException;

public class Main {
    /**
     * Amount of Russian meat product (or cash, doesn't matter really)
     */
    private static int meatProductAmount = 50;

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
     * Creates threads to buy meat product or waste some cash(doesn't matter)
     * @param threadAmount amount of threads
     */
    private static void kolbasaEatExample(int threadAmount) {
        for (int i = 0; i < threadAmount; i++) {
            new Thread(() -> {
                buyMeatProduct(50);
            }).start();
        }
    }

    /**
     * If requested meat product is more than amount - buys it
     * @param requestedMeatProduct meat product to buy
     */
    private synchronized static void buyMeatProduct(int requestedMeatProduct) {
        if (meatProductAmount >= requestedMeatProduct) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            meatProductAmount -= requestedMeatProduct;
            System.err.println("Meat product has been eaten: " + meatProductAmount);
        } else {
            System.err.println("Not enough meat product: " + meatProductAmount);
        }
    }
}
