package task_06_csvparser.providers;

import task_06_csvparser.utils.OperationSystemUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Abstract class that provides data required for work process
 */
public abstract class AbstractDataProvider {
    public static String resultFile;
    protected static String inFolder;
    protected static String resultFolder;
    protected static String processedFolder;
    protected File workFolder;

    /**
     * Returns work folder of poject
     * @return work directory
     */
    public File getWorkFolder() {
        return workFolder;
    }

    /**
     * Creates and returns instance of AbstractDataProvider type
     * based on operation system
     * @return instance of AbstractDataProvider child
     */
    public static AbstractDataProvider getDataProvider() {
        if (OperationSystemUtils.isMac()) {
            return new MacDataProvider();
        } else if (OperationSystemUtils.isWindows()) {
            return new WindowsDataProvider();
        } else {
            System.err.println("Not for Linux sorry");
            throw new RuntimeException("Switch to Mac or Windows");
        }
    }

    /**
     * Moves files from /in to /processed
     */
    public abstract void moveFilesToProcessed();

    public AbstractDataProvider() {
        initFilePaths();
    }

    /**
     * Forms Blocking queue of objects in /in directory
     * @return blocking queue of files to process
     */
    public BlockingQueue<File> getBlockingQueueOfFiles() {
        BlockingQueue<File> queueOfFiles = new ArrayBlockingQueue<File>(100, true);
        listFilesForFolder(workFolder, queueOfFiles);
        System.out.println(queueOfFiles);
        return queueOfFiles;
    }

    /**
     * Collects all files in given folder into List object
     * @param workFolder work directory
     * @return list of files
     */
    protected List<File> getListFileForForlder(File workFolder) {
        List<File> files = new ArrayList<>();
        for (final File processedFile : workFolder.listFiles()) {
            if (processedFile.isDirectory()) {
                getListFileForForlder(processedFile);
            } else {
                files.add(processedFile);
            }
        }
        return files;
    }

    /**
     * Initiates file pats to folders according to current operation system
     */
    protected abstract void initFilePaths();

    /**
     * Puts in blocking queue all files from given folder
     * @param workFolder directory
     * @param qeque queue to store files
     */
    private void listFilesForFolder(File workFolder, BlockingQueue<File> qeque) {
        for (final File csvFile : workFolder.listFiles()) {
            if (csvFile.isDirectory()) {
                listFilesForFolder(csvFile, qeque);
            } else {
                qeque.add(csvFile);
            }
        }
    }
}
