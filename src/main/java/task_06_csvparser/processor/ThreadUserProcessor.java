package task_06_csvparser.processor;

import task_06_csvparser.model.UserDataUnit;
import task_06_csvparser.utils.CsvParserUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadUserProcessor {
    private static final int THREAD_AMOUNT = 10;
    private BlockingQueue<UserDataUnit> resultQueue;
    private ArrayList<Thread> threads;

    public BlockingQueue<UserDataUnit> getResultQueue() {
        return resultQueue;
    }

    public ThreadUserProcessor(BlockingQueue<File> workFileQueue) {
        resultQueue = new ArrayBlockingQueue<>(250);
        Runnable runnable = new CsvParser(workFileQueue, resultQueue);
        initThreads(runnable);
    }

    private void initThreads(Runnable runnable) {
        threads = new ArrayList<>();
        for (int i = 0; i < THREAD_AMOUNT; i++) {
            Thread thread = new Thread(runnable);
            thread.setName("Parsing thread №" + i);
            threads.add(thread);
        }
    }

    public void processFiles() throws InterruptedException {

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            System.out.println("Joining thread: " + thread.getName());
            thread.join();
        }

        File file = formResultArray();
    }

    private File formResultArray() {
        List<UserDataUnit> userList = transformResults();
        sortAndCalculateResults(userList);
        CsvParserUtils.createAndFillResults(userList);
        return null;
    }

    private void sortAndCalculateResults(List<UserDataUnit> userList) {
        Collections.sort(userList);
        userList.forEach(System.out::println);
        for (int i = 0; i < userList.size(); i++) {
            UserDataUnit currentData = userList.get(i);
            for (int j = i + 1; j < userList.size(); j++) {
                UserDataUnit compareData = userList.get(j);
                if (currentData.getName().equals(compareData.getName())) {
                    currentData.setTimeSpend(currentData.getTimeSpend() + compareData.getTimeSpend());
                    userList.remove(j--);
                }
            }
        }
        System.out.println();
        userList.forEach(System.out::println);
    }

    private ArrayList<UserDataUnit> transformResults() {
        return new ArrayList<>(resultQueue);
    }
}
