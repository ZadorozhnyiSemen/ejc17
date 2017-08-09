package task_06_csvparser.model;

import task_06_csvparser.providers.ArrayUserDataProvider;
import task_06_csvparser.utils.CsvParserUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class CsvParser implements Runnable {
    private BlockingQueue<File> parseQueue;
    private BlockingQueue<UserDataUnit> resultQueue;

    public CsvParser(BlockingQueue<File> parseQueue,
                     BlockingQueue<UserDataUnit> resultQueue) {
        this.parseQueue = parseQueue;
        this.resultQueue = resultQueue;
    }

    @Override
    public void run() {
        try {
            while (parseQueue.size() != 0) {
                File file = parseQueue.take();
                List<UserDataUnit> userList = CsvParserUtil.parseUserHistoryCsv(file);
                System.out.println(Thread.currentThread() + " " + userList);
                for (UserDataUnit unit : userList) {
                    resultQueue.put(unit);
                    System.out.println(Thread.currentThread() + " Putting " + unit.toString() + " to Result Queue");
                }
            }
            System.out.println("end of thread");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
