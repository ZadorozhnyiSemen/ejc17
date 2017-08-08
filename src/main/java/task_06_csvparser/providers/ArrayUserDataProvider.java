package task_06_csvparser.providers;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayUserDataProvider {
    private final String USER_DIRECTORY = System.getProperty("user.dir");
    private final String FILES_PATH = "\\src\\main\\java\\task_06_csvparser\\files";
    private String inFolder;
    private String resultFolder;
    private String processedFolder;

    public ArrayUserDataProvider() {
        inFolder = USER_DIRECTORY + FILES_PATH + "\\in";
        resultFolder = USER_DIRECTORY + FILES_PATH + "\\result";
        processedFolder = USER_DIRECTORY + FILES_PATH + "\\processed";
    }

    public ArrayUserDataProvider(String inFolderPath, String resultFolderPath, String processedFolderPath) {
        this.inFolder = inFolderPath;
        this.resultFolder = resultFolderPath;
        this.processedFolder = processedFolderPath;
    }

    public BlockingQueue<File> getBlockingQueueOfFiles() {
        File workFolder = new File(inFolder);
        BlockingQueue<File> dequeOfFiles = new ArrayBlockingQueue<File>(100, true);
        listFilesForFolder(workFolder, dequeOfFiles);
        System.out.println(dequeOfFiles);
        return dequeOfFiles;
    }

    private void listFilesForFolder(File workFolder, BlockingQueue<File> deque) {
        for (final File csvFile : workFolder.listFiles()) {
            if (csvFile.isDirectory()) {
                listFilesForFolder(csvFile, deque);
            } else {
                deque.add(csvFile);
            }
        }
    }
}
