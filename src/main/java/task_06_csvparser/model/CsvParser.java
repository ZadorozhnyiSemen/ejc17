package task_06_csvparser.model;

import java.io.File;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class CsvParser implements Runnable {
    private BlockingQueue<File> parseQueue;
    private BlockingQueue<UserDataUnit> resultQueue;
    private CsvParserUtil parserUtil;

    public CsvParser(BlockingQueue<File> parseQueue,
                     CsvParserUtil parserUtil,
                     BlockingQueue<UserDataUnit> resultQueue) {
        this.parseQueue = parseQueue;
        this.parserUtil = parserUtil;
        this.resultQueue = resultQueue;
    }

    @Override
    public void run() {
        try {
            if (parseQueue.size() != 0) {
                List<UserDataUnit> userList = parserUtil.parse(parseQueue.take());
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
