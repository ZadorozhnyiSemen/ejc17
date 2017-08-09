package task_06_csvparser;

import task_06_csvparser.processor.ThreadUserProcessor;
import task_06_csvparser.providers.ArrayUserDataProvider;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayUserDataProvider provider = new ArrayUserDataProvider();
        BlockingQueue<File> workFileQueue = provider.getBlockingQueueOfFiles();
        ThreadUserProcessor userProcessor = new ThreadUserProcessor(workFileQueue);
        userProcessor.processFiles();
        System.out.println("Moving processed files");
        provider.moveFilesToProcessed(provider.getWorkFolder());
        System.out.println("asdasddas");
    }
}
