package task_06_csvparser.providers;

import task_06_csvparser.model.UserDataUnit;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayUserDataProvider {
    private static String inFolder;
    public static String resultFolder;
    public static String processedFolder;
    private File workFolder;

    public File getWorkFolder() {
        return workFolder;
    }

    public ArrayUserDataProvider() {
        String FILES_PATH = "\\src\\main\\java\\task_06_csvparser\\files";
        String USER_DIRECTORY = System.getProperty("user.dir");
        inFolder = USER_DIRECTORY + FILES_PATH + "\\in";
        resultFolder = USER_DIRECTORY + FILES_PATH + "\\result";
        processedFolder = USER_DIRECTORY + FILES_PATH + "\\processed";
        workFolder = new File(inFolder);
    }

    public BlockingQueue<File> getBlockingQueueOfFiles() {
        BlockingQueue<File> dequeOfFiles = new ArrayBlockingQueue<File>(100, true);
        listFilesForFolder(workFolder, dequeOfFiles);
        System.out.println(dequeOfFiles);
        return dequeOfFiles;
    }

    public boolean putResultFileInFolder(List<UserDataUnit> resultList) {
        return false;
    }

    private void listFilesForFolder(File workFolder, BlockingQueue<File> qeque) {
        for (final File csvFile : workFolder.listFiles()) {
            if (csvFile.isDirectory()) {
                listFilesForFolder(csvFile, qeque);
            } else {
                qeque.add(csvFile);
            }
        }
    }

    public void moveFilesToProcessed(File workFolder) {
        List<File> list = getListFileForForlder(workFolder);
        try {
            for (File file : list) {
                System.out.println(ArrayUserDataProvider.processedFolder + "\\" + file.getName());
                File newFile = new File(ArrayUserDataProvider.processedFolder + "\\" + file.getName());
                Files.move(file.toPath(), Paths.get(ArrayUserDataProvider.processedFolder + "\\" + file.getName()), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<File> getListFileForForlder(File workFolder) {
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
}
