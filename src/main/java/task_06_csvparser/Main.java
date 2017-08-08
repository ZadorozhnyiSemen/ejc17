package task_06_csvparser;

import task_06_csvparser.processor.ThreadUserProcessor;
import task_06_csvparser.providers.ArrayUserDataProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayUserDataProvider provider = new ArrayUserDataProvider();
        BlockingQueue<File> workFileQueue = provider.getBlockingQueueOfFiles();
        ArrayList<Thread> threads = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread());
        }
        ThreadUserProcessor userProcessor = new ThreadUserProcessor(workFileQueue, threads);
        userProcessor.processFiles();

        System.out.println("asdasddas");
    }
}
