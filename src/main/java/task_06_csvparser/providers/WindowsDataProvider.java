package task_06_csvparser.providers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

/**
 * Data provider for Windows operation system
 */
public class WindowsDataProvider extends AbstractDataProvider {

    @Override
    protected void initFilePaths() {
        System.out.println("Using WindowsOS path to file construction");
        String USER_DIRECTORY = System.getProperty("user.dir");
        String FILES_PATH = "\\src\\main\\java\\task_06_csvparser\\files";
        inFolder = USER_DIRECTORY + FILES_PATH + "\\in";
        resultFolder = USER_DIRECTORY + FILES_PATH + "\\result";
        resultFile = resultFolder + "\\result.csv";
        processedFolder = USER_DIRECTORY + FILES_PATH + "\\processed";
        workFolder = new File(inFolder);
    }

    @Override
    public void moveFilesToProcessed() {
        List<File> list = getListFileForForlder(getWorkFolder());
        try {
            for (File file : list) {
                System.out.println(AbstractDataProvider.processedFolder + "\\" + file.getName());
                File newFile = new File(AbstractDataProvider.processedFolder + "\\" + file.getName());
                newFile.createNewFile();
                Files.move(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
