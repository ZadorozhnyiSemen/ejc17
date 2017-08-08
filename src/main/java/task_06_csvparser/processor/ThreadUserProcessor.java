package task_06_csvparser.processor;

import task_06_csvparser.model.CsvParser;
import task_06_csvparser.model.CsvParserUtil;
import task_06_csvparser.model.UserDataUnit;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadUserProcessor {
    private final int AMOUNT_OF_THREADS = 10;
    private BlockingQueue<File> queue;
    private BlockingQueue<UserDataUnit> resultQueue;
    private CsvParserUtil parserUtil = new CsvParserUtil();
    private ArrayList<Thread> threads;

    public BlockingQueue<UserDataUnit> getResultQueue() {
        return resultQueue;
    }

    public ThreadUserProcessor(BlockingQueue<File> workFileQueue, ArrayList<Thread> threads) {
        this.queue = workFileQueue;
        resultQueue = new ArrayBlockingQueue<>(250);
        this.threads = threads;
    }

    public void processFiles() throws InterruptedException {
        Runnable runnable = new CsvParser(queue, parserUtil, resultQueue);
        for (Thread thread : threads) {
            thread = new Thread(runnable);
            thread.start();
        }
        Thread.sleep(2);
        for (Thread thread : threads) {
            System.out.println("Joining thread: " + thread.getName());
            thread.join();
        }
    }
}
