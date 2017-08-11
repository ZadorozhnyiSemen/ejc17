package task_06_csvparser.processor;

import task_06_csvparser.model.UserDataUnit;
import task_06_csvparser.utils.CsvParserUtils;

import java.io.File;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Csv parser unit (thread).
 * Main idea that it gets blocking queue to parse
 * and blocking queue to store result of parsing
 */
public class CsvParser implements Runnable {
    private BlockingQueue<File> queueToParse;
    private BlockingQueue<UserDataUnit> resultQueue;

    public CsvParser(BlockingQueue<File> queueToParse,
                     BlockingQueue<UserDataUnit> resultQueue) {
        this.queueToParse = queueToParse;
        this.resultQueue = resultQueue;
    }

    /**
     * Takes File from queue and parses it with CSVParser.
     * Creates UserDataUnit object and stores information inside it.
     * Then puts UserDataUnit object in result queue.
     */
    @Override
    public void run() {
        try {
            while (queueToParse.size() != 0) {
                File file = queueToParse.take();
                List<UserDataUnit> userList = CsvParserUtils.parseUserHistoryCsv(file);
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
